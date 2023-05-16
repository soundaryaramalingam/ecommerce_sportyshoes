package com.SportyShoesProject.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Shoes")
public class Shoes {
	
@Id
private int product_id;
@Column
private String product;
@Column
private BigDecimal price;
@Column
private String category;

public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
@Override
public String toString() {
	return "Shoes [product_id=" + product_id + ", product=" + product + ", price=" + price + ", category="
			+ category+" ]";
}


}
