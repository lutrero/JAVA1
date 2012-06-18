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
import javax.swing.SwingUtilities;

import controller.Controller;

public class ViewImpl extends JComponent implements View{

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 500;
	private static final int ALTO = 500;
	private final static int DIAMETRO = 100;
	
	private float x, y;
	private float vx, vy;
	private Controller controller;
	private int barX, barY;
	private int lifes;
	
	public ViewImpl(){
		super();
		setPreferredSize(new Dimension(ANCHO + 10, ALTO));
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
				startM();
			}
			
		});
		
		x = 245f;
		y = 480f;
		vx = 0f;
		vy = 0f;
		lifes = 10;
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
	public void setFisicsX(float x) {
		this.x = x;
	}



	@Override
	public void setFisicsY(float y) {
		this.y = y;
	}


	@Override
	public void setController(Controller c){
		controller = c;
	}
	
	private void fisica(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO + 100)
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO + 100 )
            vy = -vy;
    }
	

	private void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, ANCHO + 20, ALTO);
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
//		g.setColor(Color.BLACK);
		g.drawImage(new ImageIcon(getClass().getResource("/images/Nebulosa.jpg")).getImage(),0,0, ANCHO + 20, ALTO,this);
//		g.fillRect(0, 0, ANCHO + 20, ALTO);
		controller.tryPaintBoxex(g);
//		g.setColor(Color.PINK);
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
		if (vx > 0 ){
			if(vx < 400){
				if (vx < 50)
					vx += 20f;
				else
					vx += 50f;
			}
		}else{
			if (vx > -400){
				if(vx > -50)
					vx -= 20f;
				else
					vx -= 50f;
			}
		}
	}



	@Override
	public void deccelX() {
		if(vx > 0 )
			vx -= 50f;
		else 
			vx += 50f;
	}



	@Override
	public void accelY() {
		if (vy > 0 ){
			if(vy < 400)
				vy+=50;
		}else{
			if (vy > -400)
				vy-=50;
		}
	}



	@Override
	public void deccelY() {
		if(vy > 200 )
			vy-=50;
		else if( vy < -200)
			vy+=50;
	}



	@Override
	public void startM() {
		if (vx == 0 && vy == 0){
			y = 480f;
			vx = 100f;
			vy = -300f;
		}
	}



	@Override
	public void stopM() {
		lifes--;
		if (lifes == 0)
			controller.initializaBoxes();
		vx = vy = 0f;
	}
	
	
}
