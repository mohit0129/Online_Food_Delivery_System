package com.fooddelivery.entities;

public class Customer extends User {
	
	private Cart cart;

	// Constructor initializes the customer and their cart
	public Customer(int userId, String username, long contact) {
		super(userId, username, contact);
		this.cart = new Cart(null);
	}
	
	// Returns the customer's cart
	public Cart getCart() {
        return cart;
    }	

}
