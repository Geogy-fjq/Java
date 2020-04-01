package Work;

import java.util.concurrent.Semaphore;//导入Semaphore，用于控制进程同步互斥的量

public class BarberShop {
	private static int customer=0;//顾客
	private static int chair=5;//假设有5张可用于顾客理发的椅子
	private static int busy=0;
	private static Semaphore mutex=new Semaphore(1);//临界区互斥访问信号量（互斥锁）
	
	public static void main(String args[]) throws InterruptedException{
		BarberShop bar=new BarberShop();
		for(int i=1;i<=10;i++) {//假设有10个顾客光顾
			new Thread(bar.new Barber(bar,i)).start();
			Thread.sleep((int)(400-Math.random()*300));//使当前线程休眠随机0——0.1s
		}
	}
	public synchronized boolean isEmpty() {
		if(customer==0) {
			return true;
		}
		return false;
	}
	public synchronized boolean isFull() {
		if(customer==chair) {
			return true;
		}
		return false;
	}
	public synchronized boolean isBusy() {
		if(customer==1) {
			return true;
		}
		return false;
	}
	public void GoBar(int index) throws InterruptedException{
		System.out.println("顾客"+index+"来了");
		customer++;
		if(isFull()) {//判断椅子是否坐满了
			System.out.println("没有剩余的椅子可供顾客等待了，"+"顾客"+index+"离开了");
			customer--;
		}
		else {
			if(busy==1) {
				System.out.println("顾客"+index+"正在等待理发师");
			}
			mutex.acquire();//信号量减操作，防止其他进程再进入
			synchronized(this) {
				while(busy==1) {//有人正在理发，等待
					wait();
				}
			}
			if(customer==1) {
				System.out.println("理发店现在只有顾客"+index+"，理发师是清醒的");
			}
			busy=1;
			System.out.println("顾客"+index+"正在理发");
			Thread.sleep(1000);
			System.out.println("顾客"+index+"理完发离开了");
			customer--;
			mutex.release();//信号量加操作，允许其他进程进入
			synchronized(this) {
				busy=0;
				notify();//唤醒
			}
			if(customer==0) {
				System.out.println("没有顾客了，理发师开始睡觉");
			}
		}
	}
	private class Barber implements Runnable{
		BarberShop shop;
		private int index;
		
		public Barber(BarberShop shop,int index) {
			this.shop=shop;
			this.index=index;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				shop.GoBar(index);
			}
			catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
