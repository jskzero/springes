package com.example.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customers;
import com.example.repository.DummyRepository;
import com.example.service.CustomerService;

@RestController
public class ApiController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DummyRepository dummyRepository;
	
	
	@GetMapping("/data")
	@ResponseBody
	public List<Customers> getHome() {
		return customerService.findAll();
	}
	
	@GetMapping("/count")
	@ResponseBody
	public String getCount() {
		return String.valueOf(customerService.count());
	}
	
	@GetMapping("/save")
	@ResponseBody
	public Customers save() {
		return customerService.save();
	}
	
	@GetMapping("/city/{city}")
	@ResponseBody
	public List<Customers> city(@PathVariable("city") String city) {
		if(customerService.findByCity(city).isEmpty()) {
			throw new IllegalArgumentException("City not found");
		}
		return customerService.findByCity(city);
	}
	
	@GetMapping("/es/{term}")
	@ResponseBody
	public Collection<Map<String, Object>> search(@PathVariable("term") String term){
		return dummyRepository.search(term);
	}
}
