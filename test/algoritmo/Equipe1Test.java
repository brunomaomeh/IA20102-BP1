package algoritmo;

import static algoritmo.ValorUtilidade.BAIXO;
import static algoritmo.ValorUtilidade.CIMA;
import static algoritmo.ValorUtilidade.DIREITA;
import static algoritmo.ValorUtilidade.ESQUERDA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Equipe1Test {

	private static Integer SEM_VISAO_PARA_O_LOCAL = -2;
	private static Integer FORA_DO_AMBIENTE = -1;
	private static Integer CELULA_NAO_VISITADA = 0;
	private static Integer PAREDE = 1;
	private static List<Integer> EQUIPE1 = new ArrayList<Integer>();
	private static List<Integer> EQUIPE2 = new ArrayList<Integer>();
	private static Integer CAIXA = 3;
	private static Integer CELULA_VISITADA_POR_AGENTE_DA_MESMA_EQUIPE = 5;
	private static Integer CELULA_VISITADA_POR_AGENTE_DA_EQUIPE_ADVERSARIA = 6;
	private static Integer CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE = 7;
	
	private static Integer TAMANHO_DO_MAPA = 25;
	
	Equipe1 equipe;

	
	@Before
	public void setUp() {
		equipe = new Equipe1();
	}
	
	@Test
	public void deveriaTerCimaComoMaiorValorUtilidade() {
		Map<ValorUtilidade, Integer> mapa = new HashMap<ValorUtilidade, Integer>();
		
		mapa.put(CIMA, 10);
		mapa.put(BAIXO, 5);
		mapa.put(DIREITA, 5);
		mapa.put(ESQUERDA, 5);
		
		Assert.assertEquals("deveria ser verdade", equipe.temCimaComoMaiorValorUtilidade(mapa), true);
	}
	
	@Test
	public void deveriaTerBaixoComoMaiorValorUtilidade() {
		Map<ValorUtilidade, Integer> mapa = new HashMap<ValorUtilidade, Integer>();
		
		mapa.put(CIMA, 5);
		mapa.put(BAIXO, 10);
		mapa.put(DIREITA, 5);
		mapa.put(ESQUERDA, 5);
		
		Assert.assertEquals("deveria ser verdade", equipe.temBaixoComoMaiorValorUtilidade(mapa), true);
	}
	
	@Test
	public void deveriaTerDireitaComoMaiorValorUtilidade() {
		Map<ValorUtilidade, Integer> mapa = new HashMap<ValorUtilidade, Integer>();
		
		mapa.put(CIMA, 5);
		mapa.put(BAIXO, 5);
		mapa.put(DIREITA, 10);
		mapa.put(ESQUERDA, 5);
		
		Assert.assertEquals("deveria ser verdade", equipe.temDireitaComoMaiorValorUtilidade(mapa), true);
	}
	
	@Test
	public void deveriaTerEsquerdaComoMaiorValorUtilidade() {
		Map<ValorUtilidade, Integer> mapa = new HashMap<ValorUtilidade, Integer>();
		
		mapa.put(CIMA, 5);
		mapa.put(BAIXO, 5);
		mapa.put(DIREITA, 5);
		mapa.put(ESQUERDA, 10);
		
		Assert.assertEquals("deveria ser verdade", equipe.temEsquerdaComoMaiorValorUtilidade(mapa), true);
	}

	/************
	 * celula 0 *
	 ************/
	
	@Test
	public void deveriaRetornarValorDaCelulaNaoVisitadaNaPosicao0() {
		equipe.setVisao(criarMapaVisao(0, CELULA_NAO_VISITADA));
		Integer actual = equipe.valorDeVisaoDaCelula0();
		Integer expected = 2;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaSemVisaoParaOLocalNaPosicao0() {
		equipe.setVisao(criarMapaVisao(0, SEM_VISAO_PARA_O_LOCAL));
		Integer actual = equipe.valorDeVisaoDaCelula0();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaForaDoAmbienteNaPosicao0() {
		equipe.setVisao(criarMapaVisao(0, FORA_DO_AMBIENTE));
		Integer actual = equipe.valorDeVisaoDaCelula0();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaVisitadaPorAmbasAsEquipesNaPosicao0() {
		equipe.setVisao(criarMapaVisao(0, CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE));
		Integer actual = equipe.valorDeVisaoDaCelula0();
		Integer expected = 2;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaComUmaCaixaNaPosicao0() {
		equipe.setVisao(criarMapaVisao(0, CAIXA));
		Integer actual = equipe.valorDeVisaoDaCelula0();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	/************
	 * celula 1 *
	 ************/
	
	@Test
	public void deveriaRetornarValorDaCelulaNaoVisitadaNaPosicao1() {
		equipe.setVisao(criarMapaVisao(1, CELULA_NAO_VISITADA));
		Integer actual = equipe.valorDeVisaoDaCelula1();
		Integer expected = 3;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaSemVisaoParaOLocalNaPosicao1() {
		equipe.setVisao(criarMapaVisao(1, SEM_VISAO_PARA_O_LOCAL));
		Integer actual = equipe.valorDeVisaoDaCelula1();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaForaDoAmbienteNaPosicao1() {
		equipe.setVisao(criarMapaVisao(1, FORA_DO_AMBIENTE));
		Integer actual = equipe.valorDeVisaoDaCelula1();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaVisitadaPorAmbasAsEquipesNaPosicao1() {
		equipe.setVisao(criarMapaVisao(1, CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE));
		Integer actual = equipe.valorDeVisaoDaCelula1();
		Integer expected = 3;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaComUmaCaixaNaPosicao1() {
		equipe.setVisao(criarMapaVisao(1, CAIXA));
		Integer actual = equipe.valorDeVisaoDaCelula1();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	/************
	 * celula 2 *
	 ************/
	
	@Test
	public void deveriaRetornarValorDaCelulaNaoVisitadaNaPosicao2() {
		equipe.setVisao(criarMapaVisao(2, CELULA_NAO_VISITADA));
		Integer actual = equipe.valorDeVisaoDaCelula2();
		Integer expected = 4;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaSemVisaoParaOLocalNaPosicao2() {
		equipe.setVisao(criarMapaVisao(2, SEM_VISAO_PARA_O_LOCAL));
		Integer actual = equipe.valorDeVisaoDaCelula2();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaForaDoAmbienteNaPosicao2() {
		equipe.setVisao(criarMapaVisao(2, FORA_DO_AMBIENTE));
		Integer actual = equipe.valorDeVisaoDaCelula2();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaVisitadaPorAmbasAsEquipesNaPosicao2() {
		equipe.setVisao(criarMapaVisao(2, CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE));
		Integer actual = equipe.valorDeVisaoDaCelula2();
		Integer expected = 4;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaComUmaCaixaNaPosicao2() {
		equipe.setVisao(criarMapaVisao(2, CAIXA));
		Integer actual = equipe.valorDeVisaoDaCelula2();
		Integer expected = 1;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	/************
	 * celula 3 *
	 ************/
	
	@Test
	public void deveriaRetornarValorDaCelulaNaoVisitadaNaPosicao3() {
		equipe.setVisao(criarMapaVisao(3, CELULA_NAO_VISITADA));
		Integer actual = equipe.valorDeVisaoDaCelula3();
		Integer expected = 3;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaSemVisaoParaOLocalNaPosicao3() {
		equipe.setVisao(criarMapaVisao(3, SEM_VISAO_PARA_O_LOCAL));
		Integer actual = equipe.valorDeVisaoDaCelula3();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaForaDoAmbienteNaPosicao3() {
		equipe.setVisao(criarMapaVisao(3, FORA_DO_AMBIENTE));
		Integer actual = equipe.valorDeVisaoDaCelula3();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaVisitadaPorAmbasAsEquipesNaPosicao3() {
		equipe.setVisao(criarMapaVisao(3, CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE));
		Integer actual = equipe.valorDeVisaoDaCelula3();
		Integer expected = 3;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaComUmaCaixaNaPosicao3() {
		equipe.setVisao(criarMapaVisao(3, CAIXA));
		Integer actual = equipe.valorDeVisaoDaCelula3();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	/************
	 * celula 4 *
	 ************/
	
	@Test
	public void deveriaRetornarValorDaCelulaNaoVisitadaNaPosicao4() {
		equipe.setVisao(criarMapaVisao(4, CELULA_NAO_VISITADA));
		Integer actual = equipe.valorDeVisaoDaCelula4();
		Integer expected = 2;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaSemVisaoParaOLocalNaPosicao4() {
		equipe.setVisao(criarMapaVisao(4, SEM_VISAO_PARA_O_LOCAL));
		Integer actual = equipe.valorDeVisaoDaCelula4();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaForaDoAmbienteNaPosicao4() {
		equipe.setVisao(criarMapaVisao(4, FORA_DO_AMBIENTE));
		Integer actual = equipe.valorDeVisaoDaCelula4();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaVisitadaPorAmbasAsEquipesNaPosicao4() {
		equipe.setVisao(criarMapaVisao(4, CELULA_VISITADA_POR_AGENTE_DE_AMBAS_AS_EQUIPE));
		Integer actual = equipe.valorDeVisaoDaCelula4();
		Integer expected = 2;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	@Test
	public void deveriaRetornarValorDaCelulaComUmaCaixaNaPosicao4() {
		equipe.setVisao(criarMapaVisao(4, CAIXA));
		Integer actual = equipe.valorDeVisaoDaCelula4();
		Integer expected = 0;
		
		Assert.assertEquals("deveria ser iguasi", expected, actual);
	}
	
	private int[] criarMapaVisao(int posicao, Integer valorDaCelula) {
		int[] mapa = new int[TAMANHO_DO_MAPA];
		
		for (int i = 0; i < TAMANHO_DO_MAPA ; i++) {
			if (i == posicao) {
				mapa[i] = valorDaCelula;
			} else {
				mapa[i] = 0;
			}
		}
		
		return mapa;
	}
	
}
