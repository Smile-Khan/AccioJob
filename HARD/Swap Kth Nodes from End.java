QUESTION :- Swap Kth Nodes from End {
    


    Given a singly linked list of size N, and an integer K. You need to swap the Kth node from beginning and Kth node from end in linked list.

Note: You need to swap the nodes through the links and not changing the content of the nodes.

Input Format
The first line contains N, number of nodes in linked list and K, the nodes to be swapped.\

The second line contains the elements of the linked list.

Output Format
Print the linked list in a new line.

Example 1
Input

5 3
1 2 3 4 5
Output

1 2 3 4 5 
Explanation

Here k = 3, hence after swapping the 3rd node from beginning and end the new list will be 1 2 3 4 5.

Example 2
Input

4 4
1 2 3 4
Output

4 2 3 1
Explanation

Here k = 4, hence after swapping the 4th node from beginning and end the new list will be 4 2 3 1.

Constraints
1 <= N <= 10^3

1 < K < N




}

SOLUTION :-


import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

class Solution{
	Node swapkthnode(Node head, int num, int K)
    {
        //Write your code here
		 if (K < 1 || K > num)
            return head;

        if (2 * K - 1 == num)
            return head; // No need to swap

        Node xPrev = null;
        Node x = head;

        for (int i = 1; i < K; i++) {
            xPrev = x;
            x = x.next;
        }

        Node yPrev = null;
        Node y = head;

        for (int i = 1; i < num - K + 1; i++) {
            yPrev = y;
            y = y.next;
        }

        if (xPrev != null)
            xPrev.next = y;
        if (yPrev != null)
            yPrev.next = x;

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        if (K == 1)
            head = y;
        if (K == num)
            head = x;

        return head;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        LinkedList list = new LinkedList();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            list.add(x);
        }
        Solution obj = new Solution();
		list.head = obj.swapkthnode(list.head, n, k);
		Node curr = list.head;
		while(curr != null){
			System.out.print(curr.data + " ");
			curr = curr.next;
	    }
	}
}
