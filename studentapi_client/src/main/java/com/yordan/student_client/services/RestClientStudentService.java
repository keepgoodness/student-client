package com.yordan.student_client.services;

import com.yordan.student_client.models.Student;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jordan
 */
@Service
public class RestClientStudentService {

	private final RestTemplate restTemplate;
	private final String GET_ALL_STUDENTS_URL = "http://localhost:8095/api/students/";
	private final String GET_STUDENT_URL_BY_ID = "http://localhost:8095/api/students/";

	@Autowired
	public RestClientStudentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Student> findAllStudents() {
		return Arrays.stream(restTemplate.getForObject(GET_ALL_STUDENTS_URL, Student[].class))
				.collect(Collectors.toList());
	}

	public Student findStudentById(String id) {
		return restTemplate.getForObject(GET_STUDENT_URL_BY_ID.concat(id), Student.class);
	}

}
