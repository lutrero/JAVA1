package controller;



import java.awt.Graphics2D;

import model.Model;

public class ControllerImpl implements Controller {
	
	private Model model;
	
	

	public ControllerImpl() {
		super();
		model = null;
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void tryPaintAll(Graphics2D g) {
		model.paintAll(g);
	}

	@Override
	public void setBar(int x, int y) {
		model.setBarPos(x,y);
	}


}
