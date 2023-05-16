package com.SportyShoesProject.Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.xml.crypto.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "purchase_items")   
public class PurchaseItem { 

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "purchase_id")
	private long purchaseId;
	
	@Column(name = "product_id")
	private long productId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "qty")
	private int qty;

	@Column(name = "price")
	private BigDecimal price;
	
//	@Column(name = "category")
//	private int category;
	@Column(name="date_of_purchase")
	private LocalDate date_of_purchase;
	
	public long getID() {return this.id; }
	public long getPurchaseId() { return this.purchaseId;}
	public long getProductId() { return this.productId;}
	public String getUserId() { return this.userId;}
	public int getQty() { return this.qty;}	
	public BigDecimal getPrice() { return this.price;}
	
	
//	public int getCategory() {
//		return category;
//	}
//	public void setCategory(int category) {
//		this.category = category;
//	}
	
	public LocalDate getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(LocalDate localDate) {
		this.date_of_purchase = localDate;
	}
	public void setID(long id) { this.id = id;}
	public void setPurchaseId(long value) { this.purchaseId = value;}
	public void setProductId(long value) { this.productId = value;}
	public void setUserId(String value) { this.userId = value;}
	public void setQty(int value) { this.qty= value;}
	public void setPrice(BigDecimal value) { this.price= value;}
	
	@Override
	public String toString() {
		return "PurchaseItem [product_id=" + id + ", purchaseId=" + purchaseId + ", productId=" + productId + ", userId="
				+ userId+ ",qty="+qty+",price="+price+",date_of_purchase="+date_of_purchase+" ]";
	}

	
	

}