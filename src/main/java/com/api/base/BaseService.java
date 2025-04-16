package com.api.base;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseService {
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static {
        filters(new LoggingFilter());
    }
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	public void setauthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String token, String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).put(endpoint);
	}

}
