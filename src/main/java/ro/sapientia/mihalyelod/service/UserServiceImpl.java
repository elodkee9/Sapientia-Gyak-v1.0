package ro.sapientia.mihalyelod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.sapientia.mihalyelod.dao.UserRepository;
import ro.sapientia.mihalyelod.pojo.UserPojo;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserPojo> getUserByUsername() {
		List<UserPojo> userList = userRepository.findAll();
		return userList;
	}
}
