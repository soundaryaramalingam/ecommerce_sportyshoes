package com.SportyShoesProject.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SportyShoesProject.Model.CartItem;
import com.SportyShoesProject.Model.PurchaseItem;
import com.SportyShoesProject.Model.Shoes;
import com.SportyShoesProject.Model.User;
import com.SportyShoesProject.Repository.PurchaseItemRepository;
import com.SportyShoesProject.Service.ItemService;
import com.SportyShoesProject.Service.PurchaseItemService;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	PurchaseItemService cart_item_service;
	
	@Autowired
	 ItemService itemserv;

	
	@GetMapping("/addCart/{product_id}")
    public String cart(ModelMap map, HttpServletRequest request,@PathVariable Long product_id)  
    {
		System.out.println("entered map...");
	  // check if user is logged in
	  HttpSession session = request.getSession();
	  if (session.getAttribute("user_id") == null) {
		  map.addAttribute("error", "Error, You need to login before adding items to cart");
	  } else {
		  // if cart is already in session then retrieve it else create a new cart list and 
		  // save it to session
		  List<CartItem> cartItems = new ArrayList<CartItem>();
		  if (session.getAttribute("cart_items") != null)
			  cartItems = (List<CartItem>) session.getAttribute("cart_items");
		  if (isItemInCart(cartItems, product_id)) {
			  map.addAttribute("error", "This item is already in your cart");
		  } else {
		  // get total of all cart items
		 
			  
	  
	  
	  
	  CartItem item = new CartItem();
	 item.setProductId(product_id);
	 item.setName(itemserv.getItem(product_id).getProduct());
	 item.setPrice(itemserv.getItem(product_id).getPrice());
	 item.setQty(1);
	 item.setCategory(itemserv.getItem(product_id).getCategory());
	 cartItems.add(item);
	 
	  session.setAttribute("cart_items", cartItems);
	  
	  BigDecimal totalValue = getCartValue(cartItems);
	 	 map.addAttribute("cartItems", cartItems);
	 	 map.addAttribute("cartValue", totalValue);
	// 	 map.mergeAttributes(map);
	 	 System.out.println("cart value : "+totalValue);
	 	 
		  }
            }
	  return "cart"; 

    }

	BigDecimal getCartValue(List<CartItem> list) {
	  BigDecimal total = new BigDecimal(0.0);
	  
	  for(CartItem item: list) {
		  BigDecimal dprice = item.getPrice().multiply(new BigDecimal(item.getQty()));
		  total= total.add(dprice);
	   }
	  return total;
  }
  private boolean isItemInCart(List<CartItem> list, long item) {
	  boolean retVal = false;
	  
	  for(CartItem thisItem: list) {
		  if (item == thisItem.getProductId()) {
			  retVal = true;
			  break;
		  }
	  }
	  return retVal;
  } 
 

	@GetMapping("/checkOut")
  public String cart(ModelMap map)  
  {
		return "checkOut";
  }

	@GetMapping("/payment")
  public ModelAndView payment(Model model,HttpServletRequest request)  
  {
		HttpSession session= request.getSession();
		 List<CartItem> cartItems = new ArrayList<CartItem>();
		 User user = null;
		 String user_id=(String) session.getAttribute("user_id");
		if (session.getAttribute("cart_items") != null)
		{
			Long uuid=UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
			  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  for(CartItem item:cartItems) {
			
			  PurchaseItem purchase=new PurchaseItem();
			  purchase.setPurchaseId(uuid);
			  purchase.setProductId(item.getProductId());
			  purchase.setUserId(user_id);
			  purchase.setQty(item.getQty());
			  purchase.setPrice(item.getPrice());
			  purchase.setDate_of_purchase(LocalDate.now());
			  cart_item_service.saveOrder(purchase);
			 
			 
			}
			  model.addAttribute("orderlist",(List<PurchaseItem>) cart_item_service.getOrderBypurchaseId(uuid));

			 		}

		
		
		//	System.out.println(itemserv.getItem(product_id));
					
	
		return new ModelAndView("orderPage");
  }
  }
 
