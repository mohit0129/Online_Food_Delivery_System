package com.fooddelivery.entities;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	// Holds food items and their quantities
	private Map<FoodItem, Integer> items = new HashMap<>();

	// Constructor
    public Cart(Map<FoodItem, Integer> items) {
		this.items = items;
	}

	// Adds or updates food item in the cart
	public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

	// Removes a food item from the cart
    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

	// Returns all items in the cart
    public Map<FoodItem, Integer> getItems() {
        return items;
    }

	// Clears the cart
    public void clear() {
        items.clear();
    }

	// Returns cart details as a string
    @Override
    public String toString() {
        StringBuilder cartDetails = new StringBuilder();
        double totalCost = 0;

		// Builds cart summary
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double cost = item.getPrice() * quantity;
            cartDetails.append(item.getName())
                    .append(", Quantity: ")
                    .append(quantity)
                    .append(", Cost: Rs. ")
                    .append(cost)
                    .append("\n");
            totalCost += cost;
        }
        cartDetails.append("Total Cost: Rs. ").append(totalCost);
        return cartDetails.toString();
    }

}
