package com.api.base;

import java.util.HashMap;

import com.api.model.request.LoginRequest;
import com.api.model.request.SignupRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	private static final String BASE_PATH = "/api/auth/";
	
	public Response Login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "login");
	}
	
	public Response SignUp(SignupRequest payload) {
		return postRequest(payload, BASE_PATH + "signup");
	}
	
	public Response ForgotPassword(HashMap<String,String> email) {
		return postRequest(email, BASE_PATH + "forgot-password");
	}
}
