package LanQiao;

import java.util.Scanner;

/*
 问题描述
　　小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
　　小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
　　这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。
　　请告诉小明，k 个月后空地上哪些地方有草。
输入格式
　　输入的第一行包含两个整数 n, m。
　　接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。
　　接下来包含一个整数 k。
输出格式
　　输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草。
样例输入
4 5
.g...
.....
..g..
.....
2
样例输出
gggg.
gggg.
ggggg
.ggg.
评测用例规模与约定
　　对于 30% 的评测用例，2 <= n, m <= 20。
　　对于 70% 的评测用例，2 <= n, m <= 100。
 */
public class Main8 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		char[] ch=new char[m];
		String[][] area=new String[n][m];
		for(int i=0;i<n;i++) {
			ch=sc.next().toCharArray();
			for(int j=0;j<m;j++) {
				area[i][j]=String.valueOf(ch[j]);
			}
		}
		int k=sc.nextInt();
		sc.close();
		//算法
		for(int p=1;p<=k;p++) {
			//新种的草标记为h
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(area[i][j].equals("g")){
						if(j-1>=0 && !area[i][j-1].equals("g")) {
							area[i][j-1]="h";
						}
						if(j+1<m && !area[i][j+1].equals("g")) {
							area[i][j+1]="h";
						}
						if(i-1>=0 && !area[i-1][j].equals("g")) {
							area[i-1][j]="h";
						}
						if(i+1<n && !area[i+1][j].equals("g")) {
							area[i+1][j]="h";
						}
					}
				}
			}
			//将有h的地方换成g
			for(int q=0;q<n;q++){
				for(int w=0;w<m;w++){
					if(area[q][w].equals("h")){
						area[q][w]="g";

					}
				}
			}
		}
		//打印输出
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(area[i][j]);
			}
			System.out.println();
		}
	}
}
