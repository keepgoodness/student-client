package com.yordan.student_client.models;
/**
 *
 * @author Jordan
 */
public class Faculty {


	private Long id;
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
