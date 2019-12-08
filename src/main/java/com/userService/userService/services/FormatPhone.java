package com.userService.userService.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class FormatPhone {

	public static String formatPhone(String phone) {
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		Phonenumber.PhoneNumber ltNumberProto = null;
		String formatedNumber = null;

		if (phone.length() == 8) {
			try {
				ltNumberProto = phoneUtil.parse(phone, "LT");
			} catch (NumberParseException e) {
				return null;
			}
			formatedNumber = phoneUtil.format(ltNumberProto, PhoneNumberUtil.PhoneNumberFormat.E164);
			return formatedNumber;
		} else return null;

	}

}
