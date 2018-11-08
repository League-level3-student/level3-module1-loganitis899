package _03_IntroToStacks;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> stack = new Stack<Character>();

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	public static void main(String[] args) {
		_02_TextUndoRedo start = new _02_TextUndoRedo();
		start.start();
	}

	void start() {
		frame.setVisible(true);
		frame.add(panel);
		panel.setBackground(Color.green);
		panel.add(label);
		label.setBackground(Color.gray);
		frame.addKeyListener(this);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
System.out.println(stack.size());
		char typed = e.getKeyChar();
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

			label.setText(label.getText().substring(0, label.getText().length() - 1));
			stack.push(label.getText().charAt(label.getText().length()-1));
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			Character pop = stack.pop();
			String text = label.getText() + pop;
			label.setText(text);
			
			System.out.println(pop);

		} else {
			label.setText(label.getText() + e.getKeyChar());
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
