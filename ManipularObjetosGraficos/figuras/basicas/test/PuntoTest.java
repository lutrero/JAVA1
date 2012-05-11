package basicas.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basicas.Punto;

public class PuntoTest {

	private Punto punto;
	
	@Before
	public void init(){
		punto = new Punto(2,2);
		
	}

	@Test
	public void getTest() {
		assertTrue(punto.getX() == 2);
		assertTrue(punto.getY() == 2);
	}
	
	@Test
	public void setTest(){
		punto.setX(3);
		assertTrue(punto.getX() == 3);
		punto.setY(3);
		assertTrue(punto.getY() == 3);
	}
	
	@Test
	public void distanciaTest(){
		assertEquals(punto.distancia(new Punto(2, 4)), 2, 0.0000000001);
		assertEquals(punto.distancia(new Punto(97, 2)), 95, 0.0000000001);
		assertEquals(punto.distancia(new Punto(-2, -4)), 7.211102551, 0.0000000001);
		assertEquals(punto.distancia(new Punto(2, -4)), 6, 0.0000000001);
		assertEquals(punto.distancia(new Punto(-2, 4)), 4.472135955, 0.0000000001);
		assertEquals(new Punto(36, 24).distancia(new Punto(-15, -3)), 57.70615219, 0.00000001);
	}
	
	@Test
	public void moverTest(){
		assertEquals(punto.mover(3, 3), new Punto(5, 5));
		assertEquals(punto, punto.mover(3, 3).mover(-3, -3)); 
		
	}
	
	@Test
	public void getPuntoTest(){
		assertEquals(punto.getPunto(Math.sqrt(8), Math.toRadians(225)),new Punto());
		assertEquals(new Punto(15, 32).getPunto(Math.sqrt(15*15+32*32), Math.asin(32/Math.sqrt(15*15+32*32)) + Math.PI),new Punto());
		assertEquals(punto.getPunto(2, Math.toRadians(270)),new Punto(2, 0));
	}
	
	@Test
	public void anguloTest(){
		assertEquals(Punto.anguloTresPuntos(punto, new Punto(3, 2),new Punto(3, 3)), Math.PI/4 , 0.000000001);
		assertEquals(Punto.anguloTresPuntos(punto, new Punto(3, 2), new Punto(-6, 2)), Math.PI, 0.000000001);
		assertEquals(Punto.anguloTresPuntos(punto, new Punto(3, 2), new Punto(2, 3)), Math.PI/2, 0.000000001);
		assertEquals(Punto.anguloTresPuntos(punto,new Punto(3, 2), new Punto(0, 4)), 3*Math.PI/4, 0.000000001);
		assertEquals(Punto.anguloTresPuntos(new Punto(2, 1), new Punto(5, 0), new Punto(7, 8)), 1.272297395, 0.000000001);
	}
	
	@Test
	public void equalsTest(){
		assertTrue(punto.equals(new Punto(2,2)));
		assertEquals(punto, new Punto(2.00000000003,1.9999999999));
		assertFalse(new Punto(2.00003, 3.00003).equals(new Punto(2,3)));
	}
	
	
	@After
	public void finish(){
		punto = null;
	}
}
