public class Character Count Function {
    
    Write a function that takes in a string and returns the count of each character in the string.

Example:
Input:

hello
Output

{
  ''e'': 1
  ''h'': 1
  ''l'': 2
  ''o'': 1
}
Topics
Loops
Java

}

SOLUTION :-

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> charCounts = new HashMap<>();

        // Iterate through each character in the string
        for (char c : input.toCharArray()) {
            // Update the count in the map
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        return charCounts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        //System.out.println("Enter a string: ");
        String input = sc.nextLine();  // Use nextLine() to read the whole line
        Map<Character, Integer> charCounts = countCharacters(input);

        // Print the character count map
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
           System.out.println("''" + entry.getKey() + "'': " + entry.getValue());
        }
    }
}

