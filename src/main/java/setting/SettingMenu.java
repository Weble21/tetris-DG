package setting;

import main.Tetris;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SettingMenu extends JFrame {

	private JLabel sizeLabel;
	private JRadioButton[] sizeBtns;
	private ButtonGroup sizeBtnGroup;
	private JPanel sizePanel;
	private JPanel keyPanel;
	private JPanel keySettingPanel;
	private JButton gameBtn;
	private JButton startMenuBtn;
	private JButton initSettingBtn;
	private JButton saveSettingBtn;
	private JLabel colorBlindLabel;
	private JRadioButton colorBlindOnBtn;
	private JRadioButton colorBlindOffBtn;
	private ButtonGroup colorBlindBtnGroup;
	private JButton initScoreBoardBtn;
	private JPanel initScoreBoardPanel;
	private JPanel settingBtnPanel;
	private JLabel modeLabel;
	private ButtonGroup modeBtnGroup;
	private JRadioButton[] modeBtns;
	private JPanel modePanel;
	private JButton initKeySettingBtn;
	private SettingItem settingItem;
	private KeySetting keySetting;
	private int size = 1;

	public SettingMenu() throws IOException {
		settingItem = SettingItem.getInstance();

<<<<<<< HEAD
		setTitle("Setting Menu");
=======
		setTitle("설정메뉴");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		setSize(450, 720);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);

<<<<<<< HEAD
		//화면 크기 조절
		String[] sizeNames = { "SMALL", "MEDIUM", "LARGE" };
		sizeLabel = new JLabel("Screen width");
=======
		// 화면 크기 조절
		String[] sizeNames = { "SMALL", "MEDIUM", "LARGE" };
		sizeLabel = new JLabel("화면 크기");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		sizeBtns = new JRadioButton[3];
		sizeBtnGroup = new ButtonGroup();

		for (int i = 0; i < sizeBtns.length; i++) {
			sizeBtns[i] = new JRadioButton(sizeNames[i]);
			sizeBtnGroup.add(sizeBtns[i]);
		}

		sizePanel = new JPanel(new GridLayout(0, 4));
		sizePanel.add(sizeLabel);
		for (int i = 0; i < sizeBtns.length; i++) {
			sizePanel.add(sizeBtns[i]);
		}
		sizeBtns[0].addActionListener(e -> settingItem.btnSmallBtnActionPerformed());
		sizeBtns[1].addActionListener(e -> settingItem.btnMediumBtnActionPerformed());
		sizeBtns[2].addActionListener(e -> settingItem.btnLargeBtnActionPerformed());

		switch (settingItem.getBoardWidth()){
			case SettingItem.SMALL_WIDTH:
				sizeBtns[0].setSelected(true);
				break;
			case SettingItem.MEDIUM_WIDTH:
				sizeBtns[1].setSelected(true);
				break;
			case SettingItem.LARGE_WIDTH:
				sizeBtns[2].setSelected(true);
				break;
		}

		// 조작키 설정
		keyPanel = new JPanel(new BorderLayout());
		keySettingPanel = displayKeySetting();
<<<<<<< HEAD
		keyPanel.add(new JLabel("Operation Key"), BorderLayout.NORTH);
=======
		keyPanel.add(new JLabel("조작키 설정"), BorderLayout.NORTH);
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		keyPanel.add(keySettingPanel, BorderLayout.CENTER);

		// 난이도 설정
		String[] modeNames = { "EASY", "NORMAL", "HARD" };
<<<<<<< HEAD
		modeLabel = new JLabel("LEVEL");
=======
		modeLabel = new JLabel("난이도 설정");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		modeBtns = new JRadioButton[3];
		modeBtnGroup = new ButtonGroup();

		for (int i = 0; i < modeBtns.length; i++) {
			modeBtns[i] = new JRadioButton(modeNames[i]);
			modeBtnGroup.add(modeBtns[i]);
		}

		modePanel = new JPanel(new GridLayout(0, 4));
		modePanel.add(modeLabel);
		for (int i = 0; i < modeBtns.length; i++) {
			modePanel.add(modeBtns[i]);
		}
		modeBtns[0].addActionListener(e -> settingItem.btnEasyModeActionPerformed());
		modeBtns[1].addActionListener(e -> settingItem.btnNormalModeActionPerformed());
		modeBtns[2].addActionListener(e -> settingItem.btnHardModeActionPerformed());

		switch (settingItem.getModeName()){
			case "EASY":
				modeBtns[0].setSelected(true);
				break;
			case "NORMAL":
				modeBtns[1].setSelected(true);
				break;
			case "HARD":
				modeBtns[2].setSelected(true);
				break;
		}

		// 색맹 모드 켜고 끄기
<<<<<<< HEAD
		colorBlindLabel = new JLabel("Color Blind Mode");
=======
		colorBlindLabel = new JLabel("색맹 모드");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		colorBlindOnBtn = new JRadioButton("on");
		colorBlindOffBtn = new JRadioButton("off");

		colorBlindBtnGroup = new ButtonGroup();
		colorBlindBtnGroup.add(colorBlindOnBtn);
		colorBlindBtnGroup.add(colorBlindOffBtn);

		colorBlindOnBtn.addActionListener(e -> settingItem.btnColorBlindOnActionPerformed());
		colorBlindOffBtn.addActionListener(e -> settingItem.btnColorBlindOffActionPerformed());

		JPanel colorBlindPanel = new JPanel(new GridLayout(0, 3));
		colorBlindPanel.add(colorBlindLabel);
		colorBlindPanel.add(colorBlindOnBtn);
		colorBlindPanel.add(colorBlindOffBtn);

		if(settingItem.isColorBlind()){
			colorBlindOnBtn.setSelected(true);
		} else {
			colorBlindOffBtn.setSelected(true);
		}

		// 스코어 보드 기록 초기화
<<<<<<< HEAD
		initScoreBoardBtn = new JButton("Scoreboard Reset");
=======
		initScoreBoardBtn = new JButton("스코어 보드 기록 초기화");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		initScoreBoardBtn.addActionListener(e -> settingItem.btnInitScoreBoardActionPerformed());

		initScoreBoardPanel = new JPanel();
		initScoreBoardPanel.add(initScoreBoardBtn);

		// 게임 시작 버튼, 시작 메뉴 버튼 & 이벤트 설정
<<<<<<< HEAD
		gameBtn = new JButton("Game");
		startMenuBtn = new JButton("Start Menu");
		initSettingBtn = new JButton("Reset Setting");
		saveSettingBtn = new JButton("Save Setting");
=======
		gameBtn = new JButton("게임으로");
		startMenuBtn = new JButton("시작메뉴로");
		initSettingBtn = new JButton("설정 초기화");
		saveSettingBtn = new JButton("설정 저장");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8

		gameBtn.addActionListener(e -> {
			try {
				btnGameActionPerformed();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		startMenuBtn.addActionListener(e -> btnStartMenuActionPerformed());
		initSettingBtn.addActionListener(e -> btnInitSettingActionPerformed());
		saveSettingBtn.addActionListener(e -> {
			try {
				settingItem.btnSaveSettingActionPerformed();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
<<<<<<< HEAD
			JOptionPane.showMessageDialog(initScoreBoardPanel, "Settings have been saved.");
=======
			JOptionPane.showMessageDialog(initScoreBoardPanel, "설정이 저장되었습니다.");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		});

		settingBtnPanel = new JPanel(new GridLayout(5, 0));
		settingBtnPanel.add(gameBtn);
		settingBtnPanel.add(startMenuBtn);
		settingBtnPanel.add(initSettingBtn);
		settingBtnPanel.add(saveSettingBtn);

		// panel 추가
		this.getContentPane().setLayout(new GridLayout(6, 0));
		this.getContentPane().add(sizePanel);
		this.getContentPane().add(keyPanel);
		this.getContentPane().add(modePanel);
		this.getContentPane().add(initScoreBoardPanel);
		this.getContentPane().add(colorBlindPanel);
		this.getContentPane().add(settingBtnPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JPanel displayKeySetting() {

		JButton leftKey = new JButton("LEFT");
		JButton rightKey = new JButton("RIGHT");
		JButton downKey = new JButton("DOWN");
		JButton rotateKey = new JButton("ROTATE");
		JButton dropKey = new JButton("DROP");
<<<<<<< HEAD
		JButton initKey = new JButton("RESET");
=======
		JButton initKey = new JButton("초기화");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8

		leftKey.addActionListener(e -> {
			try {
				btnDisplayLeftKeySettingActionPerformed("LEFT");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		rightKey.addActionListener(e -> {
			try {
				btnDisplayRightKeySettingActionPerformed("RIGHT");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		downKey.addActionListener(e -> {
			try {
				btnDisplayDownKeySettingActionPerformed("DOWN");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		rotateKey.addActionListener(e -> {
			try {
				btnDisplayRotateKeySettingActionPerformed("ROTATE");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		dropKey.addActionListener(e -> {
			try {
				btnDisplayDropKeySettingActionPerformed("DROP");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		initKey.addActionListener(e -> {
			btnInitActionPerformed();
<<<<<<< HEAD
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Reset Keys");
=======
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "키 초기화");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
		});

		JPanel keySettingPanel = new JPanel();
		keySettingPanel.add(leftKey);
		keySettingPanel.add(rightKey);
		keySettingPanel.add(downKey);
		keySettingPanel.add(rotateKey);
		keySettingPanel.add(dropKey);
		keySettingPanel.add(initKey);
		return keySettingPanel;
	}

	private void btnInitActionPerformed() {
		settingItem.initKeySetting();
	}

	public void btnDisplayLeftKeySettingActionPerformed(String keyType) throws IOException{
		this.dispose();
		Tetris.showKeySetting(keyType);
	}

	public void btnDisplayRightKeySettingActionPerformed(String keyType) throws IOException{
		this.dispose();
		Tetris.showKeySetting(keyType);
	}

	public void btnDisplayDownKeySettingActionPerformed(String keyType) throws IOException{
		this.dispose();
		Tetris.showKeySetting(keyType);
	}

	public void btnDisplayDropKeySettingActionPerformed(String keyType) throws IOException{
		this.dispose();
		Tetris.showKeySetting(keyType);
	}

	public void btnDisplayRotateKeySettingActionPerformed(String keyType) throws IOException{
		this.dispose();
		Tetris.showKeySetting(keyType);
	}

	public void btnGameActionPerformed() throws IOException {
		dispose();
		if(SettingItem.isItemMode){
			Tetris.itemGameStart();
		}else{
			Tetris.start();
		}
	}

	public void btnStartMenuActionPerformed() {
		dispose();
		Tetris.showStartMenu();
	}

	/**
	 * 설정 초기화
	 */
	public void btnInitSettingActionPerformed() {
		settingItem.btnMediumBtnActionPerformed();
		sizeBtns[1].setSelected(true);

		settingItem.btnColorBlindOffActionPerformed();
		colorBlindOffBtn.setSelected(true);

		settingItem.btnNormalModeActionPerformed();
		modeBtns[1].setSelected(true);

		settingItem.initKeySetting();
<<<<<<< HEAD
		JOptionPane.showMessageDialog(initScoreBoardPanel, "Settings have been reset.");
=======
		JOptionPane.showMessageDialog(initScoreBoardPanel, "설정이 초기화되었습니다.");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
	}
}