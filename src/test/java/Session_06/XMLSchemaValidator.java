package Session_06;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;


public class XMLSchemaValidator {
	
	@Test
	void Test_XML_Schema() {
		
		given()
		
		.when()
		.get("https://mocktarget.apigee.net/xml")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLSchema.xsd"))
		.log().all();
		
		
	}

}
