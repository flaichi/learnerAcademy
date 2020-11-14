package com.fl.school.dao;

import com.fl.school.exceptions.InvalidCredentialException;
import com.fl.school.modal.Admin;

public interface  AdminDao {
	
	 Long saveAdmin(Admin admin);

	 void updateAdmin(Admin admin);
	 
	 boolean validateLogin(String user, String pswd) throws InvalidCredentialException;

		
}

