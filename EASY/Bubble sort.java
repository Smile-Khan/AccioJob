QUESTION :-  Bubble sort {
    

    Given is an unsorted array of size n. Use the Bubble Sort algorithm to sort the given unsorted array.

Input Format
First line contains n, size of the array.

Second line contains n space separated unsorted array elements.

Output Format
Line containing n space separated sorted elements.

Example 1
Input

3
1 7 5
Output

1 5 7
Explanation

Bubble sort would move 7 at the end to give 1 5 7 as the sorted array.

Example 2
Input

5
4 1 3 9 7
Output

1 3 4 7 9
Explanation

The elements 4 and 9 are appropriately swapped to their position.

Constraints
1 <= n <= 10^3

1 <= arr[i] <= 10^3
}


SOLUTION :-

import java.util.Scanner;

class Accio {
    
    static void bubbleSort(int n, int arr[]){
            // write your code here
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Accio Obj = new Accio();
        Obj.bubbleSort(n, arr1);
    }
}
