package controller;


import java.awt.Graphics2D;

import stuff.Bola;

import model.Model;

public interface Controller {

	public void setModel(Model model);

	public void tryPaintAll(Graphics2D g);

	public void setBar(int x, int y);

	public void addBola(Bola bola);

}
