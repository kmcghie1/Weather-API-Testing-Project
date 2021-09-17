package com.spartaglobal.weather.tests;

import com.spartaglobal.weather.ConnectionManager;
import com.spartaglobal.weather.Injector;
import com.spartaglobal.weather.dto.ProjectDTO;
import com.spartaglobal.weather.util.PropertiesLoader;
import org.junit.jupiter.api.*;

public class InjectorTests {

    ProjectDTO projectDTO;
    String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=";

    @BeforeEach
    void setup() {
        projectDTO = Injector.injectDTO(url + PropertiesLoader.getProperties().getProperty("APIKey"));
    }

    @Nested
    @DisplayName("Test return type")
    class returnType {
        @Test
        @DisplayName("Test return type is ProjectDTO")
        void testReturnTypeIsProjectDto() {
            Assertions.assertEquals(ProjectDTO.class, projectDTO.getClass());
        }
    }

    @Nested
    @DisplayName("Null & Empty checks")
    class nullValues {
        @Test
        @DisplayName("Test return value isnt null")
        void testReturnValueIsntNull() {
            Assertions.assertNotNull(projectDTO);
        }

        @Test
        @DisplayName("Test return value isn't empty")
        void testReturnValueIsnTEmpty() {
            ProjectDTO emptyDTO = new ProjectDTO();
            Assertions.assertNotEquals(projectDTO.toString(), emptyDTO.toString());
        }

        @Test
        @DisplayName("Test null path input returns null")
        void testNullPathInputReturnsNull() {
            ProjectDTO nullDTO =
                    Injector.injectDTO(null);
            Assertions.assertNull(nullDTO);
        }

        @Test
        @DisplayName("Test invalid path input returns null")
        void testInvalidPathInputReturnsNull() {
            ProjectDTO nullDTO =
                    Injector.injectDTO("invalidPath");
            Assertions.assertNull(nullDTO);
        }
    }
}
