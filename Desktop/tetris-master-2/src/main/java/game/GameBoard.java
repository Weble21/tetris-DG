package game;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import javax.swing.text.SimpleAttributeSet;

import blocks.Block;
import blocks.GetRandomBlock;
import setting.SettingItem;

public class GameBoard extends JPanel {

	private static final long serialVersionUID = 2434035659171694595L;
	public static final int HEIGHT = 20;
	public static final int WIDTH = 10;

	protected GetRandomBlock getRandomBlock;
	protected SettingItem settingItem;
	protected GamePane gamePane;

	protected SimpleAttributeSet styleSet;
	protected Block curr;
	protected Block nextBlock;
	protected NextBlockPane nextBlockPane;
	protected int score = 0;
	protected int level = 1;
	protected int lineNum = 0;
	protected boolean gameEnded = false;
	protected int x = 3; // Default Position.
	protected int y = 0;
	protected String modeName;
	protected int[][] erasedLine;

	public GameBoard() throws IOException {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		settingItem = SettingItem.getInstance();
		modeName = settingItem.getModeName();
		erasedLine = new int[0][WIDTH];

		getRandomBlock = new GetRandomBlock();
		nextBlock = getRandomBlock.getRandomBlockMode(modeName);
		nextBlockPane = new NextBlockPane(settingItem.isColorBlind());
		nextBlockPane.setFontSize(settingItem.getFontSize());
		gamePane = new GamePane(settingItem.isColorBlind());

		// Create the first block and draw.
		curr = getRandomBlock.getRandomBlockMode(modeName);
		gamePane.placeBlock(x, y, curr);
		gamePane.draw();
		add(gamePane);
	}

	protected void drawBoard() {
		gamePane.draw();
	}

	protected void setGameBoardText(String string) {
		String letter = "";
		for (int i = 0; i < 9; i++)
			letter += "          \n";
		int num = 10 - string.length();
		for (int i = 0; i < num / 2; i++)
			letter += " ";
		letter += string;
		for (int i = 0; i < num / 2; i++)
			letter += " ";
		letter += "\n";
		for (int i = 0; i < 9; i++)
			letter += "          \n";
		gamePane.setText(letter);
	}

	protected void moveRight() {
		if (curr.getItem() == "weight" && detectCrash('D')) {
		} else {
			gamePane.eraseCurr(x, y, curr);
			if (!detectCrash('R'))
				x++;
			gamePane.placeBlock(x, y, curr);
			gamePane.draw();
		}
	}

	protected void moveLeft() {
		if (curr.getItem() == "weight" && detectCrash('D')) {
		} else {
			gamePane.eraseCurr(x, y, curr);
			if (!detectCrash('L'))
				x--;
			gamePane.placeBlock(x, y, curr);
			gamePane.draw();
		}
	}

	protected boolean moveDown() {
		gamePane.eraseCurr(x, y, curr);
		if (!detectCrash('D')) {
			y++;
			score++;
			return true;
		}
		return false;
	}

	protected void dropBlock() {
		gamePane.eraseCurr(x, y, curr);
		while (!detectCrash('D')) {
			y++;
			score++;
		}
	}

	protected void eraseLine() {
		int temp = 0;
		int[][] lines = new int[HEIGHT][WIDTH];
		for (int j = 0; j < erasedLine.length; j++)
			for (int i = 0; i < WIDTH; i++)
				lines[j][i] = erasedLine[j][i];

		for (int i = 0; i < HEIGHT; i++) {
			boolean lineClear = true;
			for (int j = 0; j < WIDTH; j++) {
				if (gamePane.getBoard(i, j) == 0) {
					lineClear = false;
					j = WIDTH;
				}
			}
			if (lineClear) {
				for (int k = 0; k < WIDTH; k++) {
					if (curr.getShape(k - x, i - y) == 0)
						lines[erasedLine.length + temp][k] = gamePane.getBoard(i, k);
					else
						lines[erasedLine.length + temp][k] = 0;
				}
				for (int k = i; k > 1; k--) {
					for (int l = 0; l < WIDTH; l++) {
						gamePane.setBoard(k, l, gamePane.getBoard(k - 1, l));
						gamePane.setColorBoard(k, l, gamePane.getColorBoard(k - 1, l));
					}
				}
				score += 10 * level;
				lineNum++;
				temp++;
			}
		}

		if (temp > 0) {
			audio();
			if (temp > 1) {
				erasedLine = new int[Math.min(10, erasedLine.length + temp)][WIDTH];
				for (int j = 0; j < erasedLine.length; j++)
					for (int i = 0; i < WIDTH; i++)
						erasedLine[j][i] = lines[j][i];
			}
		}
		gamePane.draw();
	}

