package blocks;
import java.awt.Color;

public class BBlock extends Block {
	//Bomb block
	public BBlock() {
		shape = new int[][] {
				{1,1},
				{1,1},
		};
		item = "bomb";
		color = "WHITE";
	}
}
