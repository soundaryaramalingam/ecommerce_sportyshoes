package com.SportyShoesProject.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SportyShoesProject.Model.Admin;
import com.SportyShoesProject.Model.User;
import com.SportyShoesProject.Repository.UserRepository;
import com.SportyShoesProject.Service.AdminService;
import com.SportyShoesProject.Service.UserService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
	
@Autowired
private UserService userservice;

@Autowired
private AdminService adminservice;

@GetMapping("/home")
public ModelAndView homePage() {
	return new ModelAndView("loginPage");
}

@PostMapping("/login")
public ModelAndView loginPage(Model model,@RequestParam(name="emailId") String emailId,@RequestParam(name="pass_word") String pass_word,
		HttpServletRequest request) {
	
	
	
	if(userservice.getUser(emailId, pass_word)!=null) {
		System.out.println(emailId+"   "+userservice.getUser(emailId, pass_word));
		String mail=userservice.getUser(emailId, pass_word).getEmailId();
		String pass=userservice.getUser(emailId, pass_word).getPassword();
		
		if(emailId.equals(mail)&&pass_word.equals(pass)) {
			HttpSession session = request.getSession();
			 session.setAttribute("user_id",emailId);
			 model.addAttribute("getuser",userservice.getUser(emailId, pass_word));
			return new ModelAndView("redirect:/itemList");	
		}
		else {
			return new ModelAndView("loginPage");
		}
	}
	else if(adminservice.getAdmin(emailId, pass_word)!=null) {
		System.out.println(emailId+"   "+adminservice.getAdmin(emailId, pass_word));
		String mail=adminservice.getAdmin(emailId, pass_word).getEmailId();
		String pass=adminservice.getAdmin(emailId, pass_word).getPassword();
		
		if(emailId.equals(mail)&&pass_word.equals(pass)) {
			HttpSession session = request.getSession();
			 session.setAttribute("user_id",emailId);
			 model.addAttribute("getuser",adminservice.getAdmin(emailId, pass_word));
			return new ModelAndView("redirect:/adminPage");	
		}
		else {
			return new ModelAndView("loginPage");
		}
	}

	else {
		return new ModelAndView("loginPage");
	}
}

@GetMapping("/logout")
public ModelAndView LogOut(HttpSession session) {
	session.invalidate();
	return new ModelAndView("loginPage");
}

@GetMapping("/signup")
public ModelAndView SignUp() {
	return new ModelAndView("SignUp");
}

@PostMapping("/saveuser")
public ModelAndView saveuser(Model model,HttpServletRequest request) throws ParseException {
	User user=new User();
	user.setEmailId(request.getParameter("emailId"));
	user.setCountry(request.getParameter("country"));
	String datestring=request.getParameter("date_of_birth");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	Date date = (Date) formatter.parse(datestring);
	user.setDateOfBirth(date);
	user.setFirstName(request.getParameter("firstName"));
	user.setLastName(request.getParameter("lastName"));
	user.setPassword(request.getParameter("pass_word"));
	user.setGender(request.getParameter("gender"));
	userservice.save(user);
	

	
	
	return new ModelAndView("loginPage");
}

}
