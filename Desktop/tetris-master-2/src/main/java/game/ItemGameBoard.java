package game;

import java.util.Arrays;
import java.util.Objects;

public class ItemGameBoard extends GameBoard {

	private static final long serialVersionUID = 1L;

	public ItemGameBoard() throws java.io.IOException {
	}

	@Override
	protected boolean eraseLine() {
		int temp = 0;
		int[][] tempBoard = new int[HEIGHT][WIDTH];
		int[][] lines = new int[HEIGHT][WIDTH];
		String[][] tempColorBoard = new String[HEIGHT][WIDTH];

		for(int j=0;j<gamePane.board.length;j++){
			System.arraycopy(gamePane.board[j], 0, tempBoard[j], 0, WIDTH);
			System.arraycopy(gamePane.colorBoard[j], 0, tempColorBoard[j], 0, WIDTH);
		}
		for (int j = 0; j < erasedLine.length; j++)
			System.arraycopy(erasedLine[j], 0, lines[j], 0, WIDTH);
		items();
		for (int i = 0; i < HEIGHT; i++) {
			if (isErasedLine(i)) {
				eraseOneLine(i,tempColorBoard,lines,temp);
				temp++;
			}
		}
		if (temp > 0) {
			gamePane.draw(tempBoard,tempColorBoard);
			audio();
			if (temp > 1 && erasedLine.length<10) {
				erasedLine = new int[Math.min(10, erasedLine.length + temp)][WIDTH];
				for (int j = 0; j < erasedLine.length; j++)
					System.arraycopy(lines[j], 0, erasedLine[j], 0, WIDTH);
			}
			return true;
		}
		return false;
	}

	protected void items() {
		if (Objects.equals(curr.getItem(), "weight")) {
			for (int i = x; i < x + curr.width(); i++) {
				for (int j = 0; j < HEIGHT; j++) {
					gamePane.setBoard(j,i,0);
				}
			}
			y = HEIGHT - 2;
		} else if (Objects.equals(curr.getItem(), "L")) {
			lItem();
		} else if (Objects.equals(curr.getItem(), "bomb")) {
			bombItem();
		} else if (Objects.equals(curr.getItem(), "cross")) {
			crossItem();
		} else if (Objects.equals(curr.getItem(), "total")) {
			totalItem();
		}
	}

	private void lItem() {
		int line = 0;
		for (int i = 0; i < curr.width(); i++)
			for (int j = 0; j < curr.height(); j++)
				if (curr.getShape(i, j) == 2) {
					line = j;
					break;
				}
		for (int i = 0; i < WIDTH; i++)
			gamePane.setBoard(line + y,i,1);
	}

	private void crossItem() {
		for(int i=0;i<WIDTH;i++)
			gamePane.setBoard(y+1,i,1);
		for(int j=0;j<y+1;j++)
			gamePane.setBoard(j,x+1,0);
		for(int j=y+2;j<HEIGHT;j++)
			gamePane.setBoard(j,x+1,0);
	}

	private void bombItem() {
		for(int i=Math.max(0,x-2);i<Math.min(x+4,WIDTH);i++)
			for(int j=Math.max(0,y-2);j<Math.min(y+4,HEIGHT);j++)
				gamePane.setBoard(j,i,0);
	}
	private void totalItem() {
		for(int i=0;i<WIDTH;i++)
			for(int j=0;j<HEIGHT;j++)
				gamePane.setBoard(j,i,0);
	}
}