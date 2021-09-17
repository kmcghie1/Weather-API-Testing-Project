package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class SystemDTOTest {
    SystemDTO systemDTO;
    SystemDTO mockSystemDTO;

    @BeforeEach
    void setUp() {
        systemDTO = new SystemDTO();
        mockSystemDTO = Mockito.mock(SystemDTO.class);
    }

    @Nested
    @DisplayName("Type field")
    class typeFieldTests {
        @Test
        @DisplayName("Check type field class is Integer")
        void checkTypeFieldClassIsInteger() {
            Mockito.when(mockSystemDTO.getType()).thenReturn(1);
            assertEquals(Integer.class, mockSystemDTO.getType().getClass());
        }

        @ParameterizedTest
        @DisplayName("Type must be either 1 or 2")
        @ValueSource(ints = {1,2})
        void testTypeIsOneORTwoTrue(int numbers) {
            assertTrue(systemDTO.isTypeWithinBoundaries(numbers));
        }

        @ParameterizedTest
        @DisplayName("Type must be either 1 or 2")
        @ValueSource(ints = {-1,0,3})
        void testTypeIsOneORTwoFalse(int numbers) {
            assertFalse(systemDTO.isTypeWithinBoundaries(numbers));
        }
    }

    @Nested
    @DisplayName("Id field")
    class idFieldTests {
        @Test
        @DisplayName("Check id field class is Integer")
        void checkIdFieldClassIsInteger() {
            Mockito.when(mockSystemDTO.getId()).thenReturn(1200);
            assertEquals(Integer.class, mockSystemDTO.getId().getClass());
        }

        @ParameterizedTest
        @DisplayName("Id must be within ranges 0 and int max true")
        @ValueSource(ints = {0,1, Integer.MAX_VALUE-1,Integer.MAX_VALUE})
        void testIdIsInRangeTrue(int numbers) {
            assertTrue(systemDTO.isIdWithinBoundaries(numbers));
        }

        @ParameterizedTest
        @DisplayName("Id must be within ranges 0 and int max false")
        @ValueSource(ints = {-1,Integer.MAX_VALUE+1})
        void testIdIsInRangeFalse(int numbers) {
            assertFalse(systemDTO.isIdWithinBoundaries(numbers));
        }
    }

    @Nested
    @DisplayName("Country field")
    class countryCodeTests {
        @Test
        @DisplayName("Check country field class is String")
        void checkCountryFieldClassIsString() {
            Mockito.when(mockSystemDTO.getCountry()).thenReturn("UK");
            assertEquals(String.class, mockSystemDTO.getCountry().getClass());
        }

        @ParameterizedTest
        @DisplayName("Country code must be a two letter string of capitals should be True")
        @ValueSource(strings = {"AZ","TC"})
        void testCountryIsTwoLetterTrue(String countryCode) {
            assertTrue(systemDTO.isCountryTwoLetters(countryCode));
        }

        @ParameterizedTest
        @DisplayName("Country code must be a two letter string of capitals should be False")
        @ValueSource(strings = {"az","a"," "," az","azy", "ABc"})
        void testCountryIsTwoLetterFalse(String countryCode) {
            assertFalse(systemDTO.isCountryTwoLetters(countryCode));
        }
    }

    @Nested
    @DisplayName("Sunrise & Sunset field")
    class sunriseAndSunsetTests {
        @Test
        @DisplayName("Check sunrise field class is Long")
        void checkSunriseFieldClassIsLong() {
            Mockito.when(mockSystemDTO.getSunrise()).thenReturn(9_999_999_999L);
            assertEquals(Long.class, mockSystemDTO.getSunrise().getClass());
        }

        @Test
        @DisplayName("Check Sunset field class is Long")
        void checkSunsetFieldClassIsLong() {
            Mockito.when(mockSystemDTO.getSunset()).thenReturn(9_999_999_999L);
            assertEquals(Long.class, mockSystemDTO.getSunset().getClass());
        }

        @ParameterizedTest
        @DisplayName("Sunrise Check for 10 digits")
        @ValueSource(longs = {1_000_000_000, 9_999_999_999L})
        void testSunsetTimeIsTenDigitsTrue(Long number) {
            assertTrue(systemDTO.isSunriseTenDigits(number));
        }

        @ParameterizedTest
        @DisplayName("Sunrise Check for 10 digits")
        @ValueSource(longs = {100_000_000, 999_999_999, 0})
        void testSunsetTimeIsTenDigitsFalse(Long number) {
            assertFalse(systemDTO.isSunriseTenDigits(number));
        }

        @ParameterizedTest
        @DisplayName("Sunset Check for 10 digits")
        @ValueSource(longs = {1_000_000_000, 9_999_999_999L})
        void testSunriseTimeIsTenDigitsTrue(Long number) {
            assertTrue(systemDTO.isSunsetTenDigits(number));
        }

        @ParameterizedTest
        @DisplayName("Sunset Check for 10 digits")
        @ValueSource(longs = {100_000_000, 999_999_999, 0})
        void testSunriseTimeIsTenDigitsFalse(Long number) {
            assertFalse(systemDTO.isSunsetTenDigits(number));
        }

        @Test
        @DisplayName("Sunrise before sunset test should be true")
        void testSunriseIsBeforeSunsetPasses() {
            Mockito.when(mockSystemDTO.getSunrise()).thenReturn(1_000_000_000L);
            Mockito.when(mockSystemDTO.getSunset()).thenReturn(1_000_000_001L);
            assertTrue(systemDTO.isSunriseBeforeSunset(mockSystemDTO.getSunrise(), mockSystemDTO.getSunset()));
        }

        @Test
        @DisplayName("Sunrise before sunset test should be false")
        void testSunriseIsBeforeSunsetFails() {
            Mockito.when(mockSystemDTO.getSunrise()).thenReturn(1_000_000_001L);
            Mockito.when(mockSystemDTO.getSunset()).thenReturn(1_000_000_000L);
            assertFalse(systemDTO.isSunriseBeforeSunset(mockSystemDTO.getSunrise(), mockSystemDTO.getSunset()));
        }
    }

    @AfterEach
    void tearDown() {
    }
}