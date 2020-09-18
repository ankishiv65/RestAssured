package RestAssured.RestAssured;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POJO_deserialize.de_serialization;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class Oauth2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//to get authorization code
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver.exe");
			//	WebDriver driver = new ChromeDriver();
		 //driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=cmcfvvfvfv");
		 //driver.findElement(By.xpath("//*[text()='Email or phone']")).sendKeys("ankishiv65@gmail.com");
		 
		 //Thread.sleep(2000);
		 //String url=driver.getCurrentUrl();
		 //String split1[]=url.split("code=");
		 //String split2[]=split1[1].split("&scope");
		 //String code=split2[0];
		//System.out.println(code);
		//to get access token
		 //Thread.sleep(2000);
		String code="4%2F4QEzoRkixyVS-xTVrPyqMLL33vs49tvTRf38t83MVFqgQZUe8I-e15KeHaamgSdM9q1ze5byG_sFWOhP7g9Omz0";
		String access_token1=given().urlEncodingEnabled(false).
				queryParam("code",code).
				queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		        .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").
		        queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		      .queryParam("grant_type","authorization_code").when().
		      post("https://www.googleapis.com/oauth2/v4/token")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath j1=new JsonPath(access_token1);
		String access_token=j1.getString("access_token");
		System.out.println("Access token    "+access_token);
		//to get json after finidng access token
		String response=given().queryParam("access_token",access_token)
			.when().get("https://rahulshettyacademy.com/getCourse.php").then().assertThat()
	.statusCode(200).extract().response().asString();
	System.out.println(response);
	//de_serialization response=given().queryParam("access_token",access_token).
		//expect().defaultParser(Parser.JSON)
	//.when().get("https://rahulshettyacademy.com/getCourse.php").then().assertThat()
	//.statusCode(200).extract().response().as(de_serialization.class);
	//System.out.println(response.getLinkedin());
    
	}

}
