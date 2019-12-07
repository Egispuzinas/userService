package com.userService.userService.services;


import com.userService.userService.controller.models.ExternalUser;
import com.userService.userService.repository.entities.User;
import com.userService.userService.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(ExternalUser externalUser) {
		User user = ExternalUser.toInternal(externalUser);
		userRepository.save(user);
	}

	public NotFoundException deleteById(long id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return new NotFoundException("User not found with id" + id);
		}
		return null;
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
}
