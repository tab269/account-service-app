package org.example;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class PaymentMethod {

    @Embedded
    private Creditcard creditcard;

    @Embedded
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
