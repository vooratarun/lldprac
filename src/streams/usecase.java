package streams;

import java.util.ArrayList;
import java.util.List;

public class usecase {

    class Item {
        private Long id;
        private String name;
        private double price;

        public Item(Long id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }
    }

    List<Item> items = java.util.List.of(
            new Item(1L, "Item1", 10.0),
            new Item(2L, "Item2", 20.0),
            new Item(3L, "Item3", 30.0)
    );

    class Order {
        private Long id;
        private List<Item> items;

        public Order(Long id, List<Item> items) {
            this.id = id;
            this.items = items;
        }

        public List<Item> getItems() {
            return items;
        }
    }

    List<Order> orders = java.util.List.of(
            new Order(1L, List.of(items.get(0), items.get(1))),
            new Order(2L, List.of(items.get(1), items.get(2)))
    );

    class User {
        private Long id;
        private String name;
        private List<Order> orders;

        public User(Long id, String name, List<Order> orders) {
            this.id = id;
            this.name = name;
            this.orders = orders;
        }

        public List<Order> getOrders() {
            return orders;
        }
    }

    List<User> users = java.util.List.of(
            new User(1L, "Alice", List.of(orders.get(0))),
            new User(2L, "Bob", List.of(orders.get(1)))
    );


    public List<Item> getAllPurchasedItems(List<User> users) {


       List<Order> orderList =  users.stream().flatMap(user -> user.getOrders().stream()).toList();

       List<Item> itemList  = orderList.stream().flatMap(order -> order.getItems().stream()).toList();

       itemList.stream().forEach(item -> System.out.println("Item: " + item.getName() + ", Price: " + item.getPrice()));
       orderList.stream().forEach(order -> System.out.println("Order ID: " + order.id));




        return users.stream()
                .flatMap(user -> user.getOrders().stream())   // User → Orders
                .flatMap(order -> order.getItems().stream())  // Orders → Items
                .toList();

    }

    public List<Item> getAllPurchasedItemsForLoopVersion(List<User> users) {
        List<Item> result = new ArrayList<>();

        for (User user : users) {
            for (Order order : user.getOrders()) {
                result.addAll(order.getItems());
            }
        }

        return result;
    }


    public static void main(String[] args) {

        usecase uc = new usecase();
        List<Item> purchasedItems = uc.getAllPurchasedItems(uc.users);
        for (Item item : purchasedItems) {
            System.out.println("Purchased Item: " + item.getName() + " - Price: " + item.getPrice());
        }
    }
}
