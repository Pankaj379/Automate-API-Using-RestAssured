package Session_03;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Path_Query_Parameters {
	
	// https://reqres.in/api/users?page=2&id=5
	
	@Test
	void Test_Path_And_Query_Parameters(){
		
		given()
		.pathParam("myPath", "users") // Path Params. 
		.queryParam("myQuery", "page",2) // Query params.
		.queryParam("myQuery", "id",2) // Query params.
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
