package com.niit.project1backend;

import java.util.List;


import javax.persistence.Id;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.niit.configuration.DBConfiguration;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.models.Product;


/**
 * Hello world!
 *
 */

public class App  
{ 
    public static void main( String[] args )
    {
      System.out.println( "Hello World!" );
        
        
      //CREATE SPRING CONTAINER , CONFIGURATION DETAILS TO THE CONTAINER
      ApplicationContext context= new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
       
      ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");

      Product product= new Product();
      product.setId(1);
      product.setDescription("hp");
      product.setPrice(20000);
      product.setProductname("lap");   //add product
      product.setQuantity(6);
      productDao.addProduct(product);


//      Product product = productDao.getProduct(13);
//System.out.println(product);
//if(product!=null){
//System.out.println(product.getId());
//System.out.println(product.getProductname());     //check is value there or not
//System.out.println(product.getDescription());
//System.out.println(product.getPrice());
//System.out.println(product.getQuantity());
//}else{
//	  System.out.println("Product id 7 not found");
//}


//            Product p=new Product();
//      p.setId();
//      p.setDescription("upate");
//      p.setPrice(10000);                  //update product
//      p.setProductname("mobile");
//      p.setQuantity(100);
//      productDao.updateproduct(p);
//    
     // Product product = productDao.getProduct(13);
 // Product p1=new Product();
 //p1.setId(4);
//  p1.setDescription("six");
 //p1.setPrice();
// p1.setproductname("bottle 309");
  // p1.setQuantity(90);
//   System.out.println("hi"+p1);
// productDao.deleteProduct(p1);
  System.out.println("get");
//   
}
}
    
 




