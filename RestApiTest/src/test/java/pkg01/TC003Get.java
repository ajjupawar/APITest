package pkg01;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003Get {

	@Test
	public void getUserDetails() 
	{
		RestAssured.baseURI="https://www.google.co.in";
		RequestSpecification httprequest=RestAssured.given();
		Response res=httprequest.request(Method.GET,"/maps/@13.0776,80.2917,6z?hl=en-GB");
		System.out.println(res.getBody().asString());
	}
	

}
