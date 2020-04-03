package GourmetCoffeeSystem2;

import java.util.ArrayList;
import java.util.Iterator;
import GourmetCoffeeSystem1.Product;

public class Catalog implements Iterable<Product> {
	public ArrayList<Product> products;//包含对类Product的实例引用的数组列表集合
    
    public Catalog() {
    	products=new ArrayList<Product>();
    }
    public void addProduct(Product product) {
    	products.add(product);
    }
    public Iterator<Product>iterator(){
    	return products.iterator();
    }
    public Product getProduct(String code) {
    	for(Iterator<Product> it=products.iterator();it.hasNext();) {
    		Product product=it.next();
    		if(product.getCode().equals(code)) {
    			return product;
    		}
    	}
    	return null;
    }
    public int getNumberOfProducts() {
    	return products.size();
    }
}
