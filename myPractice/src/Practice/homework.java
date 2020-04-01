package Practice;

import java.util.Scanner;

/*
 * 正整数分解质因数
*定义一个正整数n,赋初值
*用一个for循环遍历一个从 k=2开始查找到k<=n/2的数
*如果 n%k==0的时候(即n可以被k整除)，输出k的值
*然后把n的值重新赋为 n=n/k
*把for循环重新执行，即再定义k=2
*/
public class homework {
    public static void main(String[]args) {
    	//定义正整数n，赋初值
    	System.out.println("请输入一个正整数：");
    	Scanner a=new Scanner(System.in);
    	int n=a.nextInt();
        //计算并输出结果
    	for(int k=2;k<=n/2;k++){
    		while(n!=k){
    		    if (n%k==0) {
    			    System.out.print(k+"*");
    		        n=n/k;
    		    }
    		else
    		    break;
    		}
    	}	
    	System.out.print(n);
    	a.close();
    }  	
}
    		    