package com.rafaeldeluca.uri2602.dto;

import com.rafaeldeluca.uri2602.projections.CustomerNameStateProjection;

public class CustomerNameStateDTO {
	
	private String name;
	private String state;
		
	public CustomerNameStateDTO () {
		
	}
	
	public CustomerNameStateDTO(String name, String state) {
		this.name = name;
		this.state = state;
	}		

	public CustomerNameStateDTO(CustomerNameStateProjection projection) {
		this.name = projection.getName();
		this.state = projection.getState();
	}
		
	public String getName () {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [Nome= " + name + ", estado= " + state + "]";
	}
	

}
