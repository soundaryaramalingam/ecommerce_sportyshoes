package com.SportyShoesProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SportyShoesProject.Service.ItemService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ItemController {

	@Autowired
	ItemService itemserv;
	
	@GetMapping("/itemList")
	public ModelAndView UserDashboard(Model model,HttpServletRequest request) {
		model.addAttribute("getallitems",itemserv.GetAllItems());
		 		return new ModelAndView("userDashboard");
		
	}
	
	@GetMapping("/itemList/{product_id}")
	public ModelAndView ViewItem(Model model,@PathVariable Long product_id) {
		
		System.out.println("entered...  ");
	//	System.out.println(itemserv.getItem(product_id));
		model.addAttribute("itemlist",itemserv.getItem(product_id));
		return new ModelAndView("home");
		
	}
	
}
