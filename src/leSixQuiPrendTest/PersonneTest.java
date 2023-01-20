package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import leSixQuiPrend.*;

class PersonneTest {

	@Test
	/**
	 * Test sur le constructeur de personne
	 * Test sur la carte
	 * Test sur l'affichage du pseudo du joueur
	 */
	void testPersonne() {
		Pioche p = new Pioche();
		Personne p1 = new Personne("Ilo",p);
		assertEquals("Erreur sur la personne",p1.toString(),"Ilo");
		assertEquals("Erreur sur la personne",p1.getmain().getcartes().size(),10);
		assertEquals("Erreur sur la personne",p1.getPseudo(),"Ilo");
	}

}
