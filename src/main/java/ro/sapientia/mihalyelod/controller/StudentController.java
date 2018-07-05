package ro.sapientia.mihalyelod.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.sapientia.mihalyelod.dao.StudentRepository;
import ro.sapientia.mihalyelod.pojo.StudentPojo;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<StudentPojo> getAllStudents(){
		return studentRepository.findAll();
	}
	
	
	@PostMapping("/students")
	public StudentPojo createStudent(@Valid @RequestBody StudentPojo student) {
	    return studentRepository.save(student);
	}

	
	@PutMapping("/students/{id}")
	public StudentPojo updateStudent(@PathVariable(value = "id") Integer studentId,
	                                        @Valid @RequestBody StudentPojo studentDetails) throws Exception {

		StudentPojo student = studentRepository.findById(studentId)
	    		.orElseThrow(() -> new Exception("Student"));

	    student.setId(studentDetails.getId());
	    student.setLastName(studentDetails.getLastName());
	    student.setFirstName(studentDetails.getLastName());
	    student.setDepartment(studentDetails.getDepartment());
	    student.setYear(studentDetails.getYear());
	    student.setCreated(studentDetails.getCreated());
	    student.setUpdated(studentDetails.getUpdated());
	    student.setStatus(studentDetails.getStatus());

	    StudentPojo updatedStudent = studentRepository.save(student);
	    return updatedStudent;
	}
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Integer studentId) throws Exception {
		StudentPojo student = studentRepository.findById(studentId)
				.orElseThrow(() -> new Exception("Student"));

		studentRepository.delete(student);

	    return ResponseEntity.ok().build();
	}
	
	
}
