package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class GetAPITest {
	
	@Test(description = "Verify if Get API is working")
	public void getAPITest() {
		AuthService authService = new AuthService();
		LoginRequest loginRequest = new LoginRequest("Sinio","Sinio1234");
		Response response = authService.Login(loginRequest);
		
		System.out.println(response.asPrettyString());
		System.out.println("*******************************************************");
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		System.out.println("*******************************************************");
		
		
		UserProfileManagementService userProfileService = new UserProfileManagementService();
		
		response = userProfileService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		
	}
	
	

}
