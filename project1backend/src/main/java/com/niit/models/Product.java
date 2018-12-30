package com.niit.models;

import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;//Using sequence, id will get generated automatically.(Always unique and not null)
	@Column(name="pname")
	@NotEmpty(message="Productname cannot be empty")
private String productname;//--mapped with column named pname
	@NotEmpty(message="Description is mandatory")
private String description;
	@Min(value=0,message="Quantity cannot be less than 0. ") //quantity cannot be less than 0
private int quantity;
	@Min(value=1,message="Price cannot be less than 1")//price cannot be less than 1
private double price;
@ManyToOne
@JoinColumn(name="cid")
private Category category;


public int getId() {
	return id;
}
public void setId(int id) 
{
	this.id=id;
}

public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category=category;


}
}

