package RestAssured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import POJO_Serialize.addplace;
import POJO_Serialize.location;
import io.restassured.RestAssured;
public class sseiralize_json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//full pojo
		addplace a=new addplace();
		a.setAccuracy(50);
		a.setName("Frontline house");
		a.setPhone_number("(+91) 983 893 3937");
		a.setWebsite("http://google.com");
		a.setLanguage("French-IN");
		location l=new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		a.setLocation(l);
		List<String> types=new ArrayList();
		types.add("shoe park");
		types.add("shop");
		a.setTypes(types);
		//full pojo
		
		String response=given().queryParam("key","qaclick123").body(a).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract()
		.response().asString();
		System.out.println(response);

	}

}
