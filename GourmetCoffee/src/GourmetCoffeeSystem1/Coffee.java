package GourmetCoffeeSystem1;

public class Coffee extends Product {
	private String origin;//咖啡的起源
	private String roast;//咖啡的烤制程度
	private String flavor;//咖啡的味道
	private String aroma;//咖啡的香气
	private String acidity;//咖啡的酸度
	private String body;//咖啡的口感
	
	public Coffee(String initialCode,String initialDescription,double initialPrice,String initialOrigin,String initialRoast,String initialFlavor,String initialAroma,String initialAcidity,String initialBody) {
		super(initialCode,initialDescription,initialPrice);
    	this.origin=initialOrigin;
    	this.roast=initialRoast;
    	this.flavor=initialFlavor;
    	this.aroma=initialAroma;
    	this.acidity=initialAcidity;
    	this.body=initialBody;
	}
	public String getOrigin() {
		return origin;
	}
	public String getRoast() {
		return roast;
	}
	public String getFlavor() {
		return flavor;
	}
	public String getAroma() {
		return aroma;
	}
	public String getAcidity() {
		return acidity;
	}
	public String getBody() {
		return body;
	}
	public String toString() {
		return getCode()+"_"+getDescription()+"_"+getPrice()+"_"+origin+"_"+roast+"_"+flavor+"_"+aroma+"_"+acidity+"_"+body;
	}
}
