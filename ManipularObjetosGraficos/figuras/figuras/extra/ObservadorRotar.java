package figuras.extra;

import figuras.interfaces.Observable;
import figuras.interfaces.Observador;

public class ObservadorRotar implements Observador {

	
	private Observable observado;

	public ObservadorRotar(Observable observado) {
		super();
		this.observado = observado;
	}
	
	@Override
	public void notificar() {
		for (String s : observado.getData())
			System.out.println(s);
	}

}
