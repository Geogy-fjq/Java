package LanQiao;

import java.util.Scanner;

/*
 问题描述
给定圆的半径r，求圆的面积。
输入格式
输入包含一个整数r，表示圆的半径。
输出格式
输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
样例输入
4
样例输出
50.2654825
数据规模与约定
1 <= r <= 10000。
 */

public class Main1_2Circular {
	
	public static final double PI=Math.PI;//考点
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		double area=r*r*PI;
		System.out.print(String.format("%.7f",area));//考点
		sc.close();
	}
}
