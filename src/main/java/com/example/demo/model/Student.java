package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Student  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	 private String name;
	 private String rollNo;
	 @Column(name="emailId")
	 private String emailId;
	 
	 private int countryId;
	 
	 public int getId() { return 0; }
	 
	/* @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	    @JoinTable(name = "STUDENT_LAPTOP_MAPPING", joinColumns = @JoinColumn(name = "student_id"), 
	        	inverseJoinColumns = @JoinColumn(name = "laptop_id"))
	    private Set<Laptop> laptops;
	 
	
	
	public Set<Laptop> getLaptop() {
		return laptops;
	}
	public void setLaptop(Set<Laptop> laptop) {
		this.laptops = laptop;
	}*/
	
	/* @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "countryId", referencedColumnName = "id")
	 private Country country;
	
	
	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}*/




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", emailId=" + emailId + "]";
	}
	
	
	public Student() {
		
	}
	public Student(Integer id, String name, String rollNo, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.emailId = emailId;
	}
	
	 
}
