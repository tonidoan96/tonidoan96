package model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.Main;

public class Bird {
	private int x, y;
	private Animation animation;
	public static final int BOUNCE = -5, FALL = 2;
	private int dy;
	private int degree;
	//gốc của con chim ngốc lên ngốc xúng
	public static final int ROTATE = 2, ROTATE_UP = -30, ROTATE_DOWN_MAX = 80;

	public Bird() {
		x = Main.WIDTH / 3;
		y = Main.HEIGHT / 2;
		animation = new Animation();
		addFrame();
	}

	public void draw(Graphics2D g2d) {
		int centerX = this.x + animation.getCurrentImage().getWidth(null) / 2;
		int centerY = this.y + animation.getCurrentImage().getHeight(null) / 2;
		g2d.rotate(Math.toRadians(degree), centerX, centerY);
		g2d.drawImage(animation.getCurrentImage(), x, y, null);

	}

	public void addFrame() {
		animation.addFrame("bird1.png", 15);
		animation.addFrame("bird2.png", 15);
		animation.addFrame("bird3.png", 15);

	}

	public void update(long elpaseTime) {
		animation.update(elpaseTime);
		y += dy;
		if (dy == BOUNCE) {
			degree = ROTATE_UP;
		} else {
			if (dy == FALL) {
				degree = (degree < ROTATE_DOWN_MAX) ? degree += ROTATE : 0;
			}

		}
	}

	public  void setFly(int speed) {
		this.dy = speed;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return this.animation.getCurrentImage().getHeight(null);
	}

	public boolean died(ArrayList<Obstacle> obstacles) {
		if (getY() + getHeight() > 406) {
			this.y = (406 - getHeight());
			return true;
		}
		for (int i = 0; i < obstacles.size(); i++) {
			if (((Obstacle) obstacles.get(i)).isHit(this)) {
				return true;
			}
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
