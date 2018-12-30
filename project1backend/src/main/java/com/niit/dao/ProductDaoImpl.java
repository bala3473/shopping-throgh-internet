package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Category;
import com.niit.models.Product;
@Repository  
@Transactional 
public class ProductDaoImpl implements ProductDao {
	@Autowired
private SessionFactory sessionFactory;
	private Object product;
	public ProductDaoImpl(){
		System.out.println("ProductDaoImpl bean is created..");
	}
	
	public Product getProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		//SQL query select * from product where id=2
		return product;
	}
	public void deleteProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product =new Product();
		product.getId();
		session.delete(product);
		//delete from product where id=3
	}
	
	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");
		List<Product> products =query.list();
		return products;
	}

	public void saveOrUpdate(Product product) {
		
	Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		//product.id doesn't exists in the table, then insert
		//product.id exists in the table, then update
	}



	public void updateproduct(Product p) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
	
		// TODO Auto-generated method stub
		
	}

	public void addProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.save(product);

		// TODO Auto-generated method stub
		
	}

	public Product getAllProduct(Product p1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(Product id) {
		Session session=sessionFactory.getCurrentSession();
		Product product =new Product();
		product.getId();
		session.delete(id);
	
		// TODO Auto-generated method stub
		
	}
	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}
	

	

}
