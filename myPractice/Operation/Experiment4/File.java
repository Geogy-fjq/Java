package Experiment4;

public class File {
	private String name;
	private int ma;
	private int length=0;
	private int point=0;
	private int opened=0;
	public File(String name,int ma) {
		this.name = name;
		this.ma = ma;
	}
	public String getname() {
		return name;
	}
	public int getopened() {
		return opened;
	}
	public int getma() {
		return ma;
	}
	public int getpoint() {
		return point;
	}
	public void setopened(int opened) {
		this.opened = opened;
	}
	public void setma(int ma) {
		this.ma = ma;
	}
	public void setpoint(int point) {
		this.point = point;
	}
	public void setlength(int length) {
		this.length = length;
	}
}
