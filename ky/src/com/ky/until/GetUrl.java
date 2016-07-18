package com.ky.until;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

public class GetUrl {
	public String getUrl(HttpServletRequest request) {

		String strBackUrl = "http://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath(); // 项目名称
		// + request.getServletPath() // 请求页面或其他地址
		// + "?" + (request.getQueryString()); // 参数
		return strBackUrl;
	}
	public String uploadUrl(HttpServletRequest request) {

		String strBackUrl = request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath(); // 项目名称
		// + request.getServletPath() // 请求页面或其他地址
		// + "?" + (request.getQueryString()); // 参数
		return strBackUrl;
	}
}
