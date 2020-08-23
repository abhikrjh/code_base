package problemsolving;

import java.util.Stack;

/* You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. 
 * You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
 * Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. 
 * This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. 
 * The removals must be performed in such a way as to maximize the height.
*/
public class EqualStack {

	// Passed all test cases
	static int equalStacks1(int[] h1, int[] h2, int[] h3) {
		int sum1 = 0, sum2 = 0, sum3 = 0;
		int n1 = h1.length;
		int n2 = h2.length;
		int n3 = h3.length;

		for (int i = 0; i < n1; i++)
			sum1 += h1[i];

		for (int i = 0; i < n2; i++)
			sum2 += h2[i];

		for (int i = 0; i < n3; i++)
			sum3 += h3[i];

		int top1 = 0, top2 = 0, top3 = 0;
		while (true) {
			if (top1 == n1 || top2 == n2 || top3 == n3)
				return 0;

			if (sum1 == sum2 && sum2 == sum3)
				return sum1;

			if (sum1 >= sum2 && sum1 >= sum3)
				sum1 -= h1[top1++];
			else if (sum2 >= sum3 && sum2 >= sum3)
				sum2 -= h2[top2++];
			else if (sum3 >= sum2 && sum3 >= sum1)
				sum3 -= h3[top3++];
		}
	}

	// Passed only three test cases
	static int equalStacks2(int[] h1, int[] h2, int[] h3) {

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();

		int h1Height = 0;
		int h2Height = 0;
		int h3Height = 0;

		for (int i = h1.length - 1; i >= 0; i--) {
			h1Height += h1[i];
			stack1.push(h1Height);
		}
		for (int i = h2.length - 1; i >= 0; i--) {
			h2Height += h2[i];
			stack2.push(h2Height);
		}
		for (int i = h3.length - 1; i >= 0; i--) {
			h3Height += h3[i];
			stack3.push(h3Height);
		}

		while (true) {

			int peek1 = stack1.peek();
			int peek2 = stack2.peek();
			int peek3 = stack3.peek();

			if (peek1 == h1.length || peek2 == h2.length || peek3 == h3.length) {
				return 0;
			}

			if (peek1 == peek2 && peek2 == peek3) {
				return peek1;
			}

			if (peek1 > peek2 && peek1 > peek3) {
				stack1.pop();
			} else if (peek2 > peek1 && peek2 > peek3) {
				stack2.pop();
			} else if (peek3 > peek1 && peek3 > peek2) {
				stack3.pop();
			}

		}

	}

	public static void main(String[] args) {
		int stack1[] = { 3, 2, 1, 1, 1 };
		int stack2[] = { 4, 3, 2 };
		int stack3[] = { 1, 1, 4, 1 };

		System.out.println(equalStacks1(stack1, stack2, stack3));
	}

}
