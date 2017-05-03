package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Control;
import game.Main;
import model.Game;
import model.Model;
import model.Obstacle;

public class Frame extends JPanel implements Runnable,Observer {
	Game game = new Model();
	Control click = new Control();
	int score = 0;
	int bestScore = game.getScore().getBestScore();
	public static boolean playing;
	static ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame() {
		game.create();
		addKeyListener(click);
		this.addMouseListener(click);
		this.requestFocusInWindow();
		this.setFocusable(true);
		new Thread(this).start();
	}

	
	//vẽ 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		game.getSky1().draw(g2d);
		game.getSky2().draw(g2d);
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g2d);

		}
		// ghi điểm
		// vẽ chướng ngại vật
		g2d.setColor(Color.yellow);
		g2d.setFont(new Font("", Font.BOLD, 40));
		g2d.drawString("" + score, Main.WIDTH / 2-15, 50);

		game.getGround1().draw(g2d);
		game.getGround2().draw(g2d);
		game.getBird().draw(g2d);

	}

	@Override
	public void run() {
		while (true) {
			bestScore = game.getScore().read();
			repaint();
			game.update();
			if (playing) {
				game.getObstancle().addObstacle(obstacles);
			}
			for (int i = 0; i < obstacles.size(); i++) {
				Obstacle obs = obstacles.get(i);
				if (obs.getX() + obs.getWidth() < 0) {
					obstacles.remove(i);
				} else {
					obs.update();
					if (obs.getX() == game.getBird().getX() - 5) {
						score++;
						Sound.CORE.play();

					}
				}

			}
			//update điểm lên frame 
			if (game.getBird().died(obstacles)) {
				Sound.HIT.play();
				game.getScore().addScore(score);//add score khi stop vào 
				String medal = game.getScore().medal(score);
				ImageIcon image = new ImageIcon(Loader.loadImage(medal));
				
				int op = JOptionPane.showConfirmDialog(null,
						"YOUR SCORE:   " + score + "\n" + "BEST:    " + game.getScore().read() + "\n" + "AGAIN?",
						"menu", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, image);

				if (op == JOptionPane.YES_NO_OPTION) {
					//reset lại game
					replay();
				} else {
					System.exit(0);
				}
			}
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	//reset lại 
	public void replay() {
		game.getBird().setFly(0);
		game.getBird().setY(Main.HEIGHT / 2);
		playing = false;
		obstacles.removeAll(obstacles);
		score = 0;

	}


}
