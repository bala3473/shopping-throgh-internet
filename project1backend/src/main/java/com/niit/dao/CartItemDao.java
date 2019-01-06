package com.niit.dao;

import java.util.List;

import com.niit.models.CartItem;
import com.niit.models.CustomerOrder;
import com.niit.models.User;

public interface CartItemDao {
void addToCart(CartItem cartItem);
User getUser(String email);
List<CartItem> getCartItems(String email);
void removeCartItem(int cartItemId);
void updateCartItem(int cartItemId, int requestedQuantity);
CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}

