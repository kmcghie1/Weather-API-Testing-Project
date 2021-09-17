package com.spartaglobal.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.weather.dto.ProjectDTO;

import java.io.File;
import java.io.IOException;

public class Injector {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ProjectDTO injectDTO(String path) {
        ProjectDTO dto = new ProjectDTO();
        if(path.contains("weather")) {
            try {
                dto = objectMapper.readValue(new File(path), ProjectDTO.class);
                return dto;
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
