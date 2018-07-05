package ro.sapientia.mihalyelod.service;

import java.util.List;

import ro.sapientia.mihalyelod.pojo.UserPojo;

public interface UserService {

	public List<UserPojo> getUserByUsername();
}
