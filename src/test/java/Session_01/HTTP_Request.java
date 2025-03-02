package Session_01;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class HTTP_Request {
	
	int id;

	@Test(priority=1)
	void getUsers() {

		given()
		// content type, set cookies, add auth, add param, set headers info etc....

		.when()
		.get("https://reqres.in/api/users?page=2")

		// Get, post, put, delete....

		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();

		// Validate status code, extract response, extract headers cookies and response
		// body....

	}

	@Test(priority=2)
	void createUser() {

		HashMap inputData = new HashMap();
		inputData.put("name", "Mark Evans");
		inputData.put("job", "QA Automation");

		id=given()
		.contentType("application/json")
		.body(inputData)

		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");

		//.then()
		//.statusCode(201)
		//.log().all();

	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser() {

		HashMap inputData = new HashMap();
		inputData.put("name", "Axel Blaze");
		inputData.put("job", "Manual Testing");

		given()
		.contentType("application/json")
		.body(inputData)

		.when()
		.put("https://reqres.in/api/users/"+id)

		.then()
		.statusCode(200)
		.log().all();

	}
	
	@Test(priority=4)
	void deleteUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}


}
