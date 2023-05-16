package com.SportyShoesProject.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoesProject.Model.User;
import com.SportyShoesProject.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;
	
	public User getUser(String emailId, String password) {
		 Optional<User> user = userrepo.findById(emailId);
		 if(user.isPresent()) {
			 return user.get();
		 }
		 else {
			 return null;
		 }
	}

	public void save(User user) {
		userrepo.save(user);		
	}
}
