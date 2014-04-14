import java.awt.Color;
import java.awt.Graphics;


public class ArcShape implements ComponentShape{
	private int x; /* call non-graphic */    
	private int y; /* return non-graphic */
	private Color color; /* graphic */
	private boolean reverse; /* graphic */

	public ArcShape(int x, int y) {
		this.x = x; /* call */
		this.y = y; /* return */
	}

	public ArcShape(int x, int y, Color color, boolean reverse) {
		this.x = x; /* call */
		this.y = y; /* return */
		this.color   = color;
		this.reverse = reverse;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		if(!reverse)
			g.drawArc(x * DrawPanel.spaceBetweenNode, DrawPanel.verticalPosition - (y-x) * DrawPanel.spaceBetweenNode/2, (y-x) * DrawPanel.spaceBetweenNode, (y-x) * DrawPanel.spaceBetweenNode, 0, 180); /* (int x, int y, int width, int height, int startAngle, int arcAngle) */
		else
			g.drawArc(x * DrawPanel.spaceBetweenNode, DrawPanel.verticalPosition - (y-x) * DrawPanel.spaceBetweenNode/2, (y-x) * DrawPanel.spaceBetweenNode, (y-x) * DrawPanel.spaceBetweenNode, 180, 360);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
