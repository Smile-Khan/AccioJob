QUESTION :- Number of ways to decrypt 

A string consisting of lowercase characters was encrypted using the following algorithm.

Replace 'a' with '1', 'b' with '2', and so on. You are given the encrypted string. You need to find out the number of ways to decrypt it.

NOTE: Use 64-bit datatype to store your answer.

You need to complete the given function. The input and printing of output will be handled by the driver code.

Your task is to complete the function waysDecrypt which receives the string as its parameter and returns the number of ways to decrypt it.

Input Format:
The first line contains the number of test cases.

For each test case: The only line contains the encrypted string.

Output Format:
Print the number of ways in a new line.

Example 1:
Input:

1
111
Output:

3
Explanation:

The three possible ways are 1+11 = ak, 11+1 = ka, and 1+1+1 = aaa.

Example 2:
Input:

1
12
Output:

2
Explanation:

The two possible ways are 1+2 = ab and 12 = l;

Constraints:
1 <= T <= 10

1 <= |s| <= 100


SOLUTION :-

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String str = sc.next();
            Solution ob = new Solution();
            long ans = ob.waysDecrypt(str);
            System.out.println(ans);
        }
    }
}

class Solution {
    public long waysDecrypt(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        // Empty string can be decoded in one way (no characters).
        dp[0] = 1;

        // If the first character is '0', then no way to decode.
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            // If the current character is not '0', add ways from previous character.
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check if the previous and current characters form a valid two-digit number.
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
