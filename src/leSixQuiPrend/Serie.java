package leSixQuiPrend;
/**
 * @author RABIARIVELO Ilo Andrianaly 
 * 
 */

import java.util.ArrayList;

public class Serie {	
	private ArrayList<Carte> serie;
	private int num_serie;
	public static int compteserie=1;
	
	/**
	 * @brief cr�e une s�rie � partir d'une pioche
	 * @param pioche la pioche de la partie
	 */
	public Serie(Pioche pioche) {
		this.serie= new ArrayList<>();
		this.getSerie().add(pioche.piocher());
		this.num_serie=compteserie++;
	}
	
	/**
	 * @brief permet de poser une carte dans la s�rie 
	 * @param carte la carte � poser
	 */
	public void poserdanslaserie(Carte carte) {
		this.getSerie().add(carte);
	}
	
	/**
	 * @brief vide la s�rie de tous ces �lements 
	 */
	public void videserie() {
		serie.clear();
	}
	
	/**
	 * @brief renvoie la position de la carte dans la s�rie 
	 * @param c le num�ro de la carte
	 * @return un entier qui correspond � la position de la carte dans la s�rie
	 */
	public int positiondanslaserie(int c) {
		int pos=1;
		for(int i=0;i<serie.size();i++) {
			if(c==serie.get(i).getNumdecarte()) {
				pos=i;
			}
		}
		return pos+1;
	}
	
	/**
	 * @brief permet d'acc�der � la s�rie
	 * @return la s�rie 
	 */
	public ArrayList<Carte> getSerie() {
		return serie;
	}
	
	/**
	 * @brief affiche la s�rie avec son num�ro et ce qu'elle contient 
	 * @return String la s�rie 
	 */
	public String toString() {
		StringBuilder laserie=new StringBuilder();
		laserie.append("- s�rie n� "+ this.num_serie+" :");
		for(int i=0; i<this.getSerie().size();i++) {
			laserie.append(this.getSerie().get(i));
			if (this.getSerie().size()-1==i) {
				laserie.append("");
			}
			else {
				laserie.append(",");
			}
		}
		return laserie.toString();
	}
	
	/**
	 * @brief affiche le num�ro de cartes de la derni�re carte de la s�rie
	 * @return la derni�re carte de la s�rie
	 */
	public int getDerniereCarte() {
		return (serie.get(serie.size()-1).getNumdecarte());
	}
	
	/**
	 * @brief permet d'acc�der au num�ro de la s�rie
	 * @return le num�ro de la s�rie
	 */
	public int getNum_serie() {
		return num_serie;
	}
	}


