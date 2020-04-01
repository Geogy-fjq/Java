package Practice;

public class P79_2 {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i+1;j--) 
				System.out.print(" ");
			for(int k=1;k<=2*i-1;k++) 
				System.out.print("*");
		    System.out.println();
		}
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i;j++) 
				System.out.print(" ");
			for(int k=7;k>=2*i-1;k--) 
				System.out.print("*");
		    System.out.println();
		}
	}

}
