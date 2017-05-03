package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import game.Main;

public class Obstacle {
	public static final int SPACE_BOT_TOP = 100, SPACE_TWO_OBSTACLE = 200;//space giữa 2 ống khóa trên dưới và khoảng cách giữa 2 cặp ống khói
	private Column columnBot;
	private Column columnTop;
	private int distance;
	private final int[] y_Values = { 0, -50, -100, -150, -200 };//vị trí time các chimneys chạy

	public Obstacle(int x, int y) {
		columnTop = new Column(x, y, 2);//2 đánh dấu cho top
		columnBot = new Column(x, y + columnTop.getHeight() + SPACE_BOT_TOP, 1);//1 đánh dấu cho bot

	}

	public Obstacle() {
	}

	public void draw(Graphics2D g2d) {
		columnTop.draw(g2d);
		columnBot.draw(g2d);
	}

	public void update() {
		columnTop.update();
		columnBot.update();
	}

	public int getWidth() {
		return columnTop.getWidth();
	}

	public int getX() {
		return columnTop.getX();
	}

	// xử lí va chạm bird và chimney
	public boolean isHit(Bird bird) {
		int xHv = bird.getX() +1;// lấy tọa độ của con chim đang bay + thêm 5 tọa độ 
		int yHv = bird.getY();//lấy tọa độ y của con chim đang bay
		int height = bird.getHeight();// lấy chìu cao con chim
		if ((xHv + height >= getX()) && (xHv <= getX() + getWidth())) {
			//nếu mà tọa độ bird y trong tọa độ Y + chìu cao của nó or là chìu cao bird lớn hơn chimney bot
			if ((yHv <= this.columnTop.getY() + this.columnTop.getHeight()) || (

			yHv + height >= this.columnBot.getY())) {
				return true;//bird still alive 
			}
		}
		return false;//bird died
	}

	// add chimneys
	public void addObstacle(ArrayList<Obstacle> obstacles) {
		if (distance < Obstacle.SPACE_TWO_OBSTACLE) {
			distance += BackGround.SPEED;
		} else {
			obstacles.add(new Obstacle(Main.WIDTH, y_Values[new Random().nextInt(5)]));
			distance -= Obstacle.SPACE_TWO_OBSTACLE;
		}
	}
}
