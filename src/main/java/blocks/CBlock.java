package blocks;
import java.awt.Color;

public class CBlock extends Block {
	//Bomb block
	public CBlock() {
		shape = new int[][] { 
			{0,1,0},
			{1,1,1},
			{0,1,0},
		};
		item = "cross";
		color = "WHITE";
	}
}
