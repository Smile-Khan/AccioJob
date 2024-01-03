public class Maximum Number of Vowels in a Substring of Given Length {
    



    You are given a string str. You have to find the maximum number of vowels in any substring of str with length k.

Input Format
The first line of input contains the string str.

The second line of input contains k.

Output Format
The only line of output contains a single integer representing the maximum number of vowels.

Example 1
Input

abciiidef
3
Output

3
Explanation: The substring iii is of length 3 containing 3 vowels.

Example 2
Input

aeiou
2
Output

2
Explanation: The substring ei is of length 2 containing 2 vowels.

Constraints:
1 <= str.length <= 105
1 <= k <= str.length
str consists of only lowercase english alphabets.


}

SOLUTION :-

import java.io.IOException;
import java.text.Format;
import java.util.Scanner;

class Solution {
    public int maxVowels(String str, int k) {
        int maxVowelsCount = 0;
        int currentVowelsCount = 0;
        
        // Initialize the count for the first substring of length k
        for (int i = 0; i < k; i++) {
            if (isVowel(str.charAt(i))) {
                currentVowelsCount++;
            }
        }
        
        maxVowelsCount = currentVowelsCount;
        
        // Slide the window through the string
        for (int i = k; i < str.length(); i++) {
            if (isVowel(str.charAt(i - k))) {
                // Remove the leftmost character from the previous substring
                currentVowelsCount--;
            }
            if (isVowel(str.charAt(i))) {
                // Add the current character to the new substring
                currentVowelsCount++;
            }
            
            // Update the maximum count
            maxVowelsCount = Math.max(maxVowelsCount, currentVowelsCount);
        }
        
        return maxVowelsCount;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        sc.close();
        Solution obj = new Solution();
        System.out.print(obj.maxVowels(str, k));
    }
}

