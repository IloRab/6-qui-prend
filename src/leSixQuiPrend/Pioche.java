package leSixQuiPrend;
/**
 * @author RABIARIVELO Ilo Andrianaly
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

public class Pioche {
	public ArrayList<Carte> pioche;
	
	/**
	 * @brief crée la pioche de la partie avec des cartes et la mélange
	 */
	public Pioche() {
		this.pioche = new ArrayList<>();
		for(int i=1;i<Carte.nombre_de_carte+1;i++) {
			pioche.add(new Carte());
		}
		Collections.shuffle(pioche);
	}
	
	/**
	 * @brief permet de piocher une carte du dessus dans la pioche 
	 * @return la carte pioché
	 */
	public Carte piocher() {
		Carte Cartedudessus = pioche.get(0);
		pioche.remove(0);
		return Cartedudessus;
	}

}
