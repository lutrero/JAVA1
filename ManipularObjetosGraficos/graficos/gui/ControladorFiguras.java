package gui;

import figuras.interfaces.FiguraDibujable;

import java.awt.Graphics2D;

import basicas.Punto;

public class ControladorFiguras implements Controlador{
	
	private Modelo modelo;
	private Vista vista;

	@Override
	public void setModelo(Modelo m) {
		modelo = m;
	}

	@Override
	public void setVista(Vista v) {
		vista = v;
	}

	@Override
	public void solicitaMover(Punto p) {
		modelo.setPosicion(p);
	}

	@Override
	public void solicitaMover(double dx, double dy) {
		modelo.setPosicion(dx, dy);	
	}
	
	@Override
	public void solicitaEscalar(double d ,double r) {
		modelo.setEscalado(d, r);
	}

	@Override
	public void solicitaRotar(double a, double r) {
		modelo.setRotacion(a, r);
	}

	@Override
	public void solicitaBorrar() {
		modelo.borrar();
	}

	@Override
	public void solicitarSeleccionar(Punto p) {
		modelo.seleccionar(p);
	}

	@Override
	public void solicitaActulizarPosicion(Punto p) {
		modelo.actualizaPosicion(p);
	}

	@Override
	public void solicitaDibujar(Seleccion s ,Graphics2D g) {
		modelo.dibujar(s, g);
	}

	@Override
	public void solicitaNueva(FiguraDibujable f) {
		modelo.addFigura(vista.getFigura());
	}
}
