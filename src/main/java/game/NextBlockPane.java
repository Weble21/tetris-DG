package game;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import blocks.Block;

public class NextBlockPane extends JTextPane {

	private GamePane gamePane;

	public NextBlockPane(boolean isColorBlindMode) {
		setEditable(false);
		setBackground(Color.BLACK);
		CompoundBorder border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 10),
				BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
		setBorder(border);
		gamePane = new GamePane(isColorBlindMode);
	}

	public void drawNextBlockBoard(Block nextBlock) {
		StyledDocument doc = this.getStyledDocument();
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < 3; i++) {
			sb.append("  ");
			for (int j = 0; j < 5; j++) {
				if (nextBlock.width() > j && nextBlock.height() > i) {
					if (nextBlock.getShape(j, i) == 1) {
						sb.append("O");
					} else if (nextBlock.getShape(j, i) == 2) {
						sb.append("L");
					} else {
						sb.append(" ");
					}
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		this.setText(sb.toString());

		doc.setParagraphAttributes(0, doc.getLength(), gamePane.getStyleSet(), false);
		doc.setCharacterAttributes(0, doc.getLength(), gamePane.getStyle(nextBlock.getColor()), false);
		this.setStyledDocument(doc);
	}
	public void setFontSize(int fontSize) {
		StyleConstants.setFontSize(gamePane.getStyleSet(), fontSize);
	}
}