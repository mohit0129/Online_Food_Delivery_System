package com.fooddelivery.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fooddelivery.entities.*;
import com.fooddelivery.services.*;

public class FoodDeliveryMain {
	
	private static FoodServices foodService = new FoodServices();
	private static CustomerServices customerService = new CustomerServices();
	private static OrderServices orderService = new OrderServices();
	private static int restaurantIdCounter = 1;
	private static int foodItemIdCounter = 1;
	private static int customerIdCounter = 1;
	private static int orderIdCounter = 1;
	private static int deliveryPersonIdCounter = 1;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Admin Panel");
			System.out.println("2. Customer Panel");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: //Admin Module
				int adminChoice;
				do {
					System.out.println("\nAdmin Menu:");
					System.out.println("1. Add Restaurant");
					System.out.println("2. Add Food Item to Restaurant");
					System.out.println("3. Remove Food Item from Restaurant");
					System.out.println("4. View Restaurant and menus");
					System.out.println("5. View Orders");
					System.out.println("6. Add Delivery Person");
					System.out.println("7. Assign Delivery Person to Order");
					System.out.println("8. Exit");
					System.out.print("Choose an option: ");
					adminChoice = scanner.nextInt();
					
					switch (adminChoice) {
					case 1:
						addRestaurant(scanner);
						break;
					case 2:
						addFoodItemToRestaurant(scanner);
						break;
					case 3:
						removeFoodItemFromRestaurant(scanner);
						break;
					case 4:
						viewRestaurantAndMenus();
						break;
					case 5:
						viewOrders();
						break;
					case 6:
						addDeliveryPerson(scanner);
						break;
					case 7:
						assignDeliveryPersonToOrder(scanner);
						break;
					case 8:
						System.out.println("Exiting Admins...");
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
					}
				} while (adminChoice != 8);
			break;
				
