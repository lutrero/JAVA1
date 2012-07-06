package view;


import javax.swing.JComponent;

import controller.Controller;

public interface View {

	public void setController(Controller controller);

	public JComponent getComponent();

	public void repintar();

	public int getBarX();

}
