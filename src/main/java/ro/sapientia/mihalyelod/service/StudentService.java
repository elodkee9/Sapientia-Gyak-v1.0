package ro.sapientia.mihalyelod.service;

import java.util.List;

import ro.sapientia.mihalyelod.pojo.StudentPojo;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();
	
}
