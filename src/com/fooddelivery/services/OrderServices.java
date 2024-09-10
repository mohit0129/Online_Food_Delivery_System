package com.fooddelivery.services;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.entities.DeliveryPerson;
import com.fooddelivery.entities.Order;


public class OrderServices {
	
	private List<Order> orders = new ArrayList<>();
	private List<DeliveryPerson> deliveryPersons = new ArrayList<>();
	
	public void placeOrder(Order order) {
		orders.add(order);
	}
	
	public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
		deliveryPersons.add(deliveryPerson);
	}
	
	public List<DeliveryPerson> getDeliveryPersons() {
		return deliveryPersons;
	}
	
	public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
		Order order = null;
	    for (Order o : orders) {
	        if (o.getOrderId() == orderId) {
	            order = o;
	            break;
	        }
	    }
	    
	    if (order == null) {
	        System.out.println("Order not found.");
	        return;
	    }
	    
	    // Find the delivery person by deliveryPersonId
	    DeliveryPerson deliveryPerson = null;
	    for (DeliveryPerson dp : deliveryPersons) {
	        if (dp.getDeliveryPersonId() == deliveryPersonId) {
	            deliveryPerson = dp;
	            break;
	        }
	    }
	    
	    if (deliveryPerson == null) {
	        System.out.println("Delivery person not found.");
	        return;
	    }
	    
	    // Assign the delivery person to the order
	    order.setDeliveryPerson(deliveryPerson);
	    
	    // Optionally update the order status
	    order.setStatus("Assigned to Delivery Person");

	    System.out.println("Delivery person " + deliveryPerson.getName() + " assigned to order " + orderId);
	}	
	
	public List<Order> getOrders() {
        return orders;
    }

}