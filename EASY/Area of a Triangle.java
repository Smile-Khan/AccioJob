QUESTION :- Area of a Triangle {
    

    Your are given height h and base length b of a triangle. Your task is to find and return the area of that triangle.

Input Format
The First line contains an integer h and b representing the height and base length of the triangle

Output Format
Returns the single integer representing the area of the triangle

Example 1
Input

3 4
Output

6
Explanation

The base length is 4 and the height is 3, so the area of the triangle is (4 * 3) / 2 = 6.

Example 2
Input

5 7
Output

17.5
Explanation

The base length is 7 and the height is 5, so the area of the triangle is (7 * 5) / 2 = 17.5.

Constraints
-10^9 <= h, b <= 10^9


}

SOLUTION :-


import java.util.Scanner;

class Solution {
    public static double triangle_area(double h, double b) {
        // Write your code here
        return (b*h)/2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        double base = sc.nextDouble();
        System.out.println(Solution.triangle_area(height, base));
    }
}
