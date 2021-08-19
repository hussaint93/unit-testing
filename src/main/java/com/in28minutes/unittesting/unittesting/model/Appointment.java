package com.in28minutes.unittesting.unittesting.model;

public class Appointment {

	private int id;
	private String name;
	private String email;
	private String address;
	private Long number;
	private float amount;
	public Appointment(int id, String name, String email, String address, Long number, float amount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.number = number;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", number="
				+ number + ", amount=" + amount + "]";
	}
	
	
}
