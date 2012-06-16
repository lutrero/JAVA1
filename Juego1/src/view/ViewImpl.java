package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import controller.Controller;

public class ViewImpl extends JComponent implements View{

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 500;
	private static final int ALTO = 400;
	private final static int DIAMETRO = 100;
	
	private float x, y;
	private float vx, vy;
	private Controller controller;
	
	public ViewImpl(){
		super();
		setPreferredSize(new Dimension(ANCHO, ALTO));
		x = 245;
		y = 380;
		vx = 300;
		vy = 400;
	}
	
	
	private void fisica(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO)
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO)
            vy = -vy;
    }
	
	public void paintComponent(Graphics g2){
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, ANCHO, ALTO);
		g.setColor(Color.CYAN);
		
		g.setColor(Color.ORANGE);
		g.setColor(Color.GREEN);
	}
}
