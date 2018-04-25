package com.dxc.msf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dxc.msf.dao.UserDAO;
import com.dxc.msf.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean CreateUser(UserDTO user) {
		if(!user.getUserName().isEmpty() && !user.getUserPassword().isEmpty())
		{
		boolean success = userDAO.CreateUser(user);
			if(success) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}

}
