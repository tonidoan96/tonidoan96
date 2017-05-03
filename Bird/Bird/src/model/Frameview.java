package model;

import java.awt.Image;

public class Frameview {
	//hình ảnh + time chơi giống thread
	private Image image;
	private long time;
	public Frameview(Image image, long time) {
		super();
		this.image = image;
		this.time = time;
	}
	public Image getImage() {
		return image;
	}
	public long getTime() {
		return time;
	}
	
}
