package model;


import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Timer;

import levels.Level1;
import levels.Levels;

import stuff.Bala;
import stuff.Bar;
import stuff.Bloque;
import stuff.Bola;
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
	
	private int puntuacion;

	
	
	
	public ModelImpl() {
		super();
		// TODO Auto-generated constructor stub
		bolas = new Vector<Bola>();
		bloques = null;
		obs = new Vector<Obstaculos>();
		puntuacion = 0;
		premios = new Vector<Premio>();
		levels = new Vector<Levels>();
		balas = new Vector<Bala>();
		vista = null;
		barra = new Bar("Nebulosa.jpg", 50, 480, 50, 10);
		levels.add(new Level1());
		bloques = levels.get(0).generateBlocks();
		bolas.add(new Bola("Nebulosa.jpg", 50, 490, 5, 500, 500));
		
	}

	@Override
	public void setView(View view) {
		vista = view;
	}

	private void pintar() {
		vista.repintar();
	}

	private void fisica(float d) {
		for ( Bola b : bolas)
			b.fisica(d);
		
	}

	private void controles() {
		barra.setCentroX(vista.getBarX());
		for (Bola b : bolas){
			for(List<Bloque> l : bloques)
				for(Bloque bl : l){
					if(bl.getToques() != 0){
						if(b.getCentroX() == bl.getCentroX() && b.getMinY() == bl.getMaxY() && b.getMaxY() == bl.getMinY()){
							bl.setToques(bl.getToques() - 1);
							b.invertVy();
							puntuacion += 25;
						}else
						if(b.getCentroY() == bl.getCentroY() && b.getMaxX() == bl.getMinX() && b.getMinX() == bl.getMaxX()){
							bl.setToques(bl.getToques() - 1);
							b.invertVx();
							puntuacion += 25;
						}
					}
				}
			if (b.getMinY() < barra.getCentroY() && b.getMaxY() >= barra.getMinY()){
				if ( b.getCentroX() < (barra.getMinX() + barra.getAnchoExt()) && b.getMaxX() > barra.getMinX()){
					if (b.getVx() >= 0)
						b.invertVx();
					if ( b.getVx() < 400f)
						b.accelX();
					if (b.getCentroX() < barra.getMinX() && b.getVy() > 200f )
						b.deccelY();
					b.invertVy();
				}else if (b.getCentroX() > (barra.getMaxX() - barra.getAnchoExt()) && b.getMinX() > barra.getMaxX() ){
					if (b.getVx() <= 0)
						b.invertVx();
					if ( b.getVx() > -400f)
						b.accelX();
					if (b.getCentroX() > barra.getMaxX() && b.getVy() > 200f)
						b.deccelY();
					b.invertVy();
				}else if ( b.getCentroX() >= barra.getMinX() + barra.getAnchoExt() && b.getCentroX() <= barra.getCentroX()){
					if ( b.getVy() < 400f && b.getVy() > 0)
						b.accelY();
					if ( b.getVx() > 0)
						b.deccelX();
					b.invertVy();
				}else if( b.getCentroX() <= barra.getMaxX() - barra.getAnchoExt() && b.getCentroX() >= barra.getCentroX()){
					if ( b.getVy() > -400f && b.getVy() < 0)
						b.accelY();
					if ( b.getVx() < 0)
						b.deccelX();
					b.invertVy();
				}
			}}
	}
	
	@Override
	public void gameCicle() {
		Timer gameTimer = new Timer(30, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controles();
				fisica(0.015f);
				pintar();
			}

		});
		gameTimer.start();
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
		
	}

	@Override
	public void paintAll(Graphics2D g) {
		for ( Bola b : bolas)
			g.drawImage(b.getIcon(), b.getMinX(), b.getMinY(), b.getRadio() * 2, b.getRadio() * 2, null);
		for(List<Bloque> l : bloques)
			for(Bloque b : l)
				if ( b.getToques() != 0)
					g.drawImage(b.getIcon(), b.getMinX(), b.getMinY(), b.getAncho(), b.getAlto(), null);
		g.drawImage(barra.getIcon(), barra.getMinX(), barra.getMinY(), barra.getAncho(), barra.getAlto(), null);
		for ( Obstaculos o : obs)
			g.drawImage(o.getIcon(), o.getMinX(), o.getMinY(), o.getAncho(), o.getAlto(), null);
		for ( Bala b : balas)
			g.drawImage(b.getIcon(), b.getMinX(), b.getMinY(), b.getRadio()* 2, b.getRadio()* 2, null);
		for ( Premio p : premios)
			g.drawImage(p.getIcon(), p.getMinX(), p.getMinY(), p.getMaxX()- p.getMinX(), p.getMaxY() - p.getMinY(), null);		
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


	@Override
	public void setBarPos(int x, int y) {
		barra.setCentroX(x + barra.getAncho()/2);
		barra.setCentroY(485);
	}

	@Override
	public int getPuntuacion() {
		// TODO Auto-generated method stub
		return puntuacion;
	}

	
}
