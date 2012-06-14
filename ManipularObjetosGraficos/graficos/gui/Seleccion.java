package gui;


import figuras.extra.FiguraExtendida;

public class Seleccion {

	private FiguraExtendida figura;
	private Integer referenciaX;
	private Integer referenciaY;
	private Integer angulo;
	private Integer escalado;
	
	
	
	
	public Seleccion(FiguraExtendida figura, Integer referenciaX,
			Integer referenciaY, Integer angulo, Integer escalado) {
		super();
		this.figura = figura;
		this.referenciaX = referenciaX;
		this.referenciaY = referenciaY;
		this.angulo = angulo;
		this.escalado = escalado;
	}

	public FiguraExtendida getFigura() {
		return figura;
	}


	public Integer getReferenciaX() {
		return referenciaX;
	}


	public void setReferenciaX(Integer referenciaX) {
		this.referenciaX = referenciaX;
	}


	public Integer getReferenciaY() {
		return referenciaY;
	}


	public void setReferenciaY(Integer referenciaY) {
		this.referenciaY = referenciaY;
	}


	public Integer getAngulo() {
		return angulo;
	}


	public void setAngulo(Integer angulo) {
		this.angulo = angulo;
	}


	public Integer getEscalado() {
		return escalado;
	}


	public void setEscalado(Integer escalado) {
		this.escalado = escalado;
	}	
}
