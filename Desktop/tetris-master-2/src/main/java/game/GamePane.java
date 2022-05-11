package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import blocks.Block;

public class GamePane extends JTextPane {

	private static final long serialVersionUID = 1L;
	protected SimpleAttributeSet styleSet;
	protected static final int HEIGHT = 20;
	protected static final int WIDTH = 10;
	protected int[][] board;
	protected String[][] colorBoard;

	public GamePane() {
		setEditable(false);
		setBackground(Color.BLACK);
		CompoundBorder border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 4),
				BorderFactory.createLineBorder(Color.white, 1));
		setBorder(border);

		styleSet = new SimpleAttributeSet();
		sideColor();
		Style w = addStyle("WHITE", null);
		StyleConstants.setForeground(w, new Color(255, 255, 255));
		Style B = addStyle("BLACK", null);
		StyleConstants.setForeground(B, Color.BLACK);
		Style G = addStyle("GRAY", null);
		StyleConstants.setForeground(G, Color.gray);
		StyleConstants.setLineSpacing(styleSet, (float) -0.3);
		StyleConstants.setFontSize(styleSet, 10);
		StyleConstants.setFontFamily(styleSet, Font.MONOSPACED);
		StyleConstants.setBold(styleSet, true);
		StyleConstants.setForeground(styleSet, Color.WHITE);
		StyleConstants.setAlignment(styleSet, StyleConstants.ALIGN_CENTER);

		board = new int[10][WIDTH];
		colorBoard = new String[10 + 2][WIDTH + 2];
		for (int i = 0; i < 10 + 2; i++)
			for (int j = 0; j < WIDTH + 2; j++)
				colorBoard[i][j] = "BLACK";
	}

	public GamePane(boolean isColorBlindMode) {
		setEditable(false);
		setBackground(Color.BLACK);
		CompoundBorder border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 12),
				BorderFactory.createLineBorder(Color.DARK_GRAY, 10));
		setBorder(border);

		styleSet = new SimpleAttributeSet();
		if (isColorBlindMode) colorBlindColor();
		else simpleColor();
		Style w = addStyle("WHITE", null);
		StyleConstants.setForeground(w, new Color(255, 255, 255));
		Style B = addStyle("BLACK", null);
		StyleConstants.setForeground(B, new Color(0, 0 , 0));
		Style G = addStyle("GRAY", null);
		StyleConstants.setForeground(G, Color.gray);

		StyleConstants.setLineSpacing(styleSet, (float) -0.2);
		StyleConstants.setFontSize(styleSet, 20);
		StyleConstants.setFontFamily(styleSet, Font.MONOSPACED);
		StyleConstants.setBold(styleSet, true);
		StyleConstants.setForeground(styleSet, Color.WHITE);
		StyleConstants.setAlignment(styleSet, StyleConstants.ALIGN_CENTER);

		board = new int[HEIGHT][WIDTH];
		colorBoard = new String[HEIGHT + 2][WIDTH + 2];
		for (int i = 0; i < HEIGHT + 2; i++)
			for (int j = 0; j < WIDTH + 2; j++)
				colorBoard[i][j] = "BLACK";
	}

	private void simpleColor() {
		Style r = addStyle("RED", null);
		StyleConstants.setForeground(r, new Color(225, 80, 80));
		Style c = addStyle("CYAN", null);
		StyleConstants.setForeground(c, new Color(96, 186, 240));
		Style b = addStyle("BLUE", null);
		StyleConstants.setForeground(b, new Color(60, 106, 210));
		Style o = addStyle("ORANGE", null);
		StyleConstants.setForeground(o, new Color(242, 126, 40));
		Style y = addStyle("YELLOW", null);
		StyleConstants.setForeground(y, new Color(245, 215, 80));
		Style g = addStyle("GREEN", null);
		StyleConstants.setForeground(g, new Color(141, 200, 60));
		Style m = addStyle("MAGENTA", null);
		StyleConstants.setForeground(m, new Color(180, 57, 160));
	}

	private void colorBlindColor() {
		Style r = addStyle("RED", null);
		StyleConstants.setForeground(r, new Color(227, 66, 52));
		Style c = addStyle("CYAN", null);
		StyleConstants.setForeground(c, new Color(135, 206, 235));
		Style b = addStyle("BLUE", null);
		StyleConstants.setForeground(b, new Color(0, 0, 225));
		Style o = addStyle("ORANGE", null);
		StyleConstants.setForeground(o, new Color(255, 165, 0));
		Style y = addStyle("YELLOW", null);
		StyleConstants.setForeground(y, new Color(255, 255, 0));
		Style g = addStyle("GREEN", null);
		StyleConstants.setForeground(g, new Color(13, 152, 186));
		Style m = addStyle("MAGENTA", null);
		StyleConstants.setForeground(m, new Color(149, 53, 83));
	}

	private void sideColor() {
		Style r = addStyle("RED", null);
		StyleConstants.setForeground(r, Color.gray);
		Style c = addStyle("CYAN", null);
		StyleConstants.setForeground(c, Color.gray);
		Style b = addStyle("BLUE", null);
		StyleConstants.setForeground(b, Color.gray);
		Style o = addStyle("ORANGE", null);
		StyleConstants.setForeground(o, Color.gray);
		Style y = addStyle("YELLOW", null);
		StyleConstants.setForeground(y, Color.gray);
		Style g = addStyle("GREEN", null);
		StyleConstants.setForeground(g, Color.gray);
		Style m = addStyle("MAGENTA", null);
		StyleConstants.setForeground(m, Color.gray);
	}

	public void draw() {
		StyledDocument doc = this.getStyledDocument();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) sb.append("O");
				else if (board[i][j] == 2) sb.append("L");
				else sb.append(" ");
			}
			if (i != board.length-1) sb.append("\n");
		}
		setText(sb.toString());
		doc.setParagraphAttributes(0, doc.getLength(), styleSet, false);
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				doc.setCharacterAttributes(i * (board[i].length + 1) + j, 1, getStyle(colorBoard[i][j]), false);
		setStyledDocument(doc);
	}

	public void draw(int [][] board, String [][] colorBoard) {
		StyledDocument doc = this.getStyledDocument();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) sb.append("O");
				else if (board[i][j] == 2) sb.append("L");
				else sb.append(" ");
			}
			if (i != board.length-1) sb.append("\n");
		}
		setText(sb.toString());
		doc.setParagraphAttributes(0, doc.getLength(), styleSet, false);
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				doc.setCharacterAttributes(i * (board[i].length + 1) + j, 1, getStyle(colorBoard[i][j]), false);
		setStyledDocument(doc);
	}

	public void placeBlock(int x, int y, Block curr) {
		StyledDocument doc = this.getStyledDocument();
		for (int j = 0; j < curr.height(); j++) {
			doc.setParagraphAttributes(0, doc.getLength(), styleSet, true);
			this.setStyledDocument(doc);
			for (int i = 0; i < curr.width(); i++)
				if (y+j < HEIGHT && x+i < WIDTH)
					if (board[y+j][x+i] == 0) {
						setBoard(y+j, x+i, curr.getShape(i, j));
						setColorBoard(y+j, x+i, curr.getColor());
					}
		}
	}

	public void eraseCurr(int x, int y, Block curr) {
		for (int i = x; i < x+curr.width(); i++) {
			for (int j = y; j < y+curr.height(); j++) {
				if (curr.getShape(i-x, j-y) != 0 && i < WIDTH && j < HEIGHT) {
					setBoard(j, i, 0);
					setColorBoard(j, i, "BLACK");
				}
			}
		}
	}

	public void setLines(int [][] lines) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Math.max(0, 10 - lines.length);i++)
			sb.append("          \n");
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[i].length; j++) {
				if (lines[i][j] == 1) sb.append("O");
				else sb.append(" ");
			}
			if (i != lines.length-1) sb.append("\n");
		}
		setText(sb.toString());
	}

	public void addLines(int [][] lines) {
		int [][] tempList = new int[HEIGHT][WIDTH];
		String [][] tempColorList = new String[HEIGHT][WIDTH];
		for (int i = board.length-1; i >=lines.length; i--) {
			for (int j = 0; j < board[i].length; j++) {
				tempList[i-lines.length][j] = board[i][j];
				tempColorList[i-lines.length][j] = colorBoard[i][j];
			}
		}
		for (int i = board.length-lines.length; i <board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				tempList[i][j] = lines[i-board.length+lines.length][j];
				tempColorList[i][j] = "GRAY";
			}
		}
		board = tempList;
		colorBoard = tempColorList;
	}

	public SimpleAttributeSet getStyleSet() {
		return styleSet;
	}

	public int getBoard(int i, int j) {
		if (i < 0 || i >= HEIGHT || j < 0 || j >= WIDTH) return 1;
		return board[i][j];
	}

	public void setBoard(int i, int j, int value) {
		board[i][j] = value;
	}

	public String getColorBoard(int i, int j) {
		if(j>=colorBoard[0].length||i>= colorBoard.length)
			return null;
		return colorBoard[i][j];
	}

	public void setColorBoard(int i, int j, String value) {
		if(j>=colorBoard[0].length||i>= colorBoard.length)
			return;
		colorBoard[i][j] = value;
	}

	public void setFontSize(int fontSize) {
		StyleConstants.setFontSize(styleSet, fontSize);
	}
}