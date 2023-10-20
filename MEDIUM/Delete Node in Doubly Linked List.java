QUESTION :- Delete Node in Doubly Linked List {
    


    An implementation of doubly linked list is given. You are given N, number of nodes in linked list. M, the value of node that needs to be deleted. And then value of the nodes of linked list. First complete the deleteNode function in the given linked list implementation and use the function to delete all the nodes with the value M.

Input Format
The First line of input contain an integer N denoting number of nodes and M, value of node to be deleted.

Second line contain N space separted random integers.

Output Format
Print the linked list after deletion.

Example 1
Input

5 6
1 3 6 5 6
Output

1 3 5 
Explanation

Remove the nodes with value 6.

Example 2
Input

4 4
1 3 6 4
Output

1 3 6
Explanation

Remove the nodes with value 4.

Constraints
2 <= N <=10^6

2 <= value of node, M <= 500
}



SOLUTION :-


import java.util.Scanner;

class Node {
    int val;
    Node prev;
    Node next;
    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void append(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    void prepend(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    void delete(Node node) {
        if (node == this.head && node == this.tail) {
            this.head = null;
            this.tail = null;
        } else if (node == this.head) {
            this.head = node.next;
            this.head.prev = null;
        } else if (node == this.tail) {
            this.tail = node.prev;
            this.tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        this.length--;
    }

    void printList() {
        Node curr = this.head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class Solution {
    public static DoublyLinkedList deleteNodeWithX(DoublyLinkedList linkedList, int x) {
        Node current = linkedList.head;
        while (current != null) {
            if (current.val == x) {
                Node toDelete = current;
                current = current.next;
                linkedList.delete(toDelete);
            } else {
                current = current.next;
            }
        }
        return linkedList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for (int i = 0; i < N; i++) {
            linkedList.append(sc.nextInt());
        }
        Solution obj = new Solution();
        linkedList = obj.deleteNodeWithX(linkedList, M);
        linkedList.printList();
    }
}

