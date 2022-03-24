package com.uppa.nationalite;

import com.google.gson.annotations.SerializedName;

public class CountryItem{
	private double probability;
	@SerializedName("country_id")
	private String countryId;

	public void setProbability(double probability){
		this.probability = probability;
	}

	public double getProbability(){
		return probability;
	}

	public void setCountryId(String countryId){
		this.countryId = countryId;
	}

	public String getCountryId(){
		return countryId;
	}
}
