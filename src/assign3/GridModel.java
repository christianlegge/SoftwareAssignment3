/**
 * Represents a 2-D array of boolean values.
 * 
 * @author Andrew Vardy
 */
public class GridModel {
	protected int width;
	protected int height;
	protected boolean grid[][];
	
	GridModel(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new boolean[width][height];
	}

	void clearAll() {
		for (int i=0; i<width; i++)
			for (int j=0; j<height; j++)
				grid[i][j] = false;
	}

	boolean getValue(int i, int j) {
		return grid[i][j];
	}
	
	void setValue(int i, int j, boolean value) {
		grid[i][j] = value;
	}
	
	int getWidth() {
		return width;
	}
	
	int getHeight() {
		return height;
	}
}
