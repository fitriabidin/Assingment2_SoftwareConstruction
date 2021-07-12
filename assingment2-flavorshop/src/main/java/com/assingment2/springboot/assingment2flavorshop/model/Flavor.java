package com.assingment2.springboot.assingment2flavorshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "flavor")
public class Flavor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "flavor_type")
	private String flavortype;
	
	@Column(name = "flavor_name")
	private String flavorname;
	
	@Column(name = "flavor_niclevel")
	private String flavorniclevel;
	
	
	public Flavor() {
		super();
	}

	public Flavor(long id, String flavortype, String flavorname, String flavorniclevel) {
		super();
		this.id = id;
		this.flavortype = flavortype;
		this.flavorname = flavorname;
		this.flavorniclevel = flavorniclevel;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlavortype() {
		return flavortype;
	}
	public void setFlavortype(String flavortype) {
		this.flavortype = flavortype;
	}
	public String getFlavorname() {
		return flavorname;
	}
	public void setFlavorname(String flavorname) {
		this.flavorname = flavorname;
	}
	public String getFlavorniclevel() {
		return flavorniclevel;
	}
	public void setFlavorniclevel(String flavorniclevel) {
		this.flavorniclevel = flavorniclevel;
	}
	
	
}
