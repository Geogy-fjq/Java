package LanQiao;

/*
 问题描述
　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class Main2_6Palindrome {
	
	public static void main(String[] args) {
		for(int i=10;i<=99;i++){
			char x=Integer.toString(i).charAt(0);
			char y=Integer.toString(i).charAt(1);
			System.out.println(""+i+y+x);
		}
	}
}
