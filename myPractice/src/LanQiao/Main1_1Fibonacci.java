package LanQiao;

import java.util.Scanner;

/*
 问题描述
Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
输入格式
输入包含一个整数n。
输出格式
输出一行，包含一个整数，表示Fn除以10007的余数。
样例输入
10
样例输出
55
样例输入
22
样例输出
7704
数据规模与约定
1 <= n <= 1,000,000。
 */

public class Main1_1Fibonacci {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] f=new int[n+2];
		f[1]=1;
		f[2]=1;
		if(n>2){
			for(int i=3;i<=n;i++){
				f[i]=(f[i-1]+f[i-2])%10007;//考点
			}
		}
		System.out.print(f[n]);
		sc.close();
	}
}
