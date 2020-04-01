package LanQiao;

import java.util.Scanner;

/*
 问题描述
小明为某机构设计了一个十字型的徽标（并非红十字会啊），如下所示：
..$$$$$$$$$$$$$..
..$...........$..
$$$.$$$$$$$$$.$$$
$...$.......$...$
$.$$$.$$$$$.$$$.$
$.$...$...$...$.$
$.$.$$$.$.$$$.$.$
$.$.$...$...$.$.$
$.$.$.$$$$$.$.$.$
$.$.$...$...$.$.$
$.$.$$$.$.$$$.$.$
$.$...$...$...$.$
$.$$$.$$$$$.$$$.$
$...$.......$...$
$$$.$$$$$$$$$.$$$
..$...........$..
..$$$$$$$$$$$$$..
对方同时也需要在电脑dos窗口中以字符的形式输出该标志，并能任意控制层数。
输入格式
一个正整数 n (n<30) 表示要求打印图形的层数。
输出格式
对应包围层数的该标志。
样例输入
1
样例输出
..$$$$$..
..$...$..
$$$.$.$$$
$...$...$
$.$$$$$.$
$...$...$
$$$.$.$$$
..$...$..
..$$$$$..
样例输入
3
样例输出
..$$$$$$$$$$$$$..
..$...........$..
$$$.$$$$$$$$$.$$$
$...$.......$...$
$.$$$.$$$$$.$$$.$
$.$...$...$...$.$
$.$.$$$.$.$$$.$.$
$.$.$...$...$.$.$
$.$.$.$$$$$.$.$.$
$.$.$...$...$.$.$
$.$.$$$.$.$$$.$.$
$.$...$...$...$.$
$.$$$.$$$$$.$$$.$
$...$.......$...$
$$$.$$$$$$$$$.$$$
..$...........$..
..$$$$$$$$$$$$$..
提示
请仔细观察样例，尤其要注意句点的数量和输出位置。
 */
public class Main5_2Graph {

	public static void main(String[] args) {
		//获取输入的n
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		//建立矩阵
		int len=2*(2*n+2)+1;
		int[][] matrix=new int[len][len];
		//描绘十字部分
		for(int i=2*n;i<2*n+5;i++) {
			matrix[i][2*n+2]=1;
			matrix[2*n+2][i]=1;
		}
		//按正方形描绘边(但需要去掉四个角)
		for(int i=0;i<n*2-1;i=i+2) {
			for(int j=0+i;j<len-i;j++) {
				if(i-j!=0  && i-j!=-1 && i+j!=len-1 && i+j!=len-2) {//去掉四个角
					matrix[i][j]=1;
					matrix[len-1-i][j]=1;
					matrix[j][i]=1;
					matrix[j][len-1-i]=1;
				}
			}
		}
		//添加四个凹边角
		for(int i=2;i<=n*2;i=i+2) {
			//左上角
			matrix[i][i]=1;
			matrix[i][i-1]=1;
			matrix[i-1][i]=1;
			//右上角
			int t=len-1-i;
			matrix[i][t]=1;
			matrix[i][t+1]=1;
			matrix[i-1][t]=1;
			//左下角
			matrix[t][i]=1;
			matrix[t][i-1]=1;
			matrix[t+1][i]=1;
			//右下角
			matrix[t][t]=1;
			matrix[t][t+1]=1;
			matrix[t+1][t]=1;
		}
		//输出矩阵
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(matrix[i][j]==1) {
					System.out.print("$");
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
}
