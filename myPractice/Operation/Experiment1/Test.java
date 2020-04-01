package Experiment1;

public class Test {
	public static void main(String[] args) {
		Storage storage=new Storage();
        Producer p1=new Producer(5,"生产者1号",storage);
        Producer p2=new Producer(6,"生产者2号",storage);
        Producer p3=new Producer(9,"生产者3号",storage);
        Customer c1=new Customer(6,"消费者1号",storage);
        Customer c2=new Customer(5,"消费者2号",storage);
        Customer c3=new Customer(2,"消费者3号",storage);
        //定义5个线程
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p2);
        Thread t3=new Thread(p3);
        Thread t4=new Thread(c1);
        Thread t5=new Thread(c2);
        Thread t6=new Thread(c3);
        //假设生产者3号的生产积极性高,把他的线程优先级调高
        t3.setPriority(10);
        //启动线程
        t1.start();
        t2.start();  
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
