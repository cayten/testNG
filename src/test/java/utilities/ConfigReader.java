package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {//Her method dan once calisir
        String dosyayolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyayolu);
            properties=new Properties();
            properties.load(fis);//fis in okuugu bilgileri propertis e yukledi
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getProperty(String key){
/*
test metodundan yolladdigimiz string key degerini alip Propertis classindan getproperty() method unu kullanarak
bu key e ait value u bize getirir
 */

        return properties.getProperty(key);
    }

}