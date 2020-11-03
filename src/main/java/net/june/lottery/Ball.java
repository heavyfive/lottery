package net.june.lottery;

public class Ball {

	private int label;
	private String color;

	public Ball(int label) {
		this.label = label;
	}
	
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
