package com.wildcodeschool.begin.aSpringQuest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moto {
	
	public Moto() {
		
	}
	
	public Moto(String make, String model, int cc) {
		this.setMake(make);
		this.setModel(model);
		this.cc=cc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int cc;
	private String model;
	private String make;
	
	@Override
	public String toString() {
		return "Moto: [id="+id+", cc="+cc+", model="+model+", make="+make+"]";
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	public int getCc() {
		return this.cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

}
