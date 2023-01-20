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
	 * @brief crée une série à partir d'une pioche
	 * @param pioche la pioche de la partie
	 */
	public Serie(Pioche pioche) {
		this.serie= new ArrayList<>();
		this.getSerie().add(pioche.piocher());
		this.num_serie=compteserie++;
	}
	
	/**
	 * @brief permet de poser une carte dans la série 
	 * @param carte la carte à poser
	 */
	public void poserdanslaserie(Carte carte) {
		this.getSerie().add(carte);
	}
	
	/**
	 * @brief vide la série de tous ces élements 
	 */
	public void videserie() {
		serie.clear();
	}
	
	/**
	 * @brief renvoie la position de la carte dans la série 
	 * @param c le numéro de la carte
	 * @return un entier qui correspond à la position de la carte dans la série
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
	 * @brief permet d'accéder à la série
	 * @return la série 
	 */
	public ArrayList<Carte> getSerie() {
		return serie;
	}
	
	/**
	 * @brief affiche la série avec son numéro et ce qu'elle contient 
	 * @return String la série 
	 */
	public String toString() {
		StringBuilder laserie=new StringBuilder();
		laserie.append("- série n° "+ this.num_serie+" :");
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
	 * @brief affiche le numéro de cartes de la dernière carte de la série
	 * @return la dernière carte de la série
	 */
	public int getDerniereCarte() {
		return (serie.get(serie.size()-1).getNumdecarte());
	}
	
	/**
	 * @brief permet d'accéder au numéro de la série
	 * @return le numéro de la série
	 */
	public int getNum_serie() {
		return num_serie;
	}
	}


