package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties intializePropertis() throws IOException {

		Properties prop = new Properties();
		File propfile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\Config.properties");
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		return prop;
	}

}
