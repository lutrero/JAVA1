package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.Model;
import model.ModelImpl;
import view.View;
import view.ViewImpl;
import controller.Controller;
import controller.ControllerImpl;

public class TheGameV2 {

	public static void main(String[] args) {
		 final Model model = new ModelImpl();
		 Controller controller = new ControllerImpl();
		 View view = new ViewImpl();
		 model.setView(view);
		 model.setController(controller);
		 controller.setModel(model);
		 view.setController(controller);
	     JFrame jf = new JFrame("TheGame--Pakanoid--");
	     jf.addWindowListener(new WindowAdapter() {
	             public void windowClosing(WindowEvent e) {
	            	 System.out.println(model.getPuntuacion());
	                 System.exit(0);
	             }
	            });
	     jf.setResizable(false);
	     jf.getContentPane().add(view.getComponent());
	     jf.pack();
	     jf.setVisible(true);
	     model.gameCicle();
	}
}
