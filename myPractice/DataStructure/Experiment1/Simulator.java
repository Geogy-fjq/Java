package Experiment1;

import java.io.*;

public class Simulator {
	private int seconds_per_page;
	protected myQueue<Event> workload_queue;
    
	public int getSeconds_per_page(int i) {
		seconds_per_page=i;
		return seconds_per_page;
	}
	public void loadWorkLoad(String file){
		workload_queue=new myQueue<Event>();
		try {
			FileReader fr=new FileReader(file);
			BufferedReader bf=new BufferedReader(fr);
			String str;
			//按行读取字符串
			while ((str=bf.readLine())!=null) {
				String arr[]=str.split(" ");//划分字符串
				Job J=new Job(arr[2],Integer.parseInt(arr[1]));
				Event e=new Event(Integer.parseInt(arr[0]),J);
				workload_queue.insert(e);
			}
			bf.close();
			fr.close();
		} 
		catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
