package com.herokuapp.restfulbooker;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();

    }
}