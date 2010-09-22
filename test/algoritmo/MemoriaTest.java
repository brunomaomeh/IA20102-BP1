package algoritmo;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemoriaTest {

	Memoria memoria;

	@Before
	public void setUp() {
		memoria = new Memoria();
	}

	@Test
	public void deveriaAdicionarUmElementoALista() {
		memoria.memoriza(new Posicao(new Point(1, 1)));

		int expected = 1;
		Assert.assertEquals(expected, memoria.getMemoria().size());
	}

	@Test
	public void deveriaAdicionarAteCincoElementos() {
		memoria.memoriza(new Posicao(new Point(1, 1)));
		memoria.memoriza(new Posicao(new Point(2, 2)));
		memoria.memoriza(new Posicao(new Point(3, 3)));
		memoria.memoriza(new Posicao(new Point(4, 4)));
		memoria.memoriza(new Posicao(new Point(5, 5)));
		memoria.memoriza(new Posicao(new Point(6, 6)));

		int expected = 5;
		Assert.assertEquals(expected, memoria.getMemoria().size());
	}

	@Test
	public void deveriaRemoverOUltimoElemento() {
		memoria.memoriza(new Posicao(new Point(1, 1)));
		memoria.memoriza(new Posicao(new Point(2, 2)));
		memoria.memoriza(new Posicao(new Point(3, 3)));
		memoria.memoriza(new Posicao(new Point(4, 4)));
		memoria.memoriza(new Posicao(new Point(5, 5)));
		memoria.memoriza(new Posicao(new Point(6, 6)));

		Assert.assertFalse("deveria nao existir esse point", memoria.getMemoria().contains(new Posicao(new Point(1, 1))));
		memoria.memoriza(new Posicao(new Point(7, 7)));
		Assert.assertFalse("deveria nao existir esse point", memoria.getMemoria().contains(new Posicao(new Point(2, 2))));
	}

	@Test
	public void deveriaRegistrarQueFoiMemorizado() {
		memoria.memoriza(new Posicao(new Point(1, 1)));
		Assert.assertTrue("deveria ser true", memoria.jahVisitou(new Point(1, 1)));
		memoria.memoriza(new Posicao(new Point(2, 2)));
		Assert.assertTrue("deveria ser true", memoria.jahVisitou(new Point(2, 2)));
		memoria.memoriza(new Posicao(new Point(3, 3)));
		Assert.assertTrue("deveria ser true", memoria.jahVisitou(new Point(3, 3)));
		memoria.memoriza(new Posicao(new Point(4, 4)));
		Assert.assertTrue("deveria ser true", memoria.jahVisitou(new Point(4, 4)));
		memoria.memoriza(new Posicao(new Point(5, 5)));
		Assert.assertTrue("deveria ser true", memoria.jahVisitou(new Point(5, 5)));
		memoria.memoriza(new Posicao(new Point(6, 6)));
		Assert.assertTrue("deveria ser true", memoria.jahVisitou(new Point(6, 6)));
		Assert.assertFalse("deveria ser false", memoria.jahVisitou(new Point(1, 1)));

	}

}
