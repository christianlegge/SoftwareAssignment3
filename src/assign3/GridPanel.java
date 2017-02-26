/**
 * A JPanel that provides a view of a GridModel.
 */
import assign3.CellColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
	// Width and height of an individual cell.
	int cw, ch;
	GridModel model;
        String color;
	
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
		
		for (int i=0; i<model.getWidth(); i++)
			for (int j=0; j<model.getHeight(); j++)
				if (model.getValue(i,j) == CellColor.Blue){
                                    g.setColor(Color.blue);
                                    g.fillRect(i*cw, j*ch, cw, ch);
                                }
                                else if (model.getValue(i,j) == CellColor.Red){
                                    g.setColor(Color.red);
                                    g.fillRect(i*cw, j*ch, cw, ch);
                                } 
                                        
                                else if (model.getValue(i,j) == CellColor.Green){
                                    g.setColor(Color.green);
                                    g.fillRect(i*cw, j*ch, cw, ch);
                                }
                                    
                                else if (model.getValue(i,j) == CellColor.White){
                                    g.setColor(Color.white);
                                    g.fillRect(i*cw, j*ch, cw, ch);
                                }
	}
	
	public int getCellWidth() {
		return cw;
	}
	
	public int getCellHeight() {
		return ch;
	}
        
        public void colorSet(String c){
            color = c;
        }
}
