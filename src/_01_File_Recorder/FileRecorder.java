package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/recorderFile.txt");	
			String sabe =JOptionPane.showInputDialog("Please enter a message");
			System.out.println(sabe);
			fw.write("\n" +sabe);
			fw.write("\nThis was my message");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
