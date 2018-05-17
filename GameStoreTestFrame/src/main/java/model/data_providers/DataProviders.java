package model.data_providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class DataProviders {

    public List<Map<String, Object>> parse(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(gson.newJsonReader(new FileReader(new File(filepath))), List.class);
    }
}
