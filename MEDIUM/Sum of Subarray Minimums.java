QUESTION :-- Sum of Subarray Minimums 

Given an array of integers arr, find the sum of the minimums of all contiguous subarrays of the array. Since the answer may be large, print the answer modulo 10^9 + 7.

Your task is to complete the function minSubarraySum which receives arr and size of array as parameters and returns the sum of the minimums of all contiguous subarrays of the array

Input Format
The first line contains a single integer n(size of the array).

The second line contains n space integers that denote the elements of the array.

Output Format
Print the sum of minimum of all subarrays.

Example 1
Input

4
3 1 2 4
Output

17
Explanation

Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

Example 2
Input

3
1 2 3
Output

10
Explanation

Subarrays are [1], [2], [3], [1,2], [2,3], [1,2,3].
Minimums are 1, 2, 3, 1, 2, 1.
Sum is 10.

Constraints
1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 3 * 10^4


SOLUTION :-

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public long minSubarraySum(int n, int a[]) {
        long MOD = 1000000007;
        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]) {
                int top = stack.pop();
                int left = top - (stack.isEmpty() ? -1 : stack.peek());
                int right = i - top;
                result = (result + (long) a[top] * left * right) % MOD;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int left = top - (stack.isEmpty() ? -1 : stack.peek());
            int right = n - top;
            result = (result + (long) a[top] * left * right) % MOD;
        }

        return result;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n, a));
    }
}

