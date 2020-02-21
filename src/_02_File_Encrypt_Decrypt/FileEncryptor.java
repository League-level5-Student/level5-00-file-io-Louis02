package _02_File_Encrypt_Decrypt;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file

	public static void main(String[] args) {
	

	}

public String Encyrpt () {
	String save = JOptionPane.showInputDialog("Enter message to be encyrpted");
	String ans = "";

	for (int i = 0; i < save.length(); i++) {
		char c = save.charAt(i);
		if (c == 'z') {
			c = 'a';
		}
		c++;
		ans += c;
		

	}
	
	System.out.println(ans);
	return ans;
}

}
