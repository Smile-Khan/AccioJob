// QUESTION :-

// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same Node class where the right child pointer points to the next node in the list and the left child pointer is always null.

// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

// Input Format
// The first line contains the number of test cases.

// For each test case: You are given a string representing the nodes of the tree, N is null .

// Output Format
// For each test case flatten the binary tree to the linked list.

// Example 1
// Input

// 1
// 1 2 3

//         1
//        / \
//       2   3
// Output

// 1 2 3
// Explanation

// After flattening, the tree looks like this:

//     1
//      \
//       2
//        \
//         3
// The in-order traversal of this flattened tree is 1 2 3.
// Example 2
// Input

// 1
// 1 2 3 4

//       1
//     /   \
//    2     3
//  / 
// 4
// Output

// 1 2 4 3
// Explanation

// After flattening, the tree looks like this:

//     1
//      \
//       2
//        \
//         4
//          \
//           3
// The in-order traversal of this flattened tree is 1 2 4 3.
// Constraints
// 1 <= T <= 10

// 1 <= N <= 1000

SOLUTION :- 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    private Node prev = null;

    public void flatten(Node root) {
        if (root == null) {
            return;
        }

        Node right = root.right; // Save the original right child

        if (prev != null) {
            prev.left = null; // Set the left child of the previous node to null
            prev.right = root; // Set the right child of the previous node to the current node
        }

        prev = root; // Update the previous node

        flatten(root.left); // Recursively flatten the left subtree
        flatten(right);    // Recursively flatten the right subtree
    }
}

public class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));

        Queue<Node> queue = new LinkedList<>(); 

        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if (!currVal.equals("N")) {

                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            if (!currVal.equals("N")) {

                currNode.right = new Node(Integer.parseInt(currVal));

                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            ob.flatten(root);
            printInorder(root);
            System.out.println();
            t--;
        }
    }
}
