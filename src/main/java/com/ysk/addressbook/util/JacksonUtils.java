package com.ysk.addressbook.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String Object2Json(Object o) {
        String result = null;
        try {
            result = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Object2Json occur exception...");
        }
        return result;
    }
}
