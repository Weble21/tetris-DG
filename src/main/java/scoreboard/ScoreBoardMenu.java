package scoreboard;

import main.Tetris;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.IOException;

public class ScoreBoardMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private ScoreBoardFile sb;
	private JPanel outerPanel = new JPanel();
	private JPanel lowerPanel = new JPanel();
	private JPanel upperPanel = new JPanel();

	private JLabel label = new JLabel();
	private JButton enterBtn = new JButton("Enter");
	private JButton exitBtn = new JButton("Exit");
	private JButton startBtn = new JButton("Start Menu");
	private JTextPane scoreboard = new JTextPane();
	protected JTextField nameEnter = new JTextField(10);
	private final int oneLineLength = 37;
	private int score;
	private String mode;

	private String level = "normal";
	private String scoreWriteText = "Game over. Enter your name within\nfour characters with alphabet and number.";

	public ScoreBoardMenu() {
		super("ScoreBoard"); // 타이틀
		setResizable(false);
		requestFocus();
		setSize(350, 580);
		scoreboard.setEditable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// load scoreboard file
		try {
			sb = new ScoreBoardFile();
			scoreboard.setText(sb.readScoreBoard());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// set style
		setStyle();

		// set layout
		upperPanel.setLayout(new BorderLayout());
		upperPanel.add(startBtn, BorderLayout.EAST);
		upperPanel.add(label, BorderLayout.CENTER);
		upperPanel.add(exitBtn, BorderLayout.WEST);
		label.setHorizontalAlignment(JLabel.CENTER);
		lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lowerPanel.add(nameEnter);
		lowerPanel.add(enterBtn);
		outerPanel.setLayout(new BorderLayout());
		scoreboard.setOpaque(true);
		outerPanel.add(scoreboard, BorderLayout.CENTER);
		outerPanel.add(lowerPanel, BorderLayout.SOUTH);
		outerPanel.add(upperPanel, BorderLayout.NORTH);
		add(outerPanel);

		// button action
		startBtn.addActionListener(e -> btnStartMenuActionPerformed());
		enterBtn.addActionListener(e -> tryWriteScoreboard());
		exitBtn.addActionListener(e -> System.exit(0));
		enterBtn.setEnabled(false);
		nameEnter.setEditable(false);
		label.setText("Scores from past games");
	}

	public ScoreBoardMenu(int score, String level, String mode) throws NumberFormatException, IOException {
		super("ScoreBoard"); // 타이틀
		setResizable(false);
		this.score = score;
		this.level = level;
		this.mode = mode;
		requestFocus();

		setSize(350, 580);
		scoreboard.setEditable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// load scoreboard file
		try {
			sb = new ScoreBoardFile();
			scoreboard.setText(sb.readScoreBoard());
			if (score < sb.isWritable()) {
				enterBtn.setEnabled(false);
				nameEnter.setEditable(false);
				label.setText("Scores from past scoreboard games");
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Game Over");
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), scoreWriteText);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// set style
		setStyle();

		// set layout
		upperPanel.setLayout(new BorderLayout());
		upperPanel.add(startBtn, BorderLayout.EAST);
		upperPanel.add(label, BorderLayout.CENTER);
		upperPanel.add(exitBtn, BorderLayout.WEST);
		label.setHorizontalAlignment(JLabel.CENTER);

		lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lowerPanel.add(nameEnter);
		lowerPanel.add(enterBtn);

		outerPanel.setLayout(new BorderLayout());
		outerPanel.add(scoreboard, BorderLayout.CENTER);
		outerPanel.add(lowerPanel, BorderLayout.SOUTH);
		outerPanel.add(upperPanel, BorderLayout.NORTH);
		add(outerPanel);

		// button action
		startBtn.addActionListener(e -> btnStartMenuActionPerformed());
		enterBtn.addActionListener(e -> tryWriteScoreboard());
		exitBtn.addActionListener(e -> System.exit(0));
	}

	private void setStyle() {
		Style redStyle = scoreboard.addStyle("Red", null);
		StyleConstants.setForeground(redStyle, Color.RED);
		StyleConstants.setBold(redStyle, true);

		Style boldStyle = scoreboard.addStyle("Bold", null);
		StyleConstants.setBold(boldStyle, true);

		StyledDocument doc = scoreboard.getStyledDocument();
		SimpleAttributeSet mainAttribute = new SimpleAttributeSet();
		StyleConstants.setFontFamily(mainAttribute, "Courier");
		StyleConstants.setFontSize(mainAttribute, 15);
		StyleConstants.setLineSpacing(mainAttribute, (float) 0.34);
		doc.setParagraphAttributes(0, doc.getLength(), mainAttribute, false);
		doc.setCharacterAttributes(0, oneLineLength * 3, scoreboard.getStyle("Bold"), true);

		SimpleAttributeSet styleSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(styleSet, StyleConstants.ALIGN_CENTER);
	}

	public void tryWriteScoreboard() {
		String name = nameEnter.getText();
		StyledDocument doc = scoreboard.getStyledDocument();
		if (name.length() > 4 || name.isEmpty() || !isAlphaOrDigit(name)) {
			nameEnter.setText("");
		} else {
			nameEnter.setText("");
			nameEnter.setEditable(false);
			try {
				int temp = sb.writeScoreBoard(name, score, level, mode);
				String scoreString = sb.readScoreBoard();
				scoreboard.setText(scoreString);

				doc.setCharacterAttributes(0, oneLineLength * 3, scoreboard.getStyle("Bold"), false);
				doc.setCharacterAttributes((oneLineLength * temp), oneLineLength, scoreboard.getStyle("Red"), false);
				enterBtn.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void btnStartMenuActionPerformed() {
		this.dispose();
		Tetris.showStartMenu();
	}

	public boolean isAlphaOrDigit(String s) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z') && !(ch >= '0' && ch <= '9'))
				return false;
		}
		return true;
	}
}