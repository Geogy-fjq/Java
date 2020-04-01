package Experiment2;

public class Service {//边类
	City from_city;//起始城市
	private int total_fee;//作为权值
	private int total_distance;

	public Service(City from_city,int total_fee,int total_distance) {
		this.from_city=from_city;
		this.total_fee=total_fee;
		this.total_distance=total_distance;
	}
	public City getFrom_City() {
		return from_city;
	}
	public int getTotal_fee() {
		return total_fee;
	} 
	public int getTotal_distance() {
		return total_distance;
	} 
}
