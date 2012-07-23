package model;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import controller.Controller;

import obstaculos.Obstaculos;

import premios.Premio;

import levels.Level1;
import levels.Level2;
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
	
	private Levels currentLevel;
	private int puntuacion;
	private int vidas;
	private boolean ballPaused;
	private int nBloques;

	public ModelImpl() {
		super();
		vidas = 3;
		ballPaused = true;
		bolas = new Vector<Bola>();
		obs = new Vector<Obstaculos>();
		puntuacion = 0;
		premios = new Vector<Premio>();
		levels = new Vector<Levels>();
		balas = new Vector<Bala>();
		vista = null;
		controller = null;
		barra = new Bar("Bar.png", 255, 480, 50, 10);
		levels.add(new Level1());
		levels.add(new Level2());
		currentLevel = levels.get(0);
		bloques = currentLevel.generateBlocks();
		bolas.add(new Bola("bullet.png", barra.getCentroX(), barra.getMinY() - 5, 5, 500, 500));
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
		for(Bala b : balas) b.fisica(d);
		
	}

	private void controles() {
		barra.setCentroX(vista.getBarX());
		if(bolas.size() == 0){
			vidas--;
			ballPaused = true;
			bolas.add(new Bola("bullet.png", barra.getCentroX(), barra.getMinY() - 5, 5, 500, 500, 0, 0));
		}
		if (ballPaused) {
			ListIterator<Bola> i = bolas.listIterator();
			Bola b = null;
			if(i.hasNext()) b = i.next();
			if ( b != null){
				b.setCentroX(barra.getCentroX());
				b.setCentroY( barra.getMinY() - 5);
			}
		}
		for (Bola b : bolas){
			if (b.isAlive()){
				nBloques = 0;
			for(List<Bloque> l : bloques)
				for (Bloque bl : l){
					if ( bl.getToques() > 0){
						if (b.intersects(bl)){
							if (bl.getToques() == 1){
								if( bl.getPremio() != null){
									premios.add(bl.getPremio());
									bl.getPremio().setBola(b);
								}
							}
							puntuacion += 5;
							bl.reboteBola(b);
						}
						nBloques++;
					}
				}
			}
			if ( b.intersects(barra)){
				b.invertVy();
				barra.propulsionBola(b);
			}else
			if (b.getCentroY() > barra.getMaxY())
				b.killBall();
		}
		
		if (nBloques == 0) nextLevel();
		
		ListIterator<Premio> i = premios.listIterator();
		Premio p;
		while (i.hasNext()){
			p = i.next();
			if (p.intersects(barra)){
				p.presentCached(controller);
			}
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
		
		ListIterator<Bala> itr = balas.listIterator();
		while (itr.hasNext()){
			Bala b = itr.next();
			if (b.isViva()){
				for (List<Bloque> l : bloques)
					for (Bloque bl : l)
						if (bl.getToques() != 0)
						if(bl.intersects(b)){
							b.setViva(false);
							if (bl.getToques() == 1 ) {
								if(bl.getPremio() != null){
									premios.add(bl.getPremio());
									bl.getPremio().setBola(new Bola());
								}
							}
							puntuacion += 5;
							bl.setToques(bl.getToques() - 1);
						}
			}else{
				itr.remove();
			}
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

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	@Override
	public void addBola(Bola b) {
		bolas.add(b);
	}

	@Override
	public void nextLevel() {
		ListIterator<Premio> i = premios.listIterator();
		while (i.hasNext()){
			i.next();
			i.remove();
		}
		ListIterator<Bola> it = bolas.listIterator();
		while (it.hasNext()){
			it.next();
			it.remove();
		}
		ListIterator<Bala> itr = balas.listIterator();
		while (itr.hasNext()){
			itr.next();
			itr.remove();
		}
		int pos = levels.lastIndexOf(currentLevel) ;
		if ( pos  == levels.size())
			currentLevel = null;
		else{
			Iterator<Levels> l = levels.listIterator(pos + 1);
			if (l.hasNext()) {
			currentLevel = l.next();
			bloques = currentLevel.generateBlocks();
		}}
		ballPaused = true;
		bolas.add(new Bola("bullet.png", barra.getCentroX(), barra.getMinY() - 5, 5, 500, 500, 0, 0));
	}

	@Override
	public void paintAll(Graphics2D g) {
		if(vidas != 0 && currentLevel != null){
		g.drawImage(currentLevel.getImage(),0,0, 500 + 20, 500 + 30 ,null);
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
			g.drawImage(b.getIcon(), b.getMinX(), b.getMinY(), b.getRadio()* 2 + 2, b.getRadio()* 2 +2, null);
		for ( Premio p : premios)
			if(p.getStartTime() == 0)
				g.drawImage(p.getIcon(), p.getMinX(), p.getMinY(), p.getMaxX()- p.getMinX(), p.getMaxY() - p.getMinY(), null);
		paintVidas(g);
		paintScore(g);
		}else{
			g.drawImage(new ImageIcon(getClass().getResource("/images/gameover2.png")).getImage(),0,0, 500 + 20, 500 + 30 ,null);
//			g.drawImage(new ImageIcon(getClass().getResource("/images/girlGameOver.jpg")).getImage(),0,0, 500 + 20, 500 + 30 ,null);
//			g.drawImage(new ImageIcon(getClass().getResource("/images/GameOver.png")).getImage(), 170, 170, 150, 150 ,null);
			g.setColor(Color.WHITE);
			g.drawString("PUNTUACION ", 400, 50);
			g.drawString( "" + puntuacion, 400, 63);
		}
	}
	
	private void paintScore(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawString("" + puntuacion, 240, 20);
		g.drawString("" + nBloques, 400, 20);
	}

	private void paintVidas(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawString(vidas + " L", 20, 20);
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

	@Override
	public int getBarMinX() {
		// TODO Auto-generated method stub
		return barra.getMinX();
	}

	@Override
	public int getBarMaxX() {
		// TODO Auto-generated method stub
		return barra.getMaxX();
	}

	@Override
	public int getBarY() {
		// TODO Auto-generated method stub
		return barra.getMinY();
	}

	@Override
	public void startMoving() {
		ballPaused = false;
		ListIterator<Bola> i = bolas.listIterator();
		Bola b = null;
		if(i.hasNext()) b = i.next();
		if(b.getVy() == 0)b.startM();
	}

	@Override
	public void liveUp() {
		vidas++;
	}

	@Override
	public void bigBall() {
		for(Bola b : bolas)
			b.setRadio(10);
	}
}
