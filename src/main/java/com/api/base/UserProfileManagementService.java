package com.api.base;

import com.api.model.request.PutRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
	private static final String BASE_PATH = "/api/users/";
	
	public Response getProfile(String token) {
		setauthToken(token);
		return getRequest(token, BASE_PATH + "profile");
	}
	
	public Response UpdateProfile(String token,PutRequest payload) {
		setauthToken(token);
		return putRequest(payload, BASE_PATH + "profile");
	}

}
