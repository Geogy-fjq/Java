package LanQiao;

import java.util.Scanner;

/*
 问题描述
　　小明想知道，满足以下条件的正整数序列的数量：
　　1. 第一项为 n；
　　2. 第二项不超过 n；
　　3. 从第三项开始，每一项小于前两项的差的绝对值。
　　请计算，对于给定的 n，有多少种满足条件的序列。
输入格式
　　输入一行包含一个整数 n。
输出格式
　　输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
样例输入
4
样例输出
7
样例说明
　　以下是满足条件的序列：
　　4 1
　　4 1 1
　　4 1 2
　　4 2
　　4 2 1
　　4 3
　　4 4
评测用例规模与约定
　　对于 20% 的评测用例，1 <= n <= 5；
　　对于 50% 的评测用例，1 <= n <= 10；
 */
public class Main9 {
	    static int n,out;
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        n = scan.nextInt();
	        out = 0;
	        int[] arr = new int[3];                //arr用于存放一直变化的长度为3的序列研究对象
	        arr[0] = n;
	        for(int i = 1; i <= n; i++) {
	            arr[1] = i;
	            f(arr[0], arr[1]);
	        }
	        System.out.println((out+n)%10000);        //加上的n是，序列长度为2的所有序列数量。
	        scan.close();
	        }
	    private static void f(int arr0, int arr1) {
	        // TODO Auto-generated method stub
	        for(int i = 1; i <= n; i++) {
	            if(i < cha(arr0,arr1)) {
	                int arr2= i;
	                f(arr1,arr2);
	                out++; 
	            }
	        }
	    }
	    private static int cha(int i, int j) {    //返回绝对值
	        // TODO Auto-generated method stub
	        if(i>j) return i-j;
	        else return j-i;
	    }
}
