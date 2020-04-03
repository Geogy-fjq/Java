package GourmetCoffeeSystem3;

import GourmetCoffeeSystem1.OrderItem;
import GourmetCoffeeSystem2.Sales;
import GourmetCoffeeSystem2.Order;

public class HTMLSalesFormatter implements SalesFormatter{
    private static HTMLSalesFormatter singletonInstance;
    private HTMLSalesFormatter() {//私有的构造方法
    }
	public static HTMLSalesFormatter getSingletonInstance() {
    	if(singletonInstance==null) {
    		singletonInstance=new HTMLSalesFormatter();
    	}
    	return singletonInstance;
    }
    public String formatSales(Sales sales) {
    	String s="\n";
    	s=s+"<html>"+"\n"+"\t"+"<body>"+"\n";
    	for(Order order:sales) {
    		s=s+"\t"+"<center><h2>Orders</h2></center>"+"\n";
    		for(OrderItem orderItem:order) {
    			s=s+"\t"+"<hr>"+"\n"+"\t"+"<h4>Total="+order.getTotalCost()+"</h4>"+"\n";
    			s=s+"\t\t"+"<p>"+"\n";
    			s=s+"\t\t\t"+"<b>code:</b>"+" "+orderItem.getProduct().getCode()+"<br>"+"\n";
    			s=s+"\t\t\t"+"<b>quantity:</b>"+" "+orderItem.getQuantity()+"<br>"+"\n";
    			s=s+"\t\t\t"+"<b>price:</b>"+" "+orderItem.getProduct().getPrice()+"<br>"+"\n";
    			s=s+"\t\t"+"</p>"+"\n";
    		}	
    	}
    	s=s+"\t"+"</body>"+"\n"+"</html>";
    	return s;
    }
}

