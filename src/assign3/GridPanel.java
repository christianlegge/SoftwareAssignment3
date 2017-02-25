/**
 * A JPanel that provides a view of a GridModel.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
	// Width and height of an individual cell.
	int cw, ch;
	GridModel model;
	
	GridPanel(int width, int height, GridModel model) {
		setPreferredSize(new Dimension(width, height));
		this.model = model;
		
		cw = width / model.getWidth();
		ch = height / model.getHeight();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// First fill the whole panel with white.
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Now fill in all true grid entries with blue.
		g.setColor(Color.blue);
		for (int i=0; i<model.getWidth(); i++)
			for (int j=0; j<model.getHeight(); j++)
				if (model.getValue(i,j))
					g.fillRect(i*cw, j*ch, cw, ch);
	}
	
	public int getCellWidth() {
		return cw;
	}
	
	public int getCellHeight() {
		return ch;
	}
}
