package RestAssured.RestAssured;

import io.restassured.path.json.JsonPath;

public class complex_json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  String json=payload.complex_json();
  JsonPath j1=new JsonPath(json);
  //1. Print No of courses returned by API
  int count=j1.getInt("courses.size()");
  System.out.println(count);
  
//2.Print Purchase Amount
  int purchase=j1.getInt("dashboard.purchaseAmount");
  System.out.println(purchase);
//	3. Print Title of the first course
	String first_title=j1.get("courses[0].title");
	System.out.println(first_title);
	//4. Print All course titles and their respective Prices
	for(int i=0;i<count;i++) {
		String course_title=j1.get("courses["+i+"].title");
		int price=j1.getInt("courses["+i+"].price");
		System.out.println("Course title is"+course_title+"Price is "+price);
	}
	
	//5. Print no of copies sold by RPA Course
	for(int i=0;i<count;i++) {
		String course_title=j1.get("courses["+i+"].title");
		if (course_title.equalsIgnoreCase("RPA")) {
			int copies=j1.getInt("courses["+i+"].copies");
			
			System.out.println("RPA COPIES"+copies);
		}
		int sum=0;
  //6. Verify if Sum of all Course prices matches with Purchase Amount
		for(int i1=0;i1<count;i1++) {
			int price1=j1.getInt("courses["+i1+"].price");
			int copies1=j1.getInt("courses["+i1+"].copies");
			int mult=price1*copies1;
			sum=sum+mult;
		}
		if (sum==purchase) {
			System.out.println("Success");
		}
	}
	}

}
