public class Concatenation of Array {
    
    Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of array nums 2 times.

Print the ans array

Input Format
The first line of the input contains the number 𝑛(length of array)

The next n integers denotes the elements of the array.

Output Format
Print the concatenated array

Example 1
Input

3
1 2 1
Output

1 2 1 1 2 1
Explanation

The array ans is formed as follows:

ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
ans = [1,2,1,1,2,1]
Example 2
Input

4   
1 3 2 1
Output

1 3 2 1 1 3 2 1
Explanation

The array ans is formed as follows:

ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
ans = [1,3,2,1,1,3,2,1]
Constraints
n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000

Java



}

SOLUTION :-

import java.util.Scanner;

class Solution {
    void concatArray(int arr[], int n) {

 
        int[] ans = new int[2 * n];

        
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
            ans[i + n] = arr[i];
        }

        
        for (int i = 0; i < 2 * n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.concatArray(arr1, n);
    }
}
