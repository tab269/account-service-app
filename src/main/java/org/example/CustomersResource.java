package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomersResource {

    @Inject
    CustomerService customerService;

    @GET
    public Response getCustomers() {
        return Response.ok(customerService.getAllCustomers()).build();
    }

    @POST
    public Response addCustomer(Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        return Response.status(Response.Status.CREATED).entity(newCustomer).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Customer newCustomer) {
        if (customerService.contains(id)) {
            newCustomer.setId(id);
            customerService.updateCustomer(newCustomer);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    public Response getOneCustomer(@PathParam("id") Integer id) {
        if (customerService.contains(id)) {
            return Response.ok(customerService.find(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Integer id) {
        if (customerService.contains(id)) {
            customerService.remove(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
