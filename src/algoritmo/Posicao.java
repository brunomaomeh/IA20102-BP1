package algoritmo;

import java.awt.Point;

class Posicao {
	
	private Point posicao;
	
	public Posicao(Point posicao) {
		this.posicao = posicao;
	}
	
	public Point getPosicao() {
		return posicao;
	}
	
	public Point getPosicao0() {
		return new Point(posicao.x - 2, posicao.y - 2);
	}
	
	public Point getPosicao1() {
		return new Point(posicao.x - 2, posicao.y - 1);
	}
	
	public Point getPosicao2() {
		return new Point(posicao.x - 2, posicao.y);
	}
	
	public Point getPosicao3() {
		return new Point(posicao.x - 2, posicao.y + 1);
	}
	
	public Point getPosicao4() {
		return new Point(posicao.x - 2, posicao.y + 2);
	}
	
	public Point getPosicao5() {
		return new Point(posicao.x - 1, posicao.y - 2);
	}
	
	public Point getPosicao6() {
		return new Point(posicao.x - 1, posicao.y - 1);
	}
	
	public Point getPosicao7() {
		return new Point(posicao.x - 1, posicao.y);
	}
	
	public Point getPosicao8() {
		return new Point(posicao.x - 1, posicao.y + 1);
	}
	
	public Point getPosicao9() {
		return new Point(posicao.x - 1, posicao.y + 2);
	}
	
	public Point getPosicao10() {
		return new Point(posicao.x, posicao.y - 2);
	}
	
	public Point getPosicao11() {
		return new Point(posicao.x, posicao.y - 1);
	}
	
	public Point getPosicao12() {
		return new Point(posicao.x, posicao.y + 1);
	}
	
	public Point getPosicao13() {
		return new Point(posicao.x, posicao.y + 2);
	}
	
	public Point getPosicao14() {
		return new Point(posicao.x + 1, posicao.y - 2);
	}
	
	public Point getPosicao15() {
		return new Point(posicao.x + 1, posicao.y - 1);
	}
	
	public Point getPosicao16() {
		return new Point(posicao.x + 1, posicao.y);
	}
	
	public Point getPosicao17() {
		return new Point(posicao.x + 1, posicao.y + 1);
	}
	
	public Point getPosicao18() {
		return new Point(posicao.x + 1, posicao.y + 2);
	}
	
	public Point getPosicao19() {
		return new Point(posicao.x + 2, posicao.y - 2);
	}
	
	public Point getPosicao20() {
		return new Point(posicao.x + 2, posicao.y - 1);
	}
	
	public Point getPosicao21() {
		return new Point(posicao.x + 2, posicao.y);
	}
	
	public Point getPosicao22() {
		return new Point(posicao.x + 2, posicao.y + 1);
	}
	
	public Point getPosicao23() {
		return new Point(posicao.x + 2, posicao.y + 2);
	}
	
}