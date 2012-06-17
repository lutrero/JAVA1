package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import controller.Controller;

public class ViewImpl extends JComponent implements View{

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 600;
	private static final int ALTO = 600;
	private final static int DIAMETRO = 100;
	
	private float x, y;
	private float vx, vy;
	private Controller controller;
	private int barX, barY;
	
	public ViewImpl(){
		super();
		setPreferredSize(new Dimension(ANCHO, ALTO));
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
				barX = e.getX() - 25;
				barY = 490;
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		x = 245f;
		y = 380f;
		vx = 200f;
		vy = 300f;
	}
	
	
	
	@Override
	public float getFisicsX() {
		return x;
	}



	@Override
	public float getFisicsY() {
		return y;
	}



	@Override
	public void setController(Controller c){
		controller = c;
	}
	
	private void fisica(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO )
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO )
            vy = -vy;
    }
	

	private void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, ANCHO, ALTO);
                }
            });
    }
	
	public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
            tiempoViejo = tiempoNuevo;
            controles();
            fisica(dt);
            dibuja();
        }
    }
	
	private void controles() {
		controller.giveState();
	}



	public void paintComponent(Graphics g2){
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ANCHO, ALTO);
		g.setColor(Color.BLUE);
		controller.tryPaintBoxex(g);
		g.setColor(Color.ORANGE);
		controller.tryPaintBar(g);
		g.setColor(Color.GREEN);
		controller.tryPaintBullet(g);
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
		return this;
	}



	@Override
	public void invertVx() {
		vx = -vx;
	}



	@Override
	public void invertVy() {
		vy = -vy;
	}



	@Override
	public float getVx() {
		return vx;
	}



	@Override
	public float getVy() {
		return vy;
	}



	@Override
	public void accelX() {
	}



	@Override
	public void deccelX() {
	}



	@Override
	public void accelY() {
	}



	@Override
	public void deccelY() {
	}
	
	
}
