package com.uppa.nationalite;

import java.util.List;

public class Response{
	private List<CountryItem> country;
	private String name;

	public void setCountry(List<CountryItem> country){
		this.country = country;
	}

	public List<CountryItem> getCountry(){
		return country;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}