// QUESTION :- 

// Given two integer arrays A and B of size N. There are N gas stations along a circular route, where the amount of gas at station i is A[i].

// You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

// Print the minimum starting gas station's index if you can travel around the circuit once, otherwise print -1.

// You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.

// Input Format
// The first line contains integer N . The second line contains N integers A[i]. The third line contains N integers B[i].

// Output Format
// Print the minimum starting gas station's index if you can travel around the circuit once, otherwise print -1.

// Example 1
// Input

// 2
// 1 2 
// 2 1
// Output

// 1

// Explanation

// If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1. If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.

// Constraints
// 1 <= N <= 100000

// 0 <= A[i], B[i] <= 10000

SOLUTION :-


import java.util.Scanner;

class Solution {
    public int canCompleteCircuit(int[] A, int[] B) {
        //Write code here

		int n = A.length;
        int totalGas = 0;
        int currentGas = 0;
        int startingStation = 0;
        
        for (int i = 0; i < n; i++) {
            int gasDiff = A[i] - B[i];
            totalGas += gasDiff;
            currentGas += gasDiff;
            
            // If we run out of gas at this station, reset and try the next station as the starting point.
            if (currentGas < 0) {
                currentGas = 0;
                startingStation = i + 1;
            }
        }
        
        // If the total gas is non-negative, it means we can complete the circuit starting from the startingStation.
        return (totalGas >= 0) ? startingStation : -1;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = input.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = input.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.canCompleteCircuit(A, B));
        input.close();
    }
}