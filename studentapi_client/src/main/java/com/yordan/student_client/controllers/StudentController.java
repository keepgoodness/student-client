package com.yordan.student_client.controllers;

import com.yordan.student_client.models.Faculty;
import com.yordan.student_client.models.Student;
import com.yordan.student_client.services.RestClientStudentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("student")
	public String createStudent(@ModelAttribute Student student, Model model) {
		return "student-create";
	}

	@PostMapping("student")
	public String createStudent(Model model,@Valid @ModelAttribute Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student-create";
		}
		if(studentService.isFacNumberExist(student.getFacNumber())){
			result.rejectValue("faculty.name", null, "Вече съществува студент с този факултетен номер!");
			return "student-create";
		}
		ResponseEntity<Student> sv = studentService.sendToSaveStudent(student);
//		System.out.println("responce status code: " + sv.getStatusCode());
//		System.out.println("responce student: "
//				+ sv.getBody().getFirstName() + " "
//				+ sv.getBody().getMiddleName() + " "
//				+ sv.getBody().getLastName()
//				+ ", факултет: " + sv.getBody().getFaculty().getName());
		return "redirect:/students";
	}
}
