package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonDataReader 
{

	 
	public String firstname,lastname , email , password;
	
	public void jsonreader() throws IOException, ParseException {
		
		String jsonpath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
		
		File srcFile = new File(jsonpath);
		JSONParser parser = new JSONParser();
		JSONArray jsonarray = (JSONArray)parser.parse(new FileReader(srcFile));
		
		for(Object jsonobject : jsonarray) 
		{
			JSONObject person = (JSONObject) jsonobject;
			firstname = (String) person.get("firstname");	
			lastname = (String) person.get("lastname");
			email = (String) person.get("email");
			password = (String) person.get("password");
		}
		
		
	}
	
	
	
	
	
	
}
