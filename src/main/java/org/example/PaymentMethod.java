package org.example;

public class PaymentMethod {

    private Creditcard creditcard;
    private PayPal payPal;

    public PaymentMethod() {
    }

    public Creditcard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(Creditcard creditcard) {
        this.creditcard = creditcard;
    }

    public PayPal getPayPal() {
        return payPal;
    }

    public void setPayPal(PayPal payPal) {
        this.payPal = payPal;
    }
}
