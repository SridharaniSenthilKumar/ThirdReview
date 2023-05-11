package com.choco.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choco.demo.model.loginModel;
import com.choco.demo.repository.loginRepository;

@Service
public class loginService {
	

		@Autowired
		loginRepository lrep;
		
		public loginModel saveUser(loginModel l)
		{
			return lrep.save(l);
		}
		
		public String validateUser(String username,String password)
		{
			String result="";
			loginModel l=lrep.findByUsername(username);
			if(l==null)
			{
				result="Invalid user";
			}
				else
				{
					if(l.getPassword().equals(password))
					{
						result="Login success";
					}
					else
					{
						result="Login failed";
					}
				}
			

			return result;
			}

		
	


}