package Practice;

public class P105_2 {
    public static void main(String[] args) {
    	String s1=new String("Li+10");
    	String s2=new String("Ha+10");
    	String s3=new String("li+10");
    	//比较s1、s2姓名
    	{
    	String S1=s1.substring(0,1);
    	String S2=s2.substring(0,1);
    	if(S1.equalsIgnoreCase(S2)) {
            System.out.println("两个字符串相同");
    	}
    	else {
    	    System.out.println("两个字符串并不相同");
    	}
        }
        //比较s1、s3全部
        {
    	String S1=s1.substring(5);
    	String S3=s3.substring(5);
    	if(S1.equalsIgnoreCase(S3)) {
            System.out.println("两个字符串相同");
        }
        else {
            System.out.println("两个字符串并不相同");
        }
        }
    }
}
