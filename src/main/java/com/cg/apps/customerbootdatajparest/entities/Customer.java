package com.cg.apps.customerbootdatajparest.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="customers")
@Entity
public class Customer 
{
	@GeneratedValue
	@Id
	private Long id;
	private String firstName, lastName;
	private Integer customerKey;
	
	public Customer() 
	{}	
	
	public Customer(String firstName, String lastName, Integer customerKey) {
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
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", customerKey="
				+ customerKey + "]";
	}
	
	@Override
	public int hashCode() {
		int hashCode=Objects.hashCode(id);
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer that = (Customer) obj;
	    return this.id.equals(that.id);
	}
	
}
