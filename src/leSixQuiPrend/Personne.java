package leSixQuiPrend;
/**
 * @author RABIARIVELO Ilo Andrianaly 
 */

public class Personne {
	private String pseudo;
	private MainduJoueur main;
	
	/**
	 * @brief cr�e le joueur donc sa main et son nom 
	 * @param nom le nom du joueur enregistr� 
	 * @param pioche la pioche de la partie 
	 */
	public Personne(String nom, Pioche pioche) {
		this.pseudo=nom;
		this.main=new MainduJoueur(pioche);
	}

	/**
	 * @brief permet d'acc�der � la main du joueur
	 * @return la main du joueur
	 */
	public MainduJoueur getmain() {
		return main;
	}

	/**
	 * @brief permet d'acc�der au pseudo du joueur
	 * @return String le nom du joueur
	 */
	public String getPseudo() {
		return pseudo;
	}
	

	/**
	 * @brief affiche le nom du joueur
	 * @return String le pseudo du joueur
	 */
	public String toString() {
		return this.pseudo;
	}
}
