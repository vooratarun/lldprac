package streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class backend {
    public static void main(String[] args) {

        class User {
            private final int id;
            private final String name;
            private final String email;

            public User(int id, String name, String email) {
                this.id = id;
                this.name = name;
                this.email = email;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getEmail() {
                return email;
            }
        }
        class UserResponse {
            private final int id;
            private final String name;
            private final String email;

            public UserResponse(int id, String name, String email) {
                this.id = id;
                this.name = name;
                this.email = email;
            }
        }

        List<User> users = List.of(
                new User(1,"tar","tar@gmail.com"),
                new User(2, "ram","ram@gmail.com"),
                new User(3, "ram","ram@gmail.com"),
                new User(4,"sita",null)

        );

        List<UserResponse> responses = users.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();

        responses.stream().forEach(r -> System.out.println(r.email));
        System.out.println(responses);

//        List<UserResponse> responses2 = users.stream()
//                .filter(Objects::nonNull)
//                .map(this::toResponse)
//                .toList();

        enum OrderStatus{
            ACTIVE,
            INACTIVE,
            PENDING
        }


        class Order{
            private final int id;
            private final OrderStatus status;

            int amount;

            final User user;
            public Order(int id, OrderStatus status, int amount,User user) {
                this.id = id;
                this.status = status;
                this.amount = amount;
                this.user = user;
            }

            public int getId() {
                return id;
            }

            public OrderStatus getStatus() {
                return status;
            }

            public int getAmount() {
                return amount;
            }

            public User getUser() {
                return user;
            }
        }


        User alice = new User(1,"alice","alice@gmail.com");
        User bob = new User(2,"bob","bob@gmail.com");

        List<Order> orders = List.of(
                new Order(1, OrderStatus.ACTIVE,100, alice),
                new Order(2, OrderStatus.INACTIVE,200,bob),
                new Order(3, OrderStatus.PENDING,150,alice),
                new Order(4, OrderStatus.ACTIVE,200,bob)
        );


        List<Order> activeOrders = orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.ACTIVE)
                .toList();

        System.out.println("Active Orders Count: " + activeOrders.size());

        List<Order> conds =  orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.ACTIVE)
                .filter(o -> o.getId() > 2)
                .toList();

        System.out.println("Cond Orders Count: " + conds.size());

        double totalRevenue = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
        System.out.println("Total Revenue: " + totalRevenue);


        Map<OrderStatus, Long> countByStatus =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getStatus,
                                Collectors.counting()
                        ));

        System.out.println(countByStatus);


        Map<Long, List<Order>> ordersByUser =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                o -> (long) o.getUser().getId()
                        ));

        for (Map.Entry<Long, List<Order>> entry  : ordersByUser.entrySet()) {
            System.out.println("User ID: " + entry.getKey());
            for (Order o : entry.getValue()) {
                System.out.println(" - Order ID: " + o.getId() + ", Amount: " + o.getAmount());
            }
        }

        Map<Long,Double> revenueByuser =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                o ->(long) o.getUser().getId(),
                                Collectors.summingDouble(Order::getAmount
                                ))
                        );
        System.out.println(revenueByuser);



        List<String> uniqueEmails = users.stream()
                .map(User::getEmail)
                .distinct()
                .toList();

        System.out.println("Unique Emails: " + uniqueEmails);

        Collection<User> uniqueUsers =
                users.stream()
                        .collect(Collectors.toMap(
                                User::getEmail,
                                u -> u,
                                (u1, u2) -> u1
                        ))
                        .values();

        System.out.println("Unique Users Count: " + uniqueUsers.size());


        List<User> invalidUsers =
                users.stream()
                        .filter(u -> u.getEmail() == null || u.getEmail().isBlank())
                        .toList();
        System.out.println("Invalid Users Count: " + invalidUsers.size());




    }
}
