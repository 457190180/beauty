package com.yimew.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年10月18日 下午2:07:40 * @version 1.0
 * * @parameter * @since * @return
 */
public class Base64Utils {
	
	/**
	 * base64加密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeBase64(String str) throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));
		return new String(encodeBase64);
	}
	/**
	 * base64解密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeBase64(String str) throws UnsupportedEncodingException {
		byte[] decodeBase64 = Base64.decodeBase64(str.getBytes("UTF-8"));
		return new String(decodeBase64);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(encodeBase64("123456"));
	}
	
}
