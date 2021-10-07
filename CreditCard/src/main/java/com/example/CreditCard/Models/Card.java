package com.example.CreditCard.Models;

public class Card {

	private long id;
	private Numbers number;
	private String scheme;
	private String type;
	private Bank bank;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
