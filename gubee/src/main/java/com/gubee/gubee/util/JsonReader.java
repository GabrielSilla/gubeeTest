package com.gubee.gubee.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gubee.gubee.model.dto.product.ProductDTO;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader {

    public static List<ProductDTO> readProductJson() throws IOException {
        Gson gson = new Gson();
        String directory = System.getProperty("user.dir").concat("\\src\\main\\resources\\gubee-json.json");
        Reader reader = Files.newBufferedReader(Paths.get(directory));

        Type listType = new TypeToken<List<ProductDTO>>() {}.getType();
        List<ProductDTO> products = gson.fromJson(reader, listType);
        return products;
    }
}
