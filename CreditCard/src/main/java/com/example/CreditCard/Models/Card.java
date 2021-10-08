package com.example.CreditCard.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Card {

	private Numbers number;
	private String scheme;
	private String type;
	private Bank bank;
	
	public Numbers getNumber() {
		return number;
	}
	public void setNumber(Numbers number) {
		this.number = number;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
}
