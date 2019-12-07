package com.userService.userService.controller.models;

import com.userService.userService.entities.User;

import java.time.LocalDateTime;

public class ExternalUser {

	private Long id;
	private String name;
	private LocalDateTime date;
	private LocalDateTime date_modified;
	private String phone;
	private String otp;

	public ExternalUser(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.date = user.getDate();
		this.date_modified = user.getDate_modified();
		this.phone = user.getPhone();
		this.otp = user.getOtp();
	}

	public ExternalUser(){};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(LocalDateTime date_modified) {
		this.date_modified = date_modified;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public static User toInternal(ExternalUser ext) {
		return new User(ext);
	}
}
