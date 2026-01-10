package Tomato;


import Tomato.models.Order;
import Tomato.models.Restaurant;
import Tomato.models.User;
import Tomato.strategies.UpiPaymentStrategy;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        System.out.println("Welcome to Tomato Restaurant!");

        TomatoApp app = new TomatoApp();
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");


        List<Restaurant> restaurantList = app.searchRestaurants("Delhi");
        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        app.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        app.addToCart(user,"P1");
        app.addToCart(user,"P2");
        app.printUserCart(user);


        Order order = app.checkoutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));
        app.payForOrder(user, order);
    }


}