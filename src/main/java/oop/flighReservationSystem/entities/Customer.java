package oop.flighReservationSystem.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	
	private String firstName;
	private String lastName;
	private String planeName;
	
	
	@ManyToOne
	@JoinColumn(name = "plane_id", nullable = false)
	private Plane plane;
	
	public Customer() {
		
	}

	public Customer(int personId, String firstName, String lastName, String planeName) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.planeName = planeName;
	}

	public int getPersonId() {
		return personId;
	}

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

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	

}
