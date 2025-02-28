package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CustomerService {

    private final EntityManager em = Customer.getEntityManager();


    @Transactional
    public Customer createCustomer(Customer customer) {
        customer.setId(null);
        customer.persist();
        return customer;
    }

    @Transactional
    public void updateCustomer(Customer newCustomer) {
        em.merge(newCustomer);
    }

    public List<Customer> getAllCustomers() {
        return Customer.listAll();
    }

    public boolean contains(Integer id) {
        return Customer.count("id", id) > 0;
    }

    public Object find(Integer id) {
        return Customer.findById(id);
    }

    @Transactional
    public void remove(Integer id) {
        Customer.deleteById(id);
    }
}
