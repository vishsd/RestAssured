package api;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;    // for given() method to import this

public class Test_POST {
	
	@Test(priority = 1)
	public void test1_Post() {
//		Map<String, Object>map = new HashMap<String, Object>();
//		                            // casting of hashmap 
//		map.put("name", "vishal");
//		map.put("job", "Test Engg");
//		
//		System.out.println(map);
//		
//		JSONObject request = new JSONObject(map);  
//		  // if we want post data in json format so add dependency of json then create a object of json class
//		
//		System.out.println(request);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "vishal");
		request.put("job", "Test Engg");   // we can directly enter data by creating a object of json
		
		System.out.println(request);
		
		// to test the created data are fetch or not 
		// header,accept ,contentType  out of 3 use any one
		given().
		    header("ContentType","application/json").  
		    accept(ContentType.JSON).
		    contentType(ContentType.JSON).
		    
		         body(request.toJSONString()).
		   when().
		         post("https://reqres.in/api/users").
		   then().
		         statusCode(201);
		
	}
	@Test(priority = 2)
	public void test1_PUT() {
	
		JSONObject request = new JSONObject();
		
		request.put("name", "vishal");
		request.put("job", "Test Engg");   // we can directly enter data by creating a object of json
		
		System.out.println(request);
		
		// to test the created data are fetch or not 
		// header,accept ,contentType  out of 3 use any one
		given().
		    header("ContentType","application/json").  
		    accept(ContentType.JSON).
		    contentType(ContentType.JSON).
		    
		         body(request.toJSONString()).
		   when().
		         put("https://reqres.in/api/users/2").
		   then().
		         statusCode(200).log().all();
		   // in put only change put instade of post and status code. to print in console so use log().all();
	}



}
