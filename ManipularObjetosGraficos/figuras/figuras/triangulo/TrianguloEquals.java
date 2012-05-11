package figuras.triangulo;

/**
 * 
 * @author Luis Treviño
 * 
 * Clase que encapsula el metodo equals.
 *
 */

public final class TrianguloEquals {
	
	static boolean comparaTriangulos(Triangulo t, Object obj){
		if (t == obj)
			return true;
		if (obj == null)
			return false;
		if (t.getClass() != obj.getClass())
			return false;
		Triangulo other = (Triangulo) obj;
		if (! t.getA().equals(other.getA()))
			if(! t.getA().equals(other.getB()))
				if(! t.getA().equals(other.getC()))
					return false;
				else if (! t.getB().equals(other.getA()))
					if (! t.getB().equals(other.getB()))
						return false;
					else if (! t.getC().equals(other.getA()))
						return false;
					else return true;
				else if (!t.getC().equals(other.getB()))
					return false;
				else return true;
			else if (!t.getB().equals(other.getA()))
				if (!t.getB().equals(other.getC()))
					return false;
				else if (!t.getC().equals(other.getA()))
					return false;
				else return true;
			else if (!t.getC().equals(other.getC()))
				return false;
			else return true;
		else if (!t.getB().equals(other.getB()))
			if (!t.getB().equals(other.getC()))
				return false;
			else if (!t.getC().equals(other.getB()))
				return false;
			else return true;
		else if(!t.getC().equals(other.getC()))
			return false;
		else return true;
	}
}
