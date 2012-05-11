package test.seleccion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basicas.Punto;

import figuras.Circulo;
import figuras.Rectangulo;
import figuras.elipse.Elipse;
import figuras.extra.FiguraExtendida;
import figuras.extra.SeleccionEnvoltura;
import figuras.extra.SeleccionPerimetro;
import figuras.extra.Seleccionable;
import figuras.triangulo.Triangulo;

public class SeleccionableTest {

	private Seleccionable s;
	private Seleccionable s2;
	private Seleccionable s3;
	private Seleccionable s4;
	
	@Before
	public void init(){
		s = new FiguraExtendida(new Circulo(new Punto(), 5));
		s2 = new FiguraExtendida(new Rectangulo(new Punto(), 5, 3, 0));
		s3 = new FiguraExtendida(new Elipse(new Punto(), new Punto(3, 0), 4));
		s4 = new FiguraExtendida(new Triangulo(new Punto(0, 0), new Punto(3, 3), new Punto(5, 1)));
	}
	
	@Test
	public void seleccionNormalTest() {
		assertTrue(s.seleccionar(new Punto(1,1)));
		assertFalse(s.seleccionar(new Punto(5.1, 0)));
		assertTrue(s2.seleccionar(new Punto(3, 3)));
		assertTrue(s3.seleccionar(new Punto(3.4, 0)));
		assertTrue(s4.seleccionar(new Punto(1,1)));
	}
	
	@Test
	public void seleccionPerimetroTest(){
		s.setSeleccion(new SeleccionPerimetro());
		s2.setSeleccion(new SeleccionPerimetro());
		s3.setSeleccion(new SeleccionPerimetro());
		s4.setSeleccion(new SeleccionPerimetro());
		assertTrue(s.seleccionar(new Punto(5,0)));
		assertFalse(s.seleccionar(new Punto(8, 0)));
		assertTrue(s2.seleccionar(new Punto(5, 2)));
		assertFalse(s2.seleccionar(new Punto(2,2)));
		assertTrue(s3.seleccionar(new Punto(3.5,0)));
		assertFalse(s3.seleccionar(new Punto(1.5, 0.6)));
		assertTrue(s4.seleccionar(new Punto(2.5, 0.5)));
		assertFalse(s4.seleccionar(new Punto(2.5,1.3)));
	}
	
	@Test
	public void seleccionEnvolturaTest(){
		s.setSeleccion(new SeleccionEnvoltura());
		s2.setSeleccion(new SeleccionEnvoltura());
		s3.setSeleccion(new SeleccionEnvoltura());
		s4.setSeleccion(new SeleccionEnvoltura());
		assertTrue(s.seleccionar(new Punto(4.999999999999999,0)));	//luis: En el decimal 16 me da fallo cosa de double.
		assertFalse(s.seleccionar(new Punto(5, 0)));	//luis: Increible pero asi es los double de java siguen en su linea.
		assertTrue(s.seleccionar(new Punto(0, 5)));
		assertTrue(s.seleccionar(new Punto(-5.0000000000000001, 0)));//luis: Es que es en el 16!!!
		assertTrue(s.seleccionar(new Punto(-5.0000000000000004440892, 0)));
		assertTrue(s.seleccionar(new Punto(-5.0000000000000004440892, -4.9999999999999995559107901)));//luis: ¿Deberia redondear o una tolerancia del orden de -15 o algo?
		assertTrue(s.seleccionar(new Punto(4, 5)));
		assertTrue(s.seleccionar(new Punto(-5, 5)));
		assertTrue(s.seleccionar(new Punto(4.9, 4.9)));
		assertTrue(s.seleccionar(new Punto(-4.9, -1.9)));
		assertTrue(s.seleccionar(new Punto(-4.999999999999, -4.999999999999)));
		assertTrue(s.seleccionar(new Punto(-5, -4)));
		assertTrue(s2.seleccionar(new Punto(2.5,3)));
		assertTrue(s2.seleccionar(new Punto(5, 0)));
		assertTrue(s3.seleccionar(new Punto(-0.5, 1)));
		assertTrue(s3.seleccionar(new Punto(3.5,0)));
		assertTrue(s3.seleccionar(new Punto(3.5,1)));
		assertTrue(s3.seleccionar(new Punto(-0.5,-1)));
		assertTrue(s4.seleccionar(new Punto(1.4, 1.6)));
		assertTrue(s4.seleccionar(new Punto(2.5, -1)));
	}
	
	@After
	public void finish(){
		s = s2 = s3 = s4 =  null;
		
	}

}
