public class Construct Binary Tree from Preorder and Inorder Traversal {
    

    You are given two arrays of size N each. They represent the preorder and inorder traversals of a binary tree.

You need to construct the original binary tree with their help. You need to print the postorder traversal of the formed tree.

NOTE You need to complete the given function and return the head node. The input and printing of output will be handled by the driver code.

Input Format
You are given an integer N, denoting the size of the tree.

The second line contains N space-separated integers denoting the preorder traversal.

The third line contains N space-separated integers denoting the in-order traversal.

Output Format
Print the postorder traversal of the tree.

Example 1
Input

6
10 11 23 24 12 35
23 11 24 10 35 12
Output

23 24 11 35 12 10
Explanation



You can check the postorder from the given tree.

Example 2
Input

4
1 2 3 4
1 2 4 3

Output

4 3 2 1
Explanation



You can check the postorder from the given tree.

Constraints
1 <= N <= 10000
}


Solution :-


import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrder(root);
        System.out.println();
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

class Solution {
    static int preIndex = 0;

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return buildTreeHelper(inorder, preorder, 0, n - 1);
    }

    public static Node buildTreeHelper(int inorder[], int preorder[], int start, int end) {
        if (start > end)
            return null;

        Node node = new Node(preorder[preIndex++]);

        if (start == end)
            return node;

        int inIndex = search(inorder, start, end, node.data);

        node.left = buildTreeHelper(inorder, preorder, start, inIndex - 1);
        node.right = buildTreeHelper(inorder, preorder, inIndex + 1, end);

        return node;
    }

    public static int search(int arr[], int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}

