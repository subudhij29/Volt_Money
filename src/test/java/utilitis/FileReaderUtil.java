package utilitis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileReaderUtil {
	public static String getObjProperty(String propName) {

		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "/src/test/resources/config/obj.properties"));
			properties.load(fis);
			return properties.getProperty(propName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propName;
	}
	public static String getConfigProperty(String propName) {

		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "/src/test/resources/config/testConfig.properties"));
			properties.load(fis);
			return properties.getProperty(propName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propName;
	}
	

	
}

