package com.qa.util;

import com.google.gson.Gson;

import persistance.domain.Account;

public class JSONUtil {

	private static Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public static String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T getObjectForJSON(Account createAccount, Class<Account> class1) {
		return (T) gson.toJson(createAccount, class1);
	}

}