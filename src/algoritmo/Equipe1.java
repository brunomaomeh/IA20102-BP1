package algoritmo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static algoritmo.ValorUtilidade.BAIXO;
import static algoritmo.ValorUtilidade.CIMA;
import static algoritmo.ValorUtilidade.DIREITA;
import static algoritmo.ValorUtilidade.ESQUERDA;

public class Equipe1 extends ProgramaEquipe1 {
	
	private Integer identificador;
	
	private static Integer count = 0;
	
	private static final Integer SEM_VISAO_PARA_O_LOCAL = -2;
	private static final Integer FORA_DO_AMBIENTE = -1;
	private static final Integer CELULA_NAO_VISITADA = 0;
	private static final Integer PAREDE = 1;
	private static final List<Integer> EQUIPE1 = new ArrayList<Integer>();
	private static final List<Integer> EQUIPE2 = new ArrayList<Integer>();
	private static final Integer CAIXA = 3;
	private static final Integer CELULA_VISITADA_POR_AGENTE_DA_MESMA_EQUIPE = 5;
	private static final Integer CELULA_VISITADA_POR_AGENTE_DA_EQUIPE_ADVERSARIA = 6;
	private static final Integer CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE = 7;
	
	private Boolean estahPreso = false;
	
	private int[] olfatoEquipe;
	private int[] olfatoOponente;
	private int[] visao;
	private Posicao posicao;
	private Memoria memoria;

	public Equipe1() {
		if (count < 9) {
			identificador = count;
			count++;
		} else {
			count = 0;
			identificador = count;
			count++;
		}
		memoria = new Memoria();
	}
	
	public void setVisao(int[] visao) {
		this.visao = visao;
	}

	public int acao() {
//		if (identificador == 0) {
			this.carregaSensores();
			Integer movimento = getMovimento();
			memoria.memoriza(posicao);
			return movimento;
//		}
//		return 0;
	}

	void carregaSensores() {
		olfatoEquipe = sensor.getAmbienteOlfatoEquipe();
		olfatoOponente = sensor.getAmbienteOlfatoOponente();
		visao = sensor.getVisaoIdentificacao();
		posicao = new Posicao(sensor.getPosicao());
	}

	public Integer getMovimento() {
		Map<ValorUtilidade, Integer> mapaUtilidade = getMapaValorUtilidade();

		if (this.temCimaComoMaiorValorUtilidade(mapaUtilidade)) {
			return CIMA.getMovimento();
		} else if (this.temBaixoComoMaiorValorUtilidade(mapaUtilidade)) {
			return BAIXO.getMovimento();
		} else if (this.temDireitaComoMaiorValorUtilidade(mapaUtilidade)) {
			return DIREITA.getMovimento();
		} else if (this.temEsquerdaComoMaiorValorUtilidade(mapaUtilidade)) {
			return ESQUERDA.getMovimento();
		}
		
		return (int) (1+Math.random() * (4));
	}

	Boolean temBaixoComoMaiorValorUtilidade(Map<ValorUtilidade, Integer> valorUtilidade) {
		return valorUtilidade.get(BAIXO) > valorUtilidade.get(CIMA) 
			&& valorUtilidade.get(BAIXO) > valorUtilidade.get(DIREITA)
			&& valorUtilidade.get(BAIXO) > valorUtilidade.get(ESQUERDA);
	}

	Boolean temCimaComoMaiorValorUtilidade(Map<ValorUtilidade, Integer> valorUtilidade) {
		return valorUtilidade.get(CIMA) > valorUtilidade.get(BAIXO) 
			&& valorUtilidade.get(CIMA) > valorUtilidade.get(DIREITA)
			&& valorUtilidade.get(CIMA) > valorUtilidade.get(ESQUERDA);
	}

	Boolean temDireitaComoMaiorValorUtilidade(Map<ValorUtilidade, Integer> valorUtilidade) {
		return valorUtilidade.get(DIREITA) > valorUtilidade.get(BAIXO) 
			&& valorUtilidade.get(DIREITA) > valorUtilidade.get(CIMA)
			&& valorUtilidade.get(DIREITA) > valorUtilidade.get(ESQUERDA);
	}
	
	Boolean temEsquerdaComoMaiorValorUtilidade(Map<ValorUtilidade, Integer> valorUtilidade) {
		return valorUtilidade.get(ESQUERDA) > valorUtilidade.get(BAIXO) 
			&& valorUtilidade.get(ESQUERDA) > valorUtilidade.get(CIMA)
			&& valorUtilidade.get(ESQUERDA) > valorUtilidade.get(DIREITA);
	}
	
	Map<ValorUtilidade, Integer> getMapaValorUtilidade() {
		Map<ValorUtilidade, Integer> mapa = new HashMap<ValorUtilidade, Integer>();
		
		mapa.put(CIMA, this.getValorUnidadeCima());
		mapa.put(BAIXO, this.getValorUnidadeBaixo());
		mapa.put(DIREITA, this.getValorUnidadeDireita());
		mapa.put(ESQUERDA, this.getValorUnidadeEsquerda());
		
		return mapa;
	}

	Integer getValorUnidadeCima() {
		Integer valorUnidade = 0;
		
		if (this.estahPreso) {
			Integer celula = visao[7];
			if (celulaIgualParede(celula)) {
				return -1000;
			}
		} else {
			valorUnidade = valorUnidade+ valorDeVisaoDaCelula0();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula1();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula2();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula3();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula4();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula6();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula7();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula8();
		}

		return valorUnidade;
	}
	
