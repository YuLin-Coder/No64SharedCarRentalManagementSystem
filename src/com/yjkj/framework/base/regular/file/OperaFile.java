package com.yjkj.framework.base.regular.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.regular.date.CreatDate;

public class OperaFile {

	private OperaFile() {};
	
	//SpringMVC 多文件上传
	public static Map<String, String> uploadFile(MultipartFile files[], String address, HttpServletRequest request)
			throws IOException {
		try {
			Map<String, String> map = new HashMap<>();
			String path = request.getServletContext().getRealPath("/WEB-INF/upload/");
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					String uploadName = file.getOriginalFilename();
					String uploadUrl = path + "/" + uploadName;
					String uploadPower = "";
					if (file.getSize() <= 1024) {
						uploadPower = file.getSize() + " B";
					} else if (file.getSize() > 1024 && file.getSize() <= 1048576) {
						uploadPower = file.getSize() / 1024 + " KB";
					} else if (file.getSize() > 1048576 && file.getSize() <= 1073741824) {
						uploadPower = file.getSize() / 1048576 + " MB";
					}

					OutputStream os = new FileOutputStream(uploadUrl);
					InputStream is = file.getInputStream();
					int temp;
					while ((temp = is.read()) != -1) {
						os.write(temp);
					}
					os.flush();
					os.close();
					is.close();

					String uploadEnt = uploadName.substring(uploadName.lastIndexOf(".") + 1);

					map.put("name", uploadName);
					map.put("time", CreatDate.getDate());
					map.put("ext", uploadEnt);
					map.put("url", path);
					map.put("size", uploadPower);
					return map;
				}
			}
		} catch (RuntimeException ex) {
			throw new RuntimeException("上传失败,原因为:" + ex.getMessage());
		}
		return null;
	}

	//删除文件
	public static void deleteFile(HttpServletRequest request, String uploadName, String address) {
		String path = request.getServletContext().getRealPath("/WEB-INF/upload/" + address);
		try {
			File file = new File(path + "/" + uploadName);
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			throw new RuntimeException("删除文件失败,原因为:" + e.getMessage());
		}
	}
	
}
