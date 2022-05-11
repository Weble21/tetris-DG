package blocks;

public abstract class Block {

	protected int[][] shape;
	protected String color;
	protected String item;

	public Block() {
		shape = new int[][] { { 1, 1 }, { 1, 1 } };
		color = "YELLOW";
	}

	public int getShape(int x, int y) {
		if(x<0||y<0||y>=shape.length||x>=shape[0].length)
			return 0;
		return shape[y][x];
	}

	public String getColor() {
		return color;
	}

	public String getItem() {
		return item;
	}

	public void setShape(int x, int y, int value) {
		if(x>=shape[0].length||y>=shape.length)
			return;
		shape[y][x] = value;
	}
	public void setItem(String item) {
		this.item = item;
	}

	public void rotate() {
		// Rotate the block 90 deg. clockwise
		int m = getShape().length;
		int n = getShape()[0].length;
		int[][] rotated = new int[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				rotated[j][m - i - 1] = getShape()[i][j];
			}
		}
		shape = rotated;
	}

	public int height() {
		return getShape().length;
	}

	public int width() {
		if (getShape().length > 0)
			return getShape()[0].length;
		return 0;
	}

	public int[][] getShape() {
		return shape;
	}
}