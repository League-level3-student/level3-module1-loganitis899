package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		Stack<Double> stack = new Stack();
		//   Don't forget to import the Stack class
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
	

		for(int i=0;i<100;i++) {
			stack.push(Math.random()*100);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String int1 = JOptionPane.showInputDialog("enter a small # 0-100");
		String int2 = JOptionPane.showInputDialog("enter a # Beeg 0-100");
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		int intone = Integer.parseInt(int1);
		int inttwo = Integer.parseInt(int2);
		for(int i=0; i<stack.size(); i++) {
			double test = stack.pop();
			if(test>intone&&test<inttwo) 
			{System.out.println(test);
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
}
