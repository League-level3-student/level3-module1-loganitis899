package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> roster = new HashMap<Integer, String>();
	JFrame j = new JFrame();
	JPanel p = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton kill = new JButton();

	public static void main(String[] args) {
		_02_LogSearch start = new _02_LogSearch();
		start.start();
	}

	void start() {
		j.setVisible(true);
		j.add(p);
		p.add(add);
		p.add(search);
		p.add(view);
		p.add(kill);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		kill.addActionListener(this);
		add.setText("Add Entry");
		search.setText("Search by ID");
		view.setText("View List");
		kill.setText("Remove User");
		add.setSize(50, 50);
		search.setSize(50, 50);
		view.setSize(50, 50);
		kill.setSize(50, 50);
		j.setSize(250, 250);
		j.pack();

		roster.put(123, "james");
		roster.put(456, "sullivan");
		roster.put(789, "Sussy");
		roster.put(007, "logan");
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.getText() == "Add Entry") {
			String IDString = JOptionPane.showInputDialog("Enter an ID number");
			String name = JOptionPane.showInputDialog("Enter a name");
			int ID = Integer.parseInt(IDString);
			roster.put(ID, name);
		}
		if (buttonPressed.getText() == "Search by ID") {
			String IDString = JOptionPane.showInputDialog("Enter an ID number to find it's user");
			int ID = Integer.parseInt(IDString);
			if (roster.containsKey(ID)) {
				JOptionPane.showMessageDialog(null, roster.get(ID));
			} else {
				JOptionPane.showMessageDialog(null, "No user found");
			}
		}
		if (buttonPressed.getText() == "View List") {
			for (Integer key : roster.keySet()) {
				System.out.println("ID number " + key + " is user " + roster.get(key));
			}
		}
		if(buttonPressed.getText()=="Remove User") {
			String IDString = JOptionPane.showInputDialog("Enter an ID number to remove it's user");
			int ID = Integer.parseInt(IDString);
			if(roster.containsKey(ID)) {
				roster.remove(ID);
				JOptionPane.showMessageDialog(null, "User removed");				
			} else {
				JOptionPane.showMessageDialog(null, "ID not found");
			}
		}
	}

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

}
