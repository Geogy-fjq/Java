package Experiment4;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		File[] a= {new File("file1.txt",1),new File("file2.txt",2),null,null,null,null,null,null,null,null};
		FileList usera= new FileList(a);
		User[] user= {new User("a",usera)};
		UserList mdf=new UserList(user);
		System.out.println("请输入用户名:");
		Scanner in=new Scanner(System.in);
		String u=in.next();
		User[] userlist=mdf.getuserlist();
		int finded=0;
		for(int i=0;i<userlist.length;i++) {
			if(userlist[i].getname().equals(u)) {
				finded++;
				User now=userlist[i];
				File[] filelist=now.getpoint().getfilelist();
				System.out.println("该用户所有文件为:");
				for(int j=0;j<filelist.length;j++) {
					if(filelist[j]!=null) {
						System.out.println(filelist[j].getname());
					}
				}
				Function work=new Function();
				int fun=0;
				while(fun!=7) {
					System.out.println("\n请输入对应操作的序号:");
					System.out.println("1: 打开文件");
					System.out.println("2: 关闭文件");
					System.out.println("3: 读出文件");
					System.out.println("4: 写入文件");
					System.out.println("5: 建立文件");
					System.out.println("6: 删除文件");
					System.out.println("7: 退出");
					fun =in.nextInt();
					if(fun==1) {
						System.out.println("请输入要打开的文件名：");
						String name=in.next();
						work.open(name,filelist);
						break;
					}
					if(fun==2) {
						System.out.println("请输入要关闭的文件名：");
						String name1=in.next();
						work.close(name1,filelist);
						break;
					}
					if(fun==1) {
						System.out.println("请输入要读出的文件名：");
						String name2=in.next();
						work.read(name2,filelist);
						break;
					}
					if(fun==4) {
						System.out.println("请输入要写入的文件名：");
						String name3=in.next();
						work.write(name3,filelist);
						break;
					}
					if(fun==5) {
						System.out.println("请输入要建立的文件名：");
						String name4=in.next();
						System.out.println("请输入添加文件的保护码");
						int ma=in.nextInt();
						mdf.addfile(now, name4, ma);
						for(int m=0;m<mdf.getuserlist().length;m++) {
							if(mdf.getuserlist()[m].getname().equals(u)) {
								File[] filelist1=mdf.getuserlist()[i].getpoint().getfilelist();
								for(int j=0;j<filelist1.length;j++) {
									if(filelist[j]!=null) {
										System.out.println(filelist[j].getname());
									}
								}
							}
						}
						break;
					}
					if(fun==6) {
						System.out.println("请输入要删除的文件名");
						String name5=in.next();
						mdf.deletefile(now, name5);
						for(int m=0;m<mdf.getuserlist().length;m++) {
							if(mdf.getuserlist()[m].getname().equals(u)) {
								File[] filelist1=mdf.getuserlist()[i].getpoint().getfilelist();
								for(int j=0;j<filelist1.length;j++) {
									if(filelist[j]!=null) {
										System.out.println(filelist[j].getname());
									}
								}
							}
						}
						break;
					}
					if(fun==7) {
						break;
					}
					else {
						break;
					}
				}
			}
		}
		if(finded==0) {
			System.out.println("该用户不存在！");
		}
	}
}
