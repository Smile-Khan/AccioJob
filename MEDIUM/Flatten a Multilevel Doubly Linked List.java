QUESTION :- Flatten a Multilevel Doubly Linked List {
    

    You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

Input Format
The First line of input contain an integer N denoting number of nodes in topmost list.

Second line contain N space separted random integers.

Third line contains number of child levels other than parent node.

For each level

line one contain index at which child list is connected

second line contain number of elements in child list

third line contains space separated value of child list

Output Format
Print the linked list after deletion.

Example 1
Input

5
1 2 3 4 5
1
2
5
8 9 10 11 12
Output

1 2 3 8 9 10 11 12 4 5 
Explanation

1 2 3 4 5
    |
    8 9 10 11 12
List is flattened.

Example 2
Input

5
1 2 3 4 5
2
2
5
8 9 10 11 12
1
2
50 60
Output

1 2 3 8 9 50 60 10 11 12 4 5 
Explanation

1 2 3 4 5
    |
    8 9 10 11 12
      |
      50 60
List is flattened

Constraints
2 <= number of nodes in a list< =100

1 <= number of levels <= 10



}

SOLUTION :-

import java.util.Scanner;
import java.util.Stack; // Import the Stack class

class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    public Node(int value, Node prev, Node next, Node children) {
        this.val = value;
        this.prev = prev;
        this.next = next;
        this.child = children;
    }
}

class Solution {
    public static Node flatten(Node head, Node rest) {
         if (head == null) {
            return rest;
        }

        Node current = head;
        Stack<Node> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            if (current.child != null) {
                if (current.next != null) {
                    stack.push(current.next);
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }

            if (current.next == null && !stack.isEmpty()) {
                current.next = stack.pop();
                current.next.prev = current;
            }

            current = current.next;
        }

        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node head = new Node(0, null, null, null); // extra node
        Node curr = head;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            Node temp = new Node(a, curr, null, null);
            curr.next = temp;
            curr = temp;
        }
        head = head.next;
        curr = head;

        int level = scanner.nextInt();
        while (level-- > 0) {
            int ind = scanner.nextInt();

            int numNodes = scanner.nextInt();

            while (ind-- > 0) {
                curr = curr.next;
            }

            int a = scanner.nextInt();
            curr.child = new Node(a, null, null, null);
            curr = curr.child;
            Node newHead = curr;
            numNodes--;

            while (numNodes-- > 0) {
                a = scanner.nextInt();
                Node temp = new Node(a, curr, null, null);
                curr.next = temp;
                curr = temp;
            }

            curr = newHead;
        }
        Solution obj = new Solution();
        Node ans = obj.flatten(head, null);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

