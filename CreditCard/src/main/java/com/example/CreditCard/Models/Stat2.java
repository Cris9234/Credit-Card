package com.example.CreditCard.Models;

import java.util.Map;

public class Stat2 {

	private String success;
	private long size;
	private Map<String, Integer> payload;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;

	}
	public Map<String, Integer> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Integer> payload) {
		this.payload = payload;
	}
	
	

}
