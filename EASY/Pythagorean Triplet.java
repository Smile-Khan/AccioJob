public class Pythagorean Triplet {
    Write a Java program to check if a given set of numbers is a valid pythagorean triplet.

Pythagorean triples are a^2+b^2 = c^2 where a, b and c are the three positive integers. These triples are represented as (a,b,c). Here, a is the perpendicular, b is the base and c is the hypotenuse of the right-angled triangle.

Input Format
Take any input three numbers a, b and c.

Output Format
Print true if they can form a pythagorean triplet and false otherwise.

Example 1
Input

3
4
5
Output

true
Example 2
Input

4
7
12
Output

false
Constraints
1 < = N < = 10^9
}

SOLUTION :-

import java.text.Format;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input three numbers
       
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // Check if they form a Pythagorean triplet
        boolean isPythagoreanTriplet = checkPythagoreanTriplet(a, b, c);

        // Output the result
        System.out.println(isPythagoreanTriplet);
    }

    static boolean checkPythagoreanTriplet(int a, int b, int c) {
        // Check the Pythagorean triplet condition
        return (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a);
    }
}

