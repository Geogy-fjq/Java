package GourmetCoffeeSystem1;

public class OrderItem {
	public Product product;//对一个Product对象的引用
	public int quantity;//订购项目的数量
	
	public OrderItem(Product initialProduct,int initialQuantity){
		this.product=initialProduct;
		this.quantity=initialQuantity;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int newQuantity) {
		this.quantity=newQuantity;
	}
	public double getValue() {
		return product.getPrice()*quantity;
	}
	public String toString() {
    	return quantity+" "+product.getCode()+" "+product.getPrice();
    }
}
