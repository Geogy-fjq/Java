package LanQiao;

import java.util.ArrayList;
import java.util.Scanner;

/*
 问题描述
　　小明对类似于 hello 这种单词非常感兴趣，这种单词可以正好分为四段，第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
　　给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。
　　元音字母包括 a, e, i, o, u，共五个，其他均为辅音字母。
输入格式
　　输入一行，包含一个单词，单词中只包含小写英文字母。
输出格式
　　输出答案，或者为yes，或者为no。
样例输入
lanqiao
样例输出
yes
样例输入
world
样例输出
no
 */
public class Main6 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		sc.close();
		char[] list=word.toCharArray();
		ArrayList<Character> yuan=new ArrayList<Character>();
		yuan.add('a');
		yuan.add('e');
		yuan.add('i');
		yuan.add('o');
		yuan.add('u');
		int temp=0;
		boolean bool=false;
		if(!yuan.contains(list[0])){//如果第一个字母是辅音
			temp++;
			bool=false;
		}
		for(int i=1;i<list.length;i++) {
			if(bool){//前面是元音
				if(!yuan.contains(list[i])){
					temp++;
					bool=false;
				}
			}
			else{//前面是辅音
				if(yuan.contains(list[i])){
					temp++;
					bool=true;
				}
			}
		} 
		if(temp==4){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}
}
