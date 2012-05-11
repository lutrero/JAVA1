package figuras.extra;

import figuras.Figura;
import basicas.Punto;

public class SeleccionEnvoltura implements CriterioSeleccion{

	@Override
	public boolean selecciona(Figura f, Punto p) {
		return f.figuraQueEnvuelve().estaContenido(p);
	}
}
