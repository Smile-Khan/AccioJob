QUESTION :- class Is Target Possible To Get 

Given an array of integers nums of size n, is it possible to choose a group of some of the integers, such that the group sums to the given target.

Input Format
The first line contains two integers representing n and target.

Next line contains n spaced integers representing the nums array.

Output Format
Return boolean true if the condition is holds else return false.

Example 1
Input

3 10
2 4 8
Output

true
Explanation

Here 2+8 == 10.
Example 2
Input

3 9
2 4 8
Output

false
Explanation

Here no combination gives the target 9.
Constraints
1 <= n <= 7

1 <= nums[i], target <= 20


SOLUTION :- 

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Scanner;

class Solution {
    public boolean targetSum(int start, int[] nums, int target) {
        //write code here
		if(start == nums.length)
		{
			return target == 0;
		}

		// Include the current number in the sum

		if(targetSum(start + 1, nums, target - nums[start]))
		{
			return true;
		}

		// Exclude the current number from the sum

		if(targetSum(start + 1, nums, target))
		{
			return true;
		}
		return false;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.targetSum(0, arr, target));
        sc.close();
    }
}

