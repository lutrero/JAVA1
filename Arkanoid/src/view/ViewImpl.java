package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.Controller;

public class ViewImpl implements View {

	
	private GamePanel gZone;
	private Controller controller;
	
	
	
	public ViewImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setController(Controller controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JComponent getComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	

	private class GamePanel extends JPanel{

		private static final long serialVersionUID = 1L;

		public GamePanel() {
			super();
			addMouseMotionListener(new GameListener());
//			addKeyListener(new GameListener());
		}
		
		@Override
		public void paintComponent(Graphics g2){
			super.paintComponent(g2);
			Graphics2D g = (Graphics2D) g2;
//			controller.tryPaintAll(g);
		}
	}
	
	private class GameListener extends MouseAdapter implements KeyListener{
		
		

		public GameListener() {
			super();
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
