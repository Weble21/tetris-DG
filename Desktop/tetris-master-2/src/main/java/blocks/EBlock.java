package blocks;

import java.awt.Color;

public class EBlock extends Block {

    public EBlock() {
        shape = new int[][]{
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 1}
        };
        item = "total";
        color = "WHITE";
    }

}