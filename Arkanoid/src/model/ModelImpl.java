package model;

import java.util.List;
import java.util.Vector;

import stuff.Bala;
import stuff.Bar;
import stuff.Bloque;
import stuff.Bola;
import stuff.Levels;
import stuff.Obstaculos;
import stuff.Premio;
import view.View;

public class ModelImpl implements Model {

	private List<Levels> levels;
	private List<Bola> bolas;
	private List<List<Bloque>> bloques;
	private List<Obstaculos> obs;
	private List<Premio> premios;
	private List<Bala> balas;
	private View vista;
	private Bar barra;
	
	
	
	public ModelImpl() {
		super();
		// TODO Auto-generated constructor stub
		bolas = new Vector<Bola>();
		bloques = null;
		obs = null;
		premios = new Vector<Premio>();
		levels = new Vector<Levels>();
		balas = new Vector<Bala>();
		vista = null;
		barra = new Bar();
	}

	@Override
	public void setView(View view) {
		vista = view;
	}

	@Override
	public void gameCicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBola() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBola(Bola b) {
		bolas.add(b);
	}

	@Override
	public void nextLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPremio(Premio p) {
		premios.add(p);
	}

	@Override
	public void addBala(Bala b) {
		balas.add(b);
	}

	@Override
	public void setBloques(List<List<Bloque>> bloques) {
		this.bloques = bloques;
	}

	@Override
	public void setObs(List<Obstaculos> obs) {
		this.obs = obs;
	}


}
