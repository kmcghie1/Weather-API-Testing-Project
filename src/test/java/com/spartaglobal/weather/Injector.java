package com.spartaglobal.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.weather.dto.ProjectDTO;
import com.spartaglobal.weather.util.PropertiesLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Injector {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ProjectDTO injectDTO(String path) {

        if(path == null) {
            return null;
        }

        ProjectDTO dto = new ProjectDTO();
        if(path.contains("weather?q=")) {
            try {
                dto = objectMapper.readValue(new URL(path), ProjectDTO.class);
                return dto;
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
