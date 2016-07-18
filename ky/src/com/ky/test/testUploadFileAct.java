package com.ky.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ky.entity.User;
import com.ky.until.GetUrl;
import com.ky.until.UploadFile;

@Controller
public class testUploadFileAct {
	@RequestMapping(value = "/uploadFile1")
	public String upload1(@RequestParam(value = "file1", required = false) MultipartFile file1,
			HttpServletRequest request, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		String path = request.getSession().getServletContext().getRealPath("/upload/member");
		UploadFile uf = new UploadFile();
		String type = "";
		String path2 = uf.uploadFile(file1, user, path, type);
		return "success";
	}

	@RequestMapping(value = "/uploadFile2")
	public String upload2(@RequestParam(value = "file2", required = false) MultipartFile file2,
			HttpServletRequest request, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		String path = request.getSession().getServletContext().getRealPath("/upload/member");
		UploadFile uf = new UploadFile();
		String type = "";
		String path2 = uf.uploadFile(file2, user, path, type);
		return "success";
	}
}
