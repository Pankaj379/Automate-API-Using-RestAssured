package Session_07;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {
	

	@Test(priority=1)
	void Test_Basic_Authentication() {
		
		given()
		.auth().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
	@Test(priority=2)
	void Test_Digest_Authentication() {
		
		given()
		.auth().digest("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
	
	@Test(priority=3)
	void Test_Preemptive_Authentication() {
		
		given()
		.auth().preemptive().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	

}
