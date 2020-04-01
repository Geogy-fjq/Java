package LanQiao;

import java.util.Scanner;

/*
 问题描述
　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
输入格式
　　输入一行，包含一个正整数n。
输出格式
　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
样例输入
52
样例输出
899998
989989
998899
数据规模和约定
　　1<=n<=54。
 */
public class Main2_5SpecialPalindrome {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//5位数
		for(int i=100;i<=999;i++) {
			int x=Integer.toString(i).charAt(0)-'0';//考点
			int y=Integer.toString(i).charAt(1)-'0';
			int z=Integer.toString(i).charAt(2)-'0';
			if((x+y)*2+z==n) {
				System.out.println(""+x+y+z+y+x);//考点	
			}
		}
		//6位数
		for(int i=100;i<=999;i++) {
			int x=Integer.toString(i).charAt(0)-'0';//考点
			int y=Integer.toString(i).charAt(1)-'0';
			int z=Integer.toString(i).charAt(2)-'0';
			if((x+y+z)*2==n) {
				System.out.println(""+x+y+z+z+y+x);	//考点
			}
		}
		sc.close();
	}
}
