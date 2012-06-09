package view;

import controller.Controller;
import model.Model;

public interface View {
	void paintCanvas();
	
	public void setModel(Model m);
	public void setController(Controller c);
}
