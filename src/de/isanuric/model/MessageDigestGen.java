package de.isanuric.model;


import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;
import javax.xml.bind.DatatypeConverter;

public class MessageDigestGen {
	 String digestStr;
	

	public MessageDigestGen() {
		System.out.println("Model");
	}

	public String createMessageDigest(String plainText) throws UnsupportedEncodingException {
			
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			
			//get a message digest object using the MD5 algorithm and calculate the digest
			digest.update(plainText.getBytes("utf8"));
			byte[] digestBytes = digest.digest();
			digestStr = DatatypeConverter.printHexBinary(digestBytes);
			return digestStr;
	    
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
	public String encryptPrivateKey(String plainText) {
	    //
	    // get a DES private key
//	    System.out.println( "\nStart generating DES key" );
//	    KeyGenerator keyGen = KeyGenerator.getInstance("DES");
//	    keyGen.init(56);
//	    Key key = keyGen.generateKey();
//	    System.out.println( "Finish generating DES key" );
	    
	    //
	    // get a DES cipher object and print the provider
//	    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

	    //
	    // encrypt using the key and the plaintext
//	    cipher.init(Cipher.ENCRYPT_MODE, key);
//	    byte[] cipherText = cipher.doFinal(plainText);
//	    System.out.println( "Finish encryption: " );
//	    System.out.println( new String(cipherText, "UTF8") );
//
//	    //
//	    // decrypt the ciphertext using the same key
//	    System.out.println( "\nStart decryption" );
//	    cipher.init(Cipher.DECRYPT_MODE, key);
//	    byte[] newPlainText = cipher.doFinal(cipherText);
//	    System.out.println( "Finish decryption: " );
//
//	    System.out.println( new String(newPlainText, "UTF8") );
	    
	    return "";
	}
}
