package Experiment1;

public class Job {
	private String user;
	private int number_of_pages;
	//定义构造方法
	public Job(String user,int number_of_pages) {
		this.user=user;
		this.number_of_pages=number_of_pages;
	}
	public String getUser() {
		return user;
	}
	public int getNumber_of_pages() {
		return number_of_pages;
	}
}
