package SequenceList;

public class Test {
    public static void main(String[] args) {
    	SequenceList<Integer> list=new SequenceList<Integer>();
    	  
    	System.out.println("测试开始！"); 
    	
    	//测试添加元素
    	System.out.println("-----------------");  
    	System.out.println("添加元素完毕："); 	
    	list.add(8);//末尾追加元素
    	list.add(12);
    	list.add(19);
    	list.add(33);
    	list.add(78);
    	list.add(56);
    	list.add(34);
    	list.add(56);
    	list.add(3,24);//指定位置插入元素
    	list.add(90);
    	list.add(10,111);//测试当顺序表长度不够用时，自动给顺序表增加长度
    	list.add(11,45);
    	list.print();
    	
    	//测试返回顺序表的元素个数
    	System.out.println("-----------------"); 
    	int d=list.size();
    	System.out.println("顺序表的元素个数是：");
    	System.out.println(d);
    	
    	//测试删除指定位置的元素,并将容量缩减至实际所需值
    	System.out.println("-----------------"); 	
    	list.remove(11);
    	System.out.println("删除元素完毕：");
    	list.print();
    		
    	//测试查找指定元素的索引
    	System.out.println("-----------------"); 
    	int a=list.find(2);
    	System.out.println("查找元素的索引（当元素不存在时）：");
    	System.out.println(a);
    	int b=list.find(111);
    	System.out.println("元素111的索引是：");
    	System.out.println(b);
    	
    	//测试根据下标返回元素值
    	System.out.println("-----------------"); 
    	int c=list.get(10);
    	System.out.println("索引为10的元素值是：");
    	System.out.println(c);
    	
    	//测试修改指定下标的元素
    	System.out.println("-----------------"); 
    	list.set(10,100);
    	System.out.println("修改索引为10的元素为100完毕：");
    	list.print();
    	
    	//测试清空顺序表
    	System.out.println("-----------------"); 
    	list.clear();
    	System.out.println("清空完毕的顺序表：");
    	list.print();
    	boolean f=list.isEmpty();
    	
    	//判断顺序表是否为空
    	System.out.println("-----------------"); 
    	System.out.println("判断顺序表是否为空：");
    	System.out.println(f);
    	
    	System.out.println("-----------------");
    	System.out.println("测试完毕！");
    	
    }
}
