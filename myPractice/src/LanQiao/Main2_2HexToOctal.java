package LanQiao;

import java.util.HashMap;
import java.util.Scanner;
/*
 问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。
输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
输出格式
　　输出n行，每行为输入对应的八进制正整数。
　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。
样例输入
　　2
　　39
　　123ABC
样例输出
　　71
　　4435274
 */
public class Main2_2HexToOctal {
	
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println(hexToOctal(sc.next()));
        }
        sc.close();
    }

    //十六进制转换成二进制
    public static String hexToBinary(String hex) {
        char[] chs={'0','1'};
        String str=new String("0123456789ABCDEF");
        char[] charArray=hex.toUpperCase().toCharArray();//将字符串转换成大写并转换成数组
        int len=charArray.length*4;
        char[] binaryArray=new char[len];
        for(int i=charArray.length-1;i>=0;i--) {
            int index=str.indexOf(charArray[i]);//返回该字符在该字符串的索引
            for(int j=0;j<4;j++) {
                binaryArray[--len]=chs[index&1];//考点
                index=index>>>1;//考点
            }
        }
        return new String(binaryArray);
    }

    //二进制处理
    public static String binaryHandle(String bin) {
        String str=bin.substring(bin.indexOf('1'));//除去开头所有的0
        int len=str.length();
        if(len%3==0)
            return str;
        else if(len%3==1)
            return "00"+str;
        else
            return "0"+str;
    }

    //二进制转换成八进制
    public static String binaryToOctal(String bin) {
        HashMap<String,Character> map=new HashMap<String,Character>();
        map.put("000",'0');
        map.put("001",'1');
        map.put("010",'2');
        map.put("011",'3');
        map.put("100",'4');
        map.put("101",'5');
        map.put("110",'6');
        map.put("111",'7');
        int len=bin.length()/3;
        char[] octArray=new char[len];
        for(int i=bin.length();i>0;i-=3) {
            String s=bin.substring(i-3,i);//substring:[0,n)
            octArray[--len]=map.get(s);
        }
        return new String(octArray);
    }
    
    //十六进制转换成八进制
    public static String hexToOctal(String str) {
        String bin=hexToBinary(str);
        String bin1=binaryHandle(bin);
        return binaryToOctal(bin1);
    }
    
    /*//当输入不太大时可用
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] list=new String[n];
		for(int i=0;i<n;i++) {
			list[i]=sc.next();
			String a=list[i];
			a=Integer.toOctalString(Integer.valueOf(a,16));
			list[i]=a;
			System.out.println(list[i]);
		}
		
		sc.close();
	}*/
}