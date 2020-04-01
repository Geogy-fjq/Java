package SequenceList;

public class SequenceList<Integer> {
    private Integer[] elements;
    private int size;
    private static final int DefaultCapacity=10;     
    
    //创建默认容量为10的空表
    public SequenceList() {
		this(DefaultCapacity);
    }
    //构造容量为length的空表
    public SequenceList(int length) {
    	elements=(Integer[]) new Object[length];
    	size=0;
    } 
    
    //指定位置插入元素
    public void add(int index,Integer Element) {
    	if(index<0||index>=size) {
    		ensureCapacity(size*2+1);//容量不足自动增加容量
    	}
    	for(int i=size;i>index;i--) {
    		elements[i]=elements[i-1];
    	}
    	elements[index]=Element;
    	size++;
    }
    //末尾追加元素
    public boolean add(Integer Element) {
    	add(size,Element);
    	return true;
    }
    //删除指定位置的元素
    public boolean remove(int index) {
     	if(index<0||index>=size) {
   		    throw new ArrayIndexOutOfBoundsException();
     	}
   		for(int i=index;i<size-1;i++) {
   			elements[i]=elements[i+1];
   		}
   		size--;
   		trimToSize();//将容量缩减为实际所需值
   		return true;
    }
    //查找指定元素的索引
    public int find(Object obj) {
    	if(obj!=null) {
    		for(int i=0;i<size;i++) {
    			if(obj.equals(elements[i])) {
    				return i;
    			}
    		}
    	}
    	else {
    		for(int i=0;i<size;i++) {
    			if(elements[i]==null) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    //根据下标返回元素值
    public Integer get(int index) {
    	if(index<0||index>=size) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	return elements[index];
    }
    //修改指定下标的元素
    public Integer set(int index,Integer newElement) {
    	if(index<0||index>=size) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	Integer oldElement=elements[index];
    	elements[index]=newElement;
    	return oldElement;
    }
    
    //返回顺序表的元素个数
    public int size(){
    	return size;
    }
    //清空顺序表
    public void clear(){
    	size=0;
    }
    //判断顺序表是否为空，为空则返回true
    public boolean isEmpty() {
    	return size==0;
    }
    //当顺序表长度不够用时，自动给顺序表增加长度
    public void ensureCapacity(int newSize) {
    	if(newSize<size) {
    		return;
    	}
    	else {
    		Integer oldElements[]=elements;
        	elements=(Integer[]) new Object[newSize];
        	for(int i=0;i<size;i++) {
        		elements[i]=oldElements[i];
    	    }
        	return;
    	}
    }
    //缩减容量至实际所需值
    public void trimToSize() {
    	ensureCapacity(size);
    }
    //打印顺序表
    public void print() {
    	for(int i=0;i<size;i++) {
    		System.out.println(elements[i]);
    	}
    }
}
