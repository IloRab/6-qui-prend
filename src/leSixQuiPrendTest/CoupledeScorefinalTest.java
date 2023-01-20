package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import leSixQuiPrend.*;

class CoupledeScorefinalTest {

	@Test
	/**
	 * Test pour le constructeur du score final
	 */
	void testCoupledeScorefinal() {
		CoupledeScorefinal c1 = new CoupledeScorefinal(2,"Bernard"); 
		assertEquals("Erreur sur le couple final",c1.toString(),"Bernard a ramassé 2 têtes de boeufs");
	}

	@Test
	/**
	 * Test pour la comparaison de pseudo du joueur
	 */
	void testComparePseudo() {
		CoupledeScorefinal c1 = new CoupledeScorefinal(2,"Bernard"); 
		CoupledeScorefinal c2 = new CoupledeScorefinal(8,"Jack"); 
		assertEquals("Erreur sur le couple final",CoupledeScorefinal.comparePseudo(c1,c2),-8);
	}

	@Test
	/**
	 * Test pour la comparaison du score
	 */
	void testCompareScore() {
		CoupledeScorefinal c1 = new CoupledeScorefinal(2,"Bernard"); 
		CoupledeScorefinal c2 = new CoupledeScorefinal(8,"Jack"); 
		assertEquals("Erreur sur le couple final",CoupledeScorefinal.compareScore(c1,c2),-6);
	}

	@Test
	/**
	 * Test pour l'affichage des scores finaux
	 */
	void testToString() {
		CoupledeScorefinal c1 = new CoupledeScorefinal(2,"Bernard"); 
		assertEquals("Erreur sur le couple final",c1.toString(),"Bernard a ramassé 2 têtes de boeufs");
	}

}
