package Experiment;

/*
 * 租用游艇问题
 * 长江上有n个游艇出租站1，2，…，n，游客可在这些出租站租用游艇，并在下游的任何一个出租站归还游艇。
 * 出租站i到出租站j之间的租金为r(i,j)。设计一个算法，编程计算出从出租站1到出租站n所需的最少租金。
 * 由文件input.txt提供输入数据，文件的第1行中有1个正整数n表示有n个游艇出租站，接下来的n-1行是r(i,j)。
 * 将计算出的从出租站1到出租站n所需的最少租金输出到文件output.txt中。
 */
public class HireYacht {
	public void hireYacht(int n,int k,int[][] rent) {
		if(k>=n) {//当k大于等于n时,停止递归
			return;}
		//弗洛伊德算法
		for(int j=2;j<n;j++) {
			for(int i=0;i<j-1;i++) {
				if(rent[i][j]>rent[i][k]+rent[k][j]) {
					rent[i][j]=rent[i][k]+rent[k][j];
				}
			}
		}
		hireYacht(n,k+1,rent); 
	}
}
