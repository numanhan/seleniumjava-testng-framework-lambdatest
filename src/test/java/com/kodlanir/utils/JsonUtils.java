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
    public static Object[][] getJsonData(String jsonFileName) { // library

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\" + jsonFileName;

        String jsonContent = null;
        List<HashMap<String, String>> dataList = null; // this field can be changed type of JSON***
        try {
            // convert json file to convert to json string -- commons-io
            jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

            // jackson-databind
            ObjectMapper mapper = new ObjectMapper();
            dataList = mapper.readValue(jsonContent,
                    new TypeReference<List<HashMap<String, String>>>() {
                    });
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
        // [{country=Argentina, gender=female, name=Esma}, {country=Belarus, gender=male, name=Fatih}]
        System.out.println(dataList); // yukarıdaki gibi geliyor ama karisik, yani firstname den sonra lastname gelmiyor.
        // field lar sirali gelmediginden Object e convert etmedim.


        //Object[][] dtt = new Object[dataa.size()][dataa.get(0).size()];
        Object[][] arrayData = new Object[dataList.size()][1];

        // arrayData = new Object[][]{{data.get(0)}, {data.get(1)}};
        // arrayData = {{data.get(0)}, {data.get(1)}, {data.get(2)}, ...}
        // arrayData is an array[][] but items of array is a hashmap (hashmap is not order)
        for (int i = 0; i < dataList.size(); i++) {
            arrayData[i][0] = dataList.get(i);
        }//
        return  arrayData;
    }


}
