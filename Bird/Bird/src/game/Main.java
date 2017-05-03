
package game;

import java.awt.Toolkit;

import javax.swing.JFrame;

import view.Frame;

public class Main extends JFrame {
	Frame a = new Frame();
	public static final int WIDTH = 340, HEIGHT = 512;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		setTitle("Flappy Bird");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/icon.png")));
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		getContentPane().add(a);
		this.setVisible(true);
		this.setLocation(500, 100);

	}

	public static void main(String[] args) {
		new Main();

	}

}
