package Experiment3;

import java.util.Scanner;
import java.util.Random;

public class MemoryManagement {
	PageTable[] pagetable = new PageTable[7];//7页的作业
	Instruction[] instruction = new Instruction[12];
	int k = 0;//当要装入新页时，被淘汰的页在数组中的位置
	int[] pageinmemory = new int[4];//表示该作业已在主存的页面
	Random rand = new Random();
	
	public void input() {
		System.out.println("Intput the page table of the job:");
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<pagetable.length;i++) {
			PageTable pt = new PageTable();
			String[] str = scan.nextLine().split(" ");
			pt.setPagenumber(Integer.parseInt(str[0]));
			pt.setSign(Integer.parseInt(str[1]));
			pt.setMemorynumber(Integer.parseInt(str[2]));
			pt.setPosition(Integer.parseInt(str[3]));
			pagetable[i] = pt;
		}
		
		System.out.println("Input the logical address of the instructions:");
		for(int i=0;i<instruction.length;i++) {
			Instruction in = new Instruction();
			String[] s = scan.nextLine().split(" ");
			in.setOperand(s[0]);
			in.setPagenumber(Integer.parseInt(s[1]));
			in.setUnitnumber(Integer.parseInt(s[2]));
			instruction[i] = in;
		}
		scan.close();
	}
	//逻辑地址转换为绝对地址
	public void AddressSwap() {
		for(int j=0;j<pageinmemory.length;j++) {
			pageinmemory[j] = j;
		}
		for(int i=0;i<instruction.length;i++) {
			Instruction ins = instruction[i];
			String absoluteaddress = null;
			int ipn = ins.getPagenumber();//取指令中访问的页号
			for(PageTable e:pagetable) {
				if(e.getPagenumber() == ipn) {
					if(e.getSign()==1) {
						absoluteaddress = "<"+e.getMemorynumber()+","+ ins.getUnitnumber()+">";
						if(ins.getOperand().compareTo("存")==0) {
							e.setModify(1);
						}//如果是“存”指令，则置该页的修改标志为1
						System.out.println(absoluteaddress);//输出绝对地址
					}
					else {
						System.out.println("*"+e.getPagenumber());						
						FIFO(e.getPagenumber());//运用FIFO算法，模拟调出和装入页号的操作
					}
				}
			}
		}
		System.out.println("主存中现有页面号为：");
		for(int j=0;j<pageinmemory.length;j++) {
			System.out.print(pageinmemory[j]+" ");
		}		
	}
	
	//处理缺页中断
	public void FIFO(int pagenumber) {		
		int pn = pageinmemory[k];		
		pageinmemory[k] = pagenumber;
		k = (k+1)%pageinmemory.length;
		for(PageTable p:pagetable) {
			if(p.getPagenumber()==pagenumber) {
				p.setSign(1);
				p.setMemorynumber(rand.nextInt(10));
				if(p.getModify()==1) {
					System.out.println("调出的页号为："+pn);
				}
			}
			else if(p.getPagenumber()==pn) {
				p.setSign(0);
			}
		}		
		System.out.println("装入的页号为："+pagenumber);
	}
}
