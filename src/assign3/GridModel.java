
import assign3.CellColor;

/**
 * Represents a 2-D array of boolean values.
 * 
 * @author Andrew Vardy
 */
public class GridModel {
	protected int width;
	protected int height;
	protected CellColor grid[][];
	
	GridModel(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new CellColor[width][height];
                for(int i = 0; i < width; i++)
                    for(int j = 0; j < height; j++)
                        grid[i][j] = CellColor.White;
	}

	void clearAll() {
		for (int i=0; i<width; i++)
			for (int j=0; j<height; j++)
				grid[i][j] = CellColor.White;
	}

	CellColor getValue(int i, int j) {
		return grid[i][j];
	}
	
	void setValue(int i, int j, CellColor value) {
		grid[i][j] = value;
	}
	
	int getWidth() {
		return width;
	}
	
	int getHeight() {
		return height;
	}
}
