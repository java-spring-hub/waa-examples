package app06b.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class Employee  implements Serializable {
    private static final long serialVersionUID = -908L;

	private long id;
 	@NotEmpty
 	@Size(min=4, max=50, message="{Size.name.validation}")
	private String firstName;
	@NotEmpty(message="Enter the last name")
	private String lastName;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
//  @DateTimeFormat(iso = ISO.DATE) // yyyy-MM-dd
//  @DateTimeFormat(style = "L-") // July 12, 2001
//   @DateTimeFormat(pattern="hh:mm:ss")  
 	private Date birthDate;
	
	
//	@NotEmpty
 	@NotNull
	private int salaryLevel;
	
	@Valid
	private Address address;

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getSalaryLevel() {
		return salaryLevel;
	}
	public void setSalaryLevel(int salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

}
