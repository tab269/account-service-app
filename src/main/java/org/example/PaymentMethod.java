package org.example;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(creditcard, that.creditcard) && Objects.equals(payPal, that.payPal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditcard, payPal);
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "creditcard=" + creditcard +
                ", payPal=" + payPal +
                '}';
    }
}
