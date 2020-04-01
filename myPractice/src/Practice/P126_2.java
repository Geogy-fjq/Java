package Practice;

import java.util.Arrays;

public class P126_2 {
	public static void main(String[] args) {
		String arr[]=new String[] {" ","2","d",".","5","+","A"};
		Arrays.sort(arr);
		System.out.print("The all are:");
		for(int i=0;i<=6;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		System.out.println();
		System.out.print("The minimum is:["+arr[0]+"]");
	}
}
