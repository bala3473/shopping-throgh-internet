package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDao;
import com.niit.models.Category;
import com.niit.models.Product;

@Controller
public class ProductController {
	@Autowired
private ProductDao productDao;//automatically wire a bean of type ProductDao (ProductDaoImpl)
	public ProductController(){
		System.out.println("ProductController bean is created");
	}
	@RequestMapping(value="/all/getallproducts")
	public String getAllProducts(Model model){ // handler method returns (model and view)
		//Data the method has to return  is List<Product>
		//How to get List<Product>? (all records from product table)
		
		List<Product> products=productDao.getAllProducts();
		model.addAttribute("products",products);
		return "productslist";
	}
	@RequestMapping(value="/all/getproduct")
	public String getProduct(@RequestParam int id,Model model){//get the id of the product from the view (productslist.jsp)
		Product product=productDao.getProduct(id);
		//model is product object for the given id
		//view is viewproduct
		model.addAttribute("productAttr",product);
		return "viewproduct";
	}
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id){
		productDao.deleteProduct(id);
		return "redirect:/all/getallproducts"; //redirect the request to the handler method getAllProducts()
	}
	//to return productform.jsp
	@RequestMapping(value="/admin/getproductform")
	public String getProductform(Model model){
		Product p=new Product();
		model.addAttribute("product",p);
		List<Category> categories=productDao.getAllCategories();
		model.addAttribute("categories",categories);
		return "productform";
	}
	
	@RequestMapping(value="/admin/getupdateform")
	public String getupdateform(@RequestParam int id,Model model){
		Product product=productDao.getProduct(id);
		model.addAttribute("product",product);
		System.out.println("BEFORE GETTING FORM " +product.getId());
		List<Category> categories=productDao.getAllCategories();
		model.addAttribute("categories",categories);
		return "updateproductform";
	}
     //read the value of the modelattribute "product"
	@RequestMapping(value="/admin/addproduct")
    public String addProduct(@ModelAttribute @Valid Product product,BindingResult result,Model model){
		if(result.hasErrors())//if values are incorrect, if it violates the hibernate validator constraints
		{
			model.addAttribute("categories",productDao.getAllCategories());
			return "productform";
		}
		//call dao
		productDao.saveOrUpdate(product);
		//redirect the user to productslist.jsp
		return "redirect:/all/getallproducts";
    }
	
	@RequestMapping(value="/admin/updateproduct")
	public String updateProduct(@ModelAttribute @Valid Product product,BindingResult result,Model model){
		if(result.hasErrors()){
			model.addAttribute("categories",productDao.getAllCategories());
			return "updateproductform";
		}
		//product is already existing object with updated values
		//in the table, there is a record with the same product id.
		System.out.println("AFTER FORM SUBMIT" + product.getId());
		productDao.saveOrUpdate(product);
		return "redirect:/all/getallproducts";
		
	}
}

