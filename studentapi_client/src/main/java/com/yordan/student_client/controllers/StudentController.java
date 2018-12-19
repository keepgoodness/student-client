package com.yordan.student_client.controllers;

import com.yordan.student_client.services.RestClientStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Jordan
 */
@Controller
public class StudentController {

	private final RestClientStudentService studentService;

	@Autowired
	public StudentController(RestClientStudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.findAllStudents());
		return "students";
	}

	@GetMapping("student/{id}")
	public String getstudentById(@PathVariable String id, Model model) {
		model.addAttribute("student", studentService.findStudentById(id));
		return "singlestudent";
	}
}
