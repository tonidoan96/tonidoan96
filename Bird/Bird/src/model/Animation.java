package model;

import java.awt.Image;
import java.util.ArrayList;

import view.Loader;

public class Animation {
	private ArrayList<Frameview> frams;
	// thời gian hiển thị
	private long trackTime;
	// tổng thời gian hiển thị
	private long totalTimeShow;
	// frame hiện tại
	private int currentFrame;
	public Animation() {

		this.frams = new ArrayList<>();
		this.trackTime = 0;
		this.totalTimeShow = 0;
		this.currentFrame = 0;
	}

	public void addFrame(String filename, long duration) {
		totalTimeShow += duration;
		frams.add(new Frameview(Loader.loadImage(filename), totalTimeShow));
	}

	public Frameview getCurrentFrame() {
		return frams.get(currentFrame);
	}

	public Image getCurrentImage() {
		return getCurrentFrame().getImage();
	}

	public void update(long elapsetime) {
		if (frams.size() > 1) {
			trackTime += elapsetime;
			if (trackTime >= totalTimeShow) {
				trackTime -= totalTimeShow;
				currentFrame = 0;
			}
		}
		if (trackTime > getCurrentFrame().getTime()) {
			currentFrame++;

		}

	}

}
