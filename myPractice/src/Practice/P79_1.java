//实现判断变量x是奇数还是偶数。
package Practice;

import java.util.Scanner;

public class P79_1 {
    public static void main(String[] args) {
    	System.out.println("Please enter your integer:");
    	Scanner a=new Scanner(System.in);
    	int x=a.nextInt();
    	if(x%2==0) {
    		System.out.println("It is an even number.");
    	}
    	else {
    		System.out.println("It is an odd number. ");
    	}
    	a.close();
    }
}
