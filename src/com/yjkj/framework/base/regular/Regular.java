package com.yjkj.framework.base.regular;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Regular {

	private Regular() {
	};

	public static String creatCDK() {
		String chars = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";
		for (int i = 0; i < 18; i++) {
			result = result + chars.charAt((int) (36 * (Math.random())));
		}
		return result;//生成18位字符串
	}
	public static String createId() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = dateFormat.format(date);
		String num = "";
		for (int i = 0; i < 2; i++) {
			num = num + (int) (10 * (Math.random()));
		}
		return time + num;// 生成ID，由当前系统时间+随机数字，要20位，用于所有表生产唯一主键
	}


	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}


	

}
