package GourmetCoffeeSystem1;

public class Product {
    private String code;//标识产品的唯一代码
    private String description;//对产品的简短描述
    private double price;//产品的价格
    
    public Product(String initialCode,String initialDescription,double initialPrice) {
    	this.code=initialCode;
    	this.description=initialDescription;
    	this.price=initialPrice;
    }
    public String getCode() {
    	return code;
    }
    public String getDescription() {
    	return description;
    }
    public double getPrice() {
    	return price;
    }
    public boolean equals(Object object) {
    	boolean flag=false;
    	if(object==this) {
    		flag=true;//判断对象是否相等	
    	}
    	if(!(object instanceof Product)) {
    		flag=false;//判断object是否属于Product类
    	}
    	else {
    		Product product=(Product)object;
    	    if(product.code.equals(this.code)){
    	    	flag=true;
    	    }
    	}
    	return flag;
    }
    public String toString() {
    	return code+"_"+description+"_"+price;
    }
}
