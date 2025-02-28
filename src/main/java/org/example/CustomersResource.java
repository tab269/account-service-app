package org.example;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomersResource {

    private final Map<Integer, Customer> customers = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @GET
    public Response getCustomers() {
        return Response.ok(customers.values()).build();
    }

    @POST
    public Response addCustomer(@Valid Customer customer) {
        Integer newId = idCounter.getAndIncrement();
        customer.setId(newId);
        customers.put(newId, customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, @Valid Customer newCustomer) {
        if (customers.containsKey(id)) {
            newCustomer.setId(id);
            customers.put(id, newCustomer);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    public Response getOneCustomer(@PathParam("id") Integer id) {
        if (customers.containsKey(id)) {
            return Response.ok(customers.get(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Integer id) {
        if (customers.containsKey(id)) {
            customers.remove(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
