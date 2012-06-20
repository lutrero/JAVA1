package stuff;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import model.Model;

public class MultiBallBox extends Boxes{
	
	private Model model;
	private int nbullets;
	
	public MultiBallBox(Model m){
		super();
		model = m;
	}

	public MultiBallBox(Rectangle2D box, int touches, Model m, int b){
		super(box, touches);
		model = m;
		nbullets = b;
	}
	
	@Override
	public void setTouches(int touches){
		super.setTouches(touches);
		for (int i =0; i< nbullets; i++)
			model.addBullet((float)super.getBox().getCenterX(),(float)super.getBox().getCenterY(), i*10 % 400, -300);
//		model.addBullet((float)super.getBox().getCenterX(),(float)super.getBox().getCenterY(), 100, -300);
//		model.addBullet((float)super.getBox().getCenterX(),(float)super.getBox().getCenterY(), 300, 300);
//		model.addBullet((float)super.getBox().getCenterX(),(float)super.getBox().getCenterY(), 200, -300);
//		model.addBullet((float)super.getBox().getCenterX(),(float)super.getBox().getCenterY(), 0, -300);
		
	}
	
	@Override
	public void paintBox(Graphics2D g){
		g.setPaint(new GradientPaint((float)getBox().getX(),(float) getBox().getY(), Color.white,(float) getBox().getCenterX(),(float) getBox().getY(), Color.GREEN, true));
		g.fill(getBox());
		g.setColor(Color.BLACK);
		g.draw(getBox());
	}
}
