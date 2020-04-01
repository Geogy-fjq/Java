package LanQiao;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
//		 //Scanner sc=new Scanner (System.in);
//		  int ans=0;
//		  int a,b,c,d;
//		  for(int i=1;i<=2019;i++) {
//			   a=i/1000;
//			   b=i%1000/100;
//			   c=i%100/10;
//			   d=i%10;
//			   if(a==9||b==9||c==9||d==9) {//题目要求了一个数值里面如果有多个9还是只算一个，所以用||
//			    ans++;
//			   }
//		  }
//		  System.out.println(ans);
		 
		 
		 
//		 int count=0;
//		A:	for (int i = 1; i <=2019; i++) {
//				int a=i;
//				while(a!=0){
//					int b = a%10;
//					if(b==9){
//						count++;
//						continue A;
//					}
//					a/=10;
//				}
//			}
//			System.out.println(count);
		 
		 
		 
//		 int count=0;
//			for (int i = 1; i <=1200000; i++) {
//				if(1200000%i==0){
//					count++;
//				}
//			}
//			System.out.println(count);
			
		 
		 
			int start=1;
			int sum=2019;
			while(sum>=0){
				sum-=start;
				start*=2;
			}
			System.out.println(start/2);
			System.out.println(sum);
	}
	
}