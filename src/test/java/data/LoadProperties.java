package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class LoadProperties {

	
	public static Properties userData= 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

	private static Properties loadProperties(String path)
	{
		Properties pro= new Properties();
		try 
		{
			FileInputStream str = new FileInputStream(path);
			pro.load(str);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return pro;	
	}
	
}
