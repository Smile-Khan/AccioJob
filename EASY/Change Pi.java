QUESTION :- Change Pi {
    

    Given a string, compute recursively (no loops) a new string where all appearances of pi have been replaced by 3.14.

Example:changePi("xpix") → "x3.14x"

changePi("pipi") → "3.143.14"

changePi("pip") → "3.14p"

Input Format
First line contains str representing the input string.

Output Format
Print the new string where all occurrences of pi have been replaced by 3.14.

Example 1
Input

xpix
Output

x3.14x
Explanation

pi is replaced with 3.14
Example 2
Input

pipi
Output

3.143.14
Constraints
1 <= str.size() <= 10^3


}

SOLUTION :-

import java.util.Scanner;
class Solution {

public static String changePi(String str) {
    // Your code here

    if(str.length() < 2)
    {
        return str;
    }

    if(str.startsWith("pi"))
    {
        return "3.14" + changePi(str.substring(2));
    }
    else 
    {
        return str.charAt(0) + changePi(str.substring(1));
    }
}
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(Solution.changePi(str));
    }
}
