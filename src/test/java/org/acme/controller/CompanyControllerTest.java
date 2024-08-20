package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.acme.entity.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@QuarkusTest
class CompanyControllerTest {

    @Test
    @DisplayName("create company return company dto")
    void t1() {
        Company company = Company.builder()
                .name("company")
                .address("street company")
                .registry("registry")
                .phone("449987768")
                .build();

        RestAssured
                .given()
                .contentType("application/json")
                .body(company)
                .when().post("/company")
                .then()
                .statusCode(200)
                .body("name", equalTo("company"))
                .body("address", equalTo("street company"))
                .body("registry", equalTo("registry"))
                .body("phone", equalTo("449987768"));
    }


    @Test
    @DisplayName("get list company return company")
    void t2() {
        RestAssured
                .given()
                .when().get("/company")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }
}
