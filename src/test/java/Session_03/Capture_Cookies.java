package Session_03;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Capture_Cookies {
	
	@Test(priority=1)
	void test_Cookies() {
		
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","AZ6Zc-VX826FI2nw-Fx03zsNQ5oDJY1RjCVvnUv2rp85NFifTofNFOBqow") // IF fail then valid because the new cookie id is generated.
		.log().all();
		
		
		
	}
	

// To handle the cookies Data Dynamically:

	// To handle the cookie data dynamically.
	
	@Test(priority=2)
	void test_Capture_Cookie() {
		
	Response res = given()
		
		.when()
		.get("https://www.google.com");
		
		// get single cookie value.
		//String cookieValue = res.getCookie("AEC");
		//System.out.println("The value of the Cookie is :- " + cookieValue);
		
		
		// Get all cookie values.
		Map<String,String> cookiesValue = res.getCookies();
		System.out.println(cookiesValue.keySet());
		
		for(String keyValue:cookiesValue.keySet() ) {
			
			String cookie_Values = res.getCookie(keyValue);
			System.out.println(keyValue +"  "+ cookie_Values);
			
		}
		
	}
	
}
