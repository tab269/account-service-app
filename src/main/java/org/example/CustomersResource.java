package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.springframework.hateoas.Link;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomersResource {

    @Context
    UriInfo uriInfo;

    private final Map<Integer, Customer> customers = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @GET
    public Response getCustomers() {
        return Response.ok(customers.values()).build();
    }

    @POST
    public Response addCustomer(Customer customer) {
        Integer newId = idCounter.getAndIncrement();
        customer.setId(newId);
        customers.put(newId, customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Customer newCustomer) {
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
            Customer result = customers.get(id);
            Link selfLink = Link.of(uriInfo.getAbsolutePath().toString()).withSelfRel();
            result.add(selfLink);
            return Response.ok(result).build();
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
