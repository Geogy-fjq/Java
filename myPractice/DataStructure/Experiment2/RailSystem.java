package Experiment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class RailSystem {
	//读取文件信息
	public Graph load_services(String file) {
		Graph graph=new Graph();
		try {
			FileReader fr=new FileReader(file);
			BufferedReader bf=new BufferedReader(fr);
			String str1,str2;
			City startCity=null,endCity=null;
			int totalFee,totalDistance;
			Service service;
			String[] line1,line2;
			int min=1000000;
			//按行读取字符串
			if((str1=bf.readLine())!=null) {
				line1=str1.split(" ");//划分字符串
				startCity=new City(line1[0],min,min);
				min++;
				//当下一行不为空时(即非最后一行)
				while((str2=bf.readLine())!=null) {
					line2=str2.split(" ");//划分字符串
					if(line1[0].equals(line2[0])) {
						endCity=new City(line1[1]);
						totalFee=Integer.parseInt(line1[2]);
						totalDistance=Integer.parseInt(line1[3]);
						service=new Service(endCity,totalFee,totalDistance);
						startCity.getServices().add(service);
						str1=str2;
						line1=str1.split(" ");//划分字符串
					}
					else {
						endCity=new City(line1[1]);
						totalFee=Integer.parseInt(line1[2]);
						totalDistance=Integer.parseInt(line1[3]);
						service=new Service(endCity,totalFee,totalDistance);
						startCity.getServices().add(service);
						graph.add(startCity);//添加到邻接表中
						str1=str2;
						line1=str1.split(" ");//划分字符串
						startCity=new City(line1[0],min,min);
						min++;
					}	
				}
				//读取的最后一行
				min--;
				line1=str1.split(" ");//划分字符串
				City adjStartCity=new City(line1[0],min,min);
				City adjendCity=new City(line1[1]);
				totalFee=Integer.parseInt(line1[2]);
				totalDistance=Integer.parseInt(line1[3]);
				service=new Service(adjendCity,totalFee,totalDistance);
				adjStartCity.getServices().add(service);
				graph.add(adjStartCity);//添加到邻接表中
			}
			bf.close();
			fr.close();
		} 
		catch (IOException exc) {
			exc.printStackTrace();
		}
		return graph;
	}	
	//重置city对象的数据成员
	public Graph reset() {
		Graph g=load_services("D:\\实验(1)\\实验\\Experiment 2\\services.txt");
		return g;
	}
	//Dijkstra最短路径算法
	public Graph calc_route(Graph g,String c) {
		//初始化
		g.getCity(c).setMinFee(0);//源点到其自身的费用为0
		g.getCity(c).setMinDistance(0);//源点到其自身的距离为0
		AVLTree<City> tree=new AVLTree<City>();
        for(City v:g.values()) {
            tree.insert(v);
        }
        //计算各顶点的最少费用、路程
        while(!(tree.isEmpty())){
        	City v=tree.delete(tree.minNode().data);//删除费用最少的顶点
        	
        	if(v!=null) {
        		LinkedList<Service> services=g.getCity(v.getName()).getServices();//获取v的所有邻接边(点)
	            for(Service s:services) {//更新
	            	City adjCity=g.getCity(s.from_city.getName());
            		if(adjCity.getMinFee()>(s.getTotal_fee()+v.getMinFee())){
		            	tree.delete(g.getCity(adjCity.getName()));
		            	g.getCity(adjCity.getName()).setMinFee(s.getTotal_fee()+v.getMinFee());//更新费用
		            	g.getCity(adjCity.getName()).setMinDistance(s.getTotal_distance()+v.getMinDistance());//更新距离
		            	g.getCity(adjCity.getName()).setCity(v);//更新顶点
		            	tree.insert(g.getCity(adjCity.getName()));
            		}
	            }
	        }
        	else {
        		break;
        	}
        }
        return g;
	}
	//打印字符串
	public void recover_route(String c,String fc){
		//读取数据(初始化city对象的数据成员)
		Graph g=reset();
		//获取费用、路程、路径
		g=calc_route(g,c);//最短路径计算后得到的邻接表
		
		int total_fee=g.getCity(fc).getMinFee();//费用
		int total_distance=g.getCity(fc).getMinDistance();//路程
		//路径
		City fc2=g.getCity(fc);
		String path=null;
		if(fc2.getCity()!=null) {
			path=fc;
			fc2=fc2.getCity();
			while(fc2.getCity()!=null) {
				path=fc2.getName()+" to "+path;
				fc2=fc2.getCity();
			}
		} 
		path=c+" to "+path;
		//打印
		System.out.println("The Cheapest route from "+c+" to "+fc);
		System.out.println("cost "+total_fee+" euros and spans "+total_distance+" kilometers");
		System.out.println(path);
		System.out.println();
		System.out.println();
		System.out.println();
	}
	//测试
	public static void main(String[] args) {
		RailSystem r=new RailSystem();//实例化铁路系统类	
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter a start and destination city: <'quit' to exit>");
		String[] str;
		str=sc.nextLine().split(" ");
		boolean flag=(!(str[0].equals("quit")));
		while(flag) {
			//获取费用、路程、路径
			String c=str[0];
			String fc=str[1];
			r.recover_route(c,fc);
		    //下一次使用
			System.out.println("Enter a start and destination city: <'quit' to exit>");
			str=sc.nextLine().split(" ");
		}
		sc.close();
	}
	
	//邻接表
	public static class Graph {
		private ArrayList<City> list=new ArrayList<City>();
		//判断是否为空
		public boolean isEmpty() {
			return list.isEmpty();
		}
		//返回顶点的个数
		public int numberOfVertices() {
			return list.size();
		}
		//根据城市名查找该顶点
		public City getCity(String name) {
			for(int i=0;i<list.size();i++) {
				if((list.get(i).getName()).equals(name)) {
					return list.get(i);
				}
			}
			return null;
		}
		//查找指定顶点值在邻接表中的位置
		public int getPosition(City c) {
			for(int i=0;i<list.size();i++) {
				if((list.get(i)).equals(c)) {
					return i;
				}
			}
			return -1;
		}
		//根据位置查找顶点
		public City getValue(int i) {
			if(i>=0 && i<list.size()) {
				return list.get(i);
			}
			else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		//返回列表的所有顶点
		public City[] values() {
			City[] cityList=new City[list.size()];
			for(int i=0;i<list.size();i++) {
				cityList[i]=list.get(i);
			}
			return cityList;
		}
		//插入顶点
		public void add(City v) {
			list.add(v);
		}
		//删除顶点
		public void remove(City v) {
			list.remove(getPosition(v));
		}
	}
	
	
	//AVL树
	public static class AVLTree<City> {
		private AVLTreeNode<City> root;//AVL树的根 
		
		class AVLTreeNode<Type>{//定义AVL树的结点（内部类）
			City data;
			int height;//高度
			AVLTreeNode<City> leftChild,rightChild;//左孩子、右孩子
			
			public AVLTreeNode(City data) {
				this.data=data;
				height=0;
				leftChild=rightChild=null;
			}
		}
		//构造空的AVL
		public AVLTree() {
			root=null;
		}
		//清空AVL
		public void clear() {
			root=null;
		}
		//判断是否为空
		public boolean isEmpty() {
			return root==null;
		}
		//树的高度
		private int height(AVLTreeNode<City> Root) {
		    if(Root!= null) {
		    	return Root.height;
		    }
		    return 0;
		}
		public int height() {
		    return height(root);
		}
		//获取两个数中较大的数
		private int max(int a,int b) {
			int flag=-1;
			if(a>=b) {
				flag=a;
			}
			else if(a<b) {
				flag=b;
			}
			return flag;
		}
		//LL旋转
		private AVLTreeNode<City> LLRotation(AVLTreeNode<City> n2) {
		    AVLTreeNode<City> n1;
		    n1=n2.leftChild;
		    n2.leftChild=n1.rightChild;
		    n1.rightChild=n2;
		    n2.height=max(height(n2.leftChild),height(n2.rightChild))+1;
		    n1.height=max(height(n1.leftChild),height(n1.rightChild))+1;
		    return n1;
		}
		//RR旋转
		private AVLTreeNode<City> RRRotation(AVLTreeNode<City> n1) {
		    AVLTreeNode<City> n2;
		    n2=n1.rightChild;
		    n1.rightChild=n2.leftChild;
		    n2.leftChild=n1;
		    n1.height=max(height(n1.leftChild),height(n1.rightChild))+1;
		    n2.height=max(height(n2.leftChild),height(n2.rightChild))+1;
		    return n2;
		}
		//LR旋转
		private AVLTreeNode<City> LRRotation(AVLTreeNode<City> n3) {
		    n3.leftChild=RRRotation(n3.leftChild);
		    return LLRotation(n3);
		}
		//RL旋转
		private AVLTreeNode<City> RLRotation(AVLTreeNode<City> n3) {
		    n3.rightChild=LLRotation(n3.rightChild);
		    return RRRotation(n3);
		}
		//插入
		private AVLTreeNode<City> insert(City x,AVLTreeNode<City> node) {
		    if(node==null) {//空的AVL树，新建节点
		    	node=new AVLTreeNode<City>(x);
		    }
		    if(search(x)!=null) {
		    	delete(x);
		    }
	    	int result=((Experiment2.City) x).getMinFee()-((Experiment2.City) node.data).getMinFee();
		    if(result<0) {//插入到左子树
		    	node.leftChild=insert(x,node.leftChild);
		        if(height(node.leftChild)-height(node.rightChild)>=2) {//插入节点后，若AVL树失去平衡，则进行相应的调节
		        	if(((Experiment2.City) x).getMinFee()-((Experiment2.City) node.leftChild.data).getMinFee()<0) {
		        		node=LLRotation(node);
		        	}   
		            else {
		            	node=LRRotation(node);
		            }   
		        } 
		    }
		    else if(result>0) {//插入到右子树
		    	node.rightChild=insert(x,node.rightChild);
		        if(height(node.rightChild)-height(node.leftChild)>=2) {//插入节点后，若AVL树失去平衡，则进行相应的调节
		        	if(((Experiment2.City) x).getMinFee()-((Experiment2.City) node.rightChild.data).getMinFee()>0) {
		        		node=RRRotation(node);
		        	}      
		            else {
		            	node=RLRotation(node);
		            }
		        } 
		    }
		    node.height=max(height(node.leftChild),height(node.rightChild))+1;
		    return node;
		}
		public void insert(City x) {
		    root=insert(x,root);
		}
		
		//找出左子树的最大结点
		private AVLTreeNode<City> maximum(AVLTreeNode<City> node,AVLTreeNode<City> root){//传入参数为被删除节点的左孩子node
			if(node.rightChild==null){//node的右孩子为空，则node为最大结点
				return node;
			}
			else {
				node=node.rightChild;
				return maximum(node,root);
			}
		}
		public AVLTreeNode<City> maximum(AVLTreeNode<City> node){
			return maximum(node,root);
		}
		//找出右子树的最小结点
		private AVLTreeNode<City> minimum(AVLTreeNode<City> node,AVLTreeNode<City> root){//传入参数为被删除节点的右孩子node
			if(node.leftChild==null){//node的左孩子为空，则node为最小结点
				return node;
			}
			else {
				node=node.leftChild;
				return minimum(node,root);
			}
		}
		public AVLTreeNode<City> minimum(AVLTreeNode<City> node){
			return minimum(node,root);
		}
		//删除
		private AVLTreeNode<City> delete(AVLTreeNode<City> node,AVLTreeNode<City> Root) {
		    if(Root==null || node==null) {//根或要删除的结点为空，返回null
		    	return null;
		    }
		    int result=((Experiment2.City) node.data).getMinFee()-((Experiment2.City) Root.data).getMinFee();
	    	if(result<0) {//待删除的节点在左子树中
		    	Root.leftChild=delete(node,Root.leftChild);
		        if(height(Root.rightChild)-height(Root.leftChild)>=2) {//删除节点后，若AVL树失去平衡，则进行相应的调节
		            AVLTreeNode<City> r=Root.rightChild;
		            if (height(r.leftChild)>=height(r.rightChild)) {
		            	Root=RLRotation(Root);
		            }
		            else {
		            	Root=RRRotation(Root);
		            }
		        }
		    } 
		    else if(result>0) {//待删除的节点在右子树中
		    	Root.rightChild=delete(node,Root.rightChild);
		        if(height(Root.leftChild)-height(Root.rightChild)>=2) {//删除节点后，若AVL树失去平衡，则进行相应的调节
		            AVLTreeNode<City> l=Root.leftChild;
		            if(height(l.rightChild)>=height(l.leftChild)) {
		            	Root=LRRotation(Root);
		            }	
		            else {
		            	Root=LLRotation(Root);
		            }
		        }
		    } 
		    else {//Root是对应要删除的节点
		        if((Root.leftChild!=null) && (Root.rightChild!=null)) {//Root的左右孩子都非空
		            if (height(Root.leftChild)>height(Root.rightChild)) {//若Root的左子树比右子树高，则找出Root的左子树中的最大节点，将该最大节点的值赋值给Root，删除该最大节点。
		                AVLTreeNode<City> max=maximum(Root.leftChild);
		                Root.data=max.data;
		                Root.leftChild=delete(max,Root.leftChild);
		            } 
		            else {//若Root的左子树不比右子树高，则找出Root的右子树中的最小节点，将该最小节点的值赋值给Root，删除该最小节点。
		                AVLTreeNode<City> min=minimum(Root.rightChild);
		                Root.data=min.data;
		                Root.rightChild=delete(min,Root.rightChild);
		            }
		        } 
		        else {//Root的左右孩子存在为空
		        	if((Root.leftChild!=null)) {
		        		Root=Root.leftChild;
		        	}
		        	else if((Root.rightChild!=null)) {
		        		Root=Root.rightChild;
		        	}
		        	else {
		        		Root=null;
		        	}
		        }
		    }
		    if(Root!=null) {
		    	Root.height=max(height(Root.leftChild),height(Root.rightChild))+1;
		    }
		    return Root;
		}
		public City delete(City x) {
		    AVLTreeNode<City> a; 
		    if((a=search(x,root))!=null) {
		        root=delete(a,root);
		        return x;
		    }
		    return null;
		}
			
		//递归搜索
		private AVLTreeNode<City> search(City x,AVLTreeNode<City> node){
			if(node==null) {//搜索失败
				return null;
			}
			int result=((Experiment2.City) x).getMinFee()-((Experiment2.City) node.data).getMinFee();
			if(result<0) {
				return search(x,node.leftChild);//在左子树递归搜索
			}
			else if(result>0) {
				return search(x,node.rightChild);//在右子树递归搜索
			}
			else {
				return node;//相等，搜索成功
			}
		}
		public AVLTreeNode<City> search(City x){
			return search(x,root);
		}
		//寻找最小结点
		private AVLTreeNode<City> minNode(AVLTreeNode<City> node){
			if(node==null){
				return null;
			}
			while(node.leftChild!=null){
				node=node.leftChild;
			}
			return node;
		}
		public AVLTreeNode<City> minNode(){
			return minNode(root);
		}
		//中序遍历
		private void inOrder(AVLTreeNode<City> node){
			if(node!=null){
				inOrder(node.leftChild);
				System.out.println(((Experiment2.City) node.data).getName());
				inOrder(node.rightChild);
			}
		}
		public void inOrder(){
			inOrder(root);
		}
	}	    
}
