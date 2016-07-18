package com.ky.until;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.ky.entity.User;

public class UploadFile {
	public String uploadFile(MultipartFile file, User user, String path, String type) {
		String fileName = file.getOriginalFilename();
		
		fileName = type + fileName;
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
