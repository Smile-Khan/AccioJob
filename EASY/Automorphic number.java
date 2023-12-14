You are given a number 'N' and you need to check if it is a automorphic number or not. A number is called an automorphic number if and only if the square of the given number ends with the same number itself.

Input Format
The first line contains the number 'N'.

Output Format
print 1 if it is a automorphic number or 0 if it is not.

Example 1
Input

6
Output

1
Explanation

Suppose, we want to check the number 6 is automorphic or not.
Square of 6 is 36
last digit of 36 is 6.
hence , the 6 is automorphic number.
Example 2
Input

25
Output

1
Constraints
1 <= n <= 1000


SOLUTION :-


import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        long n = ob.nextInt();
        if (isAutomorphicNumber(n)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean isAutomorphicNumber(long n) {
        long square = n * n;
        while (n > 0) {
            if (n % 10 != square % 10) {
                return false;
            }
            n /= 10;
            square /= 10;
        }
        return true;
    }
}
