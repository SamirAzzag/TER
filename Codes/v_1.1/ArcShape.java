import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;


public class ArcShape implements ComponentShape{
	private int x; /* call non-graphic */    
	private int y; /* return non-graphic */
	private Color defaultColor  = Color.BLACK; /* graphic */
	private Color selectedColor = Color.GREEN; /* graphic */
	private boolean reverse;  /* graphic */
	private boolean selected; /* graphic ONE CLICK */
	private boolean selected2; /* graphic TWO CLICK */
	private Arc2D shape; /* Arc object */ 

	public ArcShape(int x, int y) {
		this.x = x; /* call */
		this.y = y; /* return */
		this.selected  = false;
		this.selected2 = false;
	}

	public ArcShape(int x, int y, Color defaultColor, boolean reverse) {
		this.x = x; /* call */
		this.y = y; /* return */
		this.defaultColor = defaultColor;
		this.reverse   = reverse;
		this.selected  = false;
		this.selected2 = false;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(!reverse)
			shape = new Arc2D.Double (x * DrawPanel.spaceBetweenNode, DrawPanel.verticalPosition - (y-x) * DrawPanel.spaceBetweenNode/2, (y-x) * DrawPanel.spaceBetweenNode, (y-x) * DrawPanel.spaceBetweenNode, 0, 180, Arc2D.OPEN);
		else
			shape = new Arc2D.Double (x * DrawPanel.spaceBetweenNode, DrawPanel.verticalPosition - (y-x) * DrawPanel.spaceBetweenNode/2, (y-x) * DrawPanel.spaceBetweenNode, (y-x) * DrawPanel.spaceBetweenNode, 180, 360, Arc2D.OPEN);
		
		if(selected)
			g2d.setColor(selectedColor);
		else
			g2d.setColor(defaultColor);
		g2d.draw(shape);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
	}
	
	public Rectangle2D getShapeBounds() {
		return shape.getBounds2D();
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected2() {
		return selected2;
	}

	public void setSelected2(boolean selected2) {
		this.selected2 = selected2;
	}
}
