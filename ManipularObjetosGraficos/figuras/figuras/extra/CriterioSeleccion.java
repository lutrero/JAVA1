package figuras.extra;

import figuras.Figura;
import basicas.Punto;

public interface CriterioSeleccion {

	public boolean selecciona(Figura f, Punto p);
		
}
