QUESTION :- Accio Subarrays {
    


    Harsh has an array 'A' of length 'N', he needs to count the number of Accio Subarrays of 'A'.

An Accio subarray is one that has more than two elements with the same difference between them. For example, the length of [2, 4, 6] is 3, and the difference between any two successive items is 2.

Note

A subarray is a part of a contiguous array (i.e., occupying consecutive locations) that keeps the order of the elements in tact.

Input Format
The first line of input contains an integer denoting the number of test cases.

The first line of each test case contains an integer 'N' denoting the number of elements.

The second line of each test case contains 'N' space separated integers denoting the elements of the array.

Output Format
Print a single integer denoting the number of Accio Subarrays for each test case in a new line.

Example 1
Input

1
4
1 3 5 7
Output

3
Explanation

We have A = [1 3 5 7]

Diff of consecutive elements:

A[1]- A[0] = 3-1 = 2

A[2]- A[1] = 5-3 = 2

A[3]- A[2] = 7-5 = 2

[1 3 5], [3 5 7], and [1 3 5 7] are the three Accio subarray.

Thus the answer is 3.

Example 2
Input

1
2
1 2
Output

0
Explanation

We have A = [1 2]

The length of the array is 2, which means that there can be no subarray of length 3 or more.

Thus the number of Accio subarrays is 0.

Constraints
1 <= T <= 100

1 <= N <= 3000

0 <= A[i] <= 5000



}


SOLUTION :-

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            int ans = Solution.accioSubarrays(arr, n);
            System.out.println(ans);
        }
    }
}
class Solution 
{
    static int accioSubarrays(int[] arr, int n) 
    {
        //Write code here
		 int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int diff = arr[i + 1] - arr[i];
            for (int j = i + 2; j < n; j++) {
                if (arr[j] - arr[j - 1] == diff) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
