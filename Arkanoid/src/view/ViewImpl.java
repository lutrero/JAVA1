package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import controller.Controller;

public class ViewImpl implements View {
	
	public static final int ANCHO = 500;
	public static final int ALTO = 500;
	private static final  int DIAMETER = 10;
	
	private DrawComponent gameZone;
	private Controller controller;
	private int barX, barY;
	
	public ViewImpl(){
		super();
		gameZone = new DrawComponent();
		controller = null;
		barX = barY = 0;
	}
	
	@Override
	public Runnable getGameZone() {
		return gameZone;
	}
	
	@Override
	public void setController(Controller c) {
		controller = c;
	}
	
	@Override
	public double getBarX() {
		return barX;
	}
	
	@Override
	public double getBarY() {
		return barY;
	}
	
	@Override
	public Component getComponent() {
		return gameZone;
	}
	
	private class DrawComponent extends JComponent implements Runnable{
		
		
		public DrawComponent(){
			super();
			setPreferredSize(new Dimension(ANCHO + 10, ALTO + 30));
			addMouseMotionListener(new MouseAdapter() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					barX = e.getX() - 25;
					barY = 490;
				}
				
			});
			addMouseWheelListener(new MouseAdapter() {
				@Override
				public void mouseWheelMoved(MouseWheelEvent e){
					controller.startM();
				}
				
			});
		}

		@Override
		public void run() {
            paintImmediately(0, 0, ANCHO + 20, ALTO);
		}
		
		@Override
		public void paintComponent(Graphics g2){
			Graphics2D g = (Graphics2D) g2;
			g.drawImage(new ImageIcon(getClass().getResource("/images/Nebulosa.jpg")).getImage(),0,0, ANCHO + 20, ALTO + 30 ,this);
			controller.tryPaintBoxex(g);
			controller.tryPaintBar(g);
			controller.tryPaintBullets(g);
		}
		
	}








}
