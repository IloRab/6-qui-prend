package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import leSixQuiPrend.*;

class CoupledeMancheTest {

	@Test
	/**
	 * Test pour le constructeur du couple
	 */
	void testCoupledeManche() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		assertEquals("Erreur sur le couple",cdm1.toString(),c1.getNumdecarte()+" (Bernard)");
	}

	@Test
	/**
	 * Test pour l'accès du nom du joueur
	 */
	void testGetPseudodujoueur() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		assertEquals("Erreur sur le couple",cdm1.getPseudodujoueur(),"Bernard");
	}

	@Test
	/**
	 * Test si le couple a acces au joueur
	 */
	void testGetJoueur() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		assertEquals("Erreur sur le couple",cdm1.getJoueur().toString(),"Bernard");
	}

	@Test
	/**
	 * Test si le couple a accès au numéro de la carte
	 */
	void testGetNumerodecarte() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		assertEquals("Erreur sur le couple",cdm1.getNumerodecarte(),c1.getNumdecarte());
	
	}

	@Test
	/**
	 * Test la comparaison de deux noms de joueurs
	 */
	void testComparePseudo() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		Personne j2 = new Personne("Bob",p);
		Carte c2 = p.piocher();
		CoupledeManche cdm2 = new CoupledeManche(c2,j2);
		//System.out.print(CoupledeManche.comparePseudo(cdm1, cdm2));
		assertEquals("Erreur sur le couple",CoupledeManche.comparePseudo(cdm1, cdm2),-10);
	}

	@Test
	/**
	 * Test pour la comparaison des cartes
	 */
	void testCompareCarte() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		Personne j2 = new Personne("Bob",p);
		Carte c2 = p.piocher();
		CoupledeManche cdm2 = new CoupledeManche(c2,j2);
		assertEquals("Erreur sur le couple",CoupledeManche.compareCarte(cdm1, cdm2),c1.getNumdecarte()-c2.getNumdecarte());
	}

	@Test
	/**
	 * test l'affichage des couples
	 */
	void testToString() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		assertEquals("Erreur sur le couple",cdm1.toString(),c1.getNumdecarte()+" (Bernard)");
	
	}

	@Test
	/**
	 * test le nombre de tête de boeuf par manche dans le couple
	 */
	void testGetTeteDeBoeuf() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1 = p.piocher();
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		assertEquals("Erreur sur le couple",cdm1.getTeteDeBoeuf(),0);
	}

	@Test
	/**
	 * test le nombre de tête de boeuf dans la manche
	 */
	void testScoredeTetedeBoeuf() {
		Pioche p = new Pioche();
		Personne j1 = new Personne("Bernard",p);
		Carte c1=new Carte();
		Serie s1=new Serie(p);
		CoupledeManche cdm1 = new CoupledeManche(c1,j1);
		cdm1.scoredeTetedeBoeuf(s1);
		assertEquals("Erreur sur le couple",cdm1.getTeteDeBoeuf(),s1.getSerie().get(0).getTetedeboeuf());
		
		
	}

}
