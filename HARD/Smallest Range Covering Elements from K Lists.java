// QUESTION :- 

// You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

// We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

// The length of each list is equal to N.

// Note: You just need to complete smallestRange() function and return the smallest range that includes at least one number from each of the k lists.

// Input Format
// The first line contains a single integer contains two integers n and k. Next k lines contain n spaced integers each representing the elements of each list.

// Output Format
// Print the smallest range that includes at least one number from each of the k lists.

// Example 1
// Input

// 2 3
// 1 1
// 9 12
// 4 9
// Output

// 1 9
// Explanation

// The range [1, 9] consists at least one number from each of the 3 lists and it is smallest possible. 
// Example 2
// Input

// 3 3
// 4 7 30
// 1 2 12
// 20 40 50
// Output

// 7 20
// Explanation

// The range [7, 20] consists at least one number from each of the 3 lists and it is smallest possible. 
// Constraints
// 1 <= k <= 3500
// 1 <= N <= 50
// -105 <= nums[i][j] <= 105
// nums[i] is sorted in non-decreasing order.



SOLUTION :-

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public static int[] smallestRange(ArrayList<ArrayList<Integer>> nums) {
        int k = nums.size();
        int[] pointers = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            minHeap.offer(new int[]{val, i, 0}); // {value, list index, element index}
        }
        
        int minRange = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        while (true) {
            int[] min = minHeap.poll();
            int minVal = min[0];
            int listIdx = min[1];
            int elemIdx = min[2];
            
            if (max - minVal < minRange) {
                minRange = max - minVal;
                result[0] = minVal;
                result[1] = max;
            }
            
            elemIdx++;
            if (elemIdx >= nums.get(listIdx).size()) {
                break;
            }
            
            int newVal = nums.get(listIdx).get(elemIdx);
            max = Math.max(max, newVal);
            minHeap.offer(new int[]{newVal, listIdx, elemIdx});
        }
        
        return result;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, k;

        n = sc.nextInt();
        k = sc.nextInt();
        ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < k; ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < n; ++j) {
                int x = sc.nextInt();
                temp.add(x);
            }
            nums.add(temp);
        }
        int[] ans = Solution.smallestRange(nums);
        System.out.print(ans[0] + " " + ans[1]);
    }
}
