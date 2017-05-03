
package model;

public interface Game {
	public void create();

	public void update();

	public Bird getBird();

	public BackGround getGround1();

	public BackGround getGround2();

	public BackGround getSky1();

	public BackGround getSky2();

	public Obstacle getObstancle();

	public Score getScore();
}
