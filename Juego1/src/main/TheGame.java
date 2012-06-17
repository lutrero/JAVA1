package main;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import stuff.ListenerKeyBoard;
import view.View;
import view.ViewImpl;

import controller.Controller;
import controller.ControllerImp;

import model.Model;
import model.ModelImp;



public class TheGame {
	
	 public static void main(String[] args) throws Exception {
	        JFrame jf = new JFrame("Demo1");
	        jf.addWindowListener(new WindowAdapter() {
	                public void windowClosing(WindowEvent e) {
	                    System.exit(0);
	                }
	            });
//	        jf.addKeyListener(new ListenerKeyBoard());
	        jf.setResizable(false);
	        Model model = new ModelImp();
	        Controller controller = new ControllerImp();
	        View view = new ViewImpl();
	        model.setView(view);
	        controller.setModel(model);
	        controller.setView(view);
	        view.setController(controller);
	        jf.getContentPane().add(view.getComponent());
	        jf.pack();
	        jf.setVisible(true);
	        view.cicloPrincipalJuego();
	    }

}
