package Practice;

import java.util.Arrays;

public class P126_1 {
    public static void main(String[] args) {
    	String arr1[]=new String[] {"1","2","3","4","5","6"};
    	String arr2[]=Arrays.copyOfRange(arr1,0,3);
    	System.out.print("arr1 is:");
    	for(int i=0;i<arr1.length;i++) {
    		System.out.print(""+arr1[i]+"  ");
    	}
    	System.out.println();
    	System.out.print("arr2 is:");
    	for(int j=0;j<arr2.length;j++) {
    		System.out.print(""+arr1[j]+"  ");
    	}
    }
}
