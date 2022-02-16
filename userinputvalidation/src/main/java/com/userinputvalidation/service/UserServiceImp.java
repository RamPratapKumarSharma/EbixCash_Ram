package com.userinputvalidation.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinputvalidation.dao.UserDaoInterface;
import com.userinputvalidation.dto.User;

@Service
public class UserServiceImp implements UserServiceInterface {

	@Autowired
	UserDaoInterface dao;

	@Override
	public int userinputvalidation(User user) {
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(user.getData());
		if (matcher.find()) {
			dao.userinputvalidation(user);
		}
		return 0;
	}

}
