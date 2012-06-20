package controller;

import java.awt.Graphics2D;

import model.Model;

public class ControllerImpl implements Controller{
	
	private Model model;
	
	
	public ControllerImpl(){
		super();
		model = null;
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
	public void tryPaintBullets(Graphics2D g) {
		model.tryPaintBullets(g);
	}
	
	@Override
	public void setModel(Model m) {
		model = m;
	}

	@Override
	public void startM() {
		model.startM();
	}

}
