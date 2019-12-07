package com.userService.userService.controller;

import com.userService.userService.controller.models.ExternalUser;
import com.userService.userService.entities.User;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
	@Autowired
	UserRepository repository;

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/hello")
	public static String gethello() {
		return "Hello World";
	}

	@GetMapping("/search/{id}")
	public User search(@PathVariable long id) {
		return  userService.searchbyId(id);
	}

	@PostMapping(path = "/insertuser/", consumes = "application/json", produces = "application/json")
	public void saveUser(@RequestBody ExternalUser externalUser) {
		userService.createUser(externalUser);
	}

	@DeleteMapping(path = "/delete/{id}")
	public NotFoundException deleteUser(long id) {
		userService.deleteById(id);
		try {
			userService.deleteById(id);
		} catch (Exception e) {
			return new NotFoundException("User not found with id" + id);
		}
		return null;
	}

	@PutMapping(path = "/setOtpPassword", consumes = "application/json", produces = "application/json")
	public void setOtpPassword(@Valid @RequestBody ExternalUser externalUser) throws NotFoundException {
		 userService.setOtpPsw(externalUser);
	}

	@GetMapping("/generateOtp")
	public String generateOtp() {
		OtpGenerator otp = new OtpGenerator();
		return otp.getOtp();
	}

	;
}
