QUESTION :- Largest Coprime Divisor


You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0

X and B are co-prime i.e. gcd(X, B) = 1

Input Format
First Line contains two integer A and B separated by space.

Output Format
Print the maximum valued integer X which satisfies the above properties.

Example 1
Input

30 12
Output

5
Explanation

Largest Co-Prime divisor of 30 and 12 is 5

Example 2
Input

10 20
Output

5
Explanation

Largest Co-Prime divisor of 10 and 20 is 5

Constraints
1 <= A, B <= 1e9


ANSWER :-

import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int cpFact(int A, int B) {
        int result = 1;
        while (gcd(A, B) != 1) {
            A /= gcd(A, B);
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.print(cpFact(A, B));
    }
}

