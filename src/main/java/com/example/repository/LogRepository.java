package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Customers;

@Repository
public interface LogRepository extends MongoRepository<Customers, String>{
	public List<Customers> findByName(String name);
	@Query(value="{ 'address.city' : ?0 }")
	public List<Customers> findByCity(String city);
}
