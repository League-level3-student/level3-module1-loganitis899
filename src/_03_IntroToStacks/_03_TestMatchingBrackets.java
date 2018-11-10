package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {
	Stack<Character> test = new Stack<Character>();

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertFalse(doBracketsMatch("}{"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));

	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		char e = 'O';
		test.empty();
		for (int i = 0; i < b.length(); i++) {

			if (b.charAt(i) == '{') {
				test.push(e);
			}
			if (b.charAt(i) == '}') {
				if (test.isEmpty()) {
					return false;
				} else {
					test.pop();
				}

			}
		}

		if (test.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}
}