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

import ro.sapientia.mihalyelod.dao.UserRepository;
import ro.sapientia.mihalyelod.pojo.UserPojo;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<UserPojo> getAllusers(){
		return userRepository.findAll();
	}
	
	
	@PostMapping("/users")
	public UserPojo createuser(@Valid @RequestBody UserPojo user) {
	    return userRepository.save(user);
	}
	
	
	@PutMapping("/users/{id}")
	public UserPojo updateUser(@PathVariable(value = "id") Integer userId,
	                                        @Valid @RequestBody UserPojo userDetails) throws Exception {

		UserPojo user = userRepository.findById(userId)
	    		.orElseThrow(() -> new Exception("User"));

	    user.setId(userDetails.getId());
	    user.setUsername(userDetails.getUsername());
	    user.setPassword(userDetails.getPassword());
	    

	    UserPojo updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) throws Exception {
		UserPojo user = userRepository.findById(userId)
				.orElseThrow(() -> new Exception("User"));

		userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
	
}
