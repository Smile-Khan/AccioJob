// QUESTION :-  Construct BST from given Pre-order traversal

// https://course.acciojob.com/idle?question=f7984e21-28b9-4d24-a233-b3130578a438

// Print the Inorder traversal of a binary search tree that matches the given preorder traversal.

// (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val. Also, recall that a preorder traversal displays the node's value first, then traverses the node.left, then traverses node.right.)

// Note: It is guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

// Input Format
// The first line inputs N, size of preorder array.

// The second line contains N elements of the preorder array.

// Output Format
// Print the Inorder traversal of a BST that matches the given preorder traversal.

// Example 1
// Input

// 6
// 8 5 1 7 10 12
// Output

// 1 5 7 8 10 12
// Explanation

// 1 5 7 8 10 12 is the Inorder traversal.

// Example 2
// Input

// 4
// 2 1 3 4
// Output

// 1 2 3 4
// Explanation

// 1 2 3 4 is the Inorder traversal.

// Constraints
// 1 <= preorder.length <= 100

// 1 <= preorder[i] <= 10^8

// The values of preorder are distinct.

SOLUTION :-

import java.util.Scanner;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    Node root = null;

    BST() {

    }

    Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for (int i = 0; i < n; i++) {
            t.root = t.insert(t.root, input.nextInt());
        }
        inorder(t.root);
    }
}
