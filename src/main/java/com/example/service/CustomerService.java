package com.example.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customers;
import com.example.repository.LogRepository;

@Service
public class CustomerService {
	
	@Autowired
	private LogRepository logRepository;
	
	public Customers save() {
		byte[] array = new byte[7];
		new Random().nextBytes(array);
		Customers customer = Customers.builder()
				.__v(0)
				._id(new ObjectId())
				.email(new String(array, Charset.forName("UTF-8")))
				.name(new String(array, Charset.forName("UTF-8")))
				.phone(new String(array, Charset.forName("UTF-8")))
				.build();
		return customer;
	}
	
	public List<Customers> findAll(){
		List<Customers> listOfNames = new ArrayList<>();
		listOfNames = logRepository.findAll();
		return listOfNames;
	}
	
	public long count() {
		return logRepository.count();
	}
	
	public List<Customers> findByCity(String city){
		return logRepository.findByCity(city);
	}
}
