package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomersResourceTest {

    @Test
    void getCustomers_should_return_empty_collection() {
        RestAssured.given()
                .when().get("/customers")
                .then()
                .statusCode(200)
                .body("", empty());
    }

    @Test
    void getCustomers_should_return_collection_with_one_entry_after_successful_post() {
        Customer newCustomer = new Customer();
        newCustomer.setVorname("Adam");
        newCustomer.setNachname("Aleph");

        RestAssured.given()
            .contentType("application/json")
            .body(newCustomer)
        .when()
            .post("/customers")
        .then()
            .statusCode(201);

        newCustomer.setId(1);
        Customer expectedCustomer = newCustomer;
        Response r = RestAssured.given()
                .when().get("/customers");
        String body = r.getBody().asString();
        r.then()
                .statusCode(200)
                .body("$[0].id", notNullValue())
                .body("$[0].vorname", equalTo("Adam"))
                .body("$[0].nachname", equalTo("Aleph"));
    }
}