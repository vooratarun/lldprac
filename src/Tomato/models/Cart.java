package Tomato.models;

import Tomato.factories.OrderFactory;
import Tomato.managers.OrderManager;
import Tomato.strategies.PaymentStrategy;

import java.util.List;

public class Cart {

    private Restaurant restaurant;
    private List<MenuItem> items;

    public Cart() {
        if(restaurant == null) {
            System.err.println("Cart: Set a restaurant before adding items.");
            return;
        }
        items = new java.util.ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isEmpty() {
        return restaurant == null || items.isEmpty();
    }

    public void clear() {
        items.clear();
        restaurant = null;
    }


}