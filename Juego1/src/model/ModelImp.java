package model;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;



import stuff.Boxes;
import view.View;

public class ModelImp implements Model {
	
	private static final Rectangle2D deadZone = new Rectangle2D.Float(0, 499, 500, 1);
	
	private List<List<Boxes>> boxes;
	private RoundRectangle2D bar;
	private Ellipse2D bullet;
	private View view;
	private ListenerKeyBoard l;
	
	
	public ModelImp() {
		super();
		boxes = new ArrayList<List<Boxes>>();
		bar = new RoundRectangle2D.Float(225, 390, 50, 10, 10, 10);
		bullet = new Ellipse2D.Float(245, 380, 10, 10);
		view = null;
		l = new ListenerKeyBoard();
		generateBoxes();
	}
	
	public void generateBoxes(){
		for(int i = 0; i <= 50; i++){
			boxes.add(new ArrayList<Boxes>());
			for (int j = 0; j <= 10; j++){
				if(j == 10 || j == 0)
					boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 2));
				else if ( j == 5)
					boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 3));
				else
					boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 1));
			}
		}
	}

	@Override
	public void setView(View v) {
		view = v;
	}

	@Override
	public void tryPaintBoxes(Graphics2D g) {
		for(List<Boxes> l : boxes)
			for(Boxes b : l)
				if(b.getTouches() != 0){
					if(b.getTouches() == 1)
//						g.setColor(Color.BLUE);
					g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.GRAY,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.blue, true));
					else if(b.getTouches() == 2)
//						g.setColor(Color.RED);
						g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.RED,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.ORANGE, true));
					else if (b.getTouches() == 3)
//						g.setColor(Color.GRAY);
						g.setPaint(new GradientPaint((float)b.getBox().getX(),(float) b.getBox().getY(), Color.white,(float) b.getBox().getCenterX(),(float) b.getBox().getY(), Color.GRAY, true));
					g.fill(b.getBox());
					g.setColor(Color.BLACK);
					g.draw(b.getBox());
				}
	}

	@Override
	public void tryPaintBullet(Graphics2D g) {
		bullet.setFrame(view.getFisicsX(), view.getFisicsY(), 10, 10);
		g.setPaint(new GradientPaint((float)bullet.getX(),(float) bullet.getY(), Color.GREEN,(float) bullet.getCenterX(),(float) bullet.getY(), Color.YELLOW, true));
		g.fill(bullet);
	}

	@Override
	public void tryPaintBar(Graphics2D g) {
//		bar.setFrame(view.getBarX(), view.getBarY(), 50, 10);
		bar.setFrame(l.x, 490, 50, 10);
		g.setPaint(new GradientPaint((float)bar.getX(),(float) bar.getY(), Color.RED,(float) bar.getCenterX(),(float) bar.getY(), Color.WHITE, true));
		g.fill(bar);
	}

	@Override
	public void updateState() throws InterruptedException {
		if (bullet.intersects(deadZone)){
//				view.setFisicsX(250);
				view.setFisicsY(480);
				view.stopM();
		}else{
			if (bullet.intersects(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight())){
				if(view.getVy() > 0)
					view.invertVy();
				if(bullet.getMaxX() < bar.getCenterX()){
					if(view.getVx() > 0){
//						view.invertVx();
						view.deccelX();
//						view.accelY();
						if(bullet.getMinX() < bar.getMinX())
							view.invertVx();
					}else
						view.accelX();
//					view.deccelY();
				}else if(bullet.getMinX() > bar.getCenterX()){
					if (view.getVx() < 0){
//						view.invertVx();
						view.deccelX();
//						view.accelY();
						if(bullet.getMaxX() > bar.getMaxX())
							view.invertVx();
					}else
						view.accelX();
//					view.deccelY();
				}else if(bullet.getCenterX() == bar.getCenterX()){
//					view.accelY();
					view.deccelX();
				}
		}
		}
		for(List<Boxes> l : boxes)
			for(Boxes b : l){
				if(bullet.contains(b.getBox().getCenterX(), b.getBox().getMaxY()) && b.getTouches() != 0){
					b.setTouches(b.getTouches() - 1);
					if ( view.getVy() < 0)
						view.invertVy();
				}else if ( bullet.contains(b.getBox().getCenterX(), b.getBox().getMinY()) && b.getTouches() != 0){
					b.setTouches(b.getTouches() - 1);
					if (view.getVy() > 0)
						view.invertVy();
				}else if( bullet.contains(b.getBox().getMinX(), b.getBox().getCenterY()) && b.getTouches() != 0){
					b.setTouches(b.getTouches() - 1);
					if (view.getVx() > 0)
						view.invertVx();
				}else if( bullet.contains(b.getBox().getMaxX(), b.getBox().getCenterY()) && b.getTouches() != 0){
					b.setTouches(b.getTouches() - 1);
					if(view.getVx() < 0 )
						view.invertVx();
				}
			}
				
					
	}

	@Override
	public void defaultBulletPos() {
		bullet.setFrame(0, 480, 10, 10);
	}

	@Override
	public KeyListener getKeyListener() {
		return l;
	}

//	@Override
//	public boolean verticalCollision() {
//		for(List<Boxes> l : boxes)
//			for(Boxes b : l)
//				if(b.getTouches() != 0 && bullet.intersects(b.getBox())){
//					b.setTouches(b.getTouches() - 1);
//					return true;
//				}
//		return bullet.intersects(new Rectangle2D.Float((float) bar.getX(),(float) bar.getY(), (float)bar.getWidth(),(float) bar.getHeight()));
//	}
//
//	@Override
//	public boolean lateralCollision() {
//		for(List<Boxes> l : boxes)
//			for(Boxes b : l)
//				if(b.getTouches() != 0 && bullet.contains(b.getBox().getCenterX(), b.getBox().getCenterY())){
//					b.setTouches(b.getTouches() - 1);
//					return true;
//				}
//		return bullet.intersects(new Rectangle2D.Float((float) bar.getX(),(float) bar.getY(), (float)bar.getWidth(),(float) bar.getHeight()));
//	}
	
		

	
	private class ListenerKeyBoard extends KeyAdapter{

		int x;
		ListenerKeyBoard() {
			super();
			x = 240;
		}

		
		@Override
		public void keyPressed(KeyEvent k) {
//			System.out.println(x);
//			System.out.println(k.getKeyCode());
			if(k.getKeyCode() == 38)
				view.startM();
			if(x >= 0 && x <= 460){
				if(k.getKeyCode() == 39){
					if(x < 450)
						for(int i = 0; i < 20; i++)
							x ++;
					else if (x < 460)
						for(int i = 0; i < 10; i++)
							x ++;
						
				}else if(k.getKeyCode() ==37)
					if (x > 10)
						for(int i = 0; i < 20; i++)
							x --;
					else if (x > 0)
						for(int i = 0; i < 10; i++)
							x --;
			}
		}
	}


}
