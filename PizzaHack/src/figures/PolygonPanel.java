package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.security.InvalidParameterException;

import javax.swing.JPanel;

public class PolygonPanel extends JPanel{

	
	private static final long serialVersionUID = 1L;

	private Polygon polygon;
	
	public PolygonPanel(){
		super();
		polygon = new Polygon();
	}
	
	public PolygonPanel(int[]x, int[]y){
		super();
		if ( x.length != y.length) throw new InvalidParameterException();
		polygon = new Polygon(x, y, x.length);
	}
	
	public PolygonPanel(Polygon p){
		super();
		if (p == null) throw new NullPointerException();
		polygon = p;
	}
	
	public void addPoint(int x, int y){
		polygon.addPoint(x, y);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(polygon);
	}
	
	public boolean containsPoint(int x, int y){
		return polygon.contains(x, y);
	}
	
	public Rectangle2D getBounding(){
		return polygon.getBounds2D();
	}
}
