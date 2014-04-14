import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CircleShape implements ComponentShape {
	private int position;
	//private int y;
	//private int diameter;
	private Symbol label;
	private ArcShape arc1;
	private ArcShape arc2;
	private Color circleColor;
	private Color defaultBorderColor   = Color.BLACK;
	private Color selectedBorderColor  = Color.GREEN;  /* ONE CLICK */
	private Color selected2BorderColor = Color.BLUE; /* TWO CLICK */
	private Color labelColor;
	private Ellipse2D shape; /* oval object */ 
	private boolean selected;  /* ONE CLICK */
	private boolean selected2; /* TWO CLICK */


	/*CircleShape(int x, int y, /* int diameter,  String label, Color circleColor, Color labelColor) {
		this.position = x;
		//this.y = y;
		//this.diameter = diameter;
		this.label  = label;
		this.circleColor = circleColor;
		this.labelColor  = labelColor;
		this.selected  = false;
		this.selected2 = false;
	}*/

	CircleShape(int x, Symbol label, Color circleColor, Color labelColor) {
		this.position = x;
		this.label  = label;
		this.circleColor = circleColor;
		this.labelColor  = labelColor;
		this.selected  = false;
		this.selected2 = false;
		arc1 = null;
		arc2 = null;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(circleColor);
		int radius = DrawPanel.nodeDiameter/2;

		shape = new Ellipse2D.Double(position * DrawPanel.spaceBetweenNode - radius , DrawPanel.verticalPosition, DrawPanel.nodeDiameter, DrawPanel.nodeDiameter);
		g2d.fill(shape);

		if(selected)
			g2d.setColor(selectedBorderColor);
		else if (selected2)
			g2d.setColor(selected2BorderColor);
		else
			g2d.setColor(defaultBorderColor);

		g2d.drawOval(position * DrawPanel.spaceBetweenNode - radius , DrawPanel.verticalPosition, DrawPanel.nodeDiameter, DrawPanel.nodeDiameter);
		FontMetrics fm = g.getFontMetrics();
		double textWidth = fm.getStringBounds(label.getCharacter().toString(), g2d).getWidth();
		g2d.setColor(labelColor);

		/* left corner + radius + textWidth/2 or textHeight/2 */

		g2d.drawString(label.getCharacter().toString(), position * DrawPanel.spaceBetweenNode - (int)textWidth/2, DrawPanel.verticalPosition + radius + (int)fm.getMaxAscent() / 2);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int x) {
		this.position = x;
	}

	/*public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}*/
	
	public Symbol getLabel() {
		return label;
	}
	
	public ArcShape getArc1() {
		return arc1;
	}
	
	public ArcShape getArc2() {
		return arc2;
	}

	public void setArc1(ArcShape as) {
		arc1 = as;
	}
	
	public void setArc2(ArcShape as) {
		arc2 = as;
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
