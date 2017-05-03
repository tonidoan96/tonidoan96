package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Scanner;

public class Score extends Observable{
	int score;
	int bestScore = read();

	public Score() {
		super();
		this.score = 0;
		this.bestScore = read();
	}

	// write socre xun duoi txt
	public void writeScore(int score) throws IOException {
		File file = new File("src/control/score.txt");
		PrintWriter print = new PrintWriter(file);
		print.print("");
		print.print(Integer.valueOf(bestScore));
		print.close();
	}
	// đọc điểm từ file đó lên

	public int read() {
		int best = 0;
		try {
			Scanner sc = new Scanner(new File("src/control/score.txt"));
			best = sc.nextInt();
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return best;
	}

	// add high socre vào thôi
	public void addScore(int score) {
		if (score > bestScore) {
			bestScore = score;
			try {
				writeScore(bestScore);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// quản lí huy chương tương ứng số điểm
	public String medal(int score) {
		String medal = "";
		if (score <= 10) {
			medal = "Bronze.png";

		} else {
			if (score > 10 && score <= 20) {
				medal = "Silver.png";
			} else {
				if (score > 20 && score <= 30) {
					medal = "Gold.png";
				} else {
					medal = "Platinummedal.png";
				}
			}
		}
		return medal;
	}

	public int getScore() {
		return score;
	}

	public int getBestScore() {
		return bestScore;
	}

}
