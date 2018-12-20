package com.yordan.student_client.services;

import com.yordan.student_client.models.Student;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jordan
 */
@Service
public class RestClientStudentService {

	private final String HOST = "http://localhost:";
	private final String PORT = "8095";
	private final String GET_ALL_STUDENTS_URL = HOST + PORT + "/api/students/";
	private final String GET_STUDENT_URL_BY_ID = HOST + PORT + "/api/students/";
	private final String POST_STUDENT_URL = HOST + PORT + "/api/students/student";

	private final RestTemplate restTemplate;

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

	public ResponseEntity<Student> sendToSaveStudent(Student student) {
		return restTemplate.postForEntity(POST_STUDENT_URL, student, Student.class);
	}

	public boolean isFacNumberExist(String facNumber) {
		
		return false;
	}

}
