package figuras.extra;

import basicas.Punto;

public interface Seleccionable {
	
	public void setSeleccion(CriterioSeleccion c);
	
	public boolean seleccionar(Punto p);	
	
}
