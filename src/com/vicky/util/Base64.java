package com.vicky.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("all")

public class Base64 {
	public static void main(String[] args) {
		//加密
		String encode = getEncode("admin.");
		System.out.println(encode);
		//把加密的值解密
		String decode = getDecode(encode);
		System.out.println(decode);
	}
	//解密
	public static String getDecode(String base64d) {
		String value = "";
		try {
			byte[] b = new BASE64Decoder().decodeBuffer(base64d);
			value = new String(b,"utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		// TODO Auto-generated method stub
		
	}
	//加密
	public static String getEncode(String base64e) {
		try {
			byte[] bytes = base64e.getBytes("utf-8");
			return new BASE64Encoder().encode(bytes).toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub
		
	}
	
}
