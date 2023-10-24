package com.example.orm.oneToOne.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "address")
@Entity
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column
	private String street;
	@Column
	private String city;
    
	@JsonIgnore
    @OneToOne(mappedBy = "address")
    private User _user;
    
    public Address() {
    	super();
	}
    
	public Address(String street, String city,User user) {
		super();
		this.street = street;
		this.city = city;
		this._user = user;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public User get_user() {
		return _user;
	}

	public void set_user(User _user) {
		this._user = _user;
	}
    
}
