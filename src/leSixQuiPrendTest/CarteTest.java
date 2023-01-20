package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import leSixQuiPrend.*;

class CarteTest {

	@Test
	/**
	 * Test du constructeur de la carte
	 */
	void testCarte() {
		Carte c4 = new Carte();
		assertEquals("Erreur sur la carte",c4.toString()," 4");
	}

	@Test
	/**
	 * Test pour récuperer la valeur des tetes de boeufs
	 */
	void testGetTetedeboeuf() {
		Carte c8=new Carte();
		Carte c9=new Carte();
		Carte c10=new Carte();
		assertEquals("Erreur sur la carte",c10.getTetedeboeuf(),3);
		assertEquals("Erreur sur la carte",c9.getTetedeboeuf(),1);
		assertEquals("Erreur sur la carte",c8.getTetedeboeuf(),1);
	}

	@Test
	/**
	 * Test pour récuperer le numéro de la carte
	 */
	void testGetNumdecarte() {
		Carte c1=new Carte();
		Carte c2=new Carte();
		Carte c3=new Carte();
		assertEquals("Erreur sur la carte",c3.getNumdecarte(),3);
		assertEquals("Erreur sur la carte",c2.getNumdecarte(),2);
		assertEquals("Erreur sur la carte",c1.getNumdecarte(),1);
	}

	@Test
	/**
	 * Test pour l'affichage de la carte
	 */
	void testToString() {
		Carte c5=new Carte();
		Carte c6=new Carte();
		Carte c7=new Carte();
		assertEquals("Erreur sur la carte",c5.toString()," 5 (2)");
		assertEquals("Erreur sur la carte",c6.toString()," 6");
		assertEquals("Erreur sur la carte",c7.toString()," 7");
	}

	@Test
	/**
	 * Test pour la comparaison des cartes
	 */
	void testCompareCarte() {
		Carte c11=new Carte();
		Carte c12=new Carte();
		assertEquals("Erreur sur la carte",Carte.compareCarte(c11,c12),-1);
	}

}
