package blocks;
import java.awt.Color;

public class WBlock extends Block {
	
	public WBlock() {
		shape = new int[][] { 
			{0, 1, 1, 0},
			{1, 1, 1, 1}
		};
		item = "weight";
		color = "WHITE";
	}
	
	
}
