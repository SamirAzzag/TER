import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;



import javax.swing.JComponent;
import javax.swing.Timer;

public class DrawPanel extends JComponent implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	static int spaceBetweenNode = 50;
	static int nodeDiameter = 20;
	static int verticalPosition = 300;

	private int width;
	private int height;

	private List<ComponentShape> componentShape;

	/**
	 * Mouse
	 */
	/* os config : time spent between two click*/
	Integer timerinterval = (Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
	MouseEvent lastEvent;
    Timer timer = new Timer( timerinterval, this);


	public DrawPanel(int width, int height) {
		this.width  = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		addMouseListener(this);
	}


	public void paintComponent(Graphics g)
	{  
		super.paintComponent(g); 
		if(componentShape != null)
			for (ComponentShape cs : componentShape) {
				cs.draw(g);
			}	
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<ComponentShape> getComponentShape() {
		return componentShape;
	}

	public void setComponentShape(List<ComponentShape> componentShape) {
		this.componentShape = componentShape;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 2) return;

        lastEvent = e;

        if (timer.isRunning())
        {
            timer.stop();
            doubleClick( lastEvent );
        }
        else
        {
            timer.restart();
        }

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		timer.stop();
        singleClick( lastEvent );
		
	}
	
	 public void singleClick(MouseEvent e)
     {
		 /**
		  * selected shape 
		  */
		 for(ComponentShape cs : componentShape) {
				if(cs.getShapeBounds().contains(e.getPoint())) {
					if(cs.isSelected())
						cs.setSelected(false);
					else
						cs.setSelected(true);
					revalidate();
					repaint();

				}
			}
     }

     public void doubleClick(MouseEvent e)
     {
    	 /**
		  * selected shape 
		  */
		 for(ComponentShape cs : componentShape) {
			 	cs.setSelected2(false);
				if(cs.getShapeBounds().contains(e.getPoint())) {
					cs.setSelected2(true);
					revalidate();
					repaint();
				}
			}
     }
	
	
	/*
	 
	 */
}
