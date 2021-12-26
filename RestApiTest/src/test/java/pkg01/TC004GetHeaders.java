package pkg01;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004GetHeaders {
	
	
	@Test
	public void getHeadersDetails() 
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();
		Response res=httprequest.request(Method.GET,"/api/users/2");
		System.out.println(res.getBody().asString());
		
		//Headers check for the api
		
		Headers allheaders=res.headers();
		
		for (Header header : allheaders) {
			
			System.out.println(header.getName()+"*****"+header.getValue());
		}
		
	}
}
