package figuras.extra;

import figuras.CirculoDibujable;
import figuras.RectanguloDibujable;
import figuras.elipse.ElipseDibujable;
import figuras.interfaces.FiguraGrafica;
import figuras.interfaces.Observable;
import figuras.interfaces.Observador;
import figuras.triangulo.TrianguloDibujable;

public class ObservadorTest {

	
	public static void main(String[] args) {
		FiguraGrafica rectangulo = new FiguraExtendida(new RectanguloDibujable());
		FiguraGrafica circulo = new FiguraExtendida(new CirculoDibujable());
		FiguraGrafica triangulo = new FiguraExtendida(new TrianguloDibujable());
		FiguraGrafica elipse = new FiguraExtendida(new ElipseDibujable());
		Observador oEscalarRe = new ObservadorEscalar(rectangulo);
		Observador oEscalarRe2 = new ObservadorEscalar(rectangulo);
		Observador oEscalarEl = new ObservadorEscalar(elipse);
		Observador oEscalarCi = new ObservadorEscalar(circulo);
		Observador oEscalarTr = new ObservadorEscalar(triangulo);
		Observador oMoverEl = new ObservadorMover(elipse);
		Observador oMoverCi = new ObservadorMover(circulo);
		Observador oMoverRe = new ObservadorMover(rectangulo);
		Observador oMoverTr = new ObservadorMover(triangulo);
		Observador oRotarEl = new ObservadorMover(elipse);
		Observador oRotarCi = new ObservadorMover(circulo);
		Observador oRotarRe = new ObservadorMover(rectangulo);
		Observador oRotarTr = new ObservadorMover(triangulo);
		
		rectangulo.addObservador(oRotarRe, Observable.ROTAR);
		rectangulo.addObservador(oMoverRe, Observable.MOVER);
		rectangulo.addObservador(oEscalarRe, Observable.ESCALAR);
		circulo.addObservador(oRotarCi, Observable.ROTAR);
		circulo.addObservador(oMoverCi, Observable.MOVER);
		circulo.addObservador(oEscalarCi, Observable.ESCALAR);
		triangulo.addObservador(oRotarTr, Observable.ROTAR);
		triangulo.addObservador(oMoverTr, Observable.ROTAR);
		triangulo.addObservador(oEscalarTr, Observable.ESCALAR);
		elipse.addObservador(oRotarEl, Observable.ROTAR);
		elipse.addObservador(oMoverEl, Observable.MOVER);
		elipse.addObservador(oEscalarEl, Observable.ESCALAR);
		rectangulo.addObservador(oEscalarRe2, Observable.ESCALAR);
		
		rectangulo.mover(2, 2);
		rectangulo.escalar(3);
		rectangulo.rotar(Math.toRadians(90));
		circulo.mover(3, 3);
		circulo.escalar(4);
		circulo.rotar(Math.toRadians(90));
		triangulo.mover(4, 4);
		triangulo.escalar(5);
		triangulo.rotar(Math.toRadians(90));
		elipse.mover(5, 5);
		elipse.escalar(6);
		elipse.rotar(Math.toRadians(90));
		
	}

}
