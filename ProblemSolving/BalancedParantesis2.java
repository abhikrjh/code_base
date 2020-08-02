package problemsolving;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BalancedParantesis2 {

	// ( [{}()])

	public static boolean isBalancedParan(String str) {

		Stack<Character> stack = new Stack<Character>();
		List<Character> li1 = new ArrayList<Character>();
		List<Character> li2 = new ArrayList<Character>();

		li1.add('{');
		li1.add('(');
		li1.add('[');

		li2.add('}');
		li2.add(')');
		li2.add(']');

		Map<Character, Character> map = new LinkedHashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (i == 0 && li2.contains(c)) {
				return false;
			}
			// i ==1

			if (li1.contains(c)) {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					char popped = stack.pop();
					if (map.get(popped) == c) {
						continue;
					}else {
						return false;
					}
				} else {
					return false;
				}

			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String expr = "([{}()])";
		
		//String expr = "{[}]";
		if (isBalancedParan(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

}
