package com.userService.userService.controller;

import com.userService.userService.controller.models.ExternalUser;
import com.userService.userService.repository.entities.User;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.services.OtpGenerator;
import com.userService.userService.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
	@Autowired
	UserRepository repository;

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user/search/{id}")
	public User search(@PathVariable long id) {
		return userService.searchbyId(id);
	}

	@PostMapping(path = "/user/insertuser/", consumes = "application/json", produces = "application/json")
	public void saveUser(@RequestBody ExternalUser externalUser) {
		userService.createUser(externalUser);
	}

	@DeleteMapping(path = "/user/delete/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteById(id);
	}

	@PutMapping(path = "/user/setOtpPassword", consumes = "application/json", produces = "application/json")
	public void setOtpPassword(@Valid @RequestBody ExternalUser externalUser) throws NotFoundException {
		userService.setOtpPsw(externalUser);
	}

	@GetMapping("/user/getAllUsers")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@PutMapping(path = "/user/updateUser", consumes = "application/json", produces = "application/json")
	public void updateUser(@Valid @RequestBody ExternalUser externalUser) throws NotFoundException {
		userService.updateUser(externalUser);
	}


}
