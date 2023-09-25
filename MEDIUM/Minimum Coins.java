QUESTION :-

Write a program to find the minimum number of coins/ notes required to make the change of A amount of money.

For this problem, you can assume that there is an unlimited supply of the various notes/coins available in the Indian currency denominations. The various denominations available are 1, 2, 5, 10, 20, 50, 100, 200, 500 and 2000.

Input Format
The only line contains an integer, the target amount.

You need to complete minCoins function which contains coins array of size m , V and finally return the count of notes needed as output.

Output Format
Print the minimum number of coins required.

Example 1
Input

90
Output

3
Explanation

50 + 20 + 20 = 90

Example 2
Input

2058
Output

5
Explanation

2000 + 50 + 5 + 2 + 1

Constraints
1 <= Target < = 100000


SOLUTION :-

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int minCoins(int coins[], int m, int V) {
        int[] dp = new int[V + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[V];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int m = coins.length;
        int V = sc.nextInt();
        System.out.println(minCoins(coins, m, V));
    }
}
