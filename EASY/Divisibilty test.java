QUESTION :- Divisibility test

Write a program that takes a number n and print how many numbers from 1 to 10 can divide it.

Input Format
First line contain a number n

Output Format
Print how many numbers from 1 to 10 can divide it.

Example 1
Input

100
Output

5
Example 2
Input

80
Output

6
Constraints
1 <= n <= 10^9

Solution:-

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= 10; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
