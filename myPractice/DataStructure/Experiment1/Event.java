package Experiment1;

public class Event {
	private int arrival_time;
	private Job J;
	
	//定义构造方法
	public Event(int arrival_time,Job J) {
		this.arrival_time=arrival_time;
		this.J=J;
	}
	public int getArrival_time() {
		return arrival_time;
	}
	public Job getJ() {
		return J;
	}
}
