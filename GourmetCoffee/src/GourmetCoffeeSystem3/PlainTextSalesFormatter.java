package GourmetCoffeeSystem3;

import GourmetCoffeeSystem1.OrderItem;
import GourmetCoffeeSystem2.Order;
import GourmetCoffeeSystem2.Sales;

public class PlainTextSalesFormatter implements SalesFormatter{
    private static PlainTextSalesFormatter singletonInstance;
    static public PlainTextSalesFormatter getSingletonInstance() {
    	if(singletonInstance==null) {
    		singletonInstance=new PlainTextSalesFormatter();
    	}
    	return singletonInstance;
    }
    private PlainTextSalesFormatter(){
    }
    public String formatSales(Sales sales) {
    	String s="\n";
    	int Number=1;
    	for(Order order:sales) {
    		s+="---------------------------------------"+"\n"+"Order"+Number+":"+"\n";
    		for(OrderItem orderItem:order) {
    			s=s+orderItem.getQuantity()+"\t"+orderItem.getProduct().getCode()+"\t"+orderItem.getProduct().getPrice()+"\n";
    		}
    		s=s+"Total="+order.getTotalCost()+"\n";
    		Number++;
    	}
    	return s;
    }
}
