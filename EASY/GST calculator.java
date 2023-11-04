QUESTION :- GST calculator {
    

    Write a program to calculate the GST bill for a certain purchase according to the following :-

if the purchase is less than or equal to 5000/- GST is 18%
if the purchase is less than or equal to 10k and greater than 5k GST is 20%
if the purchase is less than or equal to 20k and greater than 10k GST is 25%
if the purchase is greater than 20k GST is 28%
Print upto 3 decimal points.

Input Format
First line contains purchase amount (decimal value)
Output Format
print the GST for the purchase.
Example 1
Input

10000
Output

2000.000
Explanation

Since the amount is 10k, it will attract a GST of 20% which is equal to 2000.

Example 2
Input

30000
Output

8400.000
Explanation

Since the amount is 30k, it will attract a GST of 28% which is equal to 8400.

Constraints
1 <= amount<= 10^9


}

SOLUTION :-

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double purchaseAmount = sc.nextDouble();
        double gst = calculateGST(purchaseAmount);
        System.out.printf("%.3f\n", gst);
    }

    public static double calculateGST(double purchaseAmount) {
        if (purchaseAmount <= 5000) {
            return purchaseAmount * 0.18;
        } else if (purchaseAmount <= 10000) {
            return purchaseAmount * 0.20;
        } else if (purchaseAmount <= 20000) {
            return purchaseAmount * 0.25;
        } else {
            return purchaseAmount * 0.28;
        }
    }
}

