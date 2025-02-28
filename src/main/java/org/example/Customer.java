package org.example;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Customer {

    private Integer id;

    @NotBlank(message = "Vorname darf nicht null oder leer sein")
    @Size(max = 100, message = "Vorname darf nicht länger als 100 Zeichen sein.")
    private String vorname;

    @NotBlank(message = "Nachname darf nicht null oder leer sein")
    @Size(max = 100, message = "Nachname darf nicht länger als 100 Zeichen sein.")
    private String nachname;
    private Adresse adresse;
    private PaymentMethod paymentMethod;
    private Status status;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
