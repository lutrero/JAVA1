package test.figuras;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basicas.Punto;
import figuras.elipse.Elipse;

public class ElipseTest {
	
	private Elipse elipse;
	private Elipse elipse2;
	private Elipse elipse3;
	

	@Before
	public void init(){
		elipse = new Elipse();
		elipse2 = new Elipse();
		elipse3 = new Elipse(new Punto(30, 0),new Punto(0, 5), 40);
		
	}

	@Test
	public void escalarTest() {
		assertEquals(elipse2, elipse.escalar(5).escalar(-5));	
	}

	@Test
	public void desplazarTest(){
		assertEquals(elipse2, elipse.mover(3, 5).mover(-3, -5));
		assertEquals(elipse2, elipse.mover(new Punto(6, 34)).mover(new Punto(elipse2.getOrigen())));
	}
	
	@Test
	public void estaContenidoTest(){
		assertTrue(elipse.estaContenido(new Punto()));
		assertTrue(elipse.estaContenido(new Punto(1.5,0)));
		assertTrue(elipse.estaContenido(new Punto(-1.5,0)));
		assertTrue(elipse.estaContenido(new Punto(1,0)));
	}
	
	@Test
	public void estaEnPerimetroTest(){
		assertTrue(elipse.estaEnPerimetro(new Punto(2, 0)));
		assertTrue(elipse.estaEnPerimetro(new Punto(0, -Math.sqrt(3))));
		assertTrue(elipse.estaEnPerimetro(new Punto(-2, 0)));
		assertFalse(elipse.estaEnPerimetro(new Punto(2.2, 7)));
		assertTrue(elipse.estaEnPerimetro(new Punto(1.996, 0)));
	}
	
	@Test
	public void rotarTest(){
		assertEquals(elipse2, elipse.rotar(Math.toRadians(360)));
		assertEquals(elipse2, elipse.rotar(Math.toRadians(360)));
		assertEquals(elipse2,elipse.rotar(Math.toRadians(360)));
		assertEquals(elipse2, elipse.rotar(Math.toRadians(360)));
		elipse = new Elipse(new Punto(30, 0),new Punto(0, 5), 40);
		for (int i = 0 ; i < 360; i++)
			elipse.rotar(Math.toRadians(1));
		assertEquals(elipse3, elipse);
		elipse = new Elipse(new Punto(0, 3), new Punto(6, 3), 8);
		for(int i = 0; i < 45; i++)
			elipse.rotar(Math.toRadians(2));
		assertEquals(elipse, new Elipse(new Punto(3, 0),new Punto(3, 6), 8));
		for(int i = 0; i < 60; i++)
			elipse.rotar(Math.toRadians(3));
		assertEquals(elipse, new Elipse(new Punto(3, 6), new Punto(3, 0), 8));
	}
	
	@Test
	public void rectanguloExteriorTest(){
		System.out.println(elipse2.rectanguloExterior());
		System.out.println(new Elipse(new Punto(10, 50), new Punto(40, 50) , 40).rectanguloExterior());
		assertEquals(elipse3.rectanguloExterior().getOrigen(), elipse3.getOrigen());
	}
	
	@After
	public void finish(){
		elipse = elipse2 = elipse3 = null;
	}

}
