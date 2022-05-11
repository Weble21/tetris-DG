package block;

import blocks.BBlock;
import blocks.Block;
import blocks.CBlock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CBlockTest {

	private Block block = new CBlock();
	private Block block2 = new CBlock();

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
}
