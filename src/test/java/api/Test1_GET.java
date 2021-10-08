 package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;  // write static & .* so do not need call RestAssured method we can directly acsses the operation
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;  // goto rest assured site-->usage guide --> copy file and past
import static org.hamcrest.Matchers.*;      //  and after write import static

public class Test1_GET {
	
	@Test
	public void getopration () {
		
		//Response getresponce = RestAssured.get("https://reqres.in/api/users?page=2");   // bcz of static & .* it give error in assured method it not need
		
		Response getresponce = get("https://reqres.in/api/users?page=2"); 
		
		System.out.println(getresponce.asString());
		
		System.out.println(getresponce.getBody().asString());
		
		System.out.println(getresponce.getStatusCode());
		System.out.println(getresponce.getStatusLine());
		System.out.println(getresponce.getHeader("content-type"));
		System.out.println(getresponce.getTime());
		
		
		int statusCode = getresponce.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	void m1() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);  // we can directly check the status code of given APi
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));  
		                         // body()-->to give data for specific condition id [0]= 7 or not  
	}

		
	
}
