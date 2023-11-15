QUESTION :- Maximum Absolute Difference {
    
    Problem Description

You are given an array of N integers, A1, A2 ,…, AN. Print maximum value of f(i, j) for all 1 ≤ i, j ≤ N.

f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

Print 5

Input Format The first line contains integer n . The second line contains n integers arr[i].

Output Format Print the maximum value of f(i, j) .

Example Input

3 1 3 -1

Example Output

5

Constraints:

2 <= arr.length <= 40000 -10^6 <= arr[i] <= 10^6
}


SOLUTION :-

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find the maximum value of f(i, j)
        int maxF = findMaxFValue(arr, n);
        System.out.println(maxF);
    }

    // Function to find the maximum value of f(i, j)
    static int findMaxFValue(int[] arr, int n) {
        int maxF = Integer.MIN_VALUE;

        // Iterate through each pair of indices i and j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int fValue = Math.abs(arr[i] - arr[j]) + Math.abs(i - j);
                maxF = Math.max(maxF, fValue);
            }
        }

        return maxF;
    }
}

