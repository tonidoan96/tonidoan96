package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Bird;
import model.Game;
import model.Model;
import view.Frame;
import view.Sound;

public class Control implements KeyListener, MouseListener {
	Game game=new Model();
	public Control() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32) {
			if (Frame.playing == false) {
				Frame.playing = true;
			}
			game.getBird().setFly(Bird.BOUNCE);
			Sound.FLAP.play();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.getBird().setFly(Bird.FALL);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (Frame.playing == false) {
			Frame.playing = true;
		}
		game.getBird().setFly(Bird.BOUNCE);
		Sound.FLAP.play();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		game.getBird().setFly(Bird.FALL);

	}

}
