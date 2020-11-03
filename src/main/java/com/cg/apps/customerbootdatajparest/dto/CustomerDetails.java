package com.cg.apps.customerbootdatajparest.dto;

public class CustomerDetails 
{
	private Long id;
	private String firstName, lastName;
	private Integer customerKey;
	
	public CustomerDetails()
	{ }

	public CustomerDetails(Long id, String firstName, String lastName, Integer customerKey) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerKey = customerKey;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(Integer customerKey) {
		this.customerKey = customerKey;
	}

}
