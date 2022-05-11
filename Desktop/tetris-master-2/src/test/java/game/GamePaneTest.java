package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import blocks.*;
import blocks.GetRandomBlock;
import game.GamePane;

class GamePaneTest {

	GamePane targetGamePane = new GamePane(false);
	GamePane compareGamePane = new GamePane(true);
	GamePane sideGamePane = new GamePane();
	
	@Test
	public void placeBlock() {
		Block block = new JBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);

		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new BBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new CBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new EBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new IBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new JBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new LBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new OBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new SBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new TBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new WBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new ZBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
	}
	
	@Test
	public void eraseCurr() {
		Block block = new JBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new BBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new CBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new EBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new IBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new JBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new LBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new OBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new SBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new TBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new WBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new ZBlock();
		targetGamePane.placeBlock(5, 5, block);
		compareGamePane.placeBlock(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		targetGamePane.eraseCurr(5, 5, block);
		compareGamePane.eraseCurr(5, 5, block);
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
	}

	@Test
	public void setLines(){
		int lines [][] = new int[5][10];
		for(int i=0;i<5;i++)
			for(int j=0;j<10;j++)
				lines[i][j] = 1;

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Math.max(0, 10 - lines.length);i++)
			sb.append("          \n");
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[i].length; j++) {
				sb.append("O");
			}
			if (i != lines.length-1) sb.append("\n");
		}

		sideGamePane.setLines(lines);

		Assert.assertEquals(sb.toString(), sideGamePane.getText());
	}

}
