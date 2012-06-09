package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class FigurePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private double angulo;
	
	public FigurePanel(){
		super();
		x = y = ancho = alto = 0;
		angulo = 0;
	}

	public FigurePanel(int x, int y, int ancho, int alto) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		angulo = 0;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public void rotar(int ang){
		Graphics2D g = (Graphics2D) getGraphics();
		angulo = Math.toRadians(ang);
		g.rotate(angulo, x + (double)ancho/2, y + (double)alto/2);
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

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public double getAngulo() {
		return angulo;
	}
	
	

}
