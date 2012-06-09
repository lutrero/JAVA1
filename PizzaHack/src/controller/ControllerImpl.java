package controller;

import view.View;
import model.Model;

public class ControllerImpl implements Controller {
	private Model model;
	private View view;
	
	public ControllerImpl() {
		super();
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
	}
	
	@Override
	public void setView(View view) {
		this.view = view;
	}
}
