package com.dummy.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dummy.mode.response.GetDummyResponse;

public class ReqResTest {
	
	private static final String BASE_URL = "https://reqres.in";
    RequestSpecification requestSpecification = given();
	
	public ReqResTest() {
		
		requestSpecification = given().baseUri(BASE_URL);
		
	}
	
	public Response putRequest(String payload) {
		 return requestSpecification.body(payload).contentType(ContentType.JSON).put("/api/users/2");
	}
	
	public Response deleteRequest() {
		 return requestSpecification.delete("/api/users/2");
	}
	
	public Response getRequest() {
		return requestSpecification.get("/api/unknown");
	}
	
	@Test(description = "Verify if PUT API is working", priority = 0)
	public void putAPITest() {
	    ReqResTest reqresTest = new ReqResTest();
		Response response = reqresTest.putRequest("{\"name\": \"morpheus\",\"job\": \"zion resident\"}");
		System.out.println(response.asPrettyString());
	
	}
	
	@Test(description = "Verify if Delete API is working", priority = 1)
	public void deleteAPITest() {
	    ReqResTest reqresTest = new ReqResTest();
		Response response = reqresTest.deleteRequest();
		Assert.assertEquals(response.statusCode(), 204);
		System.out.println(response.statusCode());
	
	}
	
	@Test(description = "Verify if GET API is working ", priority = 2)
	public void getAPITest() {
		ReqResTest reqresTest = new ReqResTest();
		Response response = reqresTest.getRequest();
		
		System.out.println(response.asPrettyString());
		
		GetDummyResponse getDummyResponse = response.as(GetDummyResponse.class);
		System.out.println(getDummyResponse.getData().get(0));
		List<LinkedHashMap<String, Object>> dataList = getDummyResponse.getData();
		LinkedHashMap<String, Object> colorInfo = dataList.get(0);

		int id = (Integer) colorInfo.get("id");
		String name = (String) colorInfo.get("name");
		int year = (Integer) colorInfo.get("year");
		String color = (String) colorInfo.get("color");
		String pantoneValue = (String) colorInfo.get("pantone_value");
		
		Assert.assertEquals(id, 1);
		Assert.assertEquals(name, "cerulean");
		Assert.assertEquals(year, 2000);
		Assert.assertEquals(color, "#98B2D1");
		Assert.assertEquals(pantoneValue, "15-4020");
		
		
	}

}
