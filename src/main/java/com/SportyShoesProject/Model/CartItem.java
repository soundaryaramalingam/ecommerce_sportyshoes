package com.SportyShoesProject.Model;

import java.math.BigDecimal;

public class CartItem {
	
		private long productId;
		private String name;
		private BigDecimal rate;
		private BigDecimal price;
		private int qty;
		private String category;  
		

		public long getProductId() {return this.productId; }  
		public String getName() { return this.name;} 
		public BigDecimal getPrice() { return this.price;} 
		public BigDecimal getRate() { return this.rate;} 
		public int getQty() { return this.qty;} 
	    public String getCategoryId() {return category;}
	    
		public void setProductId(long id) { this.productId= id;}
		public void setName(String value) { this.name = value;}
		public void setPrice(BigDecimal value) { this.price = value;}
		public void setRate(BigDecimal value) { this.rate = value;}
		public void setQty(int value) { this.qty = value;}
		public void setCategory(String category) {this.category = category;
		}
		
		@Override
		public String toString() {
			return "CartItem [product_id=" + productId + " ,name = "+ name+" ,price = " +price+",qty="+qty+",category="+category+" ]";
		}
		
	}