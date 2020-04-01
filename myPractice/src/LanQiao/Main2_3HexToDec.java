package LanQiao;

import java.util.Scanner;

/*
 问题描述
　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
样例输入
FFFF
样例输出
65535
 */
public class Main2_3HexToDec {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String hex=sc.next();
		Long dec=Long.parseLong(hex,16);//考点
		System.out.println(dec);
		sc.close();
	}
	
}
