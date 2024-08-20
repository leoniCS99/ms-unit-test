package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@RequiredArgsConstructor
class MyUtilsServiceTest {

    private final MyUtilsService myUtilsService;

    @Test
    @DisplayName("test prime number validation")
     void t1(){
        assertTrue(myUtilsService.isPrimeNumber(5));
        assertFalse(myUtilsService.isPrimeNumber(0));
    }

    @Test
    @DisplayName("test text size validation")
    void t2(){
        assertEquals(19, myUtilsService.countCharacters("Testing this method"));
        assertEquals(7, myUtilsService.countCharacters("Testing"));
    }
}
