package model;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import stuff.Boxes;

public class ModelImp implements Model {
	
	private List<List<Boxes>> boxes;
	private Rectangle2D deadZone;
	private RoundRectangle2D bar;
	private Ellipse2D bullet;
	
	
	public ModelImp() {
		super();
		boxes = new ArrayList<List<Boxes>>();
		deadZone = new Rectangle2D.Float(0, 399, 500, 1);
		bar = new RoundRectangle2D.Float(225, 390, 50, 10, 2, 2);
		bullet = new Ellipse2D.Float(245, 380, 10, 10);
	}
	
	public void generateBoxes(){
		for(int i = 1; i <= 50; i++){
			boxes.add(new ArrayList<Boxes>());
			for (int j = 1; j <= 10; j++){
				boxes.get(i).add(new Boxes(new Rectangle2D.Float(i*10, j*10, 10, 10), 1));
			}
		}
	}
	
	
	
	

}
