package pkg01;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002Post {
	
	@Test
	public void postUserDetails() 
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject payload=new JSONObject();
		payload.put("name", "Ajinkya");
		payload.put("job", "QA");	
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(payload.toJSONString());
		
		Response res=httprequest.request(Method.POST,"/api/users");
		System.out.println(res.getBody().asString());
		
		///Check the output respose get the details
		String aa=res.jsonPath().get("createdAt");
		System.out.println(aa);
		
		
		///Check the output respose get the status code details
				int Statuscode2=res.getStatusCode();
				System.out.println(Statuscode2);
				
				///Check the output respose get the status Line details
				String Statusline2=res.getStatusLine();
				System.out.println(Statusline2);
				
	}

}
