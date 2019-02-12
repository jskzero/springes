package com.example.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
@CompoundIndexes({
	@CompoundIndex(name="cityIndex", def="{'address.city': 1}")
})
@Document
public class Customers {
	@Id
	private ObjectId _id;
	private String name;
	private String email;
	private String phone;
	private int __v;
	private Address address;
	
	@Tolerate
	public Customers() {
	}
}
