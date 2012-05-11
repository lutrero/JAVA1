package figuras.extra;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Vector;

import figuras.Figura;
import basicas.Punto;

public final class FiguraExtendida implements Seleccionable, Observable {
	
	private Figura figura;
	private CriterioSeleccion criterioS;
	private List<Observador> observadores;
	private List<Observador> observadoresRotar;
	private List<Observador> observadoresEscalar;
	private List<Observador> observadoresMover;
	private String [] datos;
	
	public FiguraExtendida(Figura figura){
		this(figura, new SeleccionNormal());
	}

	public FiguraExtendida(Figura figura, CriterioSeleccion criterioS) {
		super();
		this.figura = figura;
		this.criterioS = criterioS;
		observadores = new Vector<Observador>();
		observadoresRotar = new Vector<Observador>();
		observadoresEscalar = new Vector<Observador>();
		observadoresMover = new Vector<Observador>();
		datos = new String[3];
	}

	@Override
	public void setSeleccion(CriterioSeleccion c) {
		criterioS = c;
	}

	@Override
	public boolean seleccionar(Punto p) {
		return criterioS.selecciona(figura, p);
	}

	@Override
	public void addObservador(Observador o, int tipo) {
		if (tipo == 1) observadoresRotar.add(o);
		else if (tipo == 2) observadoresEscalar.add(o);
		else if (tipo == 3) observadoresMover.add(o);
	}

	@Override
	public void delObservador(Observador o, int tipo) {
		if (tipo == 1) observadoresRotar.remove(o);
		else if (tipo == 2) observadoresEscalar.remove(o);
		else if (tipo == 3) observadoresMover.remove(o);
	}

	@Override
	public void notificarObservadores() {
		for ( Observador o : observadores )
			o.notificar();
	}

	@Override
	public void rotar(double ang) {
		figura.rotar(ang);
		datos[0] = "rotar";
		datos[1] = "" + ang;
		datos[2] = "";
		observadores = observadoresRotar;
		notificarObservadores();
	}

	@Override
	public void escalar(double f) {
		figura.escalar(f);
		datos[0] = "escalar";
		datos[1] = "" + f;
		datos[2] = "";
		observadores = observadoresEscalar;
		notificarObservadores();
	}

	@Override
	public void mover(double x, double y) {
		figura.mover(new Punto(x, y));
		datos[0] = "mover";
		datos[1] = "" + x;
		datos[2] = "" + y;
		observadores = observadoresMover;
		notificarObservadores();
	}

	@Override
	public String[] getData() {
		return datos;
	}

	@Override
	public Punto getOrigen() {
		return figura.getOrigen();
	}

	@Override
	public void dibuja(Graphics2D g) {
		figura.dibuja(g);
	}

	@Override
	public void mover(Punto p) {
		figura.mover(p);
	}

	@Override
	public void dibujaEnvoltura(Graphics2D g) {
		figura.figuraQueEnvuelve().dibuja(g);
	}
	
}
