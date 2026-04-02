package lld.Tomato.factories;

import lld.Tomato.models.*;
import lld.Tomato.strategies.PaymentStrategy;
import lld.Tomato.utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(
        User user,
        Cart cart,
        Restaurant restaurant,
        List<MenuItem> menuItems,
        PaymentStrategy paymentStrategy,
        double totalCost,
        String orderType
    ) {

        Order order = null;
        if (orderType.equalsIgnoreCase("Delivery")) {
            order =  new DeliveryOrder();
        } else if (orderType.equalsIgnoreCase("Pickup")) {
            order =  new PickupOrder();
        } else {
            throw new IllegalArgumentException("Invalid order type: " + orderType);
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);


        return order;
    }
}
