public class last Digit Even {
    
    Write a program to input a number and check if the last digit is even or not.

Input format
The first line contains a number n.

Output format
Print 1 if the last digit is even and 0 if the last digit is odd.

Example 1
Input format

2009
Output format

0
Example 2
Input format

1012
Output format

1
Constraint
1 <= n <= 10000

}


SOLUTION :-

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int n = ob.nextInt();
        
        // Your code here
        int lastDigit = n % 10;

        // Check if the last digit is even
        if (lastDigit % 2 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

