package gui;

import figuras.extra.FiguraExtendida;
import figuras.extra.SeleccionEnvoltura;
import figuras.extra.SeleccionNormal;
import figuras.interfaces.FiguraDibujable;
import figuras.interfaces.Seleccionable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Vector;

import basicas.Punto;

public class ModeloFiguras implements Modelo {
	
	private Vector<Seleccion> vectorFiguras;
	private Seleccion seleccionada;
	private Vista vista;
	
	public ModeloFiguras(){
		super();
		vectorFiguras = new Vector<Seleccion>();
	}

	@Override
	public void setVista(Vista v) {
		vista = v;
	}

	@Override
	public Seleccion getSeleccion() {
		return seleccionada;
	}

	@Override
	public Vector<Seleccion> getVectorFiguras() {
		return vectorFiguras;
	}

	@Override
	public synchronized void setRotacion(double angulo, double ref) {
		if (seleccionada != null){
			seleccionada.getFigura().rotar(angulo);
			seleccionada.setAngulo((int) ref);
			Punto p = seleccionada.getFigura().getOrigen();
			seleccionada.setReferenciaX((int) p.getX());
			seleccionada.setReferenciaY((int) p.getY());
		}
		vista.repintar();
	}

	@Override
	public synchronized void setPosicion(Punto p) {
		if (seleccionada != null) {
			seleccionada.getFigura().mover(p);
			seleccionada.setReferenciaX((int) p.getX());
			seleccionada.setReferenciaY((int) p.getY());
		}
		vista.repintar();
	}

	@Override
	public synchronized void setPosicion(double dx, double dy) {
		if (seleccionada != null) {
			seleccionada.getFigura().mover(dx, dy);
			seleccionada.setReferenciaX(seleccionada.getReferenciaX() + (int)dx);
			seleccionada.setReferenciaY( seleccionada.getReferenciaY() + (int)dy);
		}
		vista.repintar();
	}

	
	@Override
	public synchronized void setEscalado(double factor, double ref) {
		if (seleccionada != null){
			seleccionada.getFigura().escalar(factor);
			seleccionada.setEscalado((int) ref);
		}
		vista.setSliders(null);
		vista.repintar();
	}

	@Override
	public synchronized Seleccion seleccionar(Punto p) {
		if (seleccionada != null){
			Seleccionable sel = seleccionada.getFigura();
			if(seleccionada.getFigura().seleccionar(p)){
				sel = seleccionada.getFigura();
				sel.setSeleccion(new SeleccionEnvoltura());
				return seleccionada;
			}else
				for (Seleccion s : vectorFiguras)
					if(s.getFigura().seleccionar(p)){
						seleccionada = s;
						sel = seleccionada.getFigura();
						sel.setSeleccion(new SeleccionEnvoltura());
						return seleccionada;
					}
			sel.setSeleccion(new SeleccionNormal());
		}else
			for (Seleccion s : vectorFiguras)
				if(s.getFigura().seleccionar(p)){
					seleccionada = s;
					Seleccionable sel = seleccionada.getFigura();
					sel.setSeleccion(new SeleccionEnvoltura());
					return seleccionada;
				}
		seleccionada = null;
		return null;
	}

	@Override
	public synchronized void actualizaPosicion(Punto p) {
		seleccionada.getFigura().mover(p);
		seleccionada.setReferenciaX((int) p.getX());
		seleccionada.setReferenciaY((int) p.getY());
		vista.setSliders(p);
		vista.repintar();
	}

	@Override
	public void dibujar(Seleccion s, Graphics2D g) {
		s.getFigura().dibuja(g);
		if(seleccionada != null && seleccionada.equals(s)){
			g.setColor(Color.WHITE);
			s.getFigura().dibujaEnvoltura(g);
			g.setColor(Color.BLACK);
		}
		vista.repintar();
	}

	@Override
	public synchronized void addFigura(FiguraDibujable f) {
		vectorFiguras.add(new Seleccion(new FiguraExtendida(f),(int) f.getOrigen().getX(), (int)f.getOrigen().getY(), 0, 1));
		vista.repintar();
	}

	@Override
	public synchronized void borrar() {
		if(seleccionada != null)
			vectorFiguras.remove(seleccionada);
		seleccionada = null;
		vista.repintar();
	}
}
