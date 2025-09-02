import java.util.*;

public class Task_B {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean isPalindrome = true;
			
        for (int i = 0; i < str.length() / 2; i++)
        {
        	int lastChar = str.length() - (i + 1);
			if(str.charAt(i) != str.charAt(lastChar))
			{
				isPalindrome = false;
				break;
			}
		}
        
        System.out.println(isPalindrome ? "Yes" : "No");
	}
}
