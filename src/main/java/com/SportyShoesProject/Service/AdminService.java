package com.SportyShoesProject.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoesProject.Model.Admin;
import com.SportyShoesProject.Model.User;
import com.SportyShoesProject.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminrepo;
	
	public Admin getAdmin(String emailId, String password) {
		 Optional<Admin> admin = adminrepo.findById(emailId);
		 if(admin.isPresent()) {
			 return admin.get();
		 }
		 else {
			 return null;
		 }
	}
	
	public Admin getbyEmailId(String emailId) {
		System.out.println("entered ..."+emailId);
		 Optional<Admin> admin = adminrepo.findById(emailId);
		 if(admin.isPresent()) {
			 return admin.get();
		 }
		 else {
			 return null;
		 }		
	}
	public void save(Admin admin) {
		adminrepo.save(admin);		
	}

}
