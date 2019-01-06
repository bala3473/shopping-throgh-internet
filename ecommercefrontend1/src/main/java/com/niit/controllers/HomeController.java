package com.niit.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.models.CartItem;

@Controller
public class HomeController {
	public HomeController(){
		System.out.println("homeController bean is created..");
	}
    @RequestMapping("/home")
	public String homePage(){
		return "homepage";
	}
    @RequestMapping("/aboutus")
    public String aboutUs(){
    	return "aboutuspage";
    }
    @RequestMapping("/login")
    public String login(){
    	return "login";
    }
    @RequestMapping("/loginerror")
    public String loginError(Model model){
    	model.addAttribute("loginError","Invalid Email/password");
    	return "login";
    }
    @RequestMapping("/logoutsuccess")
    public String logoutSuccess(Model model){
    	model.addAttribute("logoutSuccess","Loggedout Successfully");
    	return "login";
    }
//    @RequestMapping("/home")
//	public String homePage(@AuthenticationPrincipal Principal principal,HttpSession session){
//        List<CartItem> cartItems=null;
//    	if(principal!=null){
//         cartItems=cartItemDao.getCartItems(principal.getName());
//    	session.setAttribute("cartSize",cartItems.size());
//    	
//    	}
//		return "homePage";
//	}

}


