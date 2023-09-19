// QUESTION :- 


// Find a continuous subarray within an integer array nums of size n such that, if you only sort this continuous subarray in ascending order, the entire array will also be sorted in ascending order.

// Give the length of the shortest such subarray.

// Input Format
// First line contains an integer n which is the size of nums

// Next line contains n space-separated integers which are the elements of nums

// Output Format
// Complete the function UnsortedSubarrayLength() which returns the required integer

// Example 1
// Input

// 6
// 3 7 5 9 11 10 16
// Output

// 5
// Explanation

// To sort the entire array in ascending order, you must first sort [7, 5, 9, 11, 10] in ascending order.

// Example 2
// Input

// 5
// 1 2 3 4 5
// Output

// 0
// Constraints
// 1 <= n <= 104

// 1 <= nums[i] <= 105

SOLUTION :- 

import java.util.Scanner;

class Solution {
    public int UnsortedSubarrayLength(int[] nums) {
        // Write your code here

		 int n = nums.length;
        int left = 0; // Initialize the left boundary.
        int right = n - 1; // Initialize the right boundary.
        
        // Find the left boundary of the unsorted subarray.
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        
        // If left reaches the end, the array is already sorted.
        if (left == n - 1) {
            return 0;
        }
        
        // Find the right boundary of the unsorted subarray.
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        
        // Find the minimum and maximum values within the unsorted subarray.
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        
        // Expand the left boundary to include all elements less than the minimum value.
        while (left > 0 && nums[left - 1] > minVal) {
            left--;
        }
        
        // Expand the right boundary to include all elements greater than the maximum value.
        while (right < n - 1 && nums[right + 1] < maxVal) {
            right++;
        }
        
        // Calculate the length of the unsorted subarray.
        return right - left + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();

	    Solution Obj = new Solution();
        System.out.println(Obj.UnsortedSubarrayLength(ar));
    }
}