package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CloudsDTOTest {

    CloudsDTO cloudsDTO;

    @BeforeEach
    void setup(){
        cloudsDTO = new CloudsDTO();
    }

    @Test
    @DisplayName("Testing the percentage boundaries")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100, 101})
    void testPercentageBoundaries(int percentages){
        Assertions.assertTrue(cloudsDTO.isPercentWithinBoundaries(percentages));
    }

}
