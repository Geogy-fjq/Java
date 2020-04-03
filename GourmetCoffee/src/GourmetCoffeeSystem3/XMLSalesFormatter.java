package GourmetCoffeeSystem3;

import GourmetCoffeeSystem1.OrderItem;
import GourmetCoffeeSystem2.Order;
import GourmetCoffeeSystem2.Sales;

public class XMLSalesFormatter implements SalesFormatter {
    private static XMLSalesFormatter singletonInstance;
    private XMLSalesFormatter() {//私有化构造函数
    }
    public static XMLSalesFormatter getSingletonInstance() {
    	if(singletonInstance==null) {
    		singletonInstance=new XMLSalesFormatter();
    	}
    	return singletonInstance;
    }
    public String formatSales(Sales sales) {
    	String s="\n";
    	s=s+"<Sales>"+"\n";
    	for(Order order:sales) {
    		s=s+"\t"+"<Order total="+"\""+order.getTotalCost()+"\""+">"+"\n";
    		for(OrderItem orderItem:order) {
    			s=s+"\t"+"<OrderItem quantity="+"\""+orderItem.getQuantity()+"\""+"\t"+"price="+"\""+orderItem.getProduct().getPrice()+"\"";
    			s=s+orderItem.getProduct().getCode()+"</OrderItem>"+"\n";
    		}
    		s=s+"\t"+"</Order>"+"\n";
    	}
    	s=s+"</Sales>";
    	return s;
    }
}
