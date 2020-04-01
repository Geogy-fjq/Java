package Experiment2;

public class PCBProcess {
	private PCB head=new PCB();//队列的头节点
	PCB current=null;//当前节点
	public int i=0;
	
    //将PCB对象添加到队列中
    public void add(PCB process) {
        if (head.next==null) {
            head.next=process;
        } 
        else {
        	current=head;
            while(current.next!=null) {
                if(current.next.priority<process.priority) {
                    PCB p=current.next;
                    current.next=process;
                    process.next=p;
                    return;
                }
                current=current.next;
            }
            current.next=process;
        }
    }
    //当队列不为空，返回true，可继续执行
    public boolean run() {
        if(head.next!=null) {
        	current=head;
            while(current.next!=null) {
                if (current.next.time==0) {
                	current.next.state=3;
                    if (current.next.finish==-1) {
                    	current.next.finish=i;
                    }
                    current=current.next;
                    continue;
                }
                else {
                	break;
                }
            }
            if (current.next!=null) {
            	PCB p=current.next;
            	current.next=current.next.next;
                p.next=null;
                p.time--;//时间-1
                p.priority--;//优先级-1
                p.state=2;
                add(p);
            } 
            else {
                return false;
            }
        }
        return true;
    }
    //打印结果表
    public void printProcess() {
        if(head.next!=null) {
        	System.out.println("NAME   "+"NEEDTIME   "+"PRIORITY   "+"STATE   ");
        	current=head.next;
            while(current!=null) {
            	System.out.println(current.name+"     " +current.time+"          "+ current.priority+"          "+getState(current.state));
                if (current.state==2) {
                	current.state=0;
                }
                current=current.next;
            }
            System.out.println();
        }
    }
    //获取STATE的返回值
    private String getState(int s) {
        if(s==0) {
        	return "ready";
        }
        else if(s==1) {
        	return "waiting";
        }
        else if(s==2) {
        	return "working";
        }
        else if(s==3) {
        	return "finish";
        }
		return null;
    }
    //打印总时间表
    public void printTime() {
        if (head.next!=null) {
            System.out.println("NAME   RoundTime   WaitingTime");
            PCB node=head.next;
            while(node!=null) {
                System.out.println(node.name + "     " + node.getRoundTime() + "           " + (node.getRoundTime()-node.initial_time));
                node=node.next;
            }
        }
    }
}
