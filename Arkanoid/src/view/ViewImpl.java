package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.Controller;

public class ViewImpl implements View {

	
	private GamePanel gZone;
	private Controller controller;
	private int barX;
	
	
	
	public ViewImpl() {
		super();
		controller = null;
		gZone = new GamePanel();
		barX = 50;
	}
	
	@Override
	public int getBarX() {
		// TODO Auto-generated method stub
		return barX;
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public JComponent getComponent() {
		return gZone;
	}

	@Override
	public void repintar() {
		gZone.repaint();
	}
	

	private class GamePanel extends JPanel{

		private static final long serialVersionUID = 1L;

		public GamePanel() {
			super();
			addMouseMotionListener(new GameListener());
			setPreferredSize(new Dimension(500, 500));
//			addKeyListener(new GameListener());
		}
		
		@Override
		public void paintComponent(Graphics g2){
			super.paintComponent(g2);
			Graphics2D g = (Graphics2D) g2;
			controller.tryPaintAll(g);
		}
	}
	
	private class GameListener extends MouseAdapter implements KeyListener{
		
		

		public GameListener() {
			super();
		}

		@Override
		public void mouseMoved(MouseEvent e){
//			controller.setBar(e.getX(), e.getY());
			barX= e.getX();
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
