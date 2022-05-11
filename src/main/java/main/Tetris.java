package main;

import game.FightMenu;
import game.GameMenu;
import scoreboard.ScoreBoardMenu;
import setting.KeySetting;
import setting.SettingItem;
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

    public static void start(boolean isFightMode,boolean isItemMode,boolean isTimeAttackMode) throws IOException {
        if(!isFightMode){
            gameMenu = new GameMenu(isItemMode);
            gameMenu.setVisible(true);
        } else {
            gameForm = new FightMenu(isItemMode,isTimeAttackMode);
            gameForm.setVisible(true);
        }
    }

    public static void fightModeStart(boolean isItemMode, boolean isTimeAttackMode) throws IOException {
        gameForm = new FightMenu(isItemMode,isTimeAttackMode);
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
        settingMenuForm.dispose();
        try {
            settingMenuForm = new SettingMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        settingMenuForm.setVisible(true);
    }

    public static void showScoreBoard() {
        scoreBoardForm = new ScoreBoardMenu();
        scoreBoardForm.setVisible(true);
    }

    public static void showKeySetting(String keyType,int player) throws IOException {
        keySetting = new KeySetting(keyType,player);
        keySetting.setVisible(true);
    }

    public static void showUnderSetting(String keyType) throws IOException {
        int temp = SettingItem.isFightMode?1:0;
        keySetting = new KeySetting(keyType,temp);
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