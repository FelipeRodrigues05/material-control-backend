package com.edphysics.backend.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student")
	private int id;
	
	@Column(name = "name_student")
	private String name;
	
	@Column(name = "number_student")
	private int number;
	
	@Column(name = "type_material")
	private String type;
	
	public Students() {
		super();
	}

	public Students(int id, String name, int number, String type, Calendar takedHour,
			Calendar exitHour) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}