package oop.flighReservationSystem.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "plane")
public class Plane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planeId;
	private String planeName; 
	private String flightTime;
	
	
	@OneToMany(mappedBy = "plane")
	private Set<Customer> customers;
	
	
	public Plane() {
		
	}


	public Plane(int planeId, String planeName, String flightTime) {
		super();
		this.planeId = planeId;
		this.planeName = planeName;
		this.flightTime = flightTime;
	}
	

	public String getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}


	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}


	public int getPlaneId() {
		return planeId;
	}


	public String getPlaneName() {
		return planeName;
	}


	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	
	

	
}