	protected int[][] getErasedLine() {
		return erasedLine;
	}

	protected void resetErasedLine() {
		erasedLine = new int[0][0];
	}

	protected void rotateBlock() {
		gamePane.eraseCurr(x, y, curr);
		if (x + curr.height() >= WIDTH)
			x = WIDTH - curr.height();
		if (y + curr.width() >= HEIGHT)
			y = HEIGHT - curr.width();
		curr.rotate();
		for (int i = x; i < x + curr.width(); i++) {
			for (int j = y; j < y + curr.height(); j++) {
				if (gamePane.getBoard(j, i) == 1 && curr.getShape(i - x, j - y) == 1) {
					curr.rotate();
					curr.rotate();
					curr.rotate();
					break;
				}
			}
		}
		gamePane.placeBlock(x, y, curr);
		gamePane.draw();
	}

	protected static void audio() {
		try {
			File file = new File("images/lineClear.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.loop(0);
			clip.start();
		} catch (Exception e) {
			System.err.println("no music");
		}
	}

	protected void animation(int line) {
		System.out.println("animation");
		for (int i = 0; i < WIDTH; i++) {
			gamePane.setColorBoard(line, i, "WHITE");
		}
		gamePane.draw();
	}

	protected boolean detectCrash(char position) {
		switch (position) {
			case 'L':
				for (int i = 0; i < curr.height(); i++)
					for (int j = 0; j < curr.width(); j++)
						if (curr.getShape(j, i) != 0 && gamePane.getBoard(i + y, j + x - 1) != 0)
							return true;
						else if (curr.getShape(j, i) != 0 && gamePane.getBoard(i + y, j + x - 1) == 0)
							j = curr.width();
				break;
			case 'R':
				for (int i = 0; i < curr.height(); i++)
					for (int j = curr.width() - 1; j >= 0; j--)
						if (curr.getShape(j, i) != 0 && gamePane.getBoard(i + y, j + x + 1) != 0)
							return true;
						else if (curr.getShape(j, i) != 0 && gamePane.getBoard(i + y, j + x - 1) == 0)
							j = -1;
				break;
			case 'D':
				for (int i = 0; i < curr.width(); i++)
					for (int j = curr.height() - 1; j >= 0; j--)
						if (curr.getShape(i, j) != 0 && gamePane.getBoard(j + y + 1, i + x) != 0) {
							return true;
						} else if (curr.getShape(i, j) != 0 && gamePane.getBoard(j + y + 1, i + x) == 0)
							j = -1;
				break;
		}
		return false;
	}

	protected boolean isGameEnded() {
		for (int i = 0; i < WIDTH; i++) {
			if (gamePane.getBoard(0, i) != 0)
				return true;
		}
		return false;
	}

	public void placeBlock() {
		gamePane.placeBlock(x, y, curr);
	}

	public int getScore() {
		return score;
	}

	public void setLevel(int newLevel) {
		level = newLevel;
	}

	public int getLevel() {
		return level;
	}

	public int getLineNum() {
		return lineNum;
	}

	public Block getNextBlock() {
		return nextBlock;
	}

	public String getModeName() {
		return modeName.toString();
	}

}