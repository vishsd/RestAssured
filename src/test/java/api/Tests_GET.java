package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests_GET {

	@Test
	public void m1() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		                               // log().all();--> it give the all data in console 
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).
		               body("data.id[1]", equalTo(8)).body("data.first_name", hasItems("Michael","Lindsay"));
		
		
	}
}
