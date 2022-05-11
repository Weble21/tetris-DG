package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import main.Tetris;
import setting.SettingItem;

import static java.lang.System.currentTimeMillis;

public class FightMenu extends JFrame implements KeyListener {

	private SettingItem settingItem;
	private GameBoard gameBoard1;
	private GameBoard gameBoard2;
	private GamePane gamePane1;
	private GamePane gamePane2;

	protected static int initInterval;
	protected JLabel scoreLabel1;
	protected JLabel scoreLabel2;
	protected String gameMode;
	protected Timer timer;
	protected long startTime;
	protected final long exitTime = 60000;
	protected boolean isTimeAttackMode;
	protected boolean isGameEnded;


	public FightMenu(boolean isItemMode,boolean isTimeAttackMode) throws IOException {
		super("Tetris Fight");
		settingItem = SettingItem.getInstance();
		setSize(settingItem.getBoardWidth() * 2, settingItem.getBoardHeight());
		SettingItem.isItemMode = isItemMode;
		this.isTimeAttackMode = isTimeAttackMode;
		setResizable(false);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// lower panel
		JButton settingButton = new JButton("Settings");
		JButton startMenuBtn = new JButton("Start Menu");
		JButton scoreBoardBtn = new JButton("EXIT");
		JButton restartBtn = new JButton("restart");
		settingButton.addActionListener(e -> btnSettingActionPerformed());
		startMenuBtn.addActionListener(e -> btnStartMenuActionPerformed());
		scoreBoardBtn.addActionListener(e -> btnScoreBoardActionPerformed());
		restartBtn.addActionListener(e -> btnRestartActionPerformed());
		JPanel lowerPanel = new JPanel(new GridLayout(0, 4));
		lowerPanel.add(settingButton);
		lowerPanel.add(startMenuBtn);
		lowerPanel.add(scoreBoardBtn);
		lowerPanel.add(restartBtn);

		if (isItemMode) {
			gameBoard1 = new ItemGameBoard();
			gameBoard2 = new ItemGameBoard();
			gameMode = "item";
		} else {
			gameBoard1 = new GameBoard();
			gameBoard2 = new GameBoard();
			gameMode = "regul";
		}
		gameBoard1.gamePane.setFontSize(settingItem.getFontSize());
		gameBoard1.drawBoard();
		gameBoard2.gamePane.setFontSize(settingItem.getFontSize());
		gameBoard2.drawBoard();
		gameBoard1.nextBlockPane.drawNextBlockBoard(gameBoard1.getNextBlock());
		gameBoard2.nextBlockPane.drawNextBlockBoard(gameBoard2.getNextBlock());

		JPanel sidePanel1 = new JPanel();
		sidePanel1.setBackground(Color.white);
		JPanel sidePanel2 = new JPanel();
		sidePanel2.setBackground(Color.white);
		gamePane1 = new GamePane();
		gamePane1.draw();
		sidePanel1.add(gamePane1);
		gamePane2 = new GamePane();
		gamePane2.draw();
		sidePanel2.add(gamePane2);

		// Side display
		scoreLabel1 = new JLabel(gameBoard1.getScore() + "", JLabel.CENTER);
		TitledBorder tborder = new TitledBorder("SCORE");
		tborder.setTitlePosition(TitledBorder.ABOVE_TOP);
		tborder.setTitleJustification(TitledBorder.CENTER);
		scoreLabel1.setBorder(tborder);
		scoreLabel1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
		scoreLabel1.setBackground(Color.white);

		// Side display
		scoreLabel2 = new JLabel(gameBoard2.getScore() + "", JLabel.CENTER);
		scoreLabel2.setBorder(tborder);
		scoreLabel2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
		scoreLabel2.setBackground(Color.white);
		updateScore();

		// left panel
		JPanel rightPanel1 = new JPanel();
		rightPanel1.setLayout(new BoxLayout(rightPanel1, BoxLayout.Y_AXIS));
		rightPanel1.add(gameBoard1.nextBlockPane);
		rightPanel1.add(scoreLabel1);
		rightPanel1.add(sidePanel1);
		rightPanel1.setAlignmentX(LEFT_ALIGNMENT);
		rightPanel1.setBackground(Color.WHITE);
		JPanel rightPanel2 = new JPanel();
		rightPanel2.setLayout(new BoxLayout(rightPanel2, BoxLayout.Y_AXIS));
		rightPanel2.add(gameBoard2.nextBlockPane);
		rightPanel2.add(scoreLabel2);
		rightPanel2.add(sidePanel2);
		rightPanel2.setAlignmentX(LEFT_ALIGNMENT);
		rightPanel2.setBackground(Color.WHITE);

		// upper panel
		JPanel panel1 = new JPanel();
		panel1.add(gameBoard1);
		panel1.add(rightPanel1);
		panel1.setBackground(Color.white);
		JPanel panel2 = new JPanel();
		panel2.add(gameBoard2);
		panel2.add(rightPanel2);
		panel2.setBackground(Color.white);
		JPanel upperPanel = new JPanel(new GridLayout(0, 2));
		upperPanel.add(panel1);
		upperPanel.add(panel2);

		// outer panel
		JPanel outerPanel = new JPanel();
		outerPanel.add(upperPanel);
		outerPanel.add(lowerPanel);
		setContentPane(outerPanel);
		outerPanel.setForeground(Color.WHITE);

		// Set timer for block drops.
		initInterval = settingItem.getInitInterval();
<<<<<<< HEAD
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "PLAYER1: A,S,D,W(rotate),SPACE BAR(drop)\nPLAYER2: Arrow keys, ENTER(drop)");
=======
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "PLAYER1: A←,S↓,D→,W(rotate),SPACE BAR(drop)\nPLAYER2: Arrow keys, ENTER(drop)");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		startTime = currentTimeMillis();
		addKeyListener(this);
		setTimer();
		setFocusable(true);
		requestFocus();
	}

	protected void setTimer() {
		timer = new Timer(initInterval, e -> {
			moveDown(gameBoard1);
			moveDown(gameBoard2);
			updateScore();
		});
		timer.start();
	}

	protected void updateScore() {
		scoreLabel1.setText(String.format("%5s", gameBoard1.getScore() + "") + " ");
		scoreLabel2.setText(String.format("%5s", gameBoard2.getScore() + "") + " ");
		if (Math.max(gameBoard1.getLineNum(), gameBoard2.getLineNum()) / 7 >= gameBoard1.getLevel()) {
			gameBoard1.setLevel(gameBoard1.getLevel() + 1);
			gameBoard2.setLevel(gameBoard2.getLevel() + 1);
			initInterval -= settingItem.getReduceSpeed();
			timer.stop();
			setTimer();
		}
		if (gameBoard1.getErasedLine().length > 1)
			gamePane2.setLines(gameBoard1.getErasedLine());
		if (gameBoard2.getErasedLine().length > 1)
			gamePane1.setLines(gameBoard2.getErasedLine());
	}

	public void pause() {
		if (!timer.isRunning()) {
			timer.start();
			gameBoard1.drawBoard();
			gameBoard2.drawBoard();
		} else {
			timer.stop();
			gameBoard1.setGameBoardText("PAUSE");
			gameBoard2.setGameBoardText("PAUSE");
		}
	}

	protected void moveDown(GameBoard gameBoard) {
		if (!gameBoard.moveDown()) {
			if(newBlock(gameBoard)){
				gameBoard.placeBlock();
			} else{
				gameBoard.placeBlock();
				gameBoard.drawBoard();
			}
		} else{
			gameBoard.placeBlock();
			gameBoard.drawBoard();
		}

		if(isGameEnded)
			return;
	}

	protected boolean newBlock(GameBoard gameBoard) {
		gameBoard.placeBlock(); // 밑으로 내려가지 않게 고정
		System.out.println(currentTimeMillis()-startTime);
		if (gameBoard.isGameEnded() || (isTimeAttackMode && currentTimeMillis()-startTime>exitTime)) {
			timer.stop();
			isGameEnded = true;
			gameOver();
			return false;
		}
		if(gameBoard==gameBoard1) {
			gameBoard.gamePane.addLines(gameBoard2.erasedLine);
			gameBoard2.resetErasedLine();
			gamePane1.setLines(gameBoard2.getErasedLine());
		} else {
			gameBoard.gamePane.addLines(gameBoard1.erasedLine);
			gameBoard1.resetErasedLine();
			gamePane2.setLines(gameBoard1.getErasedLine());
		}
		boolean isErased = gameBoard.eraseLine();
		gameBoard.curr = gameBoard.nextBlock;
		if(SettingItem.isItemMode && (gameBoard.lineNum/gameBoard.count >= gameBoard.lineChange)) {
			gameBoard.nextBlock = gameBoard.getRandomBlock.getItemBlock(gameBoard.modeName);
			gameBoard.count = gameBoard.count+1;
		} else {
			gameBoard.nextBlock = gameBoard.getRandomBlock.getRandomBlockMode(gameBoard.modeName);
		}
		gameBoard.x = 3;
		gameBoard.y = 0;
		gameBoard.nextBlockPane.drawNextBlockBoard(gameBoard.getNextBlock());
		return isErased;
	}
	private void gameOver() {
		String text = "draw";
		if(gameBoard1.isGameEnded() && !gameBoard2.isGameEnded()) {
			gameBoard1.setGameBoardText("LOSE");
			gameBoard2.setGameBoardText("WIN!");
			text = "player2 win";
		} else if(!gameBoard1.isGameEnded() && gameBoard2.isGameEnded()){
			gameBoard1.setGameBoardText("WIN!");
			gameBoard2.setGameBoardText("LOSE");
			text = "player1 win";
		} else if(gameBoard1.isGameEnded() && gameBoard2.isGameEnded()){
			gameBoard1.setGameBoardText("DRAW!");
			gameBoard2.setGameBoardText("DRAW!");
		} else{
			if(gameBoard1.score>gameBoard2.score){
				gameBoard1.setGameBoardText("WIN!");
				gameBoard2.setGameBoardText("LOSE");
				text = "player1 win";
			} else if(gameBoard1.score<gameBoard2.score){
				gameBoard1.setGameBoardText("LOSE");
				gameBoard2.setGameBoardText("WIN!");
				text = "player2 win";
			} else{
				gameBoard1.setGameBoardText("DRAW!");
				gameBoard2.setGameBoardText("DRAW!");
			}
		}
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), text);
	}

	private void btnScoreBoardActionPerformed() {
		timer.stop();
		dispose();
		System.exit(0);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (timer.isRunning())
				gameBoard2.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (timer.isRunning())
				gameBoard2.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (timer.isRunning()) {
				moveDown(gameBoard2);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (timer.isRunning())
				gameBoard2.rotateBlock();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (timer.isRunning()) {
				gameBoard2.dropBlock();
				if(newBlock(gameBoard2)){
					gameBoard2.placeBlock();
				} else{
					if(!isGameEnded){
						gameBoard2.placeBlock();
						gameBoard2.drawBoard();
					}
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (timer.isRunning())
				gameBoard1.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			if (timer.isRunning())
				gameBoard1.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			if (timer.isRunning())
				moveDown(gameBoard1);
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			if (timer.isRunning())
				gameBoard1.rotateBlock();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (timer.isRunning()) {
				gameBoard1.dropBlock();
				if(newBlock(gameBoard1)){
					gameBoard1.placeBlock();
				} else{
					if(!isGameEnded){
						gameBoard1.placeBlock();
						gameBoard1.drawBoard();
					}
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_P) {
			pause();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stud
	}

	private void btnSettingActionPerformed() {
		timer.stop();
		dispose();
		Tetris.showSettingMenu();
	}

	private void btnStartMenuActionPerformed() {
		timer.stop();
		dispose();
		Tetris.showStartMenu();
	}

	private void btnRestartActionPerformed() {
		timer.stop();
		dispose();
		try {
			Tetris.start();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//to be edited
	}
}