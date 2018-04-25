package com.dxc.msf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.msf.model.UserDTO;
import com.dxc.msf.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/user/create", method = RequestMethod.POST, produces={
	"application/json; charset=UTF-8" })
	public @ResponseBody String eventCreate(@RequestBody UserDTO user) {
	 boolean success=userService.CreateUser(user);
	 if(success) {
		 return "{\"status\": \"OK\"}";
	 }
		else {
			return "{\"status\": \"Failed\"}";
		}
		
	}

}
