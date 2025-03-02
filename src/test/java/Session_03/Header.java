package Session_03;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Header {
	@Test
	void Test_Headers() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip")
		.and()
		.log().all();
	}



//2) To get all the headers:


@Test
void Test_Get_Header() {

	Response res= given()
			.when()
			.get("https://www.google.com/");

	// Get single header value.
	// String contentHeaderValue = res.header("Content-Type");
	// String contentEncoding = res.header("Content-Encoding");
	// System.out.println("The header value is :- "+ contentHeaderValue);
	// System.out.println("The content header encoding value is :- "+ contentEncoding);

	// Get all header values.

	Headers myHeader = res.getHeaders();

	for(io.restassured.http.Header headr : myHeader) {
		System.out.println(headr.getName()+"------>"+headr.getValue());
	 }
  }
}
