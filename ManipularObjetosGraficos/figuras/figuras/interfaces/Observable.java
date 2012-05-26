package figuras.interfaces;




public interface Observable {
	
	public static final int ROTAR = 1;
	public static final int ESCALAR = 2;
	public static final int MOVER = 3;

	public void addObservador(Observador o, int tipo);
	
	public void delObservador(Observador o, int tipo);
	
	public void notificarObservadores();
	
	
	public String [] getData();
}
