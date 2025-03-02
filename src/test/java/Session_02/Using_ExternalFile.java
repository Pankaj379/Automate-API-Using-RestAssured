package Session_02;
//4) Using external File:

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Using_ExternalFile {
	//Note: User the exact package as per the requirement and always use to sting in data file.


	@Test(priority=1)
	void Create_User_With_ExternalFile() throws FileNotFoundException {

		File fl = new File("./body.json");

		FileReader fr = new FileReader(fl);

		JSONTokener jt = new JSONTokener(fr);

		JSONObject data = new JSONObject(jt);





		given()
		.contentType("application/json")
		.body(data.toString())

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("fullName",equalTo("Shawn Clark"))
		.body("fatherName",equalTo("Mr. Aiden Frost"))
		.body("grades[0]",equalTo(9))
		.body("grades[1]",equalTo(9))
		.body("grades[2]",equalTo(9))
		.body("age", equalTo(19))
		.header("Content-Type","application/json")
		.log().all();

	}
}