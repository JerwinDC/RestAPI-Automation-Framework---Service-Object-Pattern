package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.PutRequest;
import com.api.model.response.GetResponse;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class PutAPITest {

	@Test(description="Verify if PUT API is working")
	public void putAPITest() {
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
		
		GetResponse getResponse = response.as(GetResponse.class);
		System.out.println(getResponse.getFirstName());
		
		
		PutRequest putRequest = new PutRequest.Builder()
		    .firstName("Marlon")
		    .lastName("Peroramas")
		    .email("lpdc26176@gmail.com")
		    .mobileNumber("7428330894")
		    .Build();
		
		response = userProfileService.UpdateProfile(loginResponse.getToken(),putRequest);
		System.out.println(response.statusCode());
		System.out.println(response.asPrettyString());
	}
}
