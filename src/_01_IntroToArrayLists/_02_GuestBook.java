package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton see = new JButton();
	ArrayList<String> guests = new ArrayList();
	public static void main(String[] args) {
		 _02_GuestBook run = new  _02_GuestBook();
		 run.start();
	}
	void start() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(add);
		panel.add(see);
		add.addActionListener(this);
		see.addActionListener(this);
				add.setText("add a mans");
		see.setText("see your men");
		frame.pack();

	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed==add) {
		String name =JOptionPane.showInputDialog("add a guest");
		guests.add(name);
		} else {
		JOptionPane.showMessageDialog(null, guests);
		}
		
	}
	
	
	
}
