package com.edphysics.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_materials")
public class Materials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_material")
	private int id;
	
	@Column(name = "type_material")
	private String type;
	
	@Column(name = "quantity_material")
	private String quantity;
	
	public Materials() {
		super();
	}

	public Materials(int id, String type, String quantity) {
		super();
		this.id = id;
		this.type = type;
		this.quantity = quantity;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	
	

}
