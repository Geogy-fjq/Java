package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<Integer> {
	//双向链表的内部结点类
    private static class Node<Integer>{
    	public Integer data;
    	public Node<Integer> lLink;
    	public Node<Integer> rLink;
    	
    	public Node(){
    		this.data=null;
    		this.lLink=null;
    		this.rLink=null;
    	}
    	public Node(Integer data,Node<Integer> lLink,Node<Integer> rLink){
    		this.data=data;
    		this.lLink=lLink;
    		this.rLink=rLink;
    	}	
    }
    //定义链表的属性：大小、头结点、当前结点
    private int size;
    private Node<Integer> first;
    private Node<Integer> now;
    
    //初始化链表(双向循环链表)
    public DoublyLinkedList() {
    	size=0;
    	first=new Node();
    	first.lLink=first.rLink=first;
    }
    //清空链表
    public void clear(){
    	now=first.rLink;
    	while(now!=first) {
    		Node<Integer> p=now;
    		now=now.rLink;
    		now.lLink=p.lLink;
    		p.lLink.rLink=now;
    		size--;
    	}
    }
    //判断链表是否为空
    public boolean isEmpty() {
    	return size==0;
    }
    //返回链表的元素个数
    public int size() {
    	return size;
    }
    //查找指定元素的索引
    public int find(Integer data) {
    	int f=-1;
    	Node<Integer> p=first.rLink;
    	if(p==first) {
    		return f;
    	}
    	for(int i=1;i<=size;i++) {
    		if(p.data.equals(data)) {
    			f=i;
    		}
    		p=p.rLink;
    	}
    	return f;
    }
    //查找指定索引的元素
    public Integer getData(int index) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		Node<Integer> p=first.rLink;
    		for(int i=1;i<index;i++) {
    			p=p.rLink;
    		}
    		return p.data;
    	}
    }  
    //查找指定索引的节点
    public Node getNode(int index) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		Node<Integer> p=first.rLink;
    		for(int i=1;i<index;i++) {
    			p=p.rLink;
    		}
    		return p;
    	}
    }  
    //在头结点后插入元素
    public void insertFirst(Integer data) {
    	Node<Integer> now=new Node(data,first,first.rLink);
    	first.rLink=now;
    	now=now.rLink;
    	now.rLink.lLink=now;
    	size++;
    }
    //在指定位置后面插入元素
    public boolean insertAppoint(Integer data,int index) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		if(index==0) {
        		this.insertFirst(data);//使用头结点处插入元素
        	}
        	else {
        		Node<Integer> now=new Node(data,this.getNode(index),this.getNode(index).rLink);
        		this.getNode(index).rLink=now;
        		now=now.rLink;
        		now.rLink.lLink=now;
        		size++;
        	}
    		return true;
    	}
    }
    //修改指定索引的元素
    public boolean set(int index,Integer data) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		Node<Integer> p=first.rLink;
    		for(int i=1;i<index;i++) {
    			p=p.rLink;
    		}
    		now=p;
    		this.remove();
    		this.insertAppoint(data, index-1);
    		return true;
    	}
    }
    //删除当前结点的元素
    public boolean remove() {
    	if(now!=null) {
    		Node<Integer> p=now;//被删结点
    		now=now.rLink;
    		now.lLink=p.lLink;
    		p.lLink.rLink=now;
    		size--;
    	}
    	if(now==first) {
    		if(isEmpty()) {
    			now=null;
    		}
    		else {
    			now=now.rLink;
    		}
    	}
    	return true;
    }
    //移动当前结点至第一个有效结点
    public boolean first() {
    	if(!isEmpty()) {
    		now=first.rLink;
    		return true;
    	}
    	now=null;
    	return false;
    }
    //移动当前结点至下一个结点
    public boolean next() {
    	if(now.rLink==first) {
    		now=null;
    		return false;
    	}
    	now=now.rLink;
    	return true;
    	
    }
    //移动当前结点至前一个结点
    public boolean pro() {
    	if(now.lLink==first) {
    		now=null;
    		return false;
    	}
    	now=now.lLink;
    	return true;
	
    }
    //打印链表
    public void print() {
    	now=first.rLink;
    	while(now!=first) {
    		System.out.println(now.data);
    		now=now.rLink;
    	}
    }
    
}
