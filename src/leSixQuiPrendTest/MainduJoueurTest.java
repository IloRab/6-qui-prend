package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */

import static org.junit.Assert.assertEquals;
import leSixQuiPrend.*;

import org.junit.jupiter.api.Test;

class MainduJoueurTest {

	@Test
	/**
	 * Test pour le constructeur de la main du joueur
	 */
	void testMainduJoueur() {
		Pioche p = new Pioche();
		MainduJoueur m1= new MainduJoueur(p);
		assertEquals("Erreur sur la main",m1.getcartes().size(),10);
	}

	@Test
	/**
	 * Test pour la récupération des têtes de boeufs dans le score final
	 */
	void testScoredetetedeboeuf() {
		Pioche p = new Pioche();
		MainduJoueur m1= new MainduJoueur(p);
		Serie s1= new Serie(p);
		m1.scoredetetedeboeuf(s1);
		assert(m1.getScoretotaldeboeuf()>0);
		assert(s1.getSerie().size()==0);
	}

	@Test
	/**
	 * Test pour voir si la carte est dans la main
	 */
	void testEstdanslamain() {
		Pioche p = new Pioche();
		MainduJoueur m1= new MainduJoueur(p);
		//test sur une carte inexistante
		assertEquals("Erreur sur la main",m1.estdanslamain(205),(false));
		
	}

	@Test
	/**
	 * Test pour voir si la main peut jouer sur une série
	 */
	void testJouerunecarte() {
		Pioche p = new Pioche();
		MainduJoueur m1= new MainduJoueur(p);
		Serie s1 = new Serie(p);
		m1.jouerunecarte(m1.getcartes().get(3).getNumdecarte(), s1);
		//la taille de la série à augmenter
		assertEquals("Erreur sur la main",s1.getSerie().size(),2);
	}
	

	@Test
	/**
	 * Test si la carte a été prisede la main
	 */
	void testPrendrelacarte() {
		Carte M1;
		int lavaleurdeM1;
		Pioche p = new Pioche();
		MainduJoueur m1 = new MainduJoueur(p);
		lavaleurdeM1=m1.getcartes().get(3).getNumdecarte();
		M1=m1.prendrelacarte(m1.getcartes().get(3).getNumdecarte());
		assertEquals("Erreur sur la main",M1.toString()," "+lavaleurdeM1);
		assertEquals("Erreur sur la main",m1.getcartes().size(),10);
	}

	@Test
	/**
	 * Test si la main de carte est possible en vérifiant sa taille
	 */
	void testGetcartes() {
		Pioche p = new Pioche();
		MainduJoueur m1 = new MainduJoueur(p);
		assertEquals("Erreur sur la main",m1.getcartes().size(),10);
	}

	@Test
	/**
	 * Test le score total de tete de boeuf initialisé à 0
	 */
	void testGetScoretotaldeboeuf() {
		Pioche p = new Pioche();
		MainduJoueur m1 = new MainduJoueur(p);
		Serie s1 = new Serie(p);
		assertEquals("Erreur sur la main",m1.getScoretotaldeboeuf(),0);
		m1.scoredetetedeboeuf(s1);
		assert(m1.getScoretotaldeboeuf()>0);
		assert(s1.getSerie().size()==0);
	}

}
