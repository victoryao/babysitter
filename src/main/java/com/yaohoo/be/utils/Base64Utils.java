package com.yaohoo.be.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64Utils {

	public static String encrypt(String key){
		return (new BASE64Encoder()).encodeBuffer(key.getBytes()); 
	}
	
	public static String decrypt(String data) throws IOException
	{
		 BASE64Decoder decoder = new BASE64Decoder();
		 byte[] bytes = decoder.decodeBuffer(data);
		 return new String(bytes);
	}
}
