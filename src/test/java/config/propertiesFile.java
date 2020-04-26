package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import tests.LoginTest;

public class propertiesFile {
	static Properties prop = new Properties();
	
	public static String getProperties()
	{
		String browserName=null;
		try {
			FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
			prop.load(fp);
			String browser=prop.getProperty("browser");
			browserName = browser; 
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return browserName;
	}


	public static void setProperty() {

		try {
			FileOutputStream op = new FileOutputStream(System.getProperty("userdir")+"\\src\\test\\java\\config\\config.properties");

			prop.setProperty("browser", "Firefox");
			prop.store(op, "null");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}	
}

