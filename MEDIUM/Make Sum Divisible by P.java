// You are given an array a consisting of n integers.

// Your task is to remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

// Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

// Note

// A subarray is defined as a contiguous block of elements in the array.

// Input Format
// The first line contains two integers, n and p.

// The second line contains n space separated integers.

// Output Format
// Return an integer denoting the length of the smallest subarray.

// Example 1
// Input

// 4 6
// 3 1 4 2
// Output

// 1
// Explanation

// The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
// Example 2
// Input

// 3 3
// 1 2 3
// Output

// 0
// Explanation

// Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
// Constraints
// 1 <= n <= 100000

// 1 <= p <= 10^9

// 1 <= a[i] <= 10^9


Solution

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,q;
        n=sc.nextInt();
        q=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.minSubarray(a,n,q));		    
    }
}

class Solution
{
  public int minSubarray(int[] A,int n, int p) {
      //Write code here

	  long prefixSum = 0;
        for (int num : A) {
            prefixSum += num;
        }

        long targetModulo = prefixSum % p;

        if (targetModulo == 0) {
            return 0; // If the sum is already divisible by p, no subarray needs to be removed.
        }

        Map<Long, Integer> moduloMap = new HashMap<>();
        moduloMap.put(0L, -1); // Initialize the map with a dummy entry.
        long currentPrefixSum = 0;
        int minLen = n; // Initialize to a large value.

        for (int i = 0; i < n; i++) {
            currentPrefixSum += A[i];
            long currentModulo = currentPrefixSum % p;

            long complementModulo = (currentModulo - targetModulo + p) % p;

            if (moduloMap.containsKey(complementModulo)) {
                int startIndex = moduloMap.get(complementModulo);
                minLen = Math.min(minLen, i - startIndex);
            }

            moduloMap.put(currentModulo, i);
        }

        return minLen == n ? -1 : minLen;
    }
}