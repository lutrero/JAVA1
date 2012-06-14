package gui;

import java.awt.Graphics2D;

import figuras.CirculoDibujable;
import figuras.RectanguloDibujable;
import figuras.elipse.ElipseDibujable;
import figuras.triangulo.TrianguloDibujable;

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
	public void solicitaNueva() {
		switch (vista.getTipoFigura()) {
		case 1:
			modelo.addFigura(new RectanguloDibujable(new Punto(0, 0),15 +  Math.random()* 85,15 + Math.random()* 85, 0));
			break;
		case 2:
			modelo.addFigura(new CirculoDibujable(new Punto(20,20), 20));
			break;
		case 3:
			modelo.addFigura(new TrianguloDibujable(new Punto(20,20),
						new Punto(30 + Math.random() * 120,30 + Math.random() * 50),new Punto(30 + Math.random() * 10,80 + Math.random() * 100)));
			break;
		case 4:
			modelo.addFigura(new ElipseDibujable(new Punto(7, 13), new Punto(37, 13) , Math.random()*80));
			break;
		}
	}
}
