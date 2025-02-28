package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public class PayPal {

    private String email;

    public PayPal() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
