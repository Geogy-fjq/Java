package LanQiao;

import java.util.Scanner;

/*
 问题描述
100 可以表示为带分数的形式：100 = 3 + 69258 / 714。
还可以表示为：100 = 82 + 3546 / 197。
注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
类似这样的带分数，100 有 11 种表示法。
输入格式
从标准输入读入一个正整数N (N<1000*1000)
输出格式
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！
样例输入1
100
样例输出1
11
样例输入2
105
样例输出2
6
 */
public class Main5_3Fraction {
	
	static int n,sum;

	//全排列(递归):依次将第一个数与后面的数交换
	private static void que(int[] list,int sta,int end) {
		if(sta==end) {
			spl(list);//将该全排列进行切片
		}else {
			for(int i=sta;i<=end;i++) {
				swap(list,sta,i);//交换第一个数和第i个数
				que(list,sta+1,end);//递归至这一条结果输出
				swap(list,i,sta);//回归上一层递归
			}
		}
	}
	
	private static void swap(int[] list,int sta,int end) {
		int temp=list[sta];
		list[sta]=list[end];
		list[end]=temp;
	}
	
	//切片
	private static void spl(int[] list) {
		int end=list.length;
		for(int i=1;i<end;i++) {
			for(int j=i+1;j<end;j++) {
				int a=toInt(list,0,i);
				int b=toInt(list,i,j);
				int c=toInt(list,j,end);
				if(b%c==0 && a+b/c==n) {
					sum++;
				}
			}
		}
	}
	
	private static int toInt(int[] list,int sta,int end) {
		int num=0;
		for(int i=sta;i<end;i++) {
			num=num*10+list[i];
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		sc.close();
		//全排列+切片
		int[] list={1,2,3,4,5,6,7,8,9};
		que(list,0,list.length-1);
		System.out.println(sum);
	}
}
