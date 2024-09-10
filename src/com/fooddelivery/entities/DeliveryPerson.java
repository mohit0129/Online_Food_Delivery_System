package com.fooddelivery.entities;

public class DeliveryPerson {
	
	private int deliveryPersonId;
	private String name;
	private long contactNo;
	
	// Constructor
	public DeliveryPerson(int deliveryPersonId, String name, long contactNo) {
		super();
		this.deliveryPersonId = deliveryPersonId;
		this.name = name;
		this.contactNo = contactNo;
	}
	public int getDeliveryPersonId() {
		return deliveryPersonId;
	}
	public String getName() {
		return name;
	}
	public long getContactNo() {
		return contactNo;
	}
	@Override
	public String toString() {
		return "DeliveryPerson [deliveryPersonId=" + deliveryPersonId + ", name=" + name + ", contactNo=" + contactNo
				+ "]";
	}
	
}
