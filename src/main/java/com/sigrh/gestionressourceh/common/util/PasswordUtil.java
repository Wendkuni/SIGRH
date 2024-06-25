package com.sigrh.gestionressourceh.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;



public class PasswordUtil {
	public static String getEncodedPassword(String key) {
		  byte[] uniqueKey=null;
		  byte[] hash = null;
		  try {
				uniqueKey = key.getBytes();
				hash=MessageDigest.getInstance("MD5").digest(uniqueKey);
		  } catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		  }
		  StringBuffer hashString = new StringBuffer();
		  for ( int i = 0; i < hash.length; ++i ) {
			String hex = Integer.toHexString(hash[i]);
			if ( hex.length() == 1 ) {
			  hashString.append('0');
			  hashString.append(hex.charAt(hex.length()-1));
			} else {
			  hashString.append(hex.substring(hex.length()-2));
			}
		  }
		  return hashString.toString();
		}

	public static boolean testPassword(String clearTextTestPassword, String encodedActualPassword) throws NoSuchAlgorithmException{
		String encodedTestPassword = getEncodedPassword(clearTextTestPassword);
		return (encodedTestPassword.equals(encodedActualPassword));
	}

	public static String getEncodedPassword1(String key) {
		  byte[] uniqueKey=null;
		  byte[] hash = null;
		  try {
			uniqueKey = key.getBytes("UTF-8");
			hash=MessageDigest.getInstance("MD5").digest(uniqueKey);
		  } catch (NoSuchAlgorithmException|UnsupportedEncodingException e) {
			throw new Error("no MD5 support in this VM");
		  }
		  String hex = Hex.encodeHexString(hash);
		  return hex;
		}
}
