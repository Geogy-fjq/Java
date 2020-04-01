package LanQiao;

import java.util.Scanner;

/*
问题描述
　　一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，例如1135是一个数位递增的数，而1024不是一个数位递增的数。
　　给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
输入格式
　　输入的第一行包含一个整数 n。
输出格式
　　输出一行包含一个整数，表示答案。
样例输入
30
样例输出
26
评测用例规模与约定
　　对于 40% 的评测用例，1 <= n <= 1000。
 */
public class Main5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int num=0;
		for(int i=1;i<=n;i++) {
			char[] list=Integer.toString(i).toCharArray();
			int now=list[0];
			for(int j=1;j<list.length;j++) {
				if(now<list[j]) {
					now=list[j];
				}
				else {
					break;
				}
			}
			if(now==list[list.length-1]) {
				num++;
			}
		}
		System.out.println(num);
		sc.close();
	}
}
