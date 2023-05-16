package com.SportyShoesProject.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SportyShoesProject.Model.Admin;
import com.SportyShoesProject.Model.Shoes;
import com.SportyShoesProject.Service.AdminService;
import com.SportyShoesProject.Service.ItemService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class AdminController {

	@Autowired
	ItemService itemserv;
	
	@Autowired
	AdminService adminservice;
	
	@GetMapping("/adminPage")
	public ModelAndView AdminDashboard(Model model,HttpServletRequest request) {
		model.addAttribute("getallitems",itemserv.GetAllItems());
		 		return new ModelAndView("adminLogin");
		
	}
	@GetMapping("/edititem/{product_id}")
	public ModelAndView DisplayItem(Model model,@PathVariable Long product_id,HttpServletRequest request) {
	
		model.addAttribute("itemlist",itemserv.getItem(product_id));
		
		return new ModelAndView("itemedit");
	}

	@PostMapping("/edit/{product_id}")
	public ModelAndView EditItems(Model model,@RequestParam(name="price") BigDecimal price,@RequestParam(name="category") String category,HttpServletRequest request,
			@PathVariable Long product_id) {
		
		Shoes shoe=new Shoes();
		shoe=itemserv.getItem(product_id);
		shoe.setCategory(category);
		shoe.setPrice(price);
		itemserv.save(shoe);
		model.addAttribute("itemlist",itemserv.getItem(product_id));
		
		return new ModelAndView("redirect:/adminPage");
	}
	@GetMapping("/deleteitem/{product_id}")
	public ModelAndView DeleteItem(Model model,@PathVariable Long product_id,HttpServletRequest request) {
	
		itemserv.deleteItem(product_id);
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@GetMapping("/changepassword")
	public ModelAndView changePassword(Model model,HttpSession session,HttpServletRequest request) {
		session=request.getSession();
		System.out.println("session attr : "+(String) session.getAttribute("user_id"));

		String emailId=(String) session.getAttribute("user_id");
		 Admin admin=new Admin();
	     admin=adminservice.getbyEmailId(emailId);
System.out.println(admin);
		//adminservice.getbyEmailId(user_id);
		 model.addAttribute("getadmin",admin);
		return new ModelAndView("editPassword");
	}
	
	@PostMapping("/updatepassword")
	public ModelAndView updatePassword(Model model,RedirectAttributes redir,HttpSession session,HttpServletRequest request,@RequestParam(name="pass_word") String pass_word) {
		session=request.getSession();
		System.out.println("session attr : "+(String) session.getAttribute("user_id"));

		String emailId=(String) session.getAttribute("user_id");	
		//adminservice.getbyEmailId(user_id);
	     Admin admin=new Admin();
	     admin=adminservice.getbyEmailId(emailId);
	     admin.setPassword(pass_word);
	     adminservice.save(admin);
		 model.addAttribute("getadmin",adminservice.getbyEmailId(emailId));
		 redir.addFlashAttribute("success", "Password got changed");
		return new ModelAndView("redirect:/adminPage");
	}
	
	@GetMapping("/additemtodb")
	public String AddItem(Model model) {
		return "additemtodb";
	}
	@PostMapping("/saveitemtodb")
	public ModelAndView SaveItem(Model model,@RequestParam(name="product") String product,@RequestParam(name="product_id") String product_id,@RequestParam(name="price") BigDecimal price,@RequestParam(name="category") String category,HttpServletRequest request) {
		Shoes shoe=new Shoes();
		shoe.setProduct_id(Integer.parseInt(product_id));
		shoe.setCategory(category);
		shoe.setPrice(price);
		shoe.setProduct(product);
		itemserv.save(shoe);
		model.addAttribute("getallitems",itemserv.GetAllItems());
		return new ModelAndView("redirect:/adminPage");
	}


	
	

	
}
