package controller;

import java.awt.Graphics2D;

import model.Model;
import view.View;

public class ControllerImp implements Controller{
	
	private Model model;
	private View view;
	
	

	public ControllerImp() {
		super();
		model = null; 
		view = null;
	}
	
	@Override
	public void setView(View v) {
		view = v;
	}
	
	@Override
	public void setModel(Model m) {
		model = m;
	}

	@Override
	public void tryPaintBoxex(Graphics2D g) {
		model.tryPaintBoxes(g);
	}

	@Override
	public void tryPaintBar(Graphics2D g) {
		model.tryPaintBar(g);
	}

	@Override
	public void tryPaintBullet(Graphics2D g) {
		model.tryPaintBullet(g);
	}


	@Override
	public boolean verticalCollision() {
		return model.verticalCollision();
	}

	@Override
	public boolean lateralCollision() {
		return model.lateralCollision();
	}

}
