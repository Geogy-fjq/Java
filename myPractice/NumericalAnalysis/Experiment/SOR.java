package Experiment;

import java.util.Scanner;

/*
 * SOR迭代法
 */
public class SOR {
	private double[][] A;//系数矩阵A
	private double[] b;//右端项b
	private int n=0;//维数n
	private double[] x0;//初始向量
	private double e=0;//精度
	private int N=0;//最大迭代次数
	private double w=0;//松弛因子
	private double[] ans1;//设定的方程组解

	/*
	 * SOR迭代法计算过程
	 */
	public void calculate(double[][] A,double[] b,int n,double[] x0,double e,int N,double w) {
		int m=0;
		for(int k=1;k<=N;k++) {
			m++;
			double t=0;
			double y=0;
			for(int i=1;i<=n;i++) {
				double z=0;
				for(int j=1;j<=n;j++) {
					z=z+A[i-1][j-1]*x0[j-1];
				}
				y=(b[i-1]-z)*w/A[i-1][i-1];
				for(int l=1;l<=n;l++) {
					if(Math.abs(y)>=Math.abs(t)){
						t=y;
					}
				}
				x0[i-1]=x0[i-1]+y;
			}
			if(m!=N) {
				if(Math.abs(t)<=e) {
					for(int i=1;i<=n;i++) {
						System.out.printf("%10.4f",x0[i-1]);
					}
					System.out.println("   现迭代次数："+k);
				}
			}else {
				for(int i=1;i<=n;i++) {
					System.out.printf("%10.4f",x0[i-1]);
				}
				System.out.println("   已达到最大迭代次数："+m);
			}
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
		//获得输入的初始向量
		x0=new double[n];
		double s=0;
		for(int i=1;i<=n;i++) {
			System.out.println("请输入初始向量第"+i+"个元素：");
			if(sc.hasNext()) {
	            str=sc.next();
				s=Double.parseDouble(str); 
			}
			x0[i-1]=s;
		}
		//获得输入的精度
		System.out.println("请输入精度：");
		if(sc.hasNext()) {
            str=sc.next();
			e=Double.parseDouble(str);
		}
		//获得输入的最大迭代次数
		System.out.println("请输入最大迭代次数：");
		if(sc.hasNext()) {
            str=sc.next();
			N=Integer.parseInt(str); 
		}
		//获得输入的松弛因子
		System.out.println("请输入松弛因子：");
		if(sc.hasNext()) {
            str=sc.next();
			w=Double.parseDouble(str); 
		}
		sc.close();
		//测试
		calculate(A,b,n,x0,e,N,w);
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
		//获得输入的初始向量
		x0=new double[n];
		double s=0;
		for(int i=1;i<=n;i++) {
			System.out.println("请输入初始向量第"+i+"个元素：");
			if(sc.hasNext()) {
	            str=sc.next();
				s=Double.parseDouble(str); 
			}
			x0[i-1]=s;
		}
		//获得输入的精度
		System.out.println("请输入精度：");
		if(sc.hasNext()) {
            str=sc.next();
			e=Double.parseDouble(str);
		}
		//获得输入的最大迭代次数
		System.out.println("请输入最大迭代次数：");
		if(sc.hasNext()) {
            str=sc.next();
			N=Integer.parseInt(str); 
		}
		//获得输入的松弛因子
		System.out.println("请输入松弛因子：");
		if(sc.hasNext()) {
            str=sc.next();
			w=Double.parseDouble(str); 
		}
		sc.close();
		//测试
		calculate(A,b,n,x0,e,N,w);
	}
	public static void main(String[]args){
		SOR s=new SOR();
		s.test1();
	}
}
