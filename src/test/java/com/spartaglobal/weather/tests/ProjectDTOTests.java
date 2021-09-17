package com.spartaglobal.weather.tests;

import com.spartaglobal.weather.ConnectionManager;
import com.spartaglobal.weather.Injector;
import com.spartaglobal.weather.dto.*;
import com.spartaglobal.weather.util.PropertiesLoader;
import org.junit.jupiter.api.*;

import java.util.List;

public class ProjectDTOTests {

    ProjectDTO projectDTO;

    @BeforeEach
    void setup() {
        projectDTO = Injector.injectDTO(
                ConnectionManager.getURL("London",
                        PropertiesLoader.getProperties().getProperty("APIKey")));
    }

    @Nested
    @DisplayName("Test Attribute Types")
    class attributeTypes {

        @Test
        @DisplayName("Coord")
        void coord() {
            Assertions.assertEquals(CoordDTO.class, projectDTO.getCoord().getClass());
        }
        @Test
        @DisplayName("Weather List")
        void weatherList() {
            Assertions.assertEquals(List.class, projectDTO.getWeather().getClass());
        }
        @Test
        @DisplayName("Weather")
        void weather() {
            Assertions.assertEquals(WeatherDTO.class, projectDTO.getWeather().get(0).getClass());
        }
        @Test
        @DisplayName("Base")
        void base() {
            Assertions.assertEquals(String.class, projectDTO.getBase().getClass());
        }
        @Test
        @DisplayName("Main")
        void main() {
            Assertions.assertEquals(MainDTO.class, projectDTO.getMain().getClass());
        }
        @Test
        @DisplayName("Visibility")
        void visibility() {
            Assertions.assertEquals(Integer.class, projectDTO.getVisibility().getClass());
        }
        @Test
        @DisplayName("Wind")
        void wind() {
            Assertions.assertEquals(WindDTO.class, projectDTO.getWind().getClass());
        }
        @Test
        @DisplayName("Clouds")
        void clouds() {
            Assertions.assertEquals(CloudsDTO.class, projectDTO.getClouds().getClass());
        }
        @Test
        @DisplayName("dt")
        void dt() {
            Assertions.assertEquals(Integer.class, projectDTO.getDt().getClass());
        }
        @Test
        @DisplayName("sys")
        void sys() {
            Assertions.assertEquals(SystemDTO.class, projectDTO.getSys().getClass());
        }
        @Test
        @DisplayName("Timezone")
        void timezone() {
            Assertions.assertEquals(Integer.class, projectDTO.getTimezone().getClass());
        }
        @Test
        @DisplayName("id")
        void id() {
            Assertions.assertEquals(Integer.class, projectDTO.getId().getClass());
        }
        @Test
        @DisplayName("Name")
        void name() {
            Assertions.assertEquals(String.class, projectDTO.getName().getClass());
        }
        @Test
        @DisplayName("cod")
        void cod() {
            Assertions.assertEquals(Integer.class, projectDTO.getCod().getClass());
        }
    }

    @Nested
    @DisplayName("Test Attribute values are not null/empty")
    class notNullOrEmpty {

    }

    @Nested
    @DisplayName("Test Helper Functions")
    class helperFunctions {

    }

    @Nested
    @DisplayName("Test getters")
    class getters {

    }

}
