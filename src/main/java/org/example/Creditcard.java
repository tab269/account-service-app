package org.example;

import java.util.Objects;

public class Creditcard {

    private String cardnumber;
    private String validity;
    private String cvv;

    public Creditcard() {
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creditcard that = (Creditcard) o;
        return Objects.equals(cardnumber, that.cardnumber) && Objects.equals(validity, that.validity) && Objects.equals(cvv, that.cvv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardnumber, validity, cvv);
    }

    @Override
    public String toString() {
        return "Creditcard{" +
                "cardnumber='" + cardnumber + '\'' +
                ", validity='" + validity + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