			case 2: //Customer Module
				int customerChoice;
				do {
					System.out.println("\nCustomer Menu:");
					System.out.println("1. Add Customer");
					System.out.println("2. View Food Items");
					System.out.println("3. Add Food to Cart");
					System.out.println("4. View Cart");
					System.out.println("5. Place Order");
					System.out.println("6. View Orders");
					System.out.println("7. Exit");
					System.out.print("Choose an option: ");
					customerChoice = scanner.nextInt();
					
					switch (customerChoice) {
					case 1:
						addCustomer(scanner);
						break;
					case 2:
						viewFoodItems();
						break;
					case 3:
						addFoodToCart(scanner);
						break;
					case 4:
						viewCart(scanner);
						break;
					case 5:
						placeOrder(scanner);
						break;
					case 6:
						viewOrders();
						break;
					case 7:
						System.out.println("Exiting Customer Menu...");
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
					}
				} while (customerChoice != 7);
			break;
			case 3:
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}

	}

	

	private static void addRestaurant(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Restaurant Name: ");
		String restaurantName = scanner.next();
		Restaurant restaurant = new Restaurant(restaurantIdCounter++, restaurantName);
		foodService.addRestaurant(restaurant);
		System.out.println("Restaurant added successfully!");
		
	}



	private static void addFoodItemToRestaurant(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Restaurant ID: ");
		int restaurantId = scanner.nextInt();
		System.out.print("Enter Food Item Name: ");
		String foodItemName = scanner.next();
		System.out.print("Enter Food Item Price: ");
		double foodItemPrice = scanner.nextDouble();
		
		FoodItem foodItem = new FoodItem(foodItemIdCounter++, foodItemName, foodItemPrice);
		foodService.addFoodItemToRestaurant(restaurantId, foodItem);
		System.out.println("Food item added successfully!");
	}



	private static void removeFoodItemFromRestaurant(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Restaurant ID: ");
		int restaurantId = scanner.nextInt();
		System.out.print("Enter Food Item ID: ");
		int foodItemId = scanner.nextInt();
		
		foodService.removeFoodItemFromRestaurant(restaurantId, foodItemId);
		System.out.println("Food item removed successfully!");
	}



	private static void viewRestaurantAndMenus() {
		// TODO Auto-generated method stub
		List<Restaurant> restaurants = foodService.getRestaurants();
		if (restaurants.isEmpty()) {
			System.out.println("No restaurants available.");
		} else {
			for (Restaurant restaurant : restaurants) {
				System.out.println("Restaurant ID: " + restaurant.getId() + ", Name: " + restaurant.getName());
				System.out.println("Menu:");
				for (FoodItem foodItem : restaurant.getMenu()) {
					System.out.println("  Food ID: " + foodItem.getId() + ", Name: " + foodItem.getName() + ", Price: " + foodItem.getPrice());
				}
			}
		}
	}



	private static void addDeliveryPerson(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Delivery Person Name: ");
		String name = scanner.next();
		System.out.print("Enter Contact Number: ");
		long contactNo = scanner.nextLong();
		DeliveryPerson deliveryPerson = new DeliveryPerson(deliveryPersonIdCounter++, name, contactNo);
		orderService.addDeliveryPerson(deliveryPerson);
		System.out.println("Delivery person added successfully!");
	}



	private static void assignDeliveryPersonToOrder(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Order ID: ");
		int orderId = scanner.nextInt();
		System.out.print("Enter Delivery Person ID: ");
		int deliveryPersonId = scanner.nextInt();
		orderService.assignDeliveryPersonToOrder(orderId, deliveryPersonId);
		System.out.println("Delivery person assigned to order successfully!");
	}



	private static void addCustomer(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Customer Id: ");
		int userId = scanner.nextInt();
		System.out.print("Enter Customer Name: ");
		String username = scanner.next();
		System.out.print("Enter Contact Number: ");
		long contactNo = scanner.nextLong();
		Customer customer = new Customer(customerIdCounter++, username, contactNo);
		customerService.addCustomer(customer);
		System.out.println("Customer added successfully!");
	}



	private static void viewFoodItems() {
		// TODO Auto-generated method stub
		List<FoodItem> foodItems = foodService.getAllFoodItems();
		if (foodItems.isEmpty()) {
			System.out.println("No food items available.");
		} else {
			for (FoodItem foodItem : foodItems) {
				System.out.println("Food ID: " + foodItem.getId() + ", Name: " + foodItem.getName() + ", Price: " + foodItem.getPrice());
			}
		}
	}



	private static void addFoodToCart(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			System.out.println("Customer not found.");
			return;
		}

		System.out.print("Enter Food Item ID: ");
		int foodItemId = scanner.nextInt();
		List<FoodItem> foodItems = foodService.getAllFoodItems();
		FoodItem foodItem = null;
		for (FoodItem item : foodItems) {
			if (item.getId() == foodItemId) {
				foodItem = item;
				break;
			}
		}
		if (foodItem == null) {
			System.out.println("Food item not found.");
			return;
		}

		System.out.print("Enter Quantity: ");
		int quantity = scanner.nextInt();
		customer.getCart().addItem(foodItem, quantity);
		System.out.println("Food item added to cart successfully!");
	}



	private static void viewCart(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			System.out.print("Customer not found.");
			return;
		}
		Map<FoodItem, Integer> cartItems = customer.getCart().getItems();
		if (cartItems.isEmpty()) {
			System.out.println("Cart is empty.");
		} else {
			for (Map.Entry<FoodItem, Integer> entry : cartItems.entrySet()) {
				System.out.println("Food ID: " + entry.getKey().getId() + ", Name: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
			}
		}
	}



	private static void placeOrder(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			System.out.println("Customer not found.");
			return;
		}
		Order order = new Order(orderIdCounter++, customer, customer.getCart().getItems());
		orderService.placeOrder(order);
		customer.getCart().clear();
		System.out.println("Order placed successfully!");
	
	}

	private static void viewOrders() {
		// TODO Auto-generated method stub
		List<Order> orders = orderService.getOrders();
		if (orders.isEmpty()) {
			System.out.println("No orders available.");
		} else {
			for (Order order : orders) {
				System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomer().getUsername() + ", Status: " + order.getStatus());
				System.out.println("Items:");
				for (Map.Entry<FoodItem, Integer> entry : order.getItems().entrySet()) {
					System.out.println("  Food ID: " + entry.getKey().getId() + ", Name: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
				}
				if (order.getDeliveryPerson() != null) {
					System.out.println("Delivery Person: " + order.getDeliveryPerson().getName());
				} else {
					System.out.println("No delivery person assigned yet.");
				}
			}
		}
	}
	
}
