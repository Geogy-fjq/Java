package Experiment1;

import java.util.LinkedList;

public class Storage {
    private final int Max=10;//设置最大仓库容量
    private LinkedList<Object> list=new LinkedList<Object>(); //仓库产品存于链表中
    //生产进程
    public void produce(int n,String threadName) {
    	synchronized (list) {//加锁
	    	//假如执行生产会使仓库容量爆满时，则无法进行生产
	        while(list.size()+n>=Max) {  
	            try {//生产阻塞
	            	System.out.println(threadName+"要生产:"+n+"个产品,当前产品库存:"+list.size()+"——仓库容量无法满足生产需要，无法进行生产!");
	            	list.wait(); 
	            }  
	            catch (InterruptedException e) {
	                e.printStackTrace();  
	            }  
	        }
	        //满足生产条件的情况下，生产n个产品  
	        for(int i=1;i<=n;i++) { 
	        	Object obj=new Object();
	            list.add(obj);  
	        }  
	        System.out.println(threadName+"生产了:"+n+"个产品,当前产品库存:"+list.size());
	        list.notifyAll();//唤醒所有等待线程
	        //每次生产完后随机休眠0——0.1s
	        try {
	        	Thread.sleep((int)(400-Math.random()*300));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	}
    }
    //消费进程
    public void consume(int n,String threadName){  
    	synchronized (list) {//加锁
			//若产品存量不足，无法进行消费  
		    while(list.size()<n) {  
		        try {//消费阻塞 
		        	System.out.println(threadName+"要消费:"+n+"个产品,当前产品库存:"+list.size()+"——库存不足,无法进行消费!");
		        	list.wait();  
		        }  
		        catch (InterruptedException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		    //满足消费条件的情况下，消费n个产品  
		    for(int i=1;i<=n;i++) {  
		        list.remove();  
		    }  
		    System.out.println(threadName+"消费了:"+n+"个产品,当前产品库存:"+list.size());
		    list.notifyAll();//唤醒所有等待线程
		    //每次消费完后随机休眠0——0.1s
		    try {
		        Thread.sleep((int)(400-Math.random()*300));
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    } 
    	}
    }  
}
