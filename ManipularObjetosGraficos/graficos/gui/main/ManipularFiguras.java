package gui.main;


import gui.Controlador;
import gui.ControladorFiguras;
import gui.Modelo;
import gui.ModeloFiguras;
import gui.Vista;
import gui.VistaFiguras;

import javax.swing.JFrame;

public final class ManipularFiguras {
	
	private ManipularFiguras(){
		super();
	}

	private void ejecuta(){
		Vista vista = new VistaFiguras();
		Modelo modelo = new ModeloFiguras(); 
		Controlador controlador = new ControladorFiguras();
		modelo.setVista(vista);
		vista.setControlador(controlador);
		vista.setModelo(modelo);
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		JFrame ventana = new JFrame("Manipulacion de figuras basicas");
		ventana.setResizable(false);
		ventana.setContentPane(vista.getContenedor());
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	public static void main(String [] args){
		new ManipularFiguras().ejecuta();			
	}
	
	
	
}


