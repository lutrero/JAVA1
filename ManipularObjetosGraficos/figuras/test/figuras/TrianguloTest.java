package test.figuras;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figuras.triangulo.Triangulo;


import basicas.Punto;



public class TrianguloTest {
	
	private Triangulo t;
	private Triangulo t2;
	
	@Before
	public void init(){
		t = new Triangulo(new Punto(),new Punto(2, 0),new Punto(1, 2));
	}

	@Test
	public void constructorTest(){
		try{
			new Triangulo(null);
		}catch (NullPointerException e) {
			assertEquals(e.getMessage(), "El triangulo es null.");
		}
	}
	
	@Test
	public void moverTest() {
		t2 = new Triangulo(new Punto(1,1), new Punto(2,3), new Punto(3,1));
		assertTrue(t.mover(1, 1).equals(t2));
	}
	
	@Test
	public void escalarTest(){
		t2 = new Triangulo(new Punto(), new Punto(2,4), new Punto(4,0));
		//System.out.println(t.escalar(2));
		System.out.println(t2);
		assertEquals(t.escalar(2), t2);
		assertTrue(t2.escalar(2).escalar(-2).equals(t));
	}
	
	@Test
	public void estaContenidoTest(){
		assertTrue(t.estaContenido(new Punto(1,1)));
		assertTrue(t.estaContenido(new Punto(1.3,1)));
		assertFalse(t.estaContenido(new Punto(2,2)));
	}
	
	@Test
	public void rotarTest(){
		t2 = new Triangulo(t);
		assertEquals(t2, t.rotar(Math.toRadians(360)));
		assertEquals(t2, t.rotar(Math.toRadians(45)).rotar(Math.toRadians(315)));
		t = new Triangulo(t2);
		System.out.println(t);
		t.rotar(Math.toRadians(25));
		t.rotar(Math.toRadians(75));
		t.rotar(Math.toRadians(350));
		t.rotar(Math.toRadians(270));
		System.out.println(t);
		assertEquals(t2, t);
		t = new Triangulo(new Punto(15, 39), new Punto(56, 45), new Punto(3, 9));
		for(int i = 0; i < 36; i++)
			System.out.println(t.rotar(Math.toRadians(10)));
	}
	
	@Test
	public void figuraEnvuelveTest(){
		assertTrue(t.figuraQueEnvuelve().estaEnPerimetro(t.getOrigen()) );
		assertTrue(t.figuraQueEnvuelve().estaEnPerimetro(new Punto(2, 0)));
		assertTrue(t.figuraQueEnvuelve().estaEnPerimetro(new Punto(1, 2)));
		t2 = new Triangulo(new Punto(30, 30),	new Punto(80, 80), new Punto(100, 0));
		assertTrue(t2.figuraQueEnvuelve().estaEnPerimetro(new Punto(30, 30)));
		assertTrue(t2.figuraQueEnvuelve().estaEnPerimetro(new Punto(80, 80)));
		assertTrue(t2.figuraQueEnvuelve().estaEnPerimetro(new Punto(100, 0)));
		System.out.println("hola" + new Triangulo().figuraQueEnvuelve().toString());
		System.out.println("hola" + t.figuraQueEnvuelve().toString());
	}

	@After
	public void finish(){
		t = t2 = null;
	}
}
