/**
 * Here we re-factor Paint1 to isolate the model as a separate 
 * class---GridModel.  Also we factor out PaintPanel and call it
 * GridPanel and place it in a separate top-level class.
 * 
 * @author Andrew Vardy
 */
import assign3.CellColor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Paint2 extends MouseAdapter implements ActionListener {

	GridModel model = new GridModel(100, 100);
	JFrame frame = new JFrame("Paint2");
	GridPanel gridPanel = new GridPanel(400, 400, model);
	JToggleButton clearButton = new JToggleButton("Clear");
        JToggleButton redButton = new JToggleButton("Red");
        JToggleButton greenButton = new JToggleButton("Green");
        JToggleButton blueButton = new JToggleButton("Blue");
        JToggleButton eraseButton = new JToggleButton("Erase");
        CellColor color = CellColor.White;
       
	
	public Paint2() {
		// Initialize frame and add the paintPanel in the center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(gridPanel);
                
		// Create a panel on the left for buttons and add
		// the buttons to it
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));		
		buttonPanel.add(clearButton);
                buttonPanel.add(blueButton);
                buttonPanel.add(redButton);
                buttonPanel.add(greenButton);
                buttonPanel.add(eraseButton);
		frame.add(buttonPanel, BorderLayout.WEST);
                          	
		// Setup event listeners.  In this case, Paint2 is the
		// listener for all component events.
		clearButton.addActionListener(this);
                redButton.addActionListener(this);
                greenButton.addActionListener(this);
                blueButton.addActionListener(this);
                eraseButton.addActionListener(this);
		gridPanel.addMouseListener(this);
		gridPanel.addMouseMotionListener(this);
		
		frame.pack();
		frame.setResizable(false); // Must not be resizable because we aren't
		frame.setVisible(true);	   // handling changes in size.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
            
            //sets the color to be drawn according to which button has been pressed
            JToggleButton toggle = (JToggleButton) e.getSource();
            if(toggle == clearButton){
                model.clearAll();
		gridPanel.repaint();
                clearButton.setSelected(false);
            }
            if(toggle == redButton){
                color = CellColor.Red;
                eraseButton.setSelected(false);
                greenButton.setSelected(false);
                blueButton.setSelected(false);
            }
            if(toggle == greenButton){
                color = CellColor.Green;
                eraseButton.setSelected(false);
                redButton.setSelected(false);
                blueButton.setSelected(false);
            }
            if(toggle == blueButton){
                color = CellColor.Blue;
                eraseButton.setSelected(false);
                redButton.setSelected(false);
                greenButton.setSelected(false);
            }
            if(toggle == eraseButton){
                color = CellColor.White;
                redButton.setSelected(false);
                greenButton.setSelected(false);
                blueButton.setSelected(false);
            }
        }
        
	public void mousePressed(MouseEvent e) {
		int cellX = e.getX() / gridPanel.getCellWidth();
		int cellY = e.getY() / gridPanel.getCellHeight();
		
		if (cellX >= 0 && cellX < model.getWidth() && 
			cellY >= 0 && cellY < model.getHeight()) {
			model.setValue(cellX, cellY, color);
			gridPanel.repaint();
		}
	}
	        
	public void mouseDragged(MouseEvent e) {
		mousePressed(e);
	}
	
	public static void main(String[] args) throws Exception {		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint2();
			}
		});
	}
}

