package Experiment3;

public class Instruction {
	private String operand;//操作数
	private int pagenumber;//对应的作业的页号
	private int unitnumber;//单元号
	
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public String getOperand() {
		return operand;
	}
	
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	public int getPagenumber() {
		return pagenumber;
	}
	
	public void setUnitnumber(int unitnumber) {
		this.unitnumber = unitnumber;
	}
	public int getUnitnumber() {
		return unitnumber;
	}
}
