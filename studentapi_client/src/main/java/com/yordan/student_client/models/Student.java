package com.yordan.student_client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 *
 * @author Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

	private Long id;
	@Size(max = 35, message = "Името не трябва да надвишава 35 символа")
	private String firstName;
	@Size(max = 35, message = "Бащиното име не трябва да надвишава 35 символа")
	private String middleName;
	@Size(max = 35, message = "Фамилията не трябва да надвишава 35 символа")
	private String lastName;
	@Size(max = 10, message = "Факултетния номер не трябва да надвишава 10 символа")
	private String facNumber;
	private @Valid Faculty faculty;

	public Student() {
	}

	public Student(String firstName, String middleName, String lastName, String facNumber, Faculty faculty) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.facNumber = facNumber;
		this.faculty = faculty;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
}
