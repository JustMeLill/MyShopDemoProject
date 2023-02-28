package InputFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtility {

    public FileInputStream fileInputStream;
    public Properties properties;

    public PropertiesUtility(String Name) {
        loadFile(Name);
    }

    private void loadFile(String Name){
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/TestData/"+Name+"Data.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public HashMap<String, String> GetAllData(){
        HashMap<String, String> TestData = new HashMap<>();
        for (String Key: properties.stringPropertyNames()){
            TestData.put(Key, properties.getProperty(Key));
        }
        return TestData;
    }
}
