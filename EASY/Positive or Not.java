QUESTION :- Positive or Not {
    

    Write a program to a number and check if it is positive or negative.

Input Format
The first line contains a number n.

Output Format
Print 1 for positive and 0 for negative

Example 1
Input

12
Output

1
Example 2
Input

-2
Output

0
Constraints
1 <= n <= 10000


}

SOLUTION :-

import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int a=ob.nextInt();
        // Your code here
		// if(a >= 0)
		// {
		// 	System.out.println("1");
		// }
		// else 
		// {
		// 	System.out.println("0");
		// }



		

		int ans = (a >= 0)?1:0;
		System.out.println(ans);
    }
}
