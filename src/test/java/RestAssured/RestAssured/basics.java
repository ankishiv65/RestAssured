package RestAssured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class basics {
     @Test(dataProvider="ankit")
	public  void Api(String address) {
		// Post
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").body(payload.getapi()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath j1=new JsonPath(response);
		String place_id=j1.getString("place_id");
		System.out.println("Place id found is"+place_id);
		//put
		String update=given().log().all().queryParam("key","qaclick123").body(payload.putAPI(address,place_id)).when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(update);
		//get
		String getresponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_id).when().get("/maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath j2=new JsonPath(getresponse);
		String updatedaddress=j2.getString("address");
		System.out.println("Updated address is"+updatedaddress);
			}
	@DataProvider(name="ankit")
	public Object[][] getdata123() {
		Object a1[][]=new Object[][] {
			{"ankit"},{"roy"}
			
		};
		return a1;
	}
	

}


