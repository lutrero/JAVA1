package controller;



import java.awt.Graphics2D;

import stuff.Bala;
import stuff.Bola;

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

	@Override
	public void addBola(Bola bola) {
		model.addBola(bola);
	}

	@Override
	public void addBala(Bala bala) {
		model.addBala(bala);
	}

	@Override
	public int getBarMinX() {
		return model.getBarMinX();
	}

	@Override
	public int getBarMaxX() {
		return model.getBarMaxX();
	}

	@Override
	public int getBarY() {
		return model.getBarY();
	}

	@Override
	public void startMoving() {
		model.startMoving();
	}

	@Override
	public void liveUp() {
		model.liveUp();
	}

	@Override
	public void bigBall() {
		model.bigBall();
	}


}
