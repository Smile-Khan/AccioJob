QUESTION :- Get Strair Paths

You are given a number n representing number of stairs in a staircase.

You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.

Your task is to complete the given function and return list of all paths that can be used to climb the staircase up.

Input Format
The first line of input contains a single number n.

Output Format
Return list of all paths that can be used to climb the staircase up.

Example 1
Input

3
Output

111 12 21 3
Explanation

All the possible ways to climb up the stairs are

Taking all the steps of size 1.

Taking first step of size 1 and second of size 2,

Taking first step of size 2 and second of size 1.

Taking first step of size 3.

Example 2
Input

1
Output

1
Explanation

The only possible way is stair of size 1.

Constraints
1 <= n <= 10


SOLUTION :-

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        
        Solution obj=new Solution();

        ArrayList<String> ans=obj.solve(n);
        Collections.sort(ans);   

        for(String s :ans)
        System.out.print(s+" ");

        System.out.println();
    }
}

class Solution{
    
    public ArrayList<String> solve(int n)
    {
        // your code here
        ArrayList<String> result = new ArrayList<>();
		findPaths(n, " ", result);
		return result;
    }
	private void findPaths(int n, String path, ArrayList<String> result)
	{
		if(n == 0)
		{
			result.add(path.trim());
			return;
		}
		if(n >= 1)
		{
			findPaths(n - 1, path + "1",result);
			
		}
		if(n >= 2)
		{
			findPaths(n - 2, path + "2",result);
		}
		if(n >= 3)
		{
			findPaths(n - 3, path + "3", result);
		}
	}
}