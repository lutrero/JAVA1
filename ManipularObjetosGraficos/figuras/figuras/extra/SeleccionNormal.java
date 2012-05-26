package figuras.extra;

import figuras.interfaces.Figura;
import basicas.Punto;

public final class SeleccionNormal implements CriterioSeleccion{

	@Override
	public boolean selecciona(Figura f, Punto p) {
		return f.estaContenido(p);
	}
}
