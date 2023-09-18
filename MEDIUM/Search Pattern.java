// You are given two string a and b. Your task is find all the indices(1-based) where string b is present in string a as a substring.

// If b is not present in a, return an array {-1}.

// Input Format
// First line contains the string a

// Second line contains the string b

// Output Format
// Complete the function FindIndices() and return the array required array/vector.

// Example 1
// Input

// acciojobacciojob
// job
// Output

// 6 14
// Explanation

// The string job occurs twice at indices {6, 14}

// Example 2
// Input

// marvelsuperheros
// batman
// Output

// -1
// Constraints
// 1 <= a.size() <= 105

// // 1 <= b.size() <= a.size()

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> FindIndices(String a, String b) {
        //Write your code here
		
		ArrayList<Integer> result = new ArrayList<>();

		int n = a.length();
		int m = b.length();

		for(int i=0; i<=n-m; i++)
			{
				if(a.substring(i,i+m).equals(b))
				{
					result.add(i+1); // 1-based indexing
				}
			}
		if(result.isEmpty()){
			result.add(-1);
		}
		return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}