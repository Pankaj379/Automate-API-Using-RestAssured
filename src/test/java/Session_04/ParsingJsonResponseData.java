package Session_04;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.awt.print.Printable;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJsonResponseData {

	//@Test
	void TestJsonResponse() {

		// Approach one.
		given()
		.contentType(ContentType.JSON)

		.when()
		.get("https://api.escuelajs.co/api/v1/products")

		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("[15].category.name", equalTo("Electronics"))
		.log().all();

	}

	//@Test(priority=2)
	void TestJsonResponseTwo() {
		// Approach Two.
		Response res = given()
				.contentType(ContentType.JSON)	
				.when()
				.get("https://api.escuelajs.co/api/v1/products");

		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");

		String productValue= res.jsonPath().get("[15].category.name").toString();

		Assert.assertEquals(productValue, "Electronics");

	}

	//@Test(priority=3)
	void TestJsonResponseBody() {
		// Approach Two.
		Response res = given()
				.contentType(ContentType.JSON)	
				.when()
				.get("https://api.escuelajs.co/api/v1/products");

		JSONArray jArray = new JSONArray(res.asString());
		
		for(int i=0; i<jArray.length(); i++) { 

			String bookTittle=jArray.getJSONObject(i).get("title").toString();

			System.out.println(bookTittle); 
			
	     }
	}
	
	//@Test(priority=4)
	void TestJsonResponseBody2() {
	    // Approach Three for specific Book.
	    Response res = given()
	            .contentType(ContentType.JSON)
	            .when()
	            .get("https://api.escuelajs.co/api/v1/products");

	    JSONArray jArray = new JSONArray(res.asString());
	    

	    boolean status = false;
	    
	    for (int i = 0; i < jArray.length(); i++)
	    {
	        String bookTitle = jArray.getJSONObject(i).get("title").toString();
	        
	        if (bookTitle.equals("Rainbow Glitter High Heels")) 
	        {
	        	status = true;
	        	break;
	        }
	        
	    }
	        
	        Assert.assertEquals(status, true);
	        
	}
	
	
	@Test(priority=5)
		void TestJsonResponseBody03() {
			// For getting price value
			Response res = given()
					.contentType(ContentType.JSON)	
					.when()
					.get("https://api.escuelajs.co/api/v1/products");

			JSONArray jArray = new JSONArray(res.asString());
			
			double totalPrice = 0;
			for(int i=0; i<jArray.length(); i++) 
			{ 
				String price=jArray.getJSONObject(i).get("price").toString();
				totalPrice = totalPrice +Double.parseDouble(price);
				
				//Assert.assertEquals(price, 39);
				
				System.out.println("Total prices of books is : " + totalPrice);
		    }
			//System.out.println("Total prices of books is : " + totalPrice);
			
			Assert.assertEquals(totalPrice, 6.35183527E8);
	
		}

}