	Integer getValorUnidadeBaixo() {
		Integer valorUnidade = 0;
		
		if (this.estahPreso) {
			Integer celula = visao[16];
			if (celulaIgualParede(celula)) {
				return -1000;
			}
		} else {
			valorUnidade = valorUnidade + valorDeVisaoDaCelula15();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula16();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula17();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula19();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula20();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula21();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula22();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula23();
		}
		
		return valorUnidade;
	}
	
	Integer getValorUnidadeDireita() {
		Integer valorUnidade = 0;
		
		if (this.estahPreso) {
			Integer celula = visao[11];
			if (celulaIgualParede(celula)) {
				return -1000;
			}
		} else {
			valorUnidade = valorUnidade + valorDeVisaoDaCelula4();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula8();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula9();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula12();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula13();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula17();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula18();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula23();
		}

		return valorUnidade;
	}
	
	Integer getValorUnidadeEsquerda() {
		Integer valorUnidade = 0;
		
		if (this.estahPreso) {
			Integer celula = visao[12];
			if (celulaIgualParede(celula)) {
				return -1000;
			}
		} else {
			valorUnidade = valorUnidade + valorDeVisaoDaCelula0();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula5();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula6();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula10();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula11();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula14();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula15();
			valorUnidade = valorUnidade + valorDeVisaoDaCelula19();
		}

		return valorUnidade;
	}
	
	Integer valorDeVisaoDaCelula0() {
		Integer celula = visao[0];
		if (memoria.jahVisitou(posicao.getPosicao0())) {
			return -3;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 3;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula1() {
		Integer celula = visao[1];
		if (memoria.jahVisitou(posicao.getPosicao1())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}

	Integer valorDeVisaoDaCelula2() {
		Integer celula = visao[2];
		if (memoria.jahVisitou(posicao.getPosicao2())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula3() {
		Integer celula = visao[3];
		if (memoria.jahVisitou(posicao.getPosicao3())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula4() {
		Integer celula = visao[4];
		if (memoria.jahVisitou(posicao.getPosicao4())) {
			return -3;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 3;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula5() {
		Integer celula = visao[5];
		if (memoria.jahVisitou(posicao.getPosicao5())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula6() {
		Integer celula = visao[6];
		if (memoria.jahVisitou(posicao.getPosicao6())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula7() {
		Integer celula = visao[7];
		if (memoria.jahVisitou(posicao.getPosicao7())) {
			return -12;
		} else if (celulaIgualParede(celula)) {
			return -12;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 12;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula8() {
		Integer celula = visao[8];
		if (memoria.jahVisitou(posicao.getPosicao8())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula9() {
		Integer celula = visao[9];
		if (memoria.jahVisitou(posicao.getPosicao9())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula10() {
		Integer celula = visao[10];
		if (memoria.jahVisitou(posicao.getPosicao10())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula11() {
		Integer celula = visao[11];
		if (memoria.jahVisitou(posicao.getPosicao11())) {
			return -12;
		} else if (celulaIgualParede(celula)) {
			return -12;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 12;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula12() {
		Integer celula = visao[12];
		if (memoria.jahVisitou(posicao.getPosicao12())) {
			return -12;
		} else if (celulaIgualParede(celula)) {
			return -12;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 12;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula13() {
		Integer celula = visao[13];
		if (memoria.jahVisitou(posicao.getPosicao13())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula14() {
		Integer celula = visao[14];
		if (memoria.jahVisitou(posicao.getPosicao14())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula15() {
		Integer celula = visao[15];
		if (memoria.jahVisitou(posicao.getPosicao15())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}

	private boolean celulaIgualParede(Integer celula) {
		return celula == PAREDE;
	}
	
	Integer valorDeVisaoDaCelula16() {
		Integer celula = visao[16];
		if (memoria.jahVisitou(posicao.getPosicao16())) {
			return -12;
		} else if (celulaIgualParede(celula)) {
			return -12;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 12;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula17() {
		Integer celula = visao[17];
		if (memoria.jahVisitou(posicao.getPosicao17())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula18() {
		Integer celula = visao[18];
		if (memoria.jahVisitou(posicao.getPosicao18())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula19() {
		Integer celula = visao[19];
		if (memoria.jahVisitou(posicao.getPosicao19())) {
			return -3;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 3;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula20() {
		Integer celula = visao[20];
		if (memoria.jahVisitou(posicao.getPosicao20())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula21() {
		Integer celula = visao[21];
		if (memoria.jahVisitou(posicao.getPosicao21())) {
			return -9;
		} else if (celulaIgualParede(celula)) {
			return -2;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 9;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula22() {
		Integer celula = visao[22];
		if (memoria.jahVisitou(posicao.getPosicao22())) {
			return -6;
		} else if (celulaIgualParede(celula)) {
			return -1;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 6;
		}
		return 0;
	}
	
	Integer valorDeVisaoDaCelula23() {
		Integer celula = visao[23];
		if (memoria.jahVisitou(posicao.getPosicao23())) {
			return -3;
		} else if (celula == CELULA_NAO_VISITADA) {
			return 3;
		}
		return 0;
	}
	
}
