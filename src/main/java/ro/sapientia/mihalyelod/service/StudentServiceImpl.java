package ro.sapientia.mihalyelod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.sapientia.mihalyelod.dao.StudentRepository;
import ro.sapientia.mihalyelod.pojo.StudentPojo;

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentsDao;
	
	@Override
	public List<StudentPojo> getStudentByName() {
		List<StudentPojo> studentList = studentsDao.findAll();
		return studentList;
	}
	
}
