package _02_File_Encrypt_Decrypt;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.

public static void main(String[] args) {
	
	FileEncryptor enc = new FileEncryptor();
	String use = enc.Encyrpt();String ans = "";
	for(int i = 0; i<use.length();i++) {
		char c = use.charAt(i);
		c--;
		
		 ans +=c;
	
	}	System.out.println(ans);
}
}
