package LanQiao;

import java.util.Scanner;

/*
 问题描述
求1+2+3+...+n的值。
输入格式
输入包括一个整数n。
输出格式
输出一行，包括一个整数，表示1+2+3+...+n的值。
样例输入
4
样例输出
10
样例输入
100
样例输出
5050
数据规模与约定
1 <= n <= 1,000,000,000。
 */
public class Main1_3Sum {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextInt();//考点
		long sum=0;
		long rem=n%2;
		long num=n/2;
		if(rem==0) {
			sum=(n+1)*num;
		}else {
			sum=(n+2)*num+1;
		}
		//sum=n*(n+1)/2//考点
		System.out.println(sum);
		sc.close();
	}
}
