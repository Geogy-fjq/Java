package Experiment;

/*
 * 找零钱问题
 * 	设有n种不同面值的硬币，现要用这些面值的硬币来找钱，记可找出钱数j的最少硬币个数记为C(i,j)。
 * 若找不出钱数j时，记C(i,j)=∞。设计一个动态规划算法，计算出所有的C( n,j )。
 * 由文件input.txt提供输入数据，文件的第1行有1个正整数n，表示有n种硬币可选，接下来的一行是每种硬币的面值。
 * 由用户输入待找钱数j，程序运行结束时，将计算出的所需最少硬币个数输出到文件output.txt中。
 */
public class MakeChange {
	public void makeChange(int n,int money,int i,int[] val,int[] C) {
		if(i>money) {//当i>money结束递归
			return;
		}
		int min=i;
		int j=0;
		while(j<n && i>=val[j]) {//遍历每一种面值的硬币，看其是否能作为找零之一
			int temp=1;
			if(i-val[j]>=1) {
				temp=C[i-val[j]-1]+1;
			}
			if(temp<min) {
				min=temp;
			}
			j++;
		}
		C[i-1]=min;
		makeChange(n,money,i+1,val,C);
	}

}
