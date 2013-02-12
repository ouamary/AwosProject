package fr.dauphine.spring.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Digester {
	public static final String toMD5String(String toConvert) {
		String MD5String = "";
		
		try {
			MessageDigest mess = MessageDigest.getInstance("MD5");
			MD5String = new BigInteger(1, mess.digest(toConvert.getBytes())).toString(16);
			
			System.out.println("MD5 : " + MD5String);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return MD5String;
	}
}
