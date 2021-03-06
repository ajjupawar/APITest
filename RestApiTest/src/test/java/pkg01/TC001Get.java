package pkg01;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001Get {

	
	@Test
	public void getUserDetails() 
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();
		Response res=httprequest.request(Method.GET,"/api/users/2");
		System.out.println(res.getBody().asString());
		
		//Status code
		int statuscode1=res.getStatusCode();
		System.out.println(statuscode1);
		Assert.assertEquals(200, statuscode1,"Status code not as per expected");
		
		//Status Line 
				String statusLine1=res.getStatusLine()		;
				System.out.println(statusLine1);
				Assert.assertEquals("HTTP/1.1 200 OK", statusLine1,"status Line1 not as per expected");
		
	}
	
}
