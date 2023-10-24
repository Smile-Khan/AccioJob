QUESTION :- Print Minimum Length String {
    


    You are given an array of string. Print the string which has minimum length. If there are two strings of minimum length, print the one that comes first.

Input Format
First line contains an integer n.

Next n line contains string.

Output Format
Print string with smallest length in a single line.

Example 1
Input

3 
Accio Jobs
Jobs
Accio
Output

Jobs
Explanation

Jobs has the smallest length out of all the given strings.

Example 2
Input

3 
dfasd fads
grdg a
hd dsgsdfgs hsg
Output

grdg a
Explanation

grdg a has the smallest length out of all the given strings.

Constraints
1 <= |string| <= 1000
1 <= N <= 1000



}


SOLUTION :-

import java.util.Scanner;

class Solution {
    public static void printMinString(String [] str){
       //Write your code here
        if(str.length == 0)
		{
			System.out.println("");
			return;
		}
		String ans = str[0];  // first string
		for(int i = 1; i < str.length; i++)
			{
				if(str[i].length() < ans.length())
				{
					ans = str[i]; // Updating
				}
			}
		System.out.println(ans);
		//return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String sentence[]=new String[n];
        for(int i=0;i<n;i++)sentence[i]=sc.nextLine();
        Solution Obj= new Solution();
        Obj.printMinString(sentence);
    }
}
