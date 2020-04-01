package LinkedList;

import SequenceList.SequenceList;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
    	  
    	System.out.println("测试开始！"); 
    	
    	//测试在指定位置后面插入元素
    	System.out.println("-----------------"); 
    	System.out.println("插入元素完毕：");
    	list.insertAppoint(1, 0);//测试使用头结点后插入元素
    	list.insertAppoint(7, 0);
    	list.insertAppoint(12, 1);//测试查找指定索引的结点
    	list.insertAppoint(66, 2);
    	list.insertAppoint(95,2);
    	list.print();
    	
    	//测试返回链表的元素个数
    	System.out.println("-----------------"); 	
    	int a=list.size();
    	System.out.println("链表的元素个数是：");
    	System.out.println(a);
    	
    	//测试查找指定索引的元素
    	System.out.println("-----------------"); 
    	int b=list.getData(2);
    	System.out.println("索引为2的元素值是：");
    	System.out.println(b);
    	
    	//测试修改指定索引的元素
    	System.out.println("-----------------"); 
    	list.set(2,73);
    	System.out.println("修改索引为2的元素为73完毕：");
    	list.print();
    	
    	//测试查找指定元素的索引
    	System.out.println("-----------------");
    	System.out.println("查找元素4的索引（当元素不存在时）：");
    	System.out.println(list.find(4));
    	System.out.println("元素12的索引是：");
    	System.out.println(list.find(12));
    	
    	//测试删除当前结点的元素
    	System.out.println("-----------------"); 	
    	list.first();//测试移动当前结点为第一个有效节点,从头开始删除
    	list.remove();
    	System.out.println("删除元素完毕：");
    	list.print();
    	
    	//测试清空链表
    	System.out.println("-----------------"); 
    	list.clear();
    	System.out.println("清空完毕的链表：");
    	list.print();
    		
    	//判断链表是否为空
    	System.out.println("-----------------"); 
    	System.out.println("判断链表是否为空：");
    	System.out.println(list.isEmpty());
    	
    	System.out.println("-----------------");
    	System.out.println("测试完毕！");
    	
    }
}
