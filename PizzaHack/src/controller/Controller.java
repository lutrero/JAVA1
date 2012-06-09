package controller;

import model.Model;
import view.View;

public interface Controller {
	
	public void setView(View v);
	public void setModel(Model m);
}
