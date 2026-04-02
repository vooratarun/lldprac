package lld.Tomato.factories;

import lld.Tomato.models.*;
import lld.Tomato.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {

    Order createOrder(
        User user,
        Cart cart,
        Restaurant restaurant,
        List<MenuItem> menuItems,
        PaymentStrategy paymentStrategy,
        double totalCost,
        String orderType
    );
}
