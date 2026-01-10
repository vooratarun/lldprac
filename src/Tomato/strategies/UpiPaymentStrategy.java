package Tomato.strategies;

public class UpiPaymentStrategy implements PaymentStrategy{

    public String mobile;
    public UpiPaymentStrategy(String mobile) {
        this.mobile = mobile;
    }


    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");

    }
}
