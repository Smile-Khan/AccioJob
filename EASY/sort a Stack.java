QUESTION :- sort a Stack {
    

    You are given stack of integers of size n. Your task is to sort it such that the top of the stack has the greatest element.

Input Format
The first line of the input contains the number n(Size of the Stack),

The next line contains n space separated integers denoting the elements of the stack.

Output Format
Return the updated stack.

Example 1
Input

4
3 6 1 0
Output

6 3 1 0
Example 2
Input

4
1 2 3 4
Output

4 3 2 1
Constraints
1 <= n <= 100

0 <= nums[i] <= 100


}

SOLUTION :-

import java.util.Scanner;
import java.util.Stack;

class Accio {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> tempStack = new Stack<>();

        while (!s.isEmpty()) {
            int currentElement = s.pop();

            // Pop elements from tempStack and push them back onto s until the correct position for currentElement is found.
            while (!tempStack.isEmpty() && tempStack.peek() < currentElement) {
                s.push(tempStack.pop());
            }

            // Push the currentElement onto tempStack.
            tempStack.push(currentElement);
        }

        // Copy elements from tempStack to s to get the sorted order.
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            stack.push(sc.nextInt());
        }
        Accio accio = new Accio();
        Stack<Integer> sortedStack = accio.sort(stack);
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}

