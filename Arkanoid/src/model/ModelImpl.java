package model;


import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import controller.Controller;

import obstaculos.Obstaculos;

import premios.Premio;

import levels.Level1;
import levels.Levels;

import stuff.Bala;
import stuff.Bar;
import stuff.Bloque;
import stuff.Bola;
import view.View;

public class ModelImpl implements Model {

	private List<Levels> levels;
	private List<Bola> bolas;
	private List<List<Bloque>> bloques;
	private List<Obstaculos> obs;
	private List<Premio> premios;
	private List<Bala> balas;
	private View vista;
	private Controller controller;
	private Bar barra;
	
	private int puntuacion;

	public ModelImpl() {
		super();
		bolas = new Vector<Bola>();
		obs = new Vector<Obstaculos>();
		puntuacion = 0;
		premios = new Vector<Premio>();
		levels = new Vector<Levels>();
		balas = new Vector<Bala>();
		vista = null;
		controller = null;
		barra = new Bar("aBar.png", 50, 480, 50, 10);
		levels.add(new Level1());
		bloques = levels.get(0).generateBlocks();
		bolas.add(new Bola("normalBall.png", 50, 450, 5, 500, 500));
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
		for(Premio p : premios){
			p.fisica(d);
		}
		
	}

	private void controles() {
		barra.setCentroX(vista.getBarX());
		for (Bola b : bolas){
			if (b.isAlive())
			for(List<Bloque> l : bloques)
				for (Bloque bl : l){
					if ( bl.getToques() != 0)
						if (b.intersects(bl)){
							if (bl.getToques() == 1 && bl.getPremio() != null){
								premios.add(bl.getPremio());
								bl.getPremio().setBola(b);
							}
							puntuacion += 5;
							bl.reboteBola(b);
						}
				}
			if ( b.intersects(barra)){
				b.invertVy();
				barra.propulsionBola(b);
			}
			if (b.getMinY() > barra.getMaxY())
				b.killBall();
		}
		for (Premio p : premios){
			if (p.intersects(barra)){
				p.presentCached(controller);
			}
		}
		ListIterator<Premio> i = premios.listIterator();
		Premio p;
		while (i.hasNext()){
			p = i.next();
			if(p.isKill())
				i.remove();
			else{
				p.doAction(controller);
			}
		}
		
		ListIterator<Bola> it = bolas.listIterator();
		while (it.hasNext()){
			if(!it.next().isAlive())
				it.remove();
		}
	}	
	

	
	@Override
	public void gameCicle() {
		Timer gameTimer = new Timer(30, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controles();
				fisica(0.025f);
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
		g.drawImage(new ImageIcon(getClass().getResource("/images/Nebulosa.jpg")).getImage(),0,0, 500 + 20, 500 + 30 ,null);
		for ( Bola b : bolas)
			if(b.isAlive())
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

	@Override
	public void setController(Controller c) {
		controller = c;
	}
}
