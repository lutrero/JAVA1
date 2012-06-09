package model;

import java.util.Vector;

import figures.FigurePanel;

import view.View;

public class ModelImpl implements Model {
	private View view;
	private Vector<FigurePanel> vFiguras;

	public ModelImpl() {
		super();
		vFiguras = new Vector<FigurePanel>();
	}

	public void setView(View view) {
		this.view = view;
	}
}
