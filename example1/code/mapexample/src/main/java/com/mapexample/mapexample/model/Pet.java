package com.mapexample.mapexample.model;
import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;

	public Pet() {
		
	}
	
	public Pet(String name) {
		this.name = name;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name;			
	}
}