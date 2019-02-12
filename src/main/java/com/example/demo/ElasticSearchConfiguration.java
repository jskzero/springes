package com.example.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration extends AbstractFactoryBean{
	
	private RestHighLevelClient restHighLevelClient;
	
	@Override
	public Class<RestHighLevelClient> getObjectType() {
		return RestHighLevelClient.class;
	}

	@Override
	protected Object createInstance() throws Exception {
		return buildClient();
	}
	
	private RestHighLevelClient buildClient() {
		restHighLevelClient = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http")));
		return restHighLevelClient;
	}

}
