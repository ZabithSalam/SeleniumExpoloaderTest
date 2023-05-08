
package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import testCases.mainTest;

/**
 *
 * @author Zabith
 */
public class propertiesFile {
    
    static Properties prop = new Properties();
    
    public static void main(String[] args) {
        readPropertiesFile();
        writePropertiesFile();
    }
    
    public static void readPropertiesFile(){
        
        try {
            
            InputStream input = new FileInputStream("C:\\Users\\moham_000\\eclipse-workspace\\ExpoloaderTest\\src\\test\\java\\config\\config.properties");
            prop.load(input);
            mainTest.browser = prop.getProperty("browser");
            System.out.println(mainTest.browser);

        } catch (Exception ex) {
        
            ex.printStackTrace();
        
        }
    }
    public static void writePropertiesFile(){
        try {
            OutputStream output = new FileOutputStream("C:\\Users\\moham_000\\eclipse-workspace\\ExpoloaderTest\\src\\test\\java\\config\\config.properties");
            prop.setProperty("Result", "Pass");
            prop.store(output, null);
            
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        
    }

}
