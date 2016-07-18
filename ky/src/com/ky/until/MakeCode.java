package com.ky.until;

import java.util.Date;

import com.ky.entity.User;

public class MakeCode {
	public static String makeCode(User user){
		long c = new Date().getTime() + user.getUserId();
		String code =Long.toString(c);
		return code;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setUserId(1);
		String code = makeCode(user);
		System.out.println(code);
	}
}
