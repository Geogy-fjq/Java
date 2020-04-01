package Experiment4;

public class User {
	private String name;
	private FileList flie;
	public User(String name,FileList point) {
		this.name = name;
		this.flie = point;
	}
	public String getname() {
		return name;
	}
	public FileList getpoint() {
		return flie;
	}
}
