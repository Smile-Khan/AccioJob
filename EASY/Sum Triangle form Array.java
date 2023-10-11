QUESTION :- Sum Triangle form Array 

Given an array of integers nums of size n, print a sum triangle from it such that the first level has all array elements.

From then, at each level number of elements is one less than the previous level and elements at the level is be the Sum of consecutive two elements in the previous level.

Input Format
The first line contains an integer representing n

Next line contains n spaced integers representing the nums array.

Output Format
Print the required triangle.

Example 1
Input

5 
1 2 3 4 5
Output

48 
20, 28 
8, 12, 16 
3, 5, 7, 9 
1, 2, 3, 4, 5
Explanation

Here,   48
        20, 28 -->(20 + 28 = 48)
        8, 12, 16 -->(8 + 12 = 20, 12 + 16 = 28)
        3, 5, 7, 9 -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        1, 2, 3, 4, 5 -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
Example 2
Input

3
1 2 3
Output

8 
3, 5 
1, 2, 3
Explanation

Here,   8 
        3 5 -->(3 + 5 = 8)
        1 2 3 -->(1 + 2 = 3, 2 + 3 = 5)
Constraints
1 <= n <= 5*10^3

1 <= nums[i] <= 10^3





import java.util.Scanner;

class Solution {
    public void printTriangle(long[] nums) {
        int n = nums.length;
        long[][] triangle = new long[n][n];
        
        // Fill the bottom row of the triangle with the given array
        for (int i = 0; i < n; i++) {
            triangle[n - 1][i] = nums[i];
        }
        
        // Calculate the sum triangle
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = triangle[i + 1][j] + triangle[i + 1][j + 1];
            }
        }
        
        // Print the sum triangle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j]);
                if (j < i) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        Solution obj = new Solution();
        obj.printTriangle(arr);
    }
}

