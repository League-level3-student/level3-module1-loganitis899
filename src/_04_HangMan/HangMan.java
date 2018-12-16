package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel words = new JLabel();
	JLabel lives = new JLabel();
	String underscores = "";
	int hearts = 6;
	String poppedWord = "";

	int L = 0;
	Stack<String> word = new Stack<String>();
	static Boolean done = false;

	public static void main(String[] args) {
		HangMan start = new HangMan();
		start.start();

	}

	void start() {
		done = false;
		f.setVisible(true);
		f.add(p);

		p.add(words);
		f.addKeyListener(this);
		p.add(lives);
		String length = JOptionPane.showInputDialog("How many words do you want to guess?");
		int lengthInt = Integer.parseInt(length);
		getWords(lengthInt);
		words.setText(setUpLength());
		lives.setText("Hearts Left: " + hearts);
		f.pack();
	}

	void getWords(int howMany) {
		for (int q = 0; q < howMany; q++) {
			word.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			System.out.println(word.get(q));
		}

	}

	public void keyTyped(KeyEvent e) {
		
	}

	void reset() {
		underscores = "";
 hearts=6;
		
		if (word.isEmpty() && underscores.contains("_") == false) {
			String play = JOptionPane
					.showInputDialog("Do you want to play agan?, Press 1 to play again, press 2 to die");
			if (play.contains("1")) {
				start();
			} else {
				System.exit(0);
			}
		}else{
		words.setText(setUpLength());
		}
		f.pack();
		checklives();
	}
 void checklives() {
	 if(hearts==0) {
		 JOptionPane.showMessageDialog(null, "You Died");
		 System.exit(0);
	 }
 }
	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		char typed = e.getKeyChar();
		boolean in=false;
		for (int i = 0; i < poppedWord.length(); i++) {

			if (typed == poppedWord.charAt(i)) {
in=true;
				if (i == 0) {
					String partA = "" + typed;
					String partB = underscores.substring(1);
					String returnWord = partA + partB;
					words.setText(returnWord);
					underscores = returnWord;
				} else {
					String partA = underscores.substring(0, i);
					String partB = underscores.substring(i + 1);
					String wordInsert = "" + typed;
					String returnWord = partA + wordInsert + partB;
					words.setText(returnWord);
					underscores = returnWord;

				}

			
			

			}
		}
		if (in == false) {
			hearts = hearts - 1;
			lives.setText("Lives left: " + hearts);
			checklives();
			
		}
		
		if (underscores.contains("_")) {

		} else {
			done = true;
			reset();
		}
	}

	String setUpLength() {
		poppedWord = word.pop();
		int lengthPoppedWord = poppedWord.length();

		for (int i = 0; i < lengthPoppedWord; i++) {
			underscores = underscores + "_";
		}
		System.out.println(underscores);
		return underscores;
	
	}
	
	
}
