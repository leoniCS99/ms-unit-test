package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class MyUtilsControllerTest {

    @Test
    @DisplayName("valid number prime return true")
    void t1() {
        given()
                .when().get("/util/validate/prime/5")
                .then()
                .statusCode(200)
                .body(is("true"));
    }

    @Test
    @DisplayName("valid number prime return false")
    void t2() {
        given()
                .when().get("/util/validate/prime/1")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

    @Test
    @DisplayName("count text return size seven")
    void t3() {
        given()
                .when().get("/util/count/testing")
                .then()
                .statusCode(200)
                .body(is("7"));
    }
}
