package de.isanuric.model;


import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;
import javax.xml.bind.DatatypeConverter;

public class MessageDigestGen {
	 String digestStr;
	
	/**
	 * @return the digestStr
	 */
	public String getDigestStr() {
		return this.digestStr;
	}

	/**
	 * @param digestStr the digestStr to set
	 */
	public void setDigestStr(String digestStr) {
		this.digestStr = digestStr;
	}

	public String createMessageDigest(String plainText) throws UnsupportedEncodingException {

		try {
//			System.out.println(DigestUtils.sha1Hex(plainText));
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			
			//get a message digest object using the MD5 algorithm and calculate the digest
			digest.update(plainText.getBytes("utf8"));
			byte[] digestBytes = digest.digest();
			digestStr = DatatypeConverter.printHexBinary(digestBytes);
			System.out.println(digestStr);
			return digestStr;
	    
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "Error";
		}
	}
}
