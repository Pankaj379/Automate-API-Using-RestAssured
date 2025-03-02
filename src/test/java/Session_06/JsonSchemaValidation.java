package Session_06;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation {

	@Test
	void Test_Schema() {

		given()

		.when()


		.get("http://localhost:3000/students/4")

		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SchemaValidation.json"))
		.log().all();
	}
	
	
}
