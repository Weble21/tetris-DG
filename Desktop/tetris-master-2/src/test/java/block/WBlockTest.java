package block;

import blocks.BBlock;
import blocks.Block;
import blocks.WBlock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WBlockTest {

	private Block block = new WBlock();
	private Block block2 = new WBlock();

	@Test
	public void getShape() {
		Assert.assertEquals(0,block.getShape(block.height()+100,block.width()+100));
	}

	@Test
	public void rotate() {
		// Rotate the block 90 deg. clockwise
		block.rotate();
		block.rotate();
		block.rotate();
		block.rotate();

		for(int i=0;i<block2.height();i++)
			for(int j=0;j<block2.width();j++)
				Assert.assertEquals(block2.getShape(i,j),block.getShape(i,j));
	}
	@Test
	public void getItem(){
		Assert.assertEquals("weight",block.getItem());
	}

}
