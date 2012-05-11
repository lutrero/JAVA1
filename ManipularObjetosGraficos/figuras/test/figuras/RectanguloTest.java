package test.figuras;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figuras.Rectangulo;
import basicas.Punto;


public class RectanguloTest {
	
	private Rectangulo r;
	private Rectangulo r2;
	private Punto p;
	
	@Before
	public void init(){
		r = new Rectangulo();
		r2 = new Rectangulo(new Punto(15, 15), 25, 10, 0);
		p = new Punto(1,1);
	}

	@Test
	public void AreaTest() {
		assertTrue(r.area() == 1); 
		assertEquals(new Rectangulo(new Punto(24, 36), 10, 25, Math.toRadians(27)).area(), 250, 0.000000001);
	}
	
	@Test
	public void EscalarTest() {
		assertTrue(r.equals(r.escalar(5).escalar(-5)));
	}
	
	@Test
	public void ContenidoTest() {
		assertTrue(r.estaContenido(p)); 
		assertTrue(r.estaContenido(new Punto(1, 1)));
		assertTrue(r.estaContenido(new Punto(0.7, 0.3)));
		assertFalse(r.estaContenido(new Punto(0, -1)));
		
	}
	
	@Test
	public void PerimetroTest() {
		assertTrue(r.estaEnPerimetro(p));
		assertFalse(r.estaEnPerimetro(new Punto(5, 5)));
	}
	
	@Test
	public void RotarTest(){
		assertTrue(r.equals(r.rotar(2*Math.PI)));
		r = new Rectangulo(new Punto(15, 15), 25, 10, 0);
		for(int i = 0; i < 360; i++)
			r2.rotar(Math.toRadians(1));
		assertEquals(r, r2); 
	}
	
	@After
	public void finish(){
		r = r2 = null;
	}
 
}
