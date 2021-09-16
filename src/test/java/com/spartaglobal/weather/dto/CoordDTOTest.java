package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoordDTOTest {

    CoordDTO coordDTO;

    @BeforeEach
    void setup() {
        coordDTO = new CoordDTO();
    }

    @Nested
    @DisplayName("Testing helper methods")
    class helperMethods {

        @Nested
        @DisplayName("Testing isLatWithinBounds")
        class latBounds {
            @ParameterizedTest
            @ValueSource(doubles = {50})
            @DisplayName("Test isLatWithinBounds valid partitions")
            void testIsLatWithinBoundsValidPartitions(double value) {
                coordDTO.setLat(value);
                Assertions.assertTrue(coordDTO.isLatWithinBounds());
            }

            @ParameterizedTest
            @ValueSource(doubles = {-30, 150})
            @DisplayName("Test isLatWithinBounds invalid partitions")
            void testIsLatWithinBoundsInvalidPartitions(double value) {
                coordDTO.setLat(value);
                Assertions.assertFalse(coordDTO.isLatWithinBounds());
            }

            @ParameterizedTest
            @ValueSource(doubles = {-90, -89, 89, 90})
            @DisplayName("Test isLatWithinBounds valid boundaries")
            void testIsLatWithinBoundsValidBoundaries(double value) {
                coordDTO.setLat(value);
                Assertions.assertTrue(coordDTO.isLatWithinBounds());
            }

            @ParameterizedTest
            @ValueSource(doubles = {-91, 91})
            @DisplayName("Test isLatWithinBounds invalid boundaries")
            void testIsLatWithinBoundsInvalidBoundaries(double value) {
                coordDTO.setLat(value);
                Assertions.assertFalse(coordDTO.isLatWithinBounds());
            }
        }

        @Nested
        @DisplayName("Test isLonWithinBounds")
        class lonBounds {
            @ParameterizedTest
            @ValueSource(doubles = {50})
            @DisplayName("Test isLonWithinBounds valid partitions")
            void testIsLonWithinBoundsValidPartitions(double value) {
                coordDTO.setLon(value);
                Assertions.assertTrue(coordDTO.isLonWithinBounds());
            }

            @ParameterizedTest
            @ValueSource(doubles = {-200, 300})
            @DisplayName("Test isLonWithinBounds invalid partitions")
            void testIsLonWithinBoundsInvalidPartitions(double value) {
                coordDTO.setLon(value);
                Assertions.assertFalse(coordDTO.isLonWithinBounds());
            }

            @ParameterizedTest
            @ValueSource(doubles = {-180, -179, 179, 180})
            @DisplayName("Test isLonWithinBounds valid boundaries")
            void testIsLonWithinBoundsValidBoundaries(double value) {
                coordDTO.setLon(value);
                Assertions.assertTrue(coordDTO.isLonWithinBounds());
            }

            @ParameterizedTest
            @ValueSource(doubles = {-181, 181})
            @DisplayName("Test isLonWithinBounds invalid boundaries")
            void testIsLonWithinBoundsInvalidBoundaries(double value) {
                coordDTO.setLon(value);
                Assertions.assertFalse(coordDTO.isLonWithinBounds());
            }
        }

        @Nested
        @DisplayName("Test isCoords Correct")
        class isCoords {
            //TODO: Implement me
        }

    }

    @Nested
    @DisplayName("Testing getters")
    class getter {
        @Test
        @DisplayName("Test Lon has a value")
        void testLonHasAValue() {
            Assertions.assertNotNull(coordDTO.getLon());
        }
        @Test
        @DisplayName("Test Lat has a value")
        void testLatHasAValue() {
            Assertions.assertNotNull(coordDTO.getLat());
        }
    }

    @Nested
    @DisplayName("Testing Types")
    class types {
        @Test
        @DisplayName("Test Lon is Double")
        void testLonIsDouble() {
            Assertions.assertEquals(Double.class, coordDTO.getLon().getClass());
        }
        @Test
        @DisplayName("Test Lat is Double")
        void testLatIsDouble() {
            Assertions.assertEquals(Double.class, coordDTO.getLat().getClass());
        }
    }


}
