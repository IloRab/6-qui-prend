package leSixQuiPrend;
/**
 * @author RABIARIVELO Ilo Andrianaly
 *
 */

public class Carte {
	public static final int nombre_de_carte=104;
	public static int comptecarte=1;
	private int numdecarte;
	private int tetedeboeuf;
	
	/**@brief cr�e une carte du sixquiprend
	 */
	public Carte() {
		this.numdecarte=comptecarte++;
		if(this.getNumdecarte()%10!=5 && this.getNumdecarte()%10!=this.getNumdecarte()/10 && this.getNumdecarte()%10!=0) {
			this.tetedeboeuf=1;
		}
		if (this.getNumdecarte()%10==5) {
			if (this.getNumdecarte()==55){
				this.tetedeboeuf=7;
				}
			else{
				this.tetedeboeuf=2;
			}
		}
		if (this.getNumdecarte()%10==this.getNumdecarte()/10 && this.getNumdecarte()!=55) {
			this.tetedeboeuf=5;
		}
		if (this.getNumdecarte()%10==0) {
			this.tetedeboeuf=3;
		}
		}
	
	/**
	 * @brief renvoie le nombre de t�te de boeuf d'une carte
	 * @return entier correspondant au t�te de boeuf de la carte
	 */
	public int getTetedeboeuf() {
		return tetedeboeuf;
	}
	
	/**
	 * @brief permet d'acc�der au num�ro de la carte
	 * @return un entier qui correspond au chiffre sur la carte 
	 */
	public int getNumdecarte() {
		return numdecarte;
	}
	
	/**
	 * @brief affiche la carte avec le chiffre et entre parenth�se les t�tes de boeufs
	 * @return un String de la carte.
	 */
	public String toString() {
		if (this.tetedeboeuf>1) {
		return " " + this.getNumdecarte()+" "+"("+this.tetedeboeuf+")";
	}
		else {
			return " "+this.getNumdecarte();
			}
	}
	
	/**
	 * @brief fais la comparaison entre deux cartes
	 * @param c1 la premi�re carte
	 * @param c2 la deuxi�me carte
	 * @return un entier permettant de savoir l'ordre
	 */
	public static int compareCarte(Carte c1, Carte c2) {
		return c1.numdecarte-c2.numdecarte;
	}
	

	}

