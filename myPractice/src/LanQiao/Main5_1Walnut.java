package LanQiao;

import java.util.Scanner;

/*
 问题描述
小张是软件项目经理，他带领3个开发组，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：
1. 各组的核桃数量必须相同
2. 各组内必须能平分核桃（当然是不能打碎的）
3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）
输入格式
输入包含三个正整数a, b, c，表示每个组正在加班的人数，用空格分开（a,b,c<30）
输出格式
输出一个正整数，表示每袋核桃的数量。
样例输入1
2 4 5
样例输出1
20
样例输入2
3 1 1
样例输出2
3
 */
public class Main5_1Walnut {
	
	//求最大公约数（辗转相除法）
	public static int gcd(int a,int b) {
		int k=a%b;
		while(k!=0) {
			a=b;
			b=k;
			k=a%b;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int n=a*b/gcd(a,b);//最小公倍数=两数乘积/最大公约数
		n=c*n/gcd(c,n);
		System.out.println(n);
		sc.close();
	}
}
