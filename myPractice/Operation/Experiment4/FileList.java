package Experiment4;

public class FileList {
	private File[] filelist=new File[10];
	public FileList(File[] filelist) {
		this.filelist=filelist;
	}
	public File[] getfilelist() {
		return filelist;
	}
	public void addnable(String name,int m) {
		int full=1;
		for(int j=0;j<filelist.length;j++) {
			if(filelist[j]==null) {
				filelist[j]=new File(name,m);
				full=0;
				break;
			}
		}
		if(full==1) {
			System.out.println("最多保存10个文件!");
		}
	}
	public void deletenable(String name) {
		int have=0;
		for(int i=0;i<filelist.length;i++) {
			if(name.equals(filelist[i].getname())) {
				filelist[i]=null;
				have++;
				break;
			}
		}
		if(have==0) {
			System.out.println("该文件不存在!");
		}
	}
}
