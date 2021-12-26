package pkg01;

import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007CheckBasicAuth {
	
@Test
	public void authorization() {
	
	RestAssured.baseURI="http://restapi.adequateshop.com";
	
	//basic authentication
	PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
	authscheme.setUserName("Developer");
	authscheme.setPassword("123456");
	RestAssured.authentication=authscheme;
	
	RequestSpecification httpreq=RestAssured.given();
	Response res=httpreq.request(Method.POST,"/api/authaccount/registration");
	System.out.println(res.getBody().asString());
	
	///Check the output respose get the status code details
			int Statuscode2=res.getStatusCode();
			System.out.println(Statuscode2);
			
			///Check the output respose get the status Line details
			String Statusline2=res.getStatusLine();
			System.out.println(Statusline2);
	}
}
