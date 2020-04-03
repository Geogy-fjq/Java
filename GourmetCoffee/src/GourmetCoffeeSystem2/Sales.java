package GourmetCoffeeSystem2;

import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Order> {
    public ArrayList<Order> orders;//包含对类Order的实例引用的数组列表集合
    
    public Sales() {
    	orders=new ArrayList<Order>();
    }
    public void addOrder(Order order) {
    	orders.add(order);
    }
    public Iterator<Order> iterator(){
    	return orders.iterator();
    }
    public int getNumberOfOrders() {
    	return orders.size();
    }
}
