package model;

public class Model implements Game {
	
	//sky1 là tấm ảnh t1 và sky2 là tấm ảnh giống sky1 mục đích ghép ảnh làm di chuyển nó
	//ground1 và ground2 như sky 
	static BackGround ground1 = new BackGround(0, BackGround.GROUND);
	static BackGround sky1 = new BackGround(0, BackGround.SKY);
	static BackGround ground2 = new BackGround(ground1.getWidth(), BackGround.GROUND);
	static BackGround sky2 = new BackGround(sky1.getWidth(), BackGround.SKY);
	static Bird bird = new Bird();
	static Score score = new Score();
	static Obstacle obstacle =new Obstacle();

	@Override
	//tạo ra bird,sky, ground.....
	public void create() {
		ground1 = new BackGround(0, BackGround.GROUND);
		sky1 = new BackGround(0, BackGround.SKY);//cho vị trí đầu
		ground2 = new BackGround(ground1.getWidth(), BackGround.GROUND);
		sky2 = new BackGround(sky1.getWidth(), BackGround.SKY);//lấy vị trí chìu dài cuối cùng sky1 để 
																//nối sky2 
		bird = new Bird();
	}

	@Override
	public void update() {
		//update làm cho di chuyển ảnh 
		ground1.update();
		sky1.update();
		ground2.update();
		sky2.update();
		bird.update(1);
	}

	public BackGround getGround1() {
		return ground1;
	}

	public BackGround getSky1() {
		return sky1;
	}

	public BackGround getGround2() {
		return ground2;
	}

	public BackGround getSky2() {
		return sky2;
	}

	public Bird getBird() {
		return bird;
	}

	public Score getScore() {
		return score;
	}

	@Override
	public Obstacle getObstancle() {
		return  obstacle;
	}

}
