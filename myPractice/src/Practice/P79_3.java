package Practice;

public class P79_3 {
	public static void main(String[] args) {
		double n=0;
		double d=1;
		double l=0;
		double s=0;
		while(n<20) {
			n++;
			d=d*n;
			l=1/d;
			s=s+l;	
        }
		System.out.print("The sum is:"+s);
	}
}
