package view;


import javax.swing.JComponent;

import controller.Controller;

public interface View {

	void setController(Controller controller);

	JComponent getComponent();

}
