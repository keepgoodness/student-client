package com.yordan.student_client.models;

import javax.validation.constraints.Size;

/**
 *
 * @author Jordan
 */
public class Faculty {


	private Long id;
	@Size(max = 10, message = "Името на факултета не трябва да надвишава 10 символа")
	private String name;

	public Faculty() {
	}

	public Faculty(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
