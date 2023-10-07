QUESTION :- subset sum 

You are given an array arr of size n. You need to find the sum of all the subsets and return them in form of an array or vector.

Input Format
First line contains an integer n

Second line contains n space separated integers

Output Format
Complete the function SubsetSums() which returns the desired array or vector

Example 1
Input

2
2 3
Output

0 2 3 5
Example 2
Input

3
1 2 3
Output

0 1 2 3 3 4 5 6
Constraints
1 <= n <= 15

0 <= arr[i] <= 104


SOLUTION :-

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> SubsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.size();
        int totalSubsets = (int) Math.pow(2, n);

        for (int i = 0; i < totalSubsets; i++) {
            int subsetSum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsetSum += arr.get(j);
                }
            }
            result.add(subsetSum);
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());
        Solution obj = new Solution();
        ArrayList<Integer> ans = obj.SubsetSums(arr);
        Collections.sort(ans);
        for (int a : ans)
            System.out.print(a + " ");
    }
}

