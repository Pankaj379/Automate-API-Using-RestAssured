package Session_05;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import org.testng.annotations.Test;

public class File_Upload_Test {


	@Test(priority=1)
	void Test_File_Upload() {

		File upload_file = new File("C:\\FileUpload\\Test.txt");

		given()
		.multiPart("file", upload_file)
		.contentType("multipart/form-data")

		.when()
		.post("http://localhost:8080/uploadFile")

		.then()
		.statusCode(200)
		.body("fileName", equalTo("Test.txt"))
		.log().all();



	}
	
	
	//@Test
	void Test_Multifile_Upload() {

		File upload_file1 = new File("C:\\FileUpload\\Test1.txt");
		File upload_file2 = new File("C:\\FileUpload\\Test2.txt");

		given()
		.multiPart("files", upload_file1)
		.multiPart("files", upload_file2)
		.contentType("multipart/form-data")

		.when()
		.post("http://localhost:8080/uploadMultipleFiles")

		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("Test1.txt"))
		.body("[1].fileName", equalTo("Test2.txt"))
		.log().all();



	}
	
	// Note: If API support array upload then it'll work.
	//@Test
	void Test_Multifile_Upload_With_Array() {

		File upload_file1 = new File("C:\\FileUpload\\Test1.txt");
		File upload_file2 = new File("C:\\FileUpload\\Test2.txt");
		
		File fileArr[] = {upload_file1, upload_file2};

		given()
		.multiPart("files", fileArr)
		.contentType("multipart/form-data")

		.when()
		.post("http://localhost:8080/uploadMultipleFiles")

		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("Test1.txt"))
		.body("[1].fileName", equalTo("Test2.txt"))
		.log().all();



	}
	
	// Download file
	
	@Test(priority=2)
	void Test_Download() {
		
		
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/Test.txt")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
