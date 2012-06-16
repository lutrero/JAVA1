package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.StrokeBorder;

import controller.Controller;

import stuff.Boxes;
import view.View;

public class ModelImp implements Model {
	
	private static final Rectangle2D deadZone = new Rectangle2D.Float(0, 399, 500, 1);
	
	private List<List<Boxes>> boxes;
	private RoundRectangle2D bar;
	private Ellipse2D bullet;
	private View view;
	
	
	public ModelImp() {
		super();
		boxes = new ArrayList<List<Boxes>>();
		bar = new RoundRectangle2D.Float(225, 390, 50, 10, 10, 10);
		bullet = new Ellipse2D.Float(245, 380, 10, 10);
		view = null;
		generateBoxes();
	}
	
	private void generateBoxes(){
		for(int i = 1; i <= 50; i++){
			boxes.add(new ArrayList<Boxes>());
			for (int j = 1; j <= 10; j++){
				boxes.get(i-1).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 1));
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
					g.fill(b.getBox());
					g.setColor(Color.BLACK);
					g.draw(b.getBox());
					g.setColor(Color.BLUE);
				}
	}

	@Override
	public void tryPaintBullet(Graphics2D g) {
		bullet.setFrame(view.getFisicsX(), view.getFisicsY(), 10, 10);
		g.fill(bullet);
	}

	@Override
	public void tryPaintBar(Graphics2D g) {
		bar.setFrame(view.getBarX(), view.getBarY(), 50, 10);
		g.fill(bar);
	}


	@Override
	public boolean verticalCollision() {
		for(List<Boxes> l : boxes)
			for(Boxes b : l)
				if(b.getTouches() != 0 && bullet.intersects(b.getBox())){
					b.setTouches(b.getTouches() - 1);
					return true;
				}
		return false;
	}

	@Override
	public boolean lateralCollision() {
		for(List<Boxes> l : boxes)
			for(Boxes b : l)
				if(b.getTouches() != 0 && bullet.contains(b.getBox().getCenterX(), b.getBox().getCenterY())){
					b.setTouches(b.getTouches() - 1);
					return true;
				}
		return false;
	}
	
		

}
