package Session_05;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class ParsingXmlResponse {
	// For Static Response.
	//@Test
	void Parsing_XML_Response(){



		given()

		.when()
		.get("https://mocktarget.apigee.net/xml")

		.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		.body("root.firstName", equalTo("John"))
		.log().all();

	}

	// second Method for variable response.

	@Test
	void Parsing_XML_Variable_Res(){


		Response res=
				given()

				.when()
				.get("https://mocktarget.apigee.net/xml");
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		String personName= res.xmlPath().get("root.firstName").toString();
		Assert.assertEquals(personName, "John");



	}

	// Verify XML values with advance technique.
	@Test
	void Parsing_XML_Variable_Response(){


		Response res=
				given()

				.when()
				.get("https://mocktarget.apigee.net/xml");

		XmlPath xmlObject = new XmlPath(res.asString());

		// Verifying the total number of XML nodes.

		List<String> cityVal=xmlObject.getList("root.city");
		Assert.assertEquals(cityVal.size(), 1);

		// Verify the exact name is present or not.

		List<String> stateVal=xmlObject.getList("root.state");
		boolean status=false;
		for(String statename:stateVal) {

			if(statename.equals("CA")) 
			{
				status = true;
				break;
			}
			
			Assert.assertEquals(status, true);
			
		}

	}

}
