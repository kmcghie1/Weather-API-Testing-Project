package com.spartaglobal.weather.tests;

import com.spartaglobal.weather.ConnectionManager;
import com.spartaglobal.weather.Injector;
import com.spartaglobal.weather.dto.helper.MainDTO;
import com.spartaglobal.weather.dto.ProjectDTO;
import com.spartaglobal.weather.util.PropertiesLoader;
import org.junit.jupiter.api.*;

public class MainDTOTest {
    MainDTO mainDTO;

    @BeforeEach
    void setup() {
        ProjectDTO projectDTO = Injector.injectDTO(
                ConnectionManager.getURL("London",
                        PropertiesLoader.getProperties().getProperty("APIKey"))
        );
        mainDTO = projectDTO.getMain();
    }

    @Nested
    @DisplayName("Testing the Getters")
    class GetterTests {

    }

    @Nested
    @DisplayName("Testing the Data Types")
    class DataTypeTests {
        @Test
        @DisplayName("temp Type Test")
        void tempTypeTest() {
            Assertions.assertSame(mainDTO.getTemp().getClass(), Double.class);
        }

        @Test
        @DisplayName("feelsLike Type Test")
        void feelsLikeTypeTest() {
            Assertions.assertSame(mainDTO.getFeelsLike().getClass(), Double.class);
        }

        @Test
        @DisplayName("pressure Type Test")
        void pressureTypeTest() {
            Assertions.assertSame(mainDTO.getPressure().getClass(), Integer.class);
        }

        @Test
        @DisplayName("humidity Type Test")
        void humidityTypeTest() {
            Assertions.assertSame(mainDTO.getHumidity().getClass(), Integer.class);
        }

        @Test
        @DisplayName("minTemp Type Test")
        void minTempTypeTest() {
            Assertions.assertSame(mainDTO.getTempMin().getClass(), Double.class);
        }

        @Test
        @DisplayName("maxTemp Type Test")
        void maxTempTypeTest() {
            Assertions.assertSame(mainDTO.getTempMax().getClass(), Double.class);
        }

        @Test
        @DisplayName("seaLevelPressure Type Test")
        void seaLevelPressureTypeTest() {
            Assumptions.assumeTrue(mainDTO.getSeaLevel() != null);
            Assertions.assertSame(mainDTO.getSeaLevel().getClass(), Integer.class);
        }

        @Test
        @DisplayName("groundLevelPressure Type Test")
        void groundLevelPressureTypeTest() {
            Assumptions.assumeTrue(mainDTO.getGrndLevel() != null);
            Assertions.assertSame(mainDTO.getGrndLevel().getClass(), Integer.class);
        }
    }

    @Nested
    @DisplayName("Min and Max Tests")
    class minMaxTests {
        @Test
        @DisplayName("Min Less Than Max Test")
        void minLessThanMaxTest() {
            Assertions.assertTrue(mainDTO.isMinTempLessThanMaxTemp());
        }
    }

    @Nested
    @DisplayName("Limit Tests")
    class LimitTests {

    }
}
