package com.yordan.student_client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *
 * @author Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String facNumber;


	public Student() {
	}

	public Student(String firstName, String middleName, String lastName, String facNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.facNumber = facNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFacNumber() {
		return facNumber;
	}

	public void setFacNumber(String facNumber) {
		this.facNumber = facNumber;
	}
}
