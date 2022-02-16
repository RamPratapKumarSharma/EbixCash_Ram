package com.userinputvalidation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.userinputvalidation.exception.UserException;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(UserException.class)
	public String handleException(HttpServletRequest request, UserException exception) {
        request.setAttribute("errMsg", exception.getMessage());
        return "userinput";
	}
}
