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
		 * @brief crée le tour du joueur pendant la manche 
		 * @param c La carte du joueur joué pendant la manche
		 * @param p La personne qui joue la carte
		 */
		
		public CoupledeManche(Carte c, Personne p) {
			this.carte= c;
			this.joueur = p;
			this.tetedeboeuf= 0;
		}
		
		/**
		 * @brief permet d'accéder au nom du joueur
		 * @return String du nom du joueur
		 */
		public String getPseudodujoueur() {
			return joueur.getPseudo();
		}
		
		/**
		 * @brief permet d'accéder au joueur 
		 * @return le joueur 
		 */
		public Personne getJoueur() {
			return joueur;
		}
		
		/**
		 * @brief permet d'accéder au numéro de la carte
		 * @return int correspondant au numéro de carte
		 */
		public int getNumerodecarte() {
			return carte.getNumdecarte();
		}
		
		
		/**
		 * @brief compare le pseudo de deux attributs de type coupledemanche 
		 * @param c1 le premier coupledemanche 
		 * @param c2 le deuxième coupledemanche
		 * @return un entier permettant de savoir l'ordre 
		 */
		public static int comparePseudo(CoupledeManche c1, CoupledeManche c2) {
	        return c1.getPseudodujoueur().compareTo(c2.getPseudodujoueur());
	    }
		
		/**
		 * @brief compare le pseudo et la carte de deux attributs de type coupledemanche 
		 * @param c1 le premier coupledemanche 
		 * @param c2 le deuxième coupledemanche
		 * @return un entier permettant de savoir l'ordre
		 */
		public static int compareCarte(CoupledeManche c1, CoupledeManche c2) {
	        if (c1.getNumerodecarte() == c2.getNumerodecarte())
	            return comparePseudo(c1, c2);
	        return c1.getNumerodecarte() - c2.getNumerodecarte();
	    }
	    
		/**
		 * @brief affiche un CoupledeManche sous la forme du numéro de la carte joué pendant la manche et le prénom du joueur entre parenthèse 
		 * @return un string du tour jouer par le joueur
		 */
		public String toString() {
			StringBuilder affcouple=new StringBuilder();
			affcouple.append(this.getNumerodecarte()+" "+"("+this.getPseudodujoueur()+")");
			return affcouple.toString();
		}
		
		/**
		 * @brief renvoie les têtes de boeufs que le joueur a eu pendant la manche
		 * @return un entier qui est le nombre de têtes de boeufs 
		 */
		public int getTeteDeBoeuf() {
			return this.tetedeboeuf;
		}
		
		/**
		 * @brief prend toutes les têtes de boeufs correspondantes a la série
		 * @param serie la serie correspondante
		 */
		public void scoredeTetedeBoeuf(Serie serie) {
			
			for(int i=0;i<serie.getSerie().size();i++) {
				this.tetedeboeuf+=serie.getSerie().get(i).getTetedeboeuf();
			}
		}
	}



