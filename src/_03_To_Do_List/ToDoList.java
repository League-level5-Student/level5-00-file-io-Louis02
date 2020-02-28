package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class ToDoList implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTask = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	ArrayList<String> task = new ArrayList<String>();

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	public ToDoList() {
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.setText("Add a task to the list.");
		viewTask.setText("View the tasks on the list.");
		removeTask.setText("Remove a task on the list.");
		saveList.setText("Save the whole list to a file.");
		loadList.setText("Get the last saved list from the file.");
		addTask.addActionListener(this);
		viewTask.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
		System.out.println("in here");
	}

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addTask) {
			String s = JOptionPane.showInputDialog("Please input a task for me to do");
			task.add(s);
		}
		if (e.getSource() == viewTask) {
			ArrayList<String> currentTasks = new ArrayList<String>();
			for (int i = 0; i < task.size(); i++) {
				currentTasks.add(task.get(i));
				System.out.println(task.get(i));
			}
			JOptionPane.showMessageDialog(null, currentTasks);
		}
		if (e.getSource() == removeTask) {
			String rTask = JOptionPane.showInputDialog("What task would you like to remove");
			if (task.contains(rTask)) {
				task.remove(rTask);
			} else {
				JOptionPane.showMessageDialog(null, "That was not a valid task");
			}
		}
		if (e.getSource() == saveList) {
			try {
				FileWriter fr = new FileWriter("src/_03_To_Do_List/To_Do_File.txt");
				for (int i = 0; i < task.size(); i++) {
					fr.write(task.get(i) + "\n");
				}

				fr.close();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == loadList) {
			try {
				BufferedReader fr = new BufferedReader(new FileReader("src/_03_To_Do_List/To_Do_File.txt"));
				String line = fr.readLine();
				while(line != null) {
					System.out.println(line);
					line = fr.readLine();
				}
			fr.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
