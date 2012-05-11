package figuras.triangulo;

/**
 * @author Luis Treviño
 * 
 * Clase que encapsula el trabajo previo del constructor con parametros.
 */

import basicas.Punto;

public final class OrdenaTriangulo {
	
	
	static Triangulo ordenaVertices(Triangulo t, Punto a1, Punto b1, Punto c1){
		if (a1.equals(b1) || a1.equals(c1) || b1.equals(c1)) throw new IllegalStateException("En un triangulo dos puntos no pueden coincidir.");
		int niveles = 0;
		if ( a1.compareX(b1) <= 0 )
			if (a1.compareX(c1) <= 0)
			{	
				t.setA(a1);
				niveles = 5;
			}
			else{
				t.setA(c1);
				niveles = 3;
			}
		else if(b1.compareX(c1) <= 0){
			t.setA(b1);
			niveles = 4;
		}
		else{
			t.setA(c1);
			niveles = 3;
		}
		switch (niveles) {
		case 3:
		{
			if (a1.compareY(b1) <= 0){
				t.setB(b1);
				t.setC(a1);
			}else{
				t.setB(a1);
				t.setC(b1);
			}
			break;
		}
		case 4:
		{
			if (a1.compareY(c1) <= 0){
				t.setB(c1);
				t.setC(a1);
			}else{
				t.setB(a1);
				t.setC(c1);
			}
			break;
		}
		case 5:
		{
			if (b1.compareY(c1) <= 0){
				t.setB(c1);
				t.setC(b1);
			}else{
				t.setB(b1);
				t.setC(c1);
				}
				break;
			}
		}
		return t;
	}
}
