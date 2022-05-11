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

	private SettingItem settingItem;

	private int size = 1;

	public SettingMenu() throws IOException {
		settingItem = SettingItem.getInstance();

		setTitle("Setting Menu");
		setSize(450, 720);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);

		//화면 크기 조절
		String[] sizeNames = { "SMALL", "MEDIUM", "LARGE" };
		sizeLabel = new JLabel("Screen width");
		sizeBtns = new JRadioButton[3];
		sizeBtnGroup = new ButtonGroup();

		for (int i = 0; i < sizeBtns.length; i++) {
			sizeBtns[i] = new JRadioButton(sizeNames[i]);
			sizeBtnGroup.add(sizeBtns[i]);
		}

		sizePanel = new JPanel(new GridLayout(0, 4));
		sizePanel.add(sizeLabel);
		for (JRadioButton sizeBtn : sizeBtns) {
			sizePanel.add(sizeBtn);
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

		JPanel keyPanel = new JPanel(new BorderLayout());
		keyPanel.add(new JLabel("Operation Key"), BorderLayout.NORTH);

		// 조작키 설정
		if(SettingItem.isFightMode){
			System.out.println("Fight mode");
			JPanel keySettingPanel1 = displayKeySetting(1);
			keyPanel.add(keySettingPanel1, BorderLayout.CENTER);
			JPanel keySettingPanel2 = displayKeySetting(2);
			keyPanel.add(keySettingPanel2, BorderLayout.SOUTH);
		} else {
			System.out.println("normal mode");
			JPanel keySettingPanel = displayKeySetting(0);
			keyPanel.add(keySettingPanel, BorderLayout.CENTER);
		}


		// 난이도 설정
		String[] modeNames = { "EASY", "NORMAL", "HARD" };
		modeLabel = new JLabel("LEVEL");
		modeBtns = new JRadioButton[3];
		modeBtnGroup = new ButtonGroup();

		for (int i = 0; i < modeBtns.length; i++) {
			modeBtns[i] = new JRadioButton(modeNames[i]);
			modeBtnGroup.add(modeBtns[i]);
		}

		modePanel = new JPanel(new GridLayout(0, 4));
		modePanel.add(modeLabel);
		for (JRadioButton modeBtn : modeBtns) {
			modePanel.add(modeBtn);
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
		colorBlindLabel = new JLabel("Color Blind Mode");
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
		initScoreBoardBtn = new JButton("Scoreboard Reset");
		initScoreBoardBtn.addActionListener(e -> settingItem.btnInitScoreBoardActionPerformed());
		initScoreBoardPanel = new JPanel();
		initScoreBoardPanel.add(initScoreBoardBtn);

		// 게임 시작 버튼, 시작 메뉴 버튼 & 이벤트 설정
		gameBtn = new JButton("Game");
		startMenuBtn = new JButton("Start Menu");
		initSettingBtn = new JButton("Reset Setting");
		saveSettingBtn = new JButton("Save Setting");

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
			JOptionPane.showMessageDialog(initScoreBoardPanel, "Settings have been saved.");
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

	public JPanel displayKeySetting(int player) {

		JButton leftKey = new JButton("LEFT");
		JButton rightKey = new JButton("RIGHT");
		JButton downKey = new JButton("DOWN");
		JButton rotateKey = new JButton("ROTATE");
		JButton dropKey = new JButton("DROP");

		leftKey.addActionListener(e -> {
			try {
				btnDisplayLeftKeySettingActionPerformed("LEFT",player);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		rightKey.addActionListener(e -> {
			try {
				btnDisplayRightKeySettingActionPerformed("RIGHT",player);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		downKey.addActionListener(e -> {
			try {
				btnDisplayDownKeySettingActionPerformed("DOWN",player);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		rotateKey.addActionListener(e -> {
			try {
				btnDisplayRotateKeySettingActionPerformed("ROTATE",player);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});
		dropKey.addActionListener(e -> {
			try {
				btnDisplayDropKeySettingActionPerformed("DROP",player);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		});

		JPanel keySettingPanel = new JPanel();
		keySettingPanel.add(leftKey);
		keySettingPanel.add(rightKey);
		keySettingPanel.add(downKey);
		keySettingPanel.add(rotateKey);
		keySettingPanel.add(dropKey);

		return keySettingPanel;
	}

	private void btnInitActionPerformed() {
		settingItem.initKeySetting();
	}

	public void btnDisplayLeftKeySettingActionPerformed(String keyType, int player) throws IOException{
		Tetris.showKeySetting(keyType,player);
	}

	public void btnDisplayRightKeySettingActionPerformed(String keyType, int player) throws IOException{
		Tetris.showKeySetting(keyType,player);
	}

	public void btnDisplayDownKeySettingActionPerformed(String keyType, int player) throws IOException{
		Tetris.showKeySetting(keyType,player);
	}

	public void btnDisplayDropKeySettingActionPerformed(String keyType,int player) throws IOException{
		Tetris.showKeySetting(keyType,player);
	}

	public void btnDisplayRotateKeySettingActionPerformed(String keyType, int player) throws IOException{
		Tetris.showKeySetting(keyType,player);
	}

	public void btnGameActionPerformed() throws IOException {
		dispose();
		Tetris.start(SettingItem.isFightMode,SettingItem.isItemMode,SettingItem.isTimeAttackMode);
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

		JOptionPane.showMessageDialog(initScoreBoardPanel, "Settings have been reset.");
	}
}