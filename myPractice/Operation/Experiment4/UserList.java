package Experiment4;

public class UserList {
	private User[] userlist=new User[10];
	public UserList(User[] userlist) {
		this.userlist=userlist;
	}
	public User[] getuserlist() {
		return userlist;
	}
	public void addfile(User user,String name,int m) {
		for(int i=0;i<userlist.length;i++) {
			if(user.getname().equals(userlist[i].getname())) {
				userlist[i].getpoint().addnable(name, m);
			}
		}
		System.out.println("添加成功，现有文件：");
	}
	public void deletefile(User user,String name) {
		for(int i=0;i<userlist.length;i++) {
			if(user.getname().equals(userlist[i].getname())) {
				userlist[i].getpoint().deletenable(name);
			}
		}
		System.out.println("删除成功，现有文件：");
	}
}
