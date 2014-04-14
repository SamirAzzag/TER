import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class DrawPanel extends JComponent {

	private static final long serialVersionUID = 1L;
	static int spaceBetweenNode = 50;
	static int nodeDiameter = 20;
	static int verticalPosition = 300;

	private int width;
	private int height;

	private List<ComponentShape> componentShape;

	public DrawPanel(int width, int height) {
		this.width  = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
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

}
