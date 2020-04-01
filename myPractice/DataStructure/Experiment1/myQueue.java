package Experiment1;

public class myQueue<Event> {
	private static final int DEFAULT_CAPACITY=10;  
	private int front;//队头,
	private int rear;//队尾
	private Event[] elements;//采用数组存储
	
    public myQueue() {
    	elements=(Event[])new Object[DEFAULT_CAPACITY];
    	front=rear=0;
    }
    //清空队列
    public void clear(){
    	front=rear=0;
    }
    //判断队列是否为空
    public boolean isEmpty() {
    	return front==rear;
    }
    //判断队列是否为满
    public boolean isFull() {
    	return (rear+1)%elements.length==front;
    }
    //返回队列元素个数
    public int size() {
    	return (rear-front+elements.length)%elements.length;
    }
    //当队列长度不够用时，自动给队列增加长度
    public void ensureCapacity(int newSize) {
    	if(newSize<elements.length) {
    		return;
    	}
    	else {
    		Event oldElements[]=elements;
        	elements=(Event[]) new Object[newSize];
        	for(int i=0;i<elements.length;i++) {
        		elements[i]=oldElements[i];
    	    }
        	return;
    	}
    }
    //在队尾插入元素
    public boolean insert(Event e) {
    	if(isFull()) {
    		ensureCapacity(elements.length*2+1);
    	}
    	elements[rear]=e;//加入队尾
    	rear=(rear+1)%elements.length;//更改队尾位置
    	return true;
    }
    //删除队首元素
    public boolean remove() {
    	if(isEmpty()) {
    		throw new IndexOutOfBoundsException();
    	}
    	else {
    		elements[front]=null;//取出队首元素
    		front=(front+1)%elements.length;//更改队首位置
        	return true;
    	}
    }
    //获取队头数据
    public Event getFront(){
        return elements[front];
    }
}
