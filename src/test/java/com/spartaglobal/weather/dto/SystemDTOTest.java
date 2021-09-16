package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SystemDTOTest {
    SystemDTO systemDTO;

    @BeforeEach
    void setUp() {
        systemDTO = new SystemDTO();
    }

    @ParameterizedTest
    @DisplayName("Type must be either 1 or 2")
    @ValueSource(ints = {-1,0,1,2,3})
    void testTypeIsOneORTwo( int numbers) {
        assertTrue(systemDTO.isTypeWithinBoundaries(numbers));
    }

    @AfterEach
    void tearDown() {
    }
}