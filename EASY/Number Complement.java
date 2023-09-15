// 

Solution

import java.util.Scanner;

class Solution{
public static int findComplement(int num){
	//Write your code here
	if(num == 0)
	{
		return 1;
	}
	int mask = 1;
	while(mask < num)
		{
			mask = (mask << 1) | 1;
		}
	return num ^ mask;
    }
}
public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	System.out.println(Solution.findComplement(num));
	sc.close();
    }
}