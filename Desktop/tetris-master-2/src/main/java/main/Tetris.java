package main;

import game.FightMenu;
import game.GameMenu;
import game.ItemGameBoard;
import scoreboard.ScoreBoardMenu;
import setting.KeySetting;
import setting.SettingMenu;
import component.StartMenu;

import java.awt.*;
import java.io.IOException;

public class Tetris {
    private static FightMenu gameForm;
    private static GameMenu gameMenu;
    private static StartMenu startmenu;
    private static SettingMenu settingMenuForm;
    private static KeySetting keySetting;
    private static ScoreBoardMenu scoreBoardForm;

    public static void start() throws IOException {
        System.out.println("NORMAL MODE");
        gameForm = new FightMenu(true,false);
        //gameMenu = new GameMenu(false);
        gameForm.setVisible(true);
    }

    public static void itemGameStart() throws IOException {
        System.out.println("ITEM MODE");
        gameMenu = new GameMenu(true);
        gameMenu.setVisible(true);
    }

    public static void fightModeStart() throws IOException {
        System.out.println("ITEM MODE");
        gameForm = new FightMenu(true,false);
        gameForm.setVisible(true);
    }

    public static void disposeGameMenu() {
        gameForm.dispose();
    }

    public static void showStartMenu() {
        startmenu.dispose();
        startmenu = new StartMenu();
    }

    public static void showSettingMenu() {
        settingMenuForm.setVisible(true);
    }

    public static void showScoreBoard() {
        scoreBoardForm = new ScoreBoardMenu();
        scoreBoardForm.setVisible(true);
    }

    public static void showKeySetting(String keyType) throws IOException {
        keySetting = new KeySetting(keyType);
        keySetting.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            startmenu = new StartMenu();
            try {
                settingMenuForm = new SettingMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            startmenu.setVisible(true);
        });
    }
}