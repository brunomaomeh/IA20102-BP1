package algoritmo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private static final int NUMERO_MAXIMO_DA_MEMORIA = 6;
	private List<Point> memoria;
	
	public Memoria() {
		memoria = new ArrayList<Point>();
	}
	
	public List<Point> getMemoria() {
		return memoria;
	}
	
	public void memoriza(Posicao posicao) {
		memoria.add(posicao.getPosicao());
		if (memoria.size() == NUMERO_MAXIMO_DA_MEMORIA) {
			memoria.remove(0);
		}
	}

	public boolean jahVisitou(Point posicao) {
		return memoria.contains(posicao);
	}
	
}