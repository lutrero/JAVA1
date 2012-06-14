package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RectanglePanel extends FigurePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public RectanglePanel(){
		super();
	}
	
	public RectanglePanel(int x, int y, int ancho, int alto){
		super(x, y, ancho, alto);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(getX(),getY(),getAncho(),getAlto());
	}

	@Override
	public boolean containsPoint(int x, int y) {
		return new Rectangle2D.Double(getX(), getY(), getAncho(), getAlto()).contains(x, y);
	}
}
