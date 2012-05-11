package test.figuras;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basicas.Punto;
import figuras.Circulo;

public class CirculoTest {
	
	private Circulo circulo;
	private Circulo circulo2;
	private Punto punto;
	
	@Before
	public void init(){
		circulo = new Circulo();
		punto = new Punto(3,2);
		circulo2 = new Circulo(punto,1);
	}

	@Test
	public void escalarTest() {
		System.out.println(circulo);
		System.out.println(circulo2);
		System.out.println(new Circulo(new Punto(),3));
		System.out.println(new Circulo(new Punto(punto),30));
		assertTrue(circulo.escalar(3).equals(new Circulo(new Punto(),3)));
		assertEquals(circulo2.escalar(30), new Circulo(new Punto(punto),30));
	}

	@Test
	public void desplazarTest(){
		assertTrue(circulo.mover(3,2).equals(circulo2));
		assertEquals(circulo2, circulo.mover(punto));
	}
	
	
	@Test
	public void estaContenidoTest(){
		assertTrue(circulo.estaContenido(new Punto(0.9,0)));
		assertTrue(circulo.estaContenido(new Punto(-0.9,0)));
		assertTrue(circulo.estaContenido(new Punto(0,0)));
		assertTrue(circulo.estaContenido(new Punto(1,0)));
		assertFalse(circulo.estaContenido(new Punto(1, 1)));
		assertTrue(circulo2.estaContenido(new Punto(3.7, 2.7)));
		assertFalse(circulo2.estaContenido(new Punto()));
	}
	
	@Test
	public void estaEnPerimetroTest(){
		assertTrue(circulo.estaEnPerimetro(new Punto(1,0)));
		assertFalse(circulo.estaEnPerimetro(punto));
		assertTrue(circulo.estaEnPerimetro(new Punto(1.004, 0)));
		assertTrue(circulo.estaEnPerimetro(new Punto(0.7071067812, 0.7071067812)));
		assertTrue(circulo2.estaEnPerimetro(new Punto(4, 2)));
		assertTrue(circulo2.estaEnPerimetro(new Punto(3, 3.004)));
		assertTrue(circulo2.estaEnPerimetro(new Punto(3, 0.996)));
		assertTrue(circulo2.estaEnPerimetro(new Punto(3.7071067812, 2.7071067812)));
		assertTrue(circulo2.estaEnPerimetro(new Punto(2.2928932188, 1.2928932188)));
		assertFalse(circulo2.estaEnPerimetro(new Punto(4.5, 3.5)));
	}
	
	@Test
	public void rotarTest(){
		assertEquals(new Circulo(), circulo.rotar(Math.toRadians(75)));
		circulo = new Circulo(punto, 1);
		for (int i = 1; i < 500; i++)
			assertEquals(circulo, circulo2.rotar(Math.toRadians(i)));
	}
	
	@After
	public void finish(){
		circulo = circulo2 = null;
		punto = null;
	}
}
