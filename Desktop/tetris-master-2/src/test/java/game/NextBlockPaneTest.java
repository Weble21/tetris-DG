package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import blocks.BBlock;
import blocks.Block;
import blocks.CBlock;
import blocks.EBlock;
import blocks.IBlock;
import blocks.JBlock;
import blocks.LBlock;
import blocks.OBlock;
import blocks.SBlock;
import blocks.TBlock;
import blocks.WBlock;
import blocks.ZBlock;

class NextBlockPaneTest {
	
	NextBlockPane targetGamePane = new NextBlockPane(false);
	NextBlockPane compareGamePane = new NextBlockPane(false);

	@Test
	public void placeBlock() {
		Block block = new JBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);

		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new BBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new CBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new EBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new IBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new JBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new LBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new OBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new SBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new TBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new WBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
		
		block = new ZBlock();
		targetGamePane.drawNextBlockBoard(block);
		compareGamePane.drawNextBlockBoard(block);
		
		Assert.assertEquals(targetGamePane.getText(), compareGamePane.getText());
	}
}
