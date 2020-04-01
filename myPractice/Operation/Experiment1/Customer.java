package Experiment1;

public class Customer implements Runnable {
    int n;
    String threadName;
    Storage storage;
    //构造方法
    public Customer(int n,String threadName,Storage storage){
    	this.n=n;
    	this.threadName=threadName;
        this.storage=storage;
    }
    @Override
    public void run(){
        storage.consume(n,threadName);
    }
}
