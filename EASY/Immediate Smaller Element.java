QUESTION :- Immediate Smaller Element

Given an integer array arr of size n. For each element in the array, check whether the right adjacent element (on the next immediate position) of the array is smaller. If next element is smaller, update the current index to that element. If not, then -1.

Input Format
line 1: contains an integer n denoting size of array.

line 2: contains n spaced integers denoting elements of array.

Output Format
Print an array of integers denoting the immediate smaller element after the current element.

Example 1
Input

4
4 2 1 3
Output

2 1 -1 -1
Explanation From left to right, at index 0, arr[1] < arr[0], hence arr[0] = arr[1]. at index 1, arr[2] < arr[1], hence arr[1] = arr[2]. at index 2, arr[3] >= arr[2], hence arr[2] = -1. at index 3, there is no element to its right hence the value of this array element is -1.

Constraints
1 <= n <= 104

1 <= arr[i] <= 106


ANSWER :- 


import java.util.Scanner;

class Solution {
    public void ImmediateSmaller(int[] arr, int n) {
        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            // Check if the next element is smaller
            if (arr[i + 1] < arr[i]) {
                // If yes, update the current element
                arr[i] = arr[i + 1];
            } else {
                // If not, set the current element to -1
                arr[i] = -1;
            }
        }
        
        // The last element always has no right adjacent element
        arr[n - 1] = -1;
        
        // Print the updated array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Solution Obj = new Solution();
        Obj.ImmediateSmaller(arr, n);
    }
}
