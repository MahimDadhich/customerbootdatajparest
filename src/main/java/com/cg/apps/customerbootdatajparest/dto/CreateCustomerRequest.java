package com.cg.apps.customerbootdatajparest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCustomerRequest 
{
	@NotBlank @Size(min =2, max = 20)
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank @Size(min =2, max = 20)
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Min(1) @Max(100)
    private Integer customerKey;

	public Integer getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(Integer customerKey) {
		this.customerKey = customerKey;
	}

   
	
}
