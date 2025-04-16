package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.BaseService;
import com.api.model.request.SignupRequest;

import io.restassured.response.Response;

public class SignupTest extends BaseService{
	
	@Test(description = "Verify if Signup API is workign")
	public void signupTest() {
		AuthService authService = new AuthService();
		
		SignupRequest singupRequest = new SignupRequest.Builder()
				.username("Sinio")
				.password("Sinio1234")
				.email("lpdc2617@gmail.com")
				.firstName("Sinio")
				.lastName("Cagasan")
				.mobileNumber("7428730894")
				.Build();
		
		Response response = authService.SignUp(singupRequest);
		System.out.println(response.asPrettyString());
		Assert.assertFalse(response.asPrettyString().equals("User registered successfully!"));
	}

}
