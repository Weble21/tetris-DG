package component;


import main.Tetris;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image screenImage;
	private Graphics screenGraphic;
	private ClassLoader cl = this.getClass().getClassLoader();

	private Image tetrisBackground = new ImageIcon("images/tetrisBackground.png")
			.getImage();

	private ImageIcon menuStartClicked = new ImageIcon("images/menuStartClicked.png");
	private ImageIcon menuStartPressed = new ImageIcon("images/menuStartClicked.png");
	private ImageIcon menuStartBasic = new ImageIcon("images/menuStart.png");
	private JButton menuStart = new JButton(menuStartBasic);

	private ImageIcon menuOptionClicked = new ImageIcon("images/menuOptionClicked.png");
	private ImageIcon menuOptionBasic = new ImageIcon("images/menuOption.png");
	private JButton menuOption = new JButton(menuOptionBasic);

	private ImageIcon menuSBClicked = new ImageIcon("images/menuSBClicked.png");
	private ImageIcon menuSBBasic = new ImageIcon("images/menuSB.png");
	private JButton menuSB = new JButton(menuSBBasic);

	private ImageIcon menuExitClicked = new ImageIcon("images/menuExitClicked.png");
	private ImageIcon menuExitBasic = new ImageIcon("images/menuExit.png");
	private JButton menuExit = new JButton(menuExitBasic);

	private ImageIcon iconClicked = new ImageIcon("images/tetrisIconClicked.png");
	private ImageIcon iconBasic = new ImageIcon("images/tetrisIcon.png");
	private JButton icon = new JButton(iconBasic);

	private ImageIcon itemStartClicked = new ImageIcon("images/itemStartClicked.png");
	private ImageIcon itemStartBasic = new ImageIcon("images/itemStart.png");
	private JButton itemStart = new JButton(itemStartBasic);

	private ImageIcon normalStartClicked = new ImageIcon("images/normalStartClicked.png");
	private ImageIcon normalStartBasic = new ImageIcon("images/normalStart.png");
	private JButton normalStart = new JButton(normalStartBasic);

	int cnt = 0;
	int step = 0;

	public StartMenu() {
		// basic
		// setUndecorated(true);
		JPanel imagepanel = new ImagePanel(tetrisBackground);
		add(imagepanel);
		setTitle("Tetris Game");
		setSize(350, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		imagepanel.add(menuStart);
		imagepanel.add(itemStart);
		imagepanel.add(normalStart);
		imagepanel.add(menuOption);
		imagepanel.add(menuSB);
		imagepanel.add(menuExit);
		imagepanel.add(icon);
		setVisible(true);
		menuStart.requestFocus();

		itemStart.setBounds(115, 335, 130, 40);
		itemStart.setBorderPainted(false);
		itemStart.setContentAreaFilled(false);
		itemStart.setFocusPainted(false);
		itemStart.setVisible(false);
		itemStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuStart.setIcon(menuStartBasic);
				itemStart.setIcon(itemStartClicked);
				normalStart.setIcon(normalStartBasic);
				menuOption.setIcon(menuOptionBasic);
				menuSB.setIcon(menuSBBasic);
				menuExit.setIcon(menuExitBasic);
				itemStart.setCursor(new Cursor(HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				itemStart.setIcon(itemStartBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				try {
					Tetris.itemGameStart();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				// item start
			}
		});

		normalStart.setBounds(115, 380, 130, 40);
		normalStart.setBorderPainted(false);
		normalStart.setContentAreaFilled(false);
		normalStart.setFocusPainted(false);
		normalStart.setVisible(false);
		normalStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuStart.setIcon(menuStartBasic);
				itemStart.setIcon(itemStartBasic);
				normalStart.setIcon(normalStartClicked);
				menuOption.setIcon(menuOptionBasic);
				menuSB.setIcon(menuSBBasic);
				menuExit.setIcon(menuExitBasic);
				normalStart.setCursor(new Cursor(HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				normalStart.setIcon(normalStartBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				try {
					Tetris.start();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				// normal start
			}
		});

		// start menu
		menuStart.setBounds(115, 425, 130, 40);
		menuStart.setBorderPainted(false);
		menuStart.setContentAreaFilled(false);
		menuStart.setFocusPainted(false);
		menuStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuStart.setIcon(menuStartClicked);
				menuOption.setIcon(menuOptionBasic);
				menuSB.setIcon(menuSBBasic);
				menuExit.setIcon(menuExitBasic);
				menuStart.setCursor(new Cursor(HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				menuStart.setIcon(menuStartBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (cnt == 0) {
					menuStart.setIcon(menuStartPressed);
					normalStart.setVisible(true);
					itemStart.setVisible(true);
					cnt++;
				} else {
					menuStart.setIcon(menuStartBasic);
					itemStart.setVisible(false);
					normalStart.setVisible(false);
					cnt--;
				}

			}
		});

		menuStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 37:
					System.out.println("left");
					menuStart.setIcon(menuStartBasic);
					menuOption.setIcon(menuOptionClicked);
					menuSB.setIcon(menuSBBasic);
					menuExit.setIcon(menuExitBasic);
					break;
				case 38:
					System.out.println("up");
					if (cnt == 0) {
						menuStart.setIcon(menuStartClicked);
						menuOption.setIcon(menuOptionBasic);
						menuSB.setIcon(menuSBBasic);
						menuExit.setIcon(menuExitBasic);
						step = 0;
					} else {
						if (step < 2)
							step++;
						if (step == 1) {
							normalStart.setIcon(normalStartClicked);
							menuStart.setIcon(menuStartBasic);
							itemStart.setIcon(itemStartBasic);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitBasic);
						}
						if (step == 2) {
							normalStart.setIcon(normalStartBasic);
							menuStart.setIcon(menuStartBasic);
							itemStart.setIcon(itemStartClicked);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitBasic);
						}
						if (step == 0) {
							normalStart.setIcon(normalStartBasic);
							menuStart.setIcon(menuStartClicked);
							itemStart.setIcon(itemStartBasic);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitBasic);
						}
						
					}

					break;
				case 39:
					setFocusable(true);
					System.out.println("right");
					menuStart.setIcon(menuStartBasic);
					menuOption.setIcon(menuOptionBasic);
					menuSB.setIcon(menuSBClicked);
					menuExit.setIcon(menuExitBasic);
					break;
				case 40:
					System.out.println("down");
					if (cnt == 0 && step == 0) {
						System.out.println("down");
						menuStart.setIcon(menuStartBasic);
						menuOption.setIcon(menuOptionBasic);
						menuSB.setIcon(menuSBBasic);
						menuExit.setIcon(menuExitClicked);
					} 
					else {
						if (step > -1)
							step--;
						if (step == 1) {
							normalStart.setIcon(normalStartClicked);
							menuStart.setIcon(menuStartBasic);
							itemStart.setIcon(itemStartBasic);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitBasic);
						}
						if (step == 2) {
							normalStart.setIcon(normalStartBasic);
							menuStart.setIcon(menuStartBasic);
							itemStart.setIcon(itemStartClicked);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitBasic);
						}
						if(step == 0) {
							normalStart.setIcon(normalStartBasic);
							menuStart.setIcon(menuStartClicked);
							itemStart.setIcon(itemStartBasic);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitBasic);
						}
						if(step == -1) {
							normalStart.setIcon(normalStartBasic);
							menuStart.setIcon(menuStartBasic);
							itemStart.setIcon(itemStartBasic);
							menuOption.setIcon(menuOptionBasic);
							menuSB.setIcon(menuSBBasic);
							menuExit.setIcon(menuExitClicked);
						}
						
					}
					break;
				case KeyEvent.VK_ENTER:
					break;
				case KeyEvent.VK_SPACE:
					break;
				default:
					JOptionPane alertNo = new JOptionPane();
					alertNo.showMessageDialog(null,
							"↑ : SELECT START \n" + "← : SELECT OPTION \n" + "→ : SELECT SCORE BOARD \n"
 		                           + "↓ : SELCET EXIT \n" + "Enter, Space Bar : EXCUTE SELECTED OPTION",
							"Key Reminder", JOptionPane.PLAIN_MESSAGE);
					break;
				}
				if ((e.getKeyCode() == KeyEvent.VK_ENTER) || (e.getKeyCode() == KeyEvent.VK_SPACE)) {
					if (itemStart.getIcon() == itemStartClicked) {
						dispose();
						try {
							Tetris.itemGameStart();
						} catch (IOException ioException) {
							ioException.printStackTrace();
						}
						// item mode start
					}
					if (normalStart.getIcon() == normalStartClicked) {
						dispose();
						try {
							Tetris.start();
						} catch (IOException ioException) {
							ioException.printStackTrace();
						}
						// normal mode start
					}
					if (menuStart.getIcon() == menuStartClicked) {

						if (cnt == 0) {
							menuStart.setIcon(menuStartPressed);
							itemStart.setVisible(true);
							normalStart.setVisible(true);
							cnt++;
						} else {
							menuStart.setIcon(menuStartBasic);
							itemStart.setVisible(false);
							normalStart.setVisible(false);
							cnt--;
						}

					}
					if (menuOption.getIcon() == menuOptionClicked) {
						dispose();
						main.Tetris.showSettingMenu();
					}
					if (menuSB.getIcon() == menuSBClicked) {
						dispose();
						main.Tetris.showScoreBoard();
					}
					if (menuExit.getIcon() == menuExitClicked) {
						System.exit(1);
					}
				}
			}
		});

		// options menu
		menuOption.setBounds(10, 490, 130, 40);
		menuOption.setBorderPainted(false);
		menuOption.setContentAreaFilled(false);
		menuOption.setFocusPainted(false);
		menuOption.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				menuStart.setIcon(menuStartBasic);
				menuOption.setIcon(menuOptionClicked);
				menuSB.setIcon(menuSBBasic);
				menuExit.setIcon(menuExitBasic);
				menuOption.setCursor(new Cursor(HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				menuOption.setIcon(menuOptionBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				main.Tetris.showSettingMenu();
			}
		});

		// tetrisIcon
		icon.setBounds(160, 490, 40, 40);
		icon.setBorderPainted(false);
		icon.setContentAreaFilled(false);
		icon.setFocusPainted(false);
		icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon.setIcon(iconClicked);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon.setIcon(iconBasic);
			}
		});

		// score_board menu
		menuSB.setBounds(220, 490, 130, 40);
		menuSB.setBorderPainted(false);
		menuSB.setContentAreaFilled(false);
		menuSB.setFocusPainted(false);
		menuSB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuStart.setIcon(menuStartBasic);
				menuOption.setIcon(menuOptionBasic);
				menuSB.setIcon(menuSBClicked);
				menuExit.setIcon(menuExitBasic);
				menuSB.setCursor(new Cursor(HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				menuSB.setIcon(menuSBBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				main.Tetris.showScoreBoard();
			}
		});

		// exit menu
		menuExit.setBounds(115, 555, 130, 40);
		menuExit.setBorderPainted(false);
		menuExit.setContentAreaFilled(false);
		menuExit.setFocusPainted(false);
		menuExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuStart.setIcon(menuStartBasic);
				menuOption.setIcon(menuOptionBasic);
				menuSB.setIcon(menuSBBasic);
				menuExit.setIcon(menuExitClicked);
				menuExit.setCursor(new Cursor(HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuExit.setIcon(menuExitBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(1);
			}
		});
	}

	public void paint(Graphics g) {
		screenImage = createImage(400, 800);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(tetrisBackground, 0, 0, null);
		paintComponents(g);
	}
}