package pkg01;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006GetJsonNodes {
	
	@Test
	private void postValidateJsonNodes() {
		
	RestAssured.baseURI="https://hub.dummyapis.com/";
	RequestSpecification httprequest=RestAssured.given();
	
	
	Response res=httprequest.request(Method.GET,"/employee?noofRecords=1&idStarts=1001");
	System.out.println(res.getBody().asString());

	JsonPath jsonpatha=res.jsonPath();

	ArrayList aa=new ArrayList (Arrays.asList(jsonpatha.get("imageUrl")));
	//String imageUrlNode=jsonpatha.get("imageUrl");
	System.out.println("Json path get the json node info =="+aa);
	
	ArrayList contactNumberNode=new ArrayList (Arrays.asList(jsonpatha.get("contactNumber")));
//	String contactNumberNode=jsonpatha.get("contactNumber");
	System.out.println("Json path get the json node info =="+contactNumberNode);

	
	
	}

}
