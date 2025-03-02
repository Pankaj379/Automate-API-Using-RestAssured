package Session_02;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

/* How may ways to create post body body:
 * 1) Post request body using HashMap.
 * 2) Post request body using ORG.json.
 * 3) Post request body using external json file.
 * 4) Post request body using POJO class.
 */

public class Ways_To_Create_Request_Body {

	//  1) Post request body using HashMap.
	//@Test(priority=1)
	void Test_Using_HashMap() {

		HashMap data = new HashMap();
		data.put("firstName","Shawn");
		data.put("lastName","Frost");
		data.put("fullName","Shawn Frost");
		data.put("fatherName","Mr. Aiden Frost");
		data.put("class","12th");
		data.put("age", 20);



		int gradeArr[] = {2, 4, 5};
		data.put("grades",gradeArr); 

		given()
		.contentType("application/json")
		.body(data)

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("fullName",equalTo("Shawn Frost"))
		.body("fatherName",equalTo("Mr. Aiden Frost"))
		.body("grades[0]",equalTo(2))
		.body("grades[1]",equalTo(4))
		.body("grades[2]",equalTo(5))
		.header("Content-Type","application/json")
		.log().all();

	}

	//@Test(priority=2)
	void Delete_Request() {

		given()

		.when()
		.delete("http://localhost:3000/students/1a90")

		.then()
		.statusCode(200)
		.log().all();


	}

	//2) Using the JSON Library:

	//	Note: only changes JSONObject and in given data.toString menthod nothing else.


	//@Test(priority=1)
	void Create_User_With_JsonLib() {


		JSONObject data = new JSONObject();
		data.put("firstName","Mark");
		data.put("lastName","Frost");
		data.put("fullName","Mark Frost");
		data.put("fatherName","David Frost");
		data.put("class","Master");
		data.put("age", 87);



		int gradeArr[] = {80, 90, 85};
		data.put("grades",gradeArr); 

		given()
		.contentType("application/json")
		.body(data.toString())

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("fullName",equalTo("Mark Frost"))
		.body("fatherName",equalTo("David Frost"))
		.body("grades[0]",equalTo(80))
		.body("grades[1]",equalTo(90))
		.body("grades[2]",equalTo(85))
		.header("Content-Type","application/json")
		.log().all();


	}
	
//	3) Using Pojo Class by encapsulation:

		//Note: First create class using of pojo and import in the below class.


		@Test(priority=1)
			void Create_User_With_pojoClass() {
				
				
				POJO_Post_Request data = new POJO_Post_Request();
				data.setFirstName("Axel");
				data.setLastName("Blaze");
				data.setFullName("Axel Blaze");
				data.setFatherName("Kevin Blaze");
				data.setAge(80);
				
				int gradeArr[] = {80, 90, 85};
				data.setGrades(gradeArr); 
				
				given()
				.contentType("application/json")
				.body(data)

				.when()
				.post("http://localhost:3000/students")

				.then()
				.statusCode(201)
				.body("fullName",equalTo("Axel Blaze"))
				.body("fatherName",equalTo("Kevin Blaze"))
				.body("grades[0]",equalTo(80))
				.body("grades[1]",equalTo(90))
				.body("grades[2]",equalTo(85))
				.header("Content-Type","application/json")
				.log().all();
			
				
			}





}
