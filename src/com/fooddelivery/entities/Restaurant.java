package com.fooddelivery.entities;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private int id;
	private String name;
	private List<FoodItem> menu;
	
	public Restaurant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.menu = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<FoodItem> getMenu() {
		return menu;
	}
	
	public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int foodItemId) {
        menu.removeIf(item -> item.getId() == foodItemId);
    }
    
    @Override
    public String toString() {
        StringBuilder menuDetails = new StringBuilder();
        menuDetails.append("Restaurant ID: ").append(id).append(", Name: ").append(name).append("\n");
        for (FoodItem item : menu) {
            menuDetails.append(item).append("\n");
        }
        return menuDetails.toString();
    }
	
	

}
