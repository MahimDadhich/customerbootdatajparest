package com.cg.apps.customerbootdatajparest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateCustomerRequest 
{
	private Long id;
	@NotBlank
    @NotBlank @Size(min =2, max = 20)
    private String firstName;

    @Min(1) @Max(100)
    private Integer customerkey;

    @NotBlank
    @NotBlank @Size(min =2, max = 20)
    private String lastName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Integer getCustomerkey() {
		return customerkey;
	}

	public void setCustomerkey(Integer customerkey) {
		this.customerkey = customerkey;
	}

    
}
