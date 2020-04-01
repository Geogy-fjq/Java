package Experiment;

import java.util.Scanner;

/*
 * 列主元Gauss消去法
 */
public class Gauss {
	private double[][] A;//系数矩阵A
	private double[] b;//右端项b
	private int n=0;//维数n
	private double[] ans;//计算出的方程组解
	private double[] ans1;//设定的方程组解
	
	/*
	 * 按列选主元素。若aik=0,则输出“no unique solution”;若i!=k,则换行。
	 */
	private void columnPivot(int k) {
		int i=k;
		double max=Math.abs(this.A[k][k]);
		double now;
		//按列选主元素,即找出最大绝对值
		for(int j=k+1;j<this.n;j++) {
			now=Math.abs(this.A[j][k]);
			if(now>max) {
				max=now;
				i=j;
			}
		}
		//若aik=0,输出“no unique solution”。
		if(max==0) {
			System.out.println("no unique solution");
			System.exit(0);
		}
		//换行
		for(int col=k;col<this.n;col++) {
			now=this.A[i][col];
			this.A[i][col]=this.A[k][col];
			this.A[k][col]=now;
		}
		now=this.b[i];
		this.b[i]=this.b[k];
		this.b[k]=now;
	}
	/*
	 * 消元计算
	 */
	public void elimination() {
		//n个方程消去n-1个未知数
		for(int i=0;i<this.n;i++) {
			this.columnPivot(i);//按列选主元素
			//相除
			double temp=this.A[i][i];
			if(temp!=0) {
				for(int j=i;j<this.n;j++) {
					this.A[i][j]/=temp;
				}
				this.b[i]/=temp;
			}
			//消元
			double temp1;
			for(int j=i+1;j<this.n;j++) {
				temp1=this.A[j][i];
				for(int k=i;k<this.n;k++) {
					this.A[j][k]-=this.A[i][k]*temp1;
				}
				this.b[j]-=this.b[i]*temp1;
			}
			int a=i+1;
			System.out.println("第"+a+"次消元后：");
			this.printMatrix();
			//若ann=0,则输出“no unique solution”。
			if(this.A[A.length-1][A.length-1]==0) {
				System.out.println("no unique solution");
				System.exit(0);
			}
		}
	}
	/*
	 * 回代求解
	 */
	public void back() {
		ans=new double[n];
		ans[n-1]=this.b[n - 1];
		for(int i=n-2;i>= 0;i--) {
			double sum=0;
			for(int j=i+1;j<this.n;j++) {
				sum+=this.A[i][j]*this.ans[j];
			}
			ans[i]=this.b[i]-sum;
		}
	}
	/*
	 * 输出增广矩阵
	 */
	public void printMatrix() {
		System.out.println("增广矩阵为：");
		for(int i= 0;i<this.n;i++) {
			for(int j=0;j<this.n;j++) {
				System.out.print(String.format("% 8.2f",this.A[i][j]));
			}
			System.out.println(String.format("% 8.2f",this.b[i]));
		}
	}
	/*
	 * 输出方程组解
	 */
	public void print() {
		System.out.println("方程组解为：");
		for(int i=0;i<this.n;i++) {
			String s=String.format("%.2f",this.ans[i]);
			int a=i+1;
			System.out.print("x"+a+"="+s+",");
		}
	}
	
	/*
	 * 根据该题题目，进行测试
	 * 适用于病态问题
	 */
	public void test1() {
		String str;
		Scanner sc=new Scanner(System.in);
		//获得输入的维数d
		System.out.println("请输入维数：");
		if(sc.hasNext()) {
            str=sc.next();
            n=Integer.parseInt(str); 
		}
		//输入各定解
		ans1=new double[n];
		for(int i=1;i<=n;i++) {
			System.out.println("请设定第"+i+"个解：");
			if(sc.hasNext()) {
	            str=sc.next();
				ans1[i-1]=Double.parseDouble(str);
			}
		}
		sc.close();
		//根据Hilbert阵，计算得到系数矩阵A
		A=new double[n][n];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				A[i-1][j-1]=1d/(double)(i+j-1);
			}
		}
		//计算得到右端项b
		b=new double[n];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				b[i-1]+=(double)A[i-1][j-1]*(double)ans1[j-1];
			}
		}
		//测试
		printMatrix();
		elimination();
		back();
		print();
	}
	/*
	 * 输入所需参数，进行测试
	 * 适用于自行输入系数矩阵、右端项的情况
	 */
	public void test() {
		String str;
		Scanner sc=new Scanner(System.in);
		
		//获得输入的维数d
		System.out.println("请输入维数：");
		if(sc.hasNext()) {
            str=sc.next();
            n=Integer.parseInt(str); 
		}
		//获得输入的系数矩阵A
		double k=0;
		A=new double[n][n];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.println("请输入系数矩阵中("+i+","+j+")的元素：");
				if(sc.hasNext()) {
		            str=sc.next();
					k=Double.parseDouble(str);
				}
				A[i-1][j-1]=k; 
			}
		}
		//获得右端项b
		double l=0;
		b=new double[n];
		for(int i=1;i<=n;i++) {
			System.out.println("请输入右端项第"+i+"个元素：");
			if(sc.hasNext()) {
	            str=sc.next();
				l=Double.parseDouble(str);
			}
			b[i-1]=l;
		}
		sc.close();
		//测试
		printMatrix();
		elimination();
		back();
		print();
	}
	public static void main(String[] args) {
		Gauss g=new Gauss();
		g.test1();
	}
}
