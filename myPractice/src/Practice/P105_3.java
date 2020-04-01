package Practice;

import java.util.Scanner;

public class P105_3 {
    public static void main(String[] args) {
    	String Text="[1]+\\d{10}";
    	System.out.println("Please enter your phone number:");
    	Scanner text=new Scanner(System.in);
    	String t=text.next();
    	if(t.matches(Text)) {
    		System.out.println("It's a right phone number.");
    	}
    	else {
    		System.out.println("It's a wrong phone number.");
    	}
    	text.close();
    }
}
