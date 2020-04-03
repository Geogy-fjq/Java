package GourmetCoffeeSystem1;

public class CoffeeBrewer extends Product {
	public String model;//咖啡机的模型
	public String waterSupply;//水的供应(Pour-over or Automated)（倒或自动）
	public int numberOfCups;//咖啡机的容量
	
	public CoffeeBrewer(String initialCode,String initialDescription,double initialPrice,String initialModel,String initialWaterSupply,int i) {
		super(initialCode,initialDescription,initialPrice);
		this.model=initialModel;
		this.waterSupply=initialWaterSupply;
		this.numberOfCups=i;
	}
	public String getModel() {
		return model;
	}
	public String getWaterSupply() {
		return waterSupply;
	}
	public int getNumberOfCups() {
		return numberOfCups;
	}
	public String toString() {
		return getCode()+"_"+getDescription()+"_"+getPrice()+"_"+model+"_"+waterSupply+"_"+numberOfCups;
	}
}
