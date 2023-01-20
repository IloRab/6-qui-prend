package leSixQuiPrendTest;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import leSixQuiPrend.*;

class PiocheTest {

	@Test
	/**
	 * Test du constructeur de la pioche
	 * Test pour piocher
	 */
	void testPioche() {
		Pioche p = new Pioche();
		assertEquals("Erreur sur la pioche",p.pioche.size(),104);
		@SuppressWarnings("unused")
		Carte c1 = p.piocher();
		assertEquals("Erreur sur la pioche",p.pioche.size(),103);
	}
}
