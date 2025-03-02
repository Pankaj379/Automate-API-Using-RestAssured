package Session_06;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;// Imported from jackson binder.

public class Serialization_Deserialization {


	// POJO ---Serialization----> Json_Object-----De-serialization------>POJO
	//@Test
	void Convert_POJO2Json() throws JsonProcessingException {
		// Create Java object using POJO Class.
		Students_POJO student_Pojo = new Students_POJO();
		student_Pojo.setFirstName("Pankaj");
		student_Pojo.setLastName("Nath");
		student_Pojo.setFullName("Pankaj_Nath");
		student_Pojo.setFatherName("Dharmpal");
		student_Pojo.setAge(27);
		int gradeArr[] = {80, 90, 85};
		student_Pojo.setGrades(gradeArr);


		// Now convert Java object to Json object: Serialize.
		ObjectMapper obj_Map = new ObjectMapper();// import from jackson.

		String json_Data = obj_Map.writerWithDefaultPrettyPrinter().writeValueAsString(student_Pojo);
		System.out.println(json_Data);

	}

	// De-serialize.
	@Test
	void Convert_Json2Pojo() throws JsonProcessingException {
		String json_Data = "{\r\n"
				+ "  \"age\" : 27,\r\n"
				+ "  \"lastName\" : \"Nath\",\r\n"
				+ "  \"firstName\" : \"Pankaj\",\r\n"
				+ "  \"fullName\" : \"Pankaj_Nath\",\r\n"
				+ "  \"fatherName\" : \"Dharmpal\",\r\n"
				+ "  \"grades\" : [ 80, 90, 85 ]\r\n"
				+ "}";
		ObjectMapper obj_Mapp = new ObjectMapper();// import from jackson.

		//Convert Json data to object.
		Students_POJO student_Obt = obj_Mapp.readValue(json_Data, Students_POJO.class);
		System.out.println("First Name:" + student_Obt.getFirstName());
		System.out.println("Last Name:"+ student_Obt.getLastName());
		System.out.println("Full Name:"+ student_Obt.getFullName());
		System.out.println("Age:"+ student_Obt.getAge());
		System.out.println("First Grade:"+ student_Obt.getGrades()[0]);
		System.out.println("2nd Grade:"+ student_Obt.getGrades()[1]);

	}
	
	// Note: Hashmap is a inbuild class and POJO is purely java object class because we create POJO class-
	//-It's not in build.
}


