package model;

import java.awt.Graphics2D;
import java.awt.Image;

import game.Main;
import view.Loader;

public class BackGround {
	public static final int GROUND = 1, SKY = 2,SPEED=2;
	private int x, y;
	private Image image;
	private int speedX;

	public BackGround(int x,int type) {
		this.x=x;
		if (type == GROUND) {
			image = Loader.loadImage("ground.png");
			y = Main.HEIGHT - image.getHeight(null);
			this.speedX=SPEED;
		} else {
			if (type == SKY) {
				image = Loader.loadImage("sky.png");
				speedX=SPEED/2;
			}
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, x, y, null);
	}
	
	public void update(){
		if(x+getWidth()<0){
			this.x += 2 * getWidth();
			
		}
		x-=speedX;
	}
	public int getWidth(){
		// trả về chiều rộng của hình ảnh
		return image.getWidth(null);
	}

}
