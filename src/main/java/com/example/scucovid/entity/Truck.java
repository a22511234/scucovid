package com.example.scucovid.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "scu_truck")
public class Truck {
	@Id
	private String id;
	private String building;
	private String classroom;
	private String truck_date;
	private String truck_time;
	private String user_code;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getTruck_date() {
		return truck_date;
	}
	public void setTruck_date(String truck_date) {
		this.truck_date = truck_date;
	}
	public String getTruck_time() {
		return truck_time;
	}
	public void setTruck_time(String truck_time) {
		this.truck_time = truck_time;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	
	
}
