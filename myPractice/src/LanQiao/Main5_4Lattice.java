package LanQiao;

import java.util.Scanner;

/*
 问题描述
如下图所示，3 x 3 的格子中填写了一些整数。
+--*--+--+
|10* 1|52|
+--****--+
|20|30* 1|
*******--+
| 1| 2| 3|
+--+--+--+
我们沿着图中的星号线剪开，得到两个部分，每个部分的数字和都是60。
本题的要求就是请你编程判定：对给定的m x n 的格子中的整数，是否可以分割为两个部分，使得这两个区域的数字和相等。
如果存在多种解答，请输出包含左上角格子的那个区域包含的格子的最小数目。
如果无法分割，则输出 0。
输入格式
程序先读入两个整数 m n 用空格分割 (m,n<10)。
表示表格的宽度和高度。
接下来是n行，每行m个正整数，用空格分开。每个整数不大于10000。
输出格式
输出一个整数，表示在所有解中，包含左上角的分割区可能包含的最小的格子数目。
样例输入1
3 3
10 1 52
20 30 1
1 2 3
样例输出1
3
样例输入2
4 3
1 1 1 1
1 30 80 2
1 1 1 100
样例输出2
10
 */
public class Main5_4Lattice {
	static int[][] arr;
	static boolean[][] visited;
	static int row,col,half;
	static int minStep=(int)Double.POSITIVE_INFINITY;
	static int[][] all={{0,1},{0,-1},{1,0},{-1,0}};
	
	private static void dfs(int x,int y,int count,int step) {
		if(count==half) {//如果已访问的数的和达到总数的一半，则更新最小格子数
			minStep=step<minStep?step:minStep;

		}
		if(x>=0 && x<row && y>=0 && y<col && visited[x][y]==false) {//如果该格子在矩阵内且该格子未访问
			count+=arr[x][y];
			visited[x][y]=true;
			step++;
			for(int i=0;i<4;i++) {
				dfs(x+all[i][0],y+all[i][1],count,step);
			}
			visited[x][y]=false;
		}
	}

	public static void main(String[] args) {
		//获取输入的数据
		Scanner sc=new Scanner(System.in);
		col=sc.nextInt();
		row=sc.nextInt();
		arr=new int[row][col]; 
		visited=new boolean[row][col];
		int sum=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
				sum+=arr[i][j];
			}
		}
		sc.close();
		//处理数据
		if(row==0 || col==0 || (row==1 && col==1) ||sum%2!=0) {
			System.out.println(0);
			
		}else {
			half=sum/2;
			dfs(0,0,0,0);
			System.out.println(minStep);
		}
		
	}
}
