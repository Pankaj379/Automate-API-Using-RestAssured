package Session_02;

public class POJO_Post_Request {

String FirstName;
String LastName;
String FullName;
String FatherName;
int Age;
int[] Grades;

public String getFatherName() {
	return FatherName;
}
public void setFatherName(String fatherName) {
	FatherName = fatherName;
}

public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getFullName() {
	return FullName;
}
public void setFullName(String fullName) {
	FullName = fullName;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public int[] getGrades() {
	return Grades;
}
public void setGrades(int[] gradeArr) {
	Grades = gradeArr;
}




}
