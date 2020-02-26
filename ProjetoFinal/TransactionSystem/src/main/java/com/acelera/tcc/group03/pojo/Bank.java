package com.acelera.tcc.group03.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "bank")
public class Bank implements BaseEntity {
	@Id
	@GeneratedValue (generator = "increment")
	@Column (name = "id")
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "number")
	private String number;	
    
    public Long getId() {
		return this.id;
	}
    
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
    public String toString() {
        return "Bank ID:[" + this.getId() + "] Name: [" + this.getName() + "] Number: [" + this.getNumber() + "]";
    }
}