package RestAssured.RestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class libraryAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      RestAssured.baseURI="http://216.10.245.166";
      String response=given().log().all().body("{\r\n" + 
      		"\r\n" + 
      		"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
      		"\"isbn\":\"bcd\",\r\n" + 
      		"\"aisle\":\"227\",\r\n" + 
      		"\"author\":\"John foe\"\r\n" + 
      		"}\r\n" + 
      		"").when().post("Library/AddBook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
	}
	

}
