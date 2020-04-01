package Experiment1;

import java.text.DecimalFormat;
import java.util.*;

import Experiment2.Service;

public class Fifo extends Simulator{
	myQueue<Event> arrives_queue=new myQueue<Event>();
	
	//在while循环内递增计数器来模拟时间的流逝
    public void fifo(String file) {
    	loadWorkLoad(file);//加载相应数据
    	System.out.println("FIFO Simulation");//打印标题
    	int conutTime=0;//模拟计时器
    	int printerTime=workload_queue.getFront().getArrival_time();//初始化打印机时间为负载队列中事件的首次到达时间
    	int latency=0;//延迟时间
    	int job_num=0;//打印总数
    	System.out.println();
    	
        while (!workload_queue.isEmpty()||!arrives_queue.isEmpty()) {
        	conutTime++;
        	//输出到达信息
        	while(true) {
        		if(!workload_queue.isEmpty()) {
            		Event e=workload_queue.getFront();
                    if(e.getArrival_time()==conutTime) {//当负载队列中事件的到达时间和计数器相等时
                        arrives_queue.insert(e);//将该事件添加到到达队列中
                        workload_queue.remove();//从负载队列中移除此事件
                        System.out.println("     Arriving: "+e.getJ().getNumber_of_pages()+" pages from "+e.getJ().getUser()+" at "+conutTime+" seconds");
                    }
            		else {
                		break;
                	}
                }
        		else {
            		break;
            	}
        	}
        	//输出打印信息
        	if(!arrives_queue.isEmpty()) {
        		if(printerTime<=conutTime) {//打印机有空闲
        			Event e=arrives_queue.getFront();
        			int Arrival=e.getArrival_time();//到达时间
        			latency+=printerTime-Arrival;//计算延迟时间=打印时间-到达时间
        			printerTime+=e.getJ().getNumber_of_pages()*getSeconds_per_page(2);//定义打印每页2分钟，并计算打印机时间=到达时间+页数*打印每页时间
        			arrives_queue.remove();
            		job_num++;
            		System.out.println("     Servicing: "+e.getJ().getNumber_of_pages()+" pages from "+e.getJ().getUser()+" at "+conutTime+" seconds");
            	}
            }
        }
        System.out.println();
        System.out.println("     Total jobs: "+job_num+" seconds");
        System.out.println("     Aggregate latency: "+latency+" seconds");
        DecimalFormat dec = new DecimalFormat("0.0000");//保留4位小数
        System.out.println("     Mean latency: "+dec.format((float)latency/job_num)+" seconds");
    }
    public static void main(String[] args) {
    	Fifo f=new Fifo();
    	f.fifo("D:\\实验(1)\\实验\\Experiment 1\\arbitrary.run");
    	System.out.println("-------------------------------------------------------");
    	f.fifo("D:\\实验(1)\\实验\\Experiment 1\\bigfirst.run");
    }
}
