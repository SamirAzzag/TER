import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CircleShape implements ComponentShape {
	private int x;
	private int y;
	//private int diameter;
	private String label;
	private Color circleColor;
	private Color defaultBorderColor  = Color.BLACK;
	private Color selectedBorderColor = Color.GREEN;  /* ONE CLICK */
	private Color selected2BorderColor = Color.BLUE; /* TWO CLICK */
	private Color labelColor;
	private Ellipse2D shape; /* oval object */ 
	private boolean selected;  /* ONE CLICK */
	private boolean selected2; /* TWO CLICK */


	CircleShape(int x, int y, /* int diameter, */ String label, Color circleColor, Color labelColor) {
		this.x = x;
		this.y = y;
		//this.diameter = diameter;
		this.label  = label;
		this.circleColor = circleColor;
		this.labelColor  = labelColor;
		this.selected  = false;
		this.selected2 = false;
	}

	CircleShape(int x, String label, Color circleColor, Color labelColor) {
		this.x = x;
		this.label  = label;
		this.circleColor = circleColor;
		this.labelColor  = labelColor;
		this.selected  = false;
		this.selected2 = false;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(circleColor);
		int radius = DrawPanel.nodeDiameter/2;

		shape = new Ellipse2D.Double(x * DrawPanel.spaceBetweenNode - radius , DrawPanel.verticalPosition, DrawPanel.nodeDiameter, DrawPanel.nodeDiameter);
		g2d.fill(shape);

		if(selected)
			g2d.setColor(selectedBorderColor);
		else if (selected2)
			g2d.setColor(selected2BorderColor);
		else
			g2d.setColor(defaultBorderColor);

		g2d.drawOval(x * DrawPanel.spaceBetweenNode - radius , DrawPanel.verticalPosition, DrawPanel.nodeDiameter, DrawPanel.nodeDiameter);
		FontMetrics fm = g.getFontMetrics();
		double textWidth = fm.getStringBounds(label, g2d).getWidth();
		g2d.setColor(labelColor);

		/* left corner + radius + textWidth/2 or textHeight/2 */

		g2d.drawString(label, x * DrawPanel.spaceBetweenNode - (int)textWidth/2, DrawPanel.verticalPosition + radius + (int)fm.getMaxAscent() / 2);
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

	public Rectangle2D getShapeBounds() {
		return shape.getBounds2D();
	}

	public boolean isSelected() {
		return selected;
	}

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
