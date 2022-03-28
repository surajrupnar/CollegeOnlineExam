package com.online.dao;

import java.util.ArrayList;


import com.online.model.Login;
import com.online.model.Registration;


public class UserService {		
	DBConnect dbconnect = new DBConnect();
	
	public boolean checkLogin(Login login) {
		return  dbconnect.checkLogin(login);		
	}
	
	public boolean registation(Registration registration) {
		return  dbconnect.registartion(registration);		
	}
	
}