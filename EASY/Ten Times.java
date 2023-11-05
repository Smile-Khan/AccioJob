QUESTION :- Ten Times {
    

    Given an array of integers nums of size n, compute recursively if the array contains somewhere a value followed in the array by that value times 10.

We''''ll use the convention of considering only the part of the array that begins at the given index.

In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

Input Format
The first line contains an integer representing n

Next line contains n spaced integers representing the nums array.

Output Format
Return boolean true if the condition is holds else return false.

Example 1
Input

5 
1 2 3 4 5
Output

false
Explanation

Here in the array no value is followed by it''''s 10 times.
Example 2
Input

3
1 2 20
Output

true
Explanation

Here 20 follows 2 which is 10 times of 2. 
Constraints
1 <= n <= 5*10^3

1 <= nums[i] <= 10^3


}

SOLUTION:-


import java.io.IOException;
import java.util.Scanner;

class Solution {
    public boolean tenTimes(int[] nums, int index) {
        //write code here
        // Base case: If the current index or the next index is out of bounds, return false.
        if (index < 0 || index >= nums.length || index + 1 >= nums.length) {
            return false;
        }
        
        // Check if the next element is 10 times the current element.
        if (nums[index] * 10 == nums[index + 1]) {
            return true;
        }
        
        // Recursively check the rest of the array.
        return tenTimes(nums, index + 1);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.tenTimes(arr, 0));
        sc.close();
    }
}

