package org.example.HW_16.services;

import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Serializer<T> {

    private final JsonMapper JSONMapper = new JsonMapper();
    private final String extension = ".json";
    private final String path = "src/main/resources/";

    public void serialize(T obj) {
        try {
            JSONMapper.writeValue(new File(path + obj.getClass().getName() + extension), obj);
        } catch (IOException e) {
            System.out.println("Can't create file!");
        }
    }

    public Optional<T> deserialize(String className, Class<T> objectClassType) {
        try {
            return Optional.of(JSONMapper.readValue(new File(path + className + extension), objectClassType));
        } catch (IOException e) {
            System.out.println("Can't read file!");
            return Optional.empty();
        }
    }
}
