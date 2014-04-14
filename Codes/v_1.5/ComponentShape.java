import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public interface ComponentShape {
	void draw(Graphics g);
	Rectangle2D getShapeBounds();
	boolean isSelected();
	void setSelected(boolean selected);	
	boolean isSelected2();
	void setSelected2(boolean selected2);
}
