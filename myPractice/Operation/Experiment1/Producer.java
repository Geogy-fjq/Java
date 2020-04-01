package Experiment1;

public class Producer implements Runnable {
	int n;
	String threadName;
	Storage storage;
    //构造方法
    public Producer(int n,String threadName,Storage storage) {
    	this.n=n;
    	this.threadName=threadName;
    	this.storage=storage;
    }
    //确保每次只有一个生产者进入该模块
    @Override
    public void run(){
		synchronized(Producer.class){
			storage.produce(n,threadName);
        }   
    }
}
