package com.kodlanir.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class JsonUtils {

    // this method is used for json file to List<HashMap>
    public static String[][] getJsonData(String jsonFileName) { // library

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\"+ jsonFileName;

        String jsonContent = null;
        List<HashMap<String, String>> data = null;
        try {
            // convert json file to convert to json string -- commons-io
            jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

            // jackson-databind
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(jsonContent,
                    new TypeReference<List<HashMap<String, String>>>() {
                    });
        }
        catch(Exception ex)
        {
            System.out.println("Error : "+ ex);
        }
        // [{country=Argentina, gender=female, name=Esma}, {country=Belarus, gender=male, name=Fatih}]
        System.out.println(data);

        String[][] dt = new String[data.size()][data.get(0).size()];

        // list<hashmap> to object[][]
        for(int i =0; i< data.size(); i++)
        {
            dt[i] = data.get(i).values().toArray(new String[0]);

        }
        System.out.println(dt);

        return dt;

    }



}
