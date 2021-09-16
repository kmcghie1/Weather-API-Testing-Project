package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class SystemDTOTest {
    SystemDTO systemDTO;

    @BeforeEach
    void setUp() {
        systemDTO = new SystemDTO();
    }

    @Nested
    @DisplayName("Type field")
    class typeFieldTests {

        @ParameterizedTest
        @DisplayName("Type must be either 1 or 2")
        @ValueSource(ints = {-1,0,1,2,3})
        void testTypeIsOneORTwo(int numbers) {
            assertTrue(systemDTO.isTypeWithinBoundaries(numbers));
        }
    }

    @Nested
    @DisplayName("Id field")
    class idFieldTests {

        @ParameterizedTest
        @DisplayName("Id must be within ranges 0 and int max")
        @ValueSource(ints = {-1,0,1, Integer.MAX_VALUE-1,Integer.MAX_VALUE, Integer.MAX_VALUE+1})
        void testIdIsInRange(int numbers) {
            assertTrue(systemDTO.isIdWithinBoundaries(numbers));
        }
    }

    @Nested
    @DisplayName("Country field")
    class countryCodeTests {

        @ParameterizedTest
        @DisplayName("Country code must be a two letter string of capitals")
        @ValueSource(strings = {"AZ","TC", "az","a"," "," az","azy", "ABc"})
        void testCountryIsTwoLetter(String countryCode) {
            assertTrue(systemDTO.isCountryTwoLetters(countryCode));
        }
    }

    @Nested
    @DisplayName("Sunrise & Sunset field")
    class sunriseAndSunsetTests {

        @ParameterizedTest
        @DisplayName("Sunrise Check for 10 digits")
        @ValueSource(longs = {1_000_000_000, 9_999_999_999L,100_000_000, 999_999_999, 0})
        void testSunsetTimeIsTenDigits(Long number) {
            assertTrue(systemDTO.isSunriseTenDigits(number));
        }

        @ParameterizedTest
        @DisplayName("Sunset Check for 10 digits")
        @ValueSource(longs = {1_000_000_000, 9_999_999_999L,100_000_000, 999_999_999, 0})
        void testSunriseTimeIsTenDigits(Long number) {
            assertTrue(systemDTO.isSunsetTenDigits(number));
        }

        @Test
        @DisplayName("Sunrise before sunset test should be true")
        void testSunriseIsBeforeSunsetPasses() {
            assertTrue(systemDTO.isSunriseBeforeSunset(1_000_000_000L,1_000_000_001L));
        }

        @Test
        @DisplayName("Sunrise before sunset test should be false")
        void testSunriseIsBeforeSunsetFails() {
            assertFalse(systemDTO.isSunriseBeforeSunset(1_000_000_001L,1_000_000_000L));
        }
    }

    @AfterEach
    void tearDown() {
    }
}