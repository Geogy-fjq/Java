package Experiment4;

public class Function {
	private File[] filelist=new File[10];
	public File[] getuserlist() {
		return filelist;
	}
	//打开文件
	public void open(String file,File[] filelist) {
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i]!=null) {
				if(file.equals(filelist[i].getname())) {
					if(filelist[i].getopened()==1) {
						System.out.println("打开文件失败！");
					}
					else {
						int full=1;
						for(int j=0;j<10;j++) {
							if(filelist[j]==null) {
								filelist[i].setopened(1);
								filelist[j]=filelist[i];
								full=0;
								System.out.println("文件打开成功！");
								break;
							}
						}
						if(full==1) {
							System.out.println("最多打开10个文件！");
						}
					}
				}
			}
		}
	}
	//关闭文件
	public void close(String file,File[] filelist) {
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i]!=null) {
				if(file.equals(filelist[i].getname())) {
					filelist[i].setopened(0);
					for(int j=0;j<5;j++) {
						if(filelist[j].getname().equals(filelist[i].getname())) {
							filelist[j]=null;
							filelist[i].setopened(0);
							System.out.println("文件已关闭！");
							break;
						}
					}
				}
			}
		}
	}
	//读出文件
	public void read(String file,File[] filelist) {
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i]!=null) {
				if(file.equals(filelist[i].getname())) {
					if(filelist[i].getma()==1) {
						for(int j=0;j<5;j++) {
							if(filelist[j].getname().equals(filelist[i].getname())) {
								filelist[i].setpoint(1);
								System.out.println("读出成功！");
								break;
							}
						}
					}
					else {
						System.out.println("读写失败！");
					}
				}
			}
		}
	}
	//写入文件
	public void write(String file,File[] filelist) {
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i]!=null) {
				if(file.equals(filelist[i].getname())) {
					if(filelist[i].getma()==1) {
						for(int j=0;j<5;j++) {
							if(filelist[j].getname().equals(filelist[i].getname())) {
								filelist[i].setpoint(1);
								System.out.println("写入成功！");
								break;
							}
						}
					}
					else {
						System.out.println("读写失败！");
					}
				}
			}
		}	
	}
}
