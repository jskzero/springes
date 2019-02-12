package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
@Getter
@Setter
public class Dummy {
	private String title;
	private String subtitle;
	
	@Tolerate
	public Dummy() {
		
	}
}
