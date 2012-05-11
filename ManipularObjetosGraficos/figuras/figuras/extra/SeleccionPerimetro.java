package figuras.extra;

import figuras.Figura;
import basicas.Punto;

public class SeleccionPerimetro implements CriterioSeleccion {

	@Override
	public boolean selecciona(Figura f, Punto p) {
		return f.estaEnPerimetro(p);
	}
}
