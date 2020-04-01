package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 问题描述
　　乔治拿来一组等长的木棒，将它们随机地裁断，使得每一节木棒的长度都不超过50个长度单位。
        然后他又想把这些木棒恢复到为裁截前的状态，但忘记了木棒的初始长度。
        请你设计一个程序，帮助乔治计算木棒的可能最小长度。每一节木棒的长度都用大于零的整数表示。
 输入格式
　　输入多组数据，每组包括两行。
       第一行是一个不超过64的整数，表示裁截之后共有多少节木棒。
       第二行是经过裁截后，所得到的各节木棒的长度。
       在最后一组之后，是零。
输出格式
　　对每组数据，输出木棒的可能最小长度，每组占一行。
样例输入
9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
样例输出
6
5
 */
public class Main3_1Sticks {//代码不正确 ！！！
	
	//处理数据
	public static void calculate(int[] stick,int sum) {
		boolean[] used=new boolean[stick.length];
		int now=stick[stick.length-1];
		//算法主体
		for(int i=now;i<=sum;i++) {//按升序列举原始木棒的可能长度
			if(sum%i==0) {
				if(is_true(stick,used,used.length,i,sum-i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	//验证是否能够成功拼接
	public static boolean is_true(int[] stick,boolean[] used,int unused_num,int res_len,int len) {
		if(res_len==0 && unused_num==0) {
			return true;
		}
		if(res_len==0) {
			res_len=len;
		}
		for(int i=stick.length-1;i>=0;i--) {//从大到小寻找可用的木棍  
	        if(used[i]==false && stick[i]<=res_len){
	        	used[i]=true; 
		        if(is_true(stick,used,unused_num-1,res_len-stick[i],len)) {  
		            return true;
		        }
		        used[i]=false;
		        if(stick[i]==res_len || res_len==len) {//如果尝试的是木棍的第一位置或者最后位置
		            break;
		        }
	        }
	    }  
	    return false;
	}
	
	public static void main(String[] args) {
		//读取输入数据
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=0) {
			int sum=0;
			int[] stick=new int[n];
			for(int i=0;i<n;i++) {
				int temp=sc.nextInt();
				sum+=temp;
				stick[i]=temp;
			}
			Arrays.sort(stick);
			calculate(stick,sum);//调用计算的方法
			n=sc.nextInt();
		}
		sc.close();
	}
}
