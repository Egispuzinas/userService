package com.userService.userService.services;


import com.userService.userService.controller.models.ExternalUser;
import com.userService.userService.repository.entities.User;
import com.userService.userService.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(ExternalUser externalUser) {
		externalUser.setPhone(FormatPhone.formatPhone(externalUser.getPhone()));
		User user = ExternalUser.toInternal(externalUser);
		userRepository.save(user);
	}

	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

	public User setOtpPsw(ExternalUser externalUser) throws NotFoundException {
		OtpGenerator otp = new OtpGenerator();
		externalUser.setOtp(otp.getOtp());
		User user = ExternalUser.toInternal(externalUser);

		return userRepository.save(user);
	}

	public User searchbyId(long id) {
		return userRepository.findById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User updateUser(ExternalUser externalUser) {
		User user = ExternalUser.toInternal(externalUser);
		return userRepository.save(user);
	}
}
