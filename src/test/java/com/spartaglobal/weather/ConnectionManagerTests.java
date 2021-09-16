package com.spartaglobal.weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectionManagerTests {
    @Test
    @DisplayName("Valid Status Code Test")
    void validStatusCodeTest() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode("London"));
    }

    @Test
    @DisplayName("Invalid Status Code Test")
    void invalidStatusCodeTest() {
        Assertions.assertEquals(404, ConnectionManager.getStatusCode("notaplace"));

    }
}
