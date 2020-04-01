package Experiment;

/*
 * Gray码问题
 * Gray码是一个长度为2n的序列，序列中无相同的元素，
 * 每个元素都是长度为n位的串，相邻元素恰好只有一位不同。
 * 用分治策略设计一个算法对任意的n构造相应的Gray码。
 * 由文件input.txt提供输入数据n。
 * 程序运行结束时，将得到的所有编码输出到文件output.txt中。
 */
public class Gray {

	public void gray(int n,int s,int arr[][]) {
		if(n<1) {//当n小于1时,停止递归
			return;
		}
		for(int i=0;i<s/2;i++) {
			arr[i][n-1]=0;
			arr[s-i-1][n-1]=1;
		}
		gray(n-1,s/2,arr);
		for(int j=s/2;j<s;j++) {
			for(int k=0;k<n-1;k++) {
				arr[j][k]=arr[s-j-1][k];
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
