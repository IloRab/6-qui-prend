package leSixQuiPrend;
/**
 * @author RABIARIVELO Ilo Andrianaly 
 *
 */

public class CoupledeScorefinal{
	private int score;
	private String perso;
	
	/**
	 * @brief cr�e le couple final pour l'affichage des scores
	 * @param s score de t�te de boeuf du joueur
	 * @param p le nom du joueur
	 */
	public CoupledeScorefinal(int s, String p) {
		this.score=s;
		this.perso=p;
	}
	
	/**
	 * @brief compare deux pr�noms de couple pour connaitre l'ordre 
	 * @param p1 Le premier couple 
	 * @param p2 Le deuxi�me couple 
	 * @return un entier correspondant � la comparaison
	 */
	public static int comparePseudo(CoupledeScorefinal p1, CoupledeScorefinal p2) {
        return p1.perso.compareTo(p2.perso);
    }
	
	/**
	 * @brief compare deux couple par rapport au nom mais aussi au score
	 * @param p1 Le premier couple 
	 * @param p2 Le deuxi�me couple 
	 * @return un entier correspondant � la comparaison
	 */
	public static int compareScore(CoupledeScorefinal p1, CoupledeScorefinal p2) {
        if (p1.score == p2.score)
            return comparePseudo(p1, p2);
        return p1.score - p2.score;
    }
	
	/**
	 * @brief affiche le score final 
	 * @return un string correspondant au joueur et son score
	 */
	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append(this.perso+" a ramass� "+this.score+" t�tes de boeufs");
		return s.toString();
	}
}
