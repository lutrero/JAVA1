package main;

import controller.ControllerImpl;
import model.ModelImpl;
import view.ViewImpl;

public class Main {
	private Main() {
		super();
	}
	
	private void execute() {
		ViewImpl viewImpl = new ViewImpl();
		ModelImpl modelImpl = new ModelImpl();
		ControllerImpl controllerImpl = new ControllerImpl();
		viewImpl.setController(controllerImpl);
		viewImpl.setModel(modelImpl);
		modelImpl.setView(viewImpl);
		controllerImpl.setView(viewImpl);
		controllerImpl.setModel(modelImpl);
		
		viewImpl.createGUI();
	}
	
	public static void main(String[] args) {
		new Main().execute();
	}
}
