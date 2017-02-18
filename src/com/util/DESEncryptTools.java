package com.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Encoder;

// DES 加密
public  class DESEncryptTools {
	private final static String DES = "DES";

	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {  //加密代码
		// 生成一个可信任的随机数据源
		SecureRandom secureRandom = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec  deskeys = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secureKey = keyFactory.generateSecret(deskeys);
		// 利用Cipher 对象完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, secureKey,secureRandom);
		return cipher.doFinal(data);
	}
	 public static String encrypt(String data, String key) throws Exception {  //对string进行BASE64Encoder转换
		  byte[] bt = encrypt(data.getBytes(), key.getBytes());
		  BASE64Encoder base64en = new BASE64Encoder();
		  String strs = new String(base64en.encode(bt));
		  return strs;
		 }
}
