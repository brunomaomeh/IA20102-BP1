package algoritmo;

enum ValorUtilidade {
	CIMA(1),
	BAIXO(2),
	DIREITA(3),
	ESQUERDA(4);
	
	private final Integer movimento;

	private ValorUtilidade(Integer movimento) {
		this.movimento = movimento;
	}
	
	public Integer getMovimento() {
		return movimento;
	}
}