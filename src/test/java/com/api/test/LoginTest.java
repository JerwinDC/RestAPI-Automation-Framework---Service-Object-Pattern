package com.api.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginTest {
	
	@Test(description = "Verify if log in api is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("Jjdc","12345qwert!");
		AuthService authService = new AuthService();
		Response response = authService.Login(loginRequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		Boolean isLogiSuccessful = loginResponse.getEmail().equals("jjdc2617@gmail.com");
		if(isLogiSuccessful) {
			System.out.println("Successfully logged in!");
		}else {
			System.out.println("Failed to login.");
		}
		
	}

}
