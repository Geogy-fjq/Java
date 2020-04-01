package Experiment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 *N皇后问题
 *在n×n格的棋盘上放置彼此不受攻击的n个皇后。
 *按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * N皇后问题等价于在n×n格的棋盘上放置n个皇后，任何2个皇后不放在同一行或同一列或同一斜线上。 
 * 数据输入:N的具体值
 * 结果输出:程序运行结束时，将最优解输出到文件output.txt中。
 */
public class NQueens {
	int[] pos;//储存每个皇后的位置
	boolean[] flag;//表示第i列已经有皇后
	boolean[] right;//表示第i条右斜线已经有皇后
	boolean[] left;//表示第i条左斜线已经有皇后	
	int n;//皇后的个数
	int row;//记录当前是第几个皇后(第几行)
	int num=0;//用来记录解的个数
	
	/*
	 * 用回溯法求n皇后问题的解
	 * 将解输出到output.txt文件中
	 */
	public void nQueens(int row,String outputFile) {
		for(int col=1;col<=n;col++) {
			//若该位置与其它皇后不在同一列或同一斜线上，则可以放置该皇后
			if(flag[col-1]==false && right[row+col-2]==false && left[n+row-col-1]==false) {
				//将该皇后放置在该位置
				pos[row-1]=col;
				flag[col-1]=right[row+col-2]=left[n+row-col-1]=true;
				if(row==n) {//若该皇后为最后一个，将结果保存到文件中
					num++;
					try {
						FileWriter fw=new FileWriter(outputFile,true);
						BufferedWriter bw=new BufferedWriter(fw);
						String str=n+"皇后问题的第"+num+"个解是:";
						for(int i=1;i<=n;i++) {
							str+="("+i+","+pos[i-1]+")  ";
						}
						bw.write(str);
						bw.newLine();
						bw.close();
						fw.close();
					}
					catch (IOException exc) {
						exc.printStackTrace();
					}
				}else {//否则，递归查找下一个皇后可以放置的位置
					nQueens(row+1,outputFile);
				}
				//回溯
				flag[col-1]=right[row+col-2]=left[n+row-col-1]=false;
			}
		}
	}
	/*
	 * 获得输入的皇后数量n
	 * 构造所需数据结构
	 * 调用nQueens函数进行计算
	 */
	public void operate() {
		String outputFile="output4.txt";
		//获取输入的n
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入皇后的数量：");
		n=sc.nextInt();
		sc.close();
		//构造所需数据结构
		pos=new int[n];
		flag=new boolean[n];
		right=new boolean[2*n-1];
		left=new boolean[2*n-1];	
		row=1;
		//调用nQueens函数进行计算
		nQueens(row,outputFile);
	}
	public static void main(String[] args) {
		NQueens N=new NQueens();
		//调用operate函数
		N.operate();
	}
}
