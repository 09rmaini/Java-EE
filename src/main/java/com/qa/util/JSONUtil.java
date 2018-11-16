package com.qa.util;

import com.google.gson.Gson;

import persistance.domain.Account;

public class JSONUtil {

	private static Gson gson = new Gson();

	public JSONUtil() {
		this.gson = new Gson();
	}

	public static String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public static <T>  T getObjectForJSON(String account, Class<T> class1) {
		return gson.fromJson(account, class1);
	}

}