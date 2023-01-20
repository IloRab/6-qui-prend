package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import leSixQuiPrend.*;

class SerieTest {

	@Test

	/**Test du constructeur de serie
	 * Test pose la s�rie
	 * Test vide la s�rie
	 * Test pour la derni�re carte de la s�rie
	 * Test pour le num�ro de la s�rie
	 */
	void testSerie() {
		Pioche p = new Pioche();
		Serie s1 = new Serie(p);
		Carte c1 = new Carte();
		assertEquals("Erreur sur la s�rie",s1.getSerie().size(),1);
		s1.poserdanslaserie(c1);
		assertEquals("Erreur sur la s�rie",s1.getSerie().size(),2);
		assertEquals("Erreur sur la s�rie",s1.getDerniereCarte(),c1.getNumdecarte());
		s1.videserie();
		assertEquals("Erreur sur la s�rie",s1.getSerie().size(),0);
		assertEquals("Erreur sur la s�rie",s1.getNum_serie(),1);
	}

}
