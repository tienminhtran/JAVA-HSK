package model;

import java.awt.Color;

public class MyColorModel {

	private Color foreground;
	private Color background;
	private boolean opapue;
	public MyColorModel() {
		this.foreground = Color.BLACK;
		this.background = Color.WHITE;
		this.opapue = true;
	}
	public Color getForeground() {
		return foreground;
	}
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public boolean isOpapue() {
		return opapue;
	}
	public void setOpapue(boolean opapue) {
		this.opapue = opapue;
	}
	
}
