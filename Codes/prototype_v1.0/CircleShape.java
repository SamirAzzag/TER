import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class CircleShape implements ComponentShape {
	private int x;
	private int y;
	//private int diameter;
	private String label;
	private Color circleColor;
	private Color borderCircleColor = Color.BLACK;
	private Color labelColor;

	CircleShape(int x, int y, /* int diameter, */ String label, Color circleColor, Color labelColor) {
		this.x = x;
		this.y = y;
		//this.diameter = diameter;
		this.label  = label;
		this.circleColor = circleColor;
		this.labelColor  = labelColor;
	}

	CircleShape(int x, String label, Color circleColor, Color labelColor) {
		this.x = x;
		this.label  = label;
		this.circleColor = circleColor;
		this.labelColor  = labelColor;
	}

	public void draw(Graphics g) {
		g.setColor(circleColor);
		int radius = DrawPanel.nodeDiameter/2;
		g.fillOval(x * DrawPanel.spaceBetweenNode - radius , DrawPanel.verticalPosition, DrawPanel.nodeDiameter, DrawPanel.nodeDiameter);
		g.setColor(borderCircleColor);
		g.drawOval(x * DrawPanel.spaceBetweenNode - radius , DrawPanel.verticalPosition, DrawPanel.nodeDiameter, DrawPanel.nodeDiameter);

		FontMetrics fm = g.getFontMetrics();
		double textWidth = fm.getStringBounds(label, g).getWidth();
		g.setColor(labelColor);

		/* left corner + radius + textWidth/2 or textHeight/2 */

		g.drawString(label, x * DrawPanel.spaceBetweenNode - (int)textWidth/2, DrawPanel.verticalPosition + radius + (int)fm.getMaxAscent() / 2);
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

}
