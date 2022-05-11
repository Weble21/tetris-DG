package game;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import blocks.Block;

public class GameBoardTest {
    GameBoard gameBoard = new GameBoard();
    public GameBoardTest() throws IOException {}

    @Test
    public void moveRight(){
    	int X = gameBoard.x;
    	int Y = gameBoard.y;
    	gameBoard.moveRight();
    	
    	Assert.assertEquals(gameBoard.x, X+1);
    	Assert.assertEquals(gameBoard.y, Y);
    }
    
    @Test
    public void moveLeft(){
    	int X = gameBoard.x;
    	int Y = gameBoard.y;
    	gameBoard.moveLeft();
    	
    	Assert.assertEquals(gameBoard.x, X-1);
    	Assert.assertEquals(gameBoard.y, Y);
    	
    }
    
    @Test
    public void moveDown(){
    	int X = gameBoard.x;
    	int Y = gameBoard.y;
    	gameBoard.moveDown();
    	
    	Assert.assertEquals(gameBoard.x, X);
    	Assert.assertEquals(gameBoard.y, Y+1);
    }
    
    @Test
    public void rotateBlock(){
    	Block block = gameBoard.curr;
    	
    	gameBoard.rotateBlock();
    	//Assert.assertNotSame(block.getShape(), gameBoard.curr.getShape());
    	gameBoard.rotateBlock();
    	//Assert.assertNotSame(block.getShape(), gameBoard.curr.getShape());
    	gameBoard.rotateBlock();
    	//Assert.assertNotSame(block.getShape(), gameBoard.curr.getShape());
    	gameBoard.rotateBlock();
    	Assert.assertArrayEquals(block.getShape(), gameBoard.curr.getShape());


		gameBoard.x=10;
		gameBoard.y=20;
		gameBoard.rotateBlock();
		Assert.assertArrayEquals(block.getShape(), gameBoard.curr.getShape());
    }
    
    @Test
    public void newBlock() {
    	Block block = gameBoard.curr;
    	Assert.assertSame(block, gameBoard.curr);
    }

	@Test
	public void setGameBoardText() {
		String temp = gameBoard.gamePane.getText();
		Assert.assertEquals(temp, gameBoard.gamePane.getText().toString());
		gameBoard.setGameBoardText("hello");
		StringBuilder letter = new StringBuilder();
		for(int i=0;i<9;i++)
			letter.append("          \n");
		int num = 10 - "hello".length();
		for(int i=0;i<num / 2;i++)
			letter.append(" ");
		letter.append("hello");
		for(int i=0;i<num / 2;i++)
			letter.append(" ");
		letter.append("\n");
		for(int i=0;i<9;i++)
			letter.append("          \n");

		System.out.println(letter);
		System.out.println(gameBoard.gamePane.getText());
		Assert.assertEquals(letter.toString(), gameBoard.gamePane.getText().toString());

		temp = gameBoard.gamePane.getText();
		gameBoard.setGameBoardText("                       ");
		Assert.assertEquals(temp, gameBoard.gamePane.getText().toString());
	}

	@Test
	public void setLevel(){
		int level = 100;
		gameBoard.setLevel(100);
		Assert.assertEquals(100,gameBoard.getLevel());
	}

	@Test
	public void eraseLine(){
		gameBoard.gamePane.eraseCurr(gameBoard.x,gameBoard.y,gameBoard.curr);
		gameBoard.drawBoard();
		String temp = gameBoard.gamePane.getText();
		int lines [][] = new int[10][10];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				lines[i][j] = 1;
		gameBoard.gamePane.addLines(lines);
		gameBoard.eraseLine();
		Assert.assertEquals(temp, gameBoard.gamePane.getText());
	}
}
