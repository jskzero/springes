package com.example.repository;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class DummyRepository {
	private final String INDEX = "fulltext";
	private final String TYPE = "dummy";
	private RestHighLevelClient restHighLevelClient;
	private ObjectMapper objectMapper;
	
	public DummyRepository(ObjectMapper objectMapper, RestHighLevelClient
										restHighLevelClient) {
		this.objectMapper = objectMapper;
		this.restHighLevelClient = restHighLevelClient;
	}
	
	public Collection<Map<String, Object>> search(String term){
		SearchRequest request = new SearchRequest(INDEX);
		request.types(TYPE);
		SearchSourceBuilder builder = new SearchSourceBuilder();
		builder.query(QueryBuilders.wildcardQuery("title", term));
		request.source(builder);
		SearchResponse response = new SearchResponse();
		try {
			response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SearchHit[] hits = response.getHits().getHits();
		Collection<Map<String, Object>> source = new LinkedList<>();
		for(SearchHit hit: hits) {
			source.add(hit.getSourceAsMap());
		}
		return source;
	}
}
