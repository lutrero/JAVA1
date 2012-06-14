package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class ElipsePanel extends FigurePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ElipsePanel(){
		super();
	}

	public ElipsePanel(int x, int y, int ancho, int alto){
		super(x, y, ancho, alto);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(getX(), getY(), getAncho(), getAlto());
	}

	@Override
	public boolean containsPoint(int x, int y) {
		return  new Ellipse2D.Double(getX(), getY(), getAncho(), getAlto()).contains(x, y);
	}

}
