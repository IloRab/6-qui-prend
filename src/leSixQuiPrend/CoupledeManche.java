package leSixQuiPrend;

/**
 * @author RABIARIVELO Ilo Andrianaly
 *
 */
	
public class CoupledeManche {
		private Carte carte; 
		private Personne joueur;  
		private int tetedeboeuf;
		
		/**
		 * @brief cr�e le tour du joueur pendant la manche 
		 * @param c La carte du joueur jou� pendant la manche
		 * @param p La personne qui joue la carte
		 */
		
		public CoupledeManche(Carte c, Personne p) {
			this.carte= c;
			this.joueur = p;
			this.tetedeboeuf= 0;
		}
		
		/**
		 * @brief permet d'acc�der au nom du joueur
		 * @return String du nom du joueur
		 */
		public String getPseudodujoueur() {
			return joueur.getPseudo();
		}
		
		/**
		 * @brief permet d'acc�der au joueur 
		 * @return le joueur 
		 */
		public Personne getJoueur() {
			return joueur;
		}
		
		/**
		 * @brief permet d'acc�der au num�ro de la carte
		 * @return int correspondant au num�ro de carte
		 */
		public int getNumerodecarte() {
			return carte.getNumdecarte();
		}
		
		
		/**
		 * @brief compare le pseudo de deux attributs de type coupledemanche 
		 * @param c1 le premier coupledemanche 
		 * @param c2 le deuxi�me coupledemanche
		 * @return un entier permettant de savoir l'ordre 
		 */
		public static int comparePseudo(CoupledeManche c1, CoupledeManche c2) {
	        return c1.getPseudodujoueur().compareTo(c2.getPseudodujoueur());
	    }
		
		/**
		 * @brief compare le pseudo et la carte de deux attributs de type coupledemanche 
		 * @param c1 le premier coupledemanche 
		 * @param c2 le deuxi�me coupledemanche
		 * @return un entier permettant de savoir l'ordre
		 */
		public static int compareCarte(CoupledeManche c1, CoupledeManche c2) {
	        if (c1.getNumerodecarte() == c2.getNumerodecarte())
	            return comparePseudo(c1, c2);
	        return c1.getNumerodecarte() - c2.getNumerodecarte();
	    }
	    
		/**
		 * @brief affiche un CoupledeManche sous la forme du num�ro de la carte jou� pendant la manche et le pr�nom du joueur entre parenth�se 
		 * @return un string du tour jouer par le joueur
		 */
		public String toString() {
			StringBuilder affcouple=new StringBuilder();
			affcouple.append(this.getNumerodecarte()+" "+"("+this.getPseudodujoueur()+")");
			return affcouple.toString();
		}
		
		/**
		 * @brief renvoie les t�tes de boeufs que le joueur a eu pendant la manche
		 * @return un entier qui est le nombre de t�tes de boeufs 
		 */
		public int getTeteDeBoeuf() {
			return this.tetedeboeuf;
		}
		
		/**
		 * @brief prend toutes les t�tes de boeufs correspondantes a la s�rie
		 * @param serie la serie correspondante
		 */
		public void scoredeTetedeBoeuf(Serie serie) {
			
			for(int i=0;i<serie.getSerie().size();i++) {
				this.tetedeboeuf+=serie.getSerie().get(i).getTetedeboeuf();
			}
		}
	}



