package game;

import org.junit.Test;
import setting.SettingItem;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class KeySettingTest {
    GameBoard gameBoard;
    GameBoard gameBoard2;
    SettingItem settingItem;

    public KeySettingTest() throws IOException {
        gameBoard = new GameBoard();
        gameBoard2 = new GameBoard();
        gameBoard2 = gameBoard;
        settingItem = SettingItem.getInstance();
    }

    @Test
    public void upKeysettingTest(){
        gameBoard.dispatchEvent(
                new KeyEvent(gameBoard, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, settingItem.getRotateKey().charAt(0)));
        gameBoard2.rotateBlock();
        assertEquals(gameBoard.gamePane, gameBoard2.gamePane);
    }

    @Test
    public void downKeysettingTest(){
        gameBoard.dispatchEvent(
                new KeyEvent(gameBoard, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, settingItem.getDownKey().charAt(0)));
        gameBoard2.moveDown();
        assertEquals(gameBoard.gamePane, gameBoard2.gamePane);
    }

    @Test
    public void leftKeysettingTest(){
        gameBoard.dispatchEvent(
                new KeyEvent(gameBoard, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, settingItem.getLeftKey().charAt(0)));
        gameBoard2.moveLeft();
        assertEquals(gameBoard.gamePane, gameBoard2.gamePane);
    }

    @Test
    public void rightKeysettingTest(){
        gameBoard.dispatchEvent(
                new KeyEvent(gameBoard, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, settingItem.getRightKey().charAt(0)));
        gameBoard2.moveRight();
        assertEquals(gameBoard.gamePane, gameBoard2.gamePane);
    }

    @Test
    public void dropKeysettingTest(){
        gameBoard.dispatchEvent(
                new KeyEvent(gameBoard, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, settingItem.getDropKey().charAt(0)));
        gameBoard2.dropBlock();
        assertEquals(gameBoard.gamePane, gameBoard2.gamePane);
    }
}
