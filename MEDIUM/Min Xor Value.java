QUESTION :-

Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.

Return the minimum XOR value.

Input Format
First line contains n (Size of the array )

Second line contains n integers (Elements of array A)

Output Format
Print a single integer denoting minimum xor value

Example 1
Input

4
0 2 5 7
Output

2
Explanation

0 xor 2 = 2

Example 2
Input

4
0 4 7 9
Output

3
Constraints
2 <= N <= 100000  
0 <= A[i] <= 1000000000


SOLUTION :-

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMinimumXOR(arr));
        sc.close();
    }

    public static int findMinimumXOR(int[] arr) {
        Arrays.sort(arr);
        int minXOR = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i] ^ arr[i + 1];
            minXOR = Math.min(minXOR, xor);
        }
        
        return minXOR;
    }
}
