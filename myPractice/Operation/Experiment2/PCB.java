package Experiment2;

public class PCB {
	public String name;
	public int time,initial_time,priority,state;
	public int arrival=0;
	public int finish=-1;
    PCB next;//指向下一个节点
    
    //构造函数
    PCB() {
    	name=null;
    	time=0;
    	initial_time=0;
    	priority=0;
    	state=0;
    }
    PCB(String name,int priority,int time) {
        this.name=name;
        this.priority=priority;
        this.time=time;
        this.initial_time=time;
        state=0;
    }
    int getRoundTime() {
        return finish-arrival-2;
    }
}
