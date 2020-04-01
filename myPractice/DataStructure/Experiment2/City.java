package Experiment2;

import java.util.LinkedList;

public class City {//顶点类
	private String name;
	private City city;//目的地城市,用于追溯最短路径
	private LinkedList<Service> services;//顶点的所有邻接边(点)
	private int minFee;//顶点到源点的最少费用
	private int minDistance;//顶点到源点的最短距离
	
	//城市顶点初始化
	public City(String name) {
		this.name=name;
		services=new LinkedList<Service>();
		minFee=Integer.MAX_VALUE;
		minDistance=Integer.MAX_VALUE;
		city=null;
	}
	public City(String name,int minFee,int minDistance) {
		this.name=name;
		services=new LinkedList<Service>();
		this.minFee=minFee;
		this.minDistance=minDistance;
		city=null;
	}
	//城市顶点之间的大小比较
	public int compareTo(City c) {
        if(this.minFee>c.minFee) {
        	return 1;
        }    
        else if(this.minFee<c.minFee) {
        	return -1;
        }  
        return 0;
    }
	
	public String getName() {
		return name;
	}
	public LinkedList<Service> getServices() {
		return services;
	} 
	public City getCity() {
		return city;
	}
	public int getMinFee() {
		return minFee;
	} 
	public int getMinDistance() {
		return minDistance;
	} 
	
	public void setName(String name) {
		this.name=name;
	}
	public void setServices(LinkedList<Service> services) {
		this.services=services;
	} 
	public void setCity(City city) {
		this.city=city;
	}
	public void setMinFee(int minFee) {
		this.minFee=minFee;
	} 
	public void setMinDistance(int minDistance) {
		this.minDistance=minDistance;
	} 
}
	
