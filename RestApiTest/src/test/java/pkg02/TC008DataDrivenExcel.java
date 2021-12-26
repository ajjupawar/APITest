package pkg02;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008DataDrivenExcel {
	
	@Test(dataProvider="postdata")
	public void DataDrivenTests(String Ename,String Esal,String Eage) 
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject payload=new JSONObject();
		payload.put("name", Ename);
		payload.put("salary", Esal);
		payload.put("age", Eage);
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(payload.toJSONString());
		
		Response res=httprequest.request(Method.POST,"/create");
		System.out.println("Response body is ="+res.getBody().asString());
		
		///Check the output respose get the status code details
				int Statuscode2=res.getStatusCode();
				System.out.println(Statuscode2);
				
				///Check the output respose get the status Line details
				String Statusline2=res.getStatusLine();
				System.out.println(Statusline2);
	}

	@DataProvider(name="postdata")
	public String[] [] getEmpdata(){
		
		String empdataa[][]= { {"AA1","5000","30"},{"AA2","5200","30"},{"AA3","5300","30"},{"AA4","5400","30"}};
		return empdataa;
	}
}
