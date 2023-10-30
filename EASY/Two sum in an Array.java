QUESTION :- Two sum in an Array {
 
    

    Given an integer array nums and an integer target

Find indices of the two numbers from the array such that they add up to target.

NOTE: It is always ensured that two elements add up to the given target. Return the output in increasing order.

Input Format
First line contains two integers n and target respectively.

Second line contains n space separated integers representing array nums.

Output Format
Print indices of the two numbers that adds up to the target.

Example 1
Input

4 9
2 7 5 11
Output

0 1
Explanation

nums[0] + nums[1] == 9, we print 0 1

Example 2
Input

3 6
5 2 4
Output

1 2
Explanation

nums[1] + nums[2] == 6, we print 1 2

Constraints
1 <= n <= 10^5

-10^8 <= nums[i] <= 10^8

-10^9 <= target <= 10^9

}


SOLUTION :-

import java.util.HashMap;
import java.util.Scanner;

class Accio {
    public int[] twoSum(int[] nums, int target) {
        // Create a data structure to store the numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (the number needed to reach the target)
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of both numbers
                return new int[] { map.get(complement), i };
            }
            
            // If not found, store the current number and its index
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array
        return new int[0];
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        // Input the number of elements and the target sum
        int n = input.nextInt();
        int target = input.nextInt();
        
        // Input the array of numbers
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        
        // Create an instance of the Accio class
        Accio obj = new Accio();
        
        // Call the twoSum method to find the indices
        int[] indices = obj.twoSum(nums, target);
        
        // Print the indices
        System.out.print(indices[0]);
        System.out.print(' ');
        System.out.print(indices[1]);
    }
}
