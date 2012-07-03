package view;

import java.awt.Component;

import controller.Controller;

public interface View {

	void setController(Controller controller);

	Component getComponent();

}
