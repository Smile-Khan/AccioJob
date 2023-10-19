QUESTION :- Merge Sort for Linked List {
    
}


Given a linked list of n nodes, the task is to sort the given linked list using Merge Sort.

Input Format
First line contains an integer n, which is the number of nodes

Second line contains n space separated integers

Output Format
Print the sorted list

Example 1
Input

5
3 5 2 4 1
Output

1 2 3 4 5
Explanation:

The sorted array is 1 2 3 4 5

Example 2
Input

6
3 5 2 4 1 6
Output

1 2 3 4 5 6
Explanation:

The sorted array is 1 2 3 4 5 6

Constraints
1 <= n <= 105

1 <= node.data <= 103


SOLUTION :-

import java.util.Scanner;

class Solution {
    public Node mergesort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergesort(head);
        Node right = mergesort(nextOfMiddle);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node sortedList = new Node(0);
        Node current = sortedList;

        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null)
            current.next = left;
        else
            current.next = right;

        return sortedList.next;
    }

    private Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList a = new LinkedList();
        for (int i = 0; i < n; i++) {
            a.add(input.nextInt());
        }
        Solution Obj = new Solution();
        a.head = Obj.mergesort(a.head);
        Node h = a.head;
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
    }
}
