package pkg01;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005ValidateJsonBody {
	@Test
	private void postValidateJsonBody() {
		
	RestAssured.baseURI="https://reqres.in";
	RequestSpecification httprequest=RestAssured.given();
	
	JSONObject payload=new JSONObject();
	payload.put("name", "Ajinkya");
	payload.put("job", "QA");	
	httprequest.header("Content-Type","application/json");
	
	httprequest.body(payload.toJSONString());
	
	Response res=httprequest.request(Method.POST,"/api/users");
	System.out.println(res.getBody().asString());
	String str=res.getBody().asString();
	
	//validate json bodySS
	Assert.assertEquals(str.contains("Ajinkya"), true);
	
	//
	
	}

}
