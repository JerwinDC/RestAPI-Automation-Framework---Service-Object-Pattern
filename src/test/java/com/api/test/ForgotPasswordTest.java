package com.api.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
     @Test(description="Verify if Forgot Password API is working")
     public void forgotpasswordTest() {
    	 AuthService authService = new AuthService();
    	 HashMap<String,String> email = new HashMap<String, String>();
    	 email.put("email", "lpdc2617@gmail.com");
    	 Response response = authService.ForgotPassword(email);
    	 
    	 System.out.println(response.asPrettyString());
     }

}
