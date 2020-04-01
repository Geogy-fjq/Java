package Experiment2;

public class Test {
	public static void main(String[] args) {
		PCBProcess process=new PCBProcess();
		process.add(new PCB("P1",2,3));
		process.add(new PCB("P2",3,4));
		process.add(new PCB("P3",1,5));
		process.add(new PCB("P4",2,1));
		process.add(new PCB("P5",4,2));
        System.out.println("CPUTIME:"+process.i++);
        process.printProcess();
        while(true) {
            if (process.run()) {
            	System.out.println("CPUTIME:"+process.i++);
            	process.printProcess();
                continue;
            }	
            System.out.println("CPUTIME:"+process.i++);
        	process.printProcess();
        	break;
        }
        process.printTime();
	}
}
