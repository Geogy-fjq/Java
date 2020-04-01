package LanQiao;

/*
 问题描述
　　153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class Main2_7SpecialNumber {
	
	public static void main(String[] args) {
		for(int i=100;i<=999;i++) {
			int x=Integer.toString(i).charAt(0)-'0';
			int y=Integer.toString(i).charAt(1)-'0';
			int z=Integer.toString(i).charAt(2)-'0';
			if(x*x*x+y*y*y+z*z*z==i) {
				System.out.println(i);
			}
		}
	}
}
