package RestAssured.RestAssured;

import static io.restassured.RestAssured.given;

import POJO_deserialize.de_serialization;
import io.restassured.parsing.Parser;

public class oauth_de_serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String access_token="ya29.a0AfH6SMBZq_gq_pIolDOf2_VSOafHqCpMQUnBYXYtqU3msvzpW44iz0V9ObCrTpfdIfjQo5qBYOqZvy9vmPC28mwPh43F5U4RddWql_VOlo1yVDHFxvG-CU1UGXhx3q52pHveI6_vUoAf9p-4r9VMp3EIbjmM-WxVepyFXA";
		
		de_serialization response=given().queryParam("access_token",access_token).
				expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").then().assertThat()
	.statusCode(200).extract().response().as(de_serialization.class);
		//get for linked in
		System.out.println(response.getLinkedIn());
		
		//get the price for soap webserviceds testing which is api
		int count=response.getCourses().getApi().size();
		for(int i=0;i<count;i++) {
			String api_coursetitle=response.getCourses().getApi().get(i).getCourseTitle();
			if (api_coursetitle.equalsIgnoreCase("SoapUI Webservices testing")) {
				String price=response.getCourses().getApi().get(i).getPrice();
				System.out.println(price);
			}
		}
		
		//print all course title for web automation
		int count1=response.getCourses().getWebAutomation().size();
		for(int j=0;j<count1;j++) {
			String course_title=response.getCourses().getWebAutomation().get(j).getCourseTitle();
			System.out.println(course_title);
		}
	}

}
