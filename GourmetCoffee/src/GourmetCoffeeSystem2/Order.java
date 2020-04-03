package GourmetCoffeeSystem2;

import java.util.ArrayList;
import java.util.Iterator;
import GourmetCoffeeSystem1.OrderItem;
import GourmetCoffeeSystem1.Product;

public class Order implements Iterable<OrderItem>{
    public ArrayList<OrderItem> items;//包含对类Order的实例引用的数组列表集合
    
    public Order() {
    	items=new ArrayList<OrderItem>();
    }
    public void addItem(OrderItem orderItem) {
    	items.add(orderItem);
    }
    public void removeItem(OrderItem orderItem) {
    	Iterator<OrderItem> it=items.iterator();
    	while (it.hasNext()) {
    		OrderItem n=it.next();
    		if(n.equals(orderItem)) {
    			it.remove();
    		}
    	}
    }
    //重写迭代器方法
    @Override
    public Iterator<OrderItem> iterator(){
    	return items.iterator();
    }
    public OrderItem getItem(Product product) {
    	Iterator<OrderItem> it=items.iterator();
    	while(it.hasNext()) {
    		OrderItem n=it.next();
    		if(n.getProduct().equals(product)) {
    			return n;
    		}
    	}
    	return null;
    }
    public int getNumberOfItems() {
    	return items.size();
    }
    public double getTotalCost() {
    	double sum=0;
    	for(Iterator<OrderItem> it=items.iterator();it.hasNext();) {
    		OrderItem orderItem=it.next();
    		sum=sum+orderItem.getValue();
    	}
    	return sum;
    }
}
