package com.example.demo.validator;



import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentFormVlaidator {
	@NotEmpty(message="Name is mandatory")
	private String name;
	
	@NotEmpty(message="Rollno is mandatory")
	private String rollNo;
	@NotEmpty(message="EmailId is mandatory")
	private String emailId;
	
	private int countryId;
	
	
	
	
}
