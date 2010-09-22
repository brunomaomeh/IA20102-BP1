package algoritmo;

public class Equipe2 extends ProgramaEquipe2 {
	
	public int acao() {
		return selecionaIntervalo(0,4);
	}
	
	public int selecionaIntervalo(int intervalo1, int intervalo2) {
		return (int) (intervalo1+Math.random() * (intervalo2-intervalo1+1));
	}
}
