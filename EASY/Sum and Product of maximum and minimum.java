QUESTION :- Sum and Product of maximum and minimum {
    

    You are given an array A of N integers. You need to find the sum and product of the maximum and minimum value present in the array.

NOTE

You need to complete the given function. The input and printing of output will be handled by the driver code.

Input Format
The first line contains the number of test cases.

For each test case: The first line has the value of N.

The next line contains N space-separated integers of array A.

Output Format
For each test case return an array of size two having the sum at first position and product at second.

Example 1
Input:

1
4
1 2 3 2
Output

4 3
Explanation

Minimum value is 1 and maximum is 3. 1 + 3 = 4 and 1 * 3 = 3.

Example 2
Input

1
5
3 2 2 4 6
Output

8 12
Explanation

Minimum value is 2 and maximum is 6. 2 + 6 = 8 and 2 * 6 = 12.

Constraints
1 <= T <= 10

1 <= N <= 10000

1<= A[i] <= 1000000


}


SOLUTION :-

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // Number of test cases

        while (T > 0) {
            int N = sc.nextInt();  // Size of the array
            int[] A = new int[N];  // Array to store elements

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();  // Input array elements
            }

            int min = A[0];
            int max = A[0];

            for (int i = 1; i < N; i++) {
                min = Math.min(min, A[i]);  // Find the minimum value
                max = Math.max(max, A[i]);  // Find the maximum value
            }

            int sum = min + max;  // Calculate the sum
            int product = min * max;  // Calculate the product

            System.out.println(sum + " " + product);  // Output sum and product

            T--;  // Decrement the number of test cases
        }
    }
}

