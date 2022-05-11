package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import main.Tetris;
import setting.SettingItem;

import static java.lang.System.currentTimeMillis;

public class FightMenu extends JFrame {

	private SettingItem settingItem;
	private GameBoard [] gameBoard;
	private GamePane [] gamePane;

	private JLabel [] scoreLabel;
	private JLabel [] lineLabel;
	private JLabel [] timeLabel;

	private Timer timer;
	private Timer timeAttackTimer;
	private long startTime;
	private final long exitTime = 60000;
	private boolean isGameEnded;
	private int [] pCountNum = {0,0};


	public FightMenu(boolean isItemMode,boolean isTimeAttackMode) throws IOException {
		super("Tetris Fight");
		settingItem = SettingItem.getInstance();
		setSize(settingItem.getBoardWidth() * 2, settingItem.getBoardHeight());
		SettingItem.isItemMode = isItemMode;
		settingItem.isTimeAttackMode = isTimeAttackMode;
		SettingItem.isFightMode = true;
		setResizable(false);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// lower panel
		JButton settingButton = new JButton("Settings");
		JButton startMenuBtn = new JButton("Start Menu");
		JButton exitBtn = new JButton("EXIT");
		JButton restartBtn = new JButton("restart");
		settingButton.addActionListener(e -> btnSettingActionPerformed());
		startMenuBtn.addActionListener(e -> btnStartMenuActionPerformed());
		exitBtn.addActionListener(e -> btnExitActionPerformed());
		restartBtn.addActionListener(e -> btnRestartActionPerformed());
		JPanel lowerPanel = new JPanel(new GridLayout(0, 4));
		lowerPanel.add(settingButton);
		lowerPanel.add(startMenuBtn);
		lowerPanel.add(exitBtn);
		lowerPanel.add(restartBtn);

		//Time Attack Mode
		if(settingItem.isTimeAttackMode){
			startTime = currentTimeMillis();
			setTimeAttackMode();
		}
		JPanel upperPanel = new JPanel(new GridLayout(0, 2));
		gameBoard = new GameBoard[2];
		gamePane = new GamePane[2];
		scoreLabel = new JLabel[2];
		lineLabel = new JLabel[2];
		upperPanel.add(playerPanel(isItemMode,0));
		upperPanel.add(playerPanel(isItemMode,1));
		updateScore();

		// outer panel
		JPanel outerPanel = new JPanel();
		outerPanel.add(upperPanel);
		outerPanel.add(lowerPanel);
		setContentPane(outerPanel);
		outerPanel.setForeground(Color.WHITE);

		// Set timer for block drops.
		String message = "PLAYER1:"+settingItem.getP1LeftKey()+" "+settingItem.getP1RightKey()+" "
				+settingItem.getP1DownKey()+" "+settingItem.getP1RotateKey()+" "+settingItem.getP1DropKey()
				+"\nPLAYER2:"+settingItem.getP2LeftKey()+" "+ settingItem.getP2RightKey()+" "+settingItem.getP2DownKey()+" "
				+settingItem.getP2RotateKey()+" "+settingItem.getP2DropKey();
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), message);
		setFocusable(true);
		requestFocus();
		initControls();
		setTimer(settingItem.getReduceSpeed());
	}

	private JPanel playerPanel(boolean isItemMode, int i) throws IOException {
		if (isItemMode) {
			gameBoard[i] = new ItemGameBoard();
		} else {
			gameBoard[i] = new GameBoard();
		}
		gameBoard[i].gamePane.setFontSize(settingItem.getFontSize());
		gameBoard[i].drawBoard();
		gameBoard[i].nextBlockPane.drawNextBlockBoard(gameBoard[i].getNextBlock());

		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(Color.white);
		gamePane[i] = new GamePane();
		gamePane[i].draw();
		sidePanel.add(gamePane[i]);

		// Side display
		scoreLabel[i] = new JLabel(gameBoard[i].getScore() + "", JLabel.CENTER);
		TitledBorder border = new TitledBorder("SCORE");
		border.setTitlePosition(TitledBorder.ABOVE_TOP);
		border.setTitleJustification(TitledBorder.CENTER);
		scoreLabel[i].setBorder(border);
		scoreLabel[i].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
		scoreLabel[i].setBackground(Color.white);
		lineLabel[i] = new JLabel(gameBoard[i].getLineNum() + "", JLabel.CENTER);
		TitledBorder border2 = new TitledBorder("LINE");
		border2.setTitlePosition(TitledBorder.ABOVE_TOP);
		border2.setTitleJustification(TitledBorder.CENTER);
		lineLabel[i].setBorder(border2);
		lineLabel[i].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
		lineLabel[i].setBackground(Color.white);

		// left panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		if(SettingItem.isTimeAttackMode)
			rightPanel.add(timeLabel[i]);
		rightPanel.add(gameBoard[i].nextBlockPane);
		rightPanel.add(scoreLabel[i]);
		rightPanel.add(lineLabel[i]);
		rightPanel.add(sidePanel);
		rightPanel.setAlignmentX(LEFT_ALIGNMENT);
		rightPanel.setBackground(Color.WHITE);

		// upper panel
		JPanel panel = new JPanel();
		panel.add(gameBoard[i]);
		panel.add(rightPanel);
		panel.setBackground(Color.white);

		return panel;
	}
	protected void initControls() {
		JRootPane rootPane = this.getRootPane();
		InputMap im = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = rootPane.getActionMap();

		im.put(KeyStroke.getKeyStroke(settingItem.getP1RightKey()), "right1");
		im.put(KeyStroke.getKeyStroke(settingItem.getP1LeftKey()), "left1");
		im.put(KeyStroke.getKeyStroke(settingItem.getP1RotateKey()), "up1");
		im.put(KeyStroke.getKeyStroke(settingItem.getP1DownKey()), "down1");
		im.put(KeyStroke.getKeyStroke(settingItem.getP1DropKey()), "space1");
		im.put(KeyStroke.getKeyStroke(settingItem.getP2RightKey()), "right2");
		im.put(KeyStroke.getKeyStroke(settingItem.getP2LeftKey()), "left2");
		im.put(KeyStroke.getKeyStroke(settingItem.getP2RotateKey()), "up2");
		im.put(KeyStroke.getKeyStroke(settingItem.getP2DownKey()), "down2");
		im.put(KeyStroke.getKeyStroke(settingItem.getP2DropKey()), "space2");
		im.put(KeyStroke.getKeyStroke(settingItem.getPauseKey()), "pause");

		am.put("right1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning() && !isGameEnded)
					gameBoard[0].moveRight();
			}
		});
		am.put("left1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()&& !isGameEnded)
					gameBoard[0].moveLeft();
			}
		});
		am.put("up1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()&& !isGameEnded)
					gameBoard[0].rotateBlock();
			}
		});
		am.put("down1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()&& !isGameEnded)
					moveDown(0);
			}
		});
		am.put("space1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()&& !isGameEnded) {
					gameBoard[0].dropBlock();
					if(newBlock(0)){
						gameBoard[0].placeBlock();
					} else{
						if(!isGameEnded){
							gameBoard[0].placeBlock();
							gameBoard[0].drawBoard();
						}
					}
				}
			}
		});
		am.put("right2", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning() && !isGameEnded)
					gameBoard[1].moveRight();
			}
		});
		am.put("left2", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning() && !isGameEnded)
					gameBoard[1].moveLeft();
			}
		});
		am.put("up2", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning() && !isGameEnded)
					gameBoard[1].rotateBlock();
			}
		});
		am.put("down2", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning() && !isGameEnded)
					moveDown(1);
			}
		});
		am.put("space2", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning() && !isGameEnded)  {
					gameBoard[1].dropBlock();
					if(newBlock(1)){
						gameBoard[1].placeBlock();
					} else{
						if(!isGameEnded){
							gameBoard[1].placeBlock();
							gameBoard[1].drawBoard();
						}
					}
				}
			}
		});
		am.put("pause", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
			}
		});
	}

	protected void setTimer(int initInterval) {
		timer = new Timer(initInterval, e -> {
			for(int i=0;i<2;i++){
				pCountNum[i]++;
				int temp = (11-gameBoard[i].getLevel())<=0?1:(11-gameBoard[i].getLevel());
				if(pCountNum[i]>=temp) {
					moveDown(i);
					System.out.println("p"+i+": "+initInterval*pCountNum[i]);
					pCountNum[i] = 0;
				}
			}
			updateScore();
		});
		timer.start();
	}
	protected void setTimeAttackMode(){
		timeLabel = new JLabel[2];
		timeLabel[0] = new JLabel((exitTime-(currentTimeMillis()-startTime))+"");
		timeLabel[1] = new JLabel((exitTime-(currentTimeMillis()-startTime))+"");
		timeAttackTimer= new Timer(10, e -> {
			if(settingItem.isTimeAttackMode && currentTimeMillis()-startTime>exitTime){
				gameOver();
			} else {
				timeLabel[0].setText(((exitTime-(currentTimeMillis()-startTime))/1000)+"");
				timeLabel[1].setText(((exitTime-(currentTimeMillis()-startTime))/1000)+"");
			}
		});
		timeAttackTimer.start();
	}

	protected void updateScore() {
		for(int i=0;i<2;i++){
			scoreLabel[i].setText(String.format("%5s", gameBoard[i].getScore()+ "") + " ");
			lineLabel[i].setText(String.format("%5s", gameBoard[i].getLineNum() + "") + " ");
			int temp = (i==0)?1:0;
			if (gameBoard[i].getErasedLine().length > 1)
				gamePane[temp].setLines(gameBoard[i].getErasedLine());
			if (gameBoard[i].getLineNum() / 7 >= gameBoard[i].getLevel()) {
				gameBoard[i].setLevel(gameBoard[i].getLevel() + 1);
			}
		}
	}

	public void pause() {
		if (!timer.isRunning() && !isGameEnded) {
			timer.start();
			gameBoard[0].drawBoard();
			gameBoard[1].drawBoard();
		} else if(timer.isRunning() && !isGameEnded) {
			timer.stop();
			gameBoard[0].setGameBoardText("PAUSE");
			gameBoard[1].setGameBoardText("PAUSE");
		}
	}

	protected void moveDown(int i) {
		if (!gameBoard[i].moveDown()) {
			if(newBlock(i)){
				gameBoard[i].placeBlock();
			} else{
				gameBoard[i].placeBlock();
				gameBoard[i].drawBoard();
			}
		} else{
			gameBoard[i].placeBlock();
			gameBoard[i].drawBoard();
		}
	}

	protected boolean newBlock(int i) {
		gameBoard[i].placeBlock(); // 밑으로 내려가지 않게 고정
		if (gameBoard[i].isGameEnded()) {
			gameOver();
			return false;
		}
		setErasedLine(i);
		boolean isErased = gameBoard[i].eraseLine();

		gameBoard[i].curr = gameBoard[i].nextBlock;
		if(SettingItem.isItemMode && (gameBoard[i].lineNum/gameBoard[i].count >= gameBoard[i].lineChange)) {
			gameBoard[i].nextBlock = gameBoard[i].getRandomBlock.getItemBlock(gameBoard[i].modeName);
			gameBoard[i].count = gameBoard[i].count+1;
		} else {
			gameBoard[i].nextBlock = gameBoard[i].getRandomBlock.getRandomBlockMode(gameBoard[i].modeName);
		}
		gameBoard[i].x = 3;
		gameBoard[i].y = 0;
		gameBoard[i].nextBlockPane.drawNextBlockBoard(gameBoard[i].getNextBlock());
		return isErased;
	}

	protected void setErasedLine(int i){
		int temp = (i == 0) ? 1:0;
		gameBoard[i].gamePane.addLines(gameBoard[temp].erasedLine);
		gameBoard[temp].resetErasedLine();
		gamePane[i].setLines(gameBoard[temp].getErasedLine());
	}

	private void gameOver() {
		timer.stop();
		if(SettingItem.isTimeAttackMode)
			timeAttackTimer.stop();
		isGameEnded = true;
		setResultText();
	}

	private void setResultText() {
		String text = "draw";
		if(gameBoard[0].isGameEnded() && !gameBoard[1].isGameEnded()) {
			gameBoard[0].setGameBoardText("LOSE");
			gameBoard[1].setGameBoardText("WIN!");
			text = "player2 win";
		} else if(!gameBoard[0].isGameEnded() && gameBoard[1].isGameEnded()){
			gameBoard[0].setGameBoardText("WIN!");
			gameBoard[1].setGameBoardText("LOSE");
			text = "player1 win";
		} else{
			if(gameBoard[0].score>gameBoard[1].score){
				gameBoard[0].setGameBoardText("WIN!");
				gameBoard[1].setGameBoardText("LOSE");
				text = "player1 win";
			} else if(gameBoard[0].score<gameBoard[1].score){
				gameBoard[0].setGameBoardText("LOSE");
				gameBoard[1].setGameBoardText("WIN!");
				text = "player2 win";
			} else if(gameBoard[0].score==gameBoard[1].score){
				gameBoard[0].setGameBoardText("DRAW!");
				gameBoard[1].setGameBoardText("DRAW!");
			}
		}
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), text);
	}
	private void exitGame() {
		timer.stop();
		if(SettingItem.isTimeAttackMode)
			timeAttackTimer.stop();
		dispose();
	}

	private void btnExitActionPerformed() {
		exitGame();
		System.exit(0);
	}

	private void btnSettingActionPerformed() {
		exitGame();
		Tetris.showSettingMenu();
	}

	private void btnStartMenuActionPerformed() {
		exitGame();
		Tetris.showStartMenu();
	}

	private void btnRestartActionPerformed() {
		exitGame();
		try {
			Tetris.start(true,SettingItem.isItemMode,SettingItem.isTimeAttackMode);
			//to be edited
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}