package figuras.interfaces;

import figuras.extra.CriterioSeleccion;
import basicas.Punto;

public interface Seleccionable {
	
	public void setSeleccion(CriterioSeleccion c);
	
	public boolean seleccionar(Punto p);	
	
}
