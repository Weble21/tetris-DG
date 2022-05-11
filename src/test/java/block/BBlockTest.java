package block;

import blocks.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BBlockTest {

	private Block block = new BBlock();
	private Block block2 = new BBlock();

	@Test
	public void getShape() {
		Assert.assertEquals(0,block.getShape(block.height()+100,block.width()+100));
	}

	@Test
	public void setShape(){
		block.setShape(100,100,1);
		Assert.assertEquals(0,block.getShape(100,100));
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
