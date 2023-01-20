package appli;
/**
 * @author RABIARIVELO Ilo Andrianaly
 */

import static util.Console.clearScreen;
import static util.Console.pause;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import leSixQuiPrend.*;

public class Application {
	public static final int nombredemanche = 10;
	public static final int nombredeserie = 4;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Création de la table de jeu
		Scanner texte=new Scanner(new FileInputStream("config.txt"));
		Scanner num=new Scanner(System.in);
		Scanner numserie=new Scanner(System.in);
		ArrayList<Personne> joueurs= new ArrayList<>();
		ArrayList<CoupledeScorefinal> classementf=new ArrayList<>();
		Pioche pioche = new Pioche();
		ArrayList<Serie> series = new ArrayList<>();
		
		
		//Affichage de la première ligne d'introduction au jeu
		for(int i=0;i<4;i++) {
			series.add(new Serie(pioche));
		}
		while(texte.hasNext()) {
			joueurs.add(new Personne(texte.nextLine(),pioche));
		}
		System.out.print("Les "+joueurs.size()+" joueurs sont ");
		for (int i=0;i<joueurs.size();i++) {
			System.out.print(joueurs.get(i));
			if(i<joueurs.size()-2) {
				System.out.print(", ");
			}
			if(i==joueurs.size()-2) {
				System.out.print(" et ");
			}
			if(i==joueurs.size()-1) {
				System.out.println(". Merci de jouer à 6 qui prend !");
			}
		}
	
	//Début de manche 
	for(int i=0;i<nombredemanche;i++) {
		ArrayList<CoupledeManche> manche=new ArrayList<>();
		for(int a = 0;a<joueurs.size();a++) {
			int numcarte=0;
			
			System.out.println("A "+joueurs.get(a)+" de jouer.");
			pause();
			for(int j=0; j<nombredeserie;j++) {
				System.out.println(series.get(j));
			}
			System.out.println(joueurs.get(a).getmain());
			System.out.print("Saisissez votre choix : ");
			//Vérifie si la carte est bien un int et est dans la main
			do {
	            try {
	                numcarte = Integer.parseInt(num.nextLine());
	                if(numcarte < 0)
	                    numcarte = -1;
	            }
	            catch(NumberFormatException e) {
	                numcarte = -1;
	            }
	            if(joueurs.get(a).getmain().estdanslamain(numcarte)==false) {
	            	numcarte = -1;
	            }
	            if(numcarte==-1) {
	            	System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
	            }
	            if(joueurs.get(a).getmain().estdanslamain(numcarte)==true) {
					manche.add(new CoupledeManche(joueurs.get(a).getmain().prendrelacarte(numcarte),joueurs.get(a)));
				}
	            
			}while(numcarte==-1);

		clearScreen();
		}
		Collections.sort(manche,CoupledeManche::compareCarte);
		//Pose les cartes automatiquement dans les séries (règle numéro 2)
		for(int m=0;m<manche.size();m++) {
			int entiermax=104;
			int compteserie=-1;
			boolean sixiemeposition=false;
			for(int s=0;s<nombredeserie;s++) {
				if(manche.get(m).getNumerodecarte()-series.get(s).getDerniereCarte()>0 && manche.get(m).getNumerodecarte()-series.get(s).getDerniereCarte()<entiermax) {
					entiermax=manche.get(m).getNumerodecarte()-series.get(s).getDerniereCarte();
					compteserie=series.get(s).getNum_serie()-1;
					if(series.get(s).positiondanslaserie(series.get(s).getDerniereCarte())==5) {
						sixiemeposition=true; //Vérifivation de la règle numéro 3
					}
				}
			}
			//Affichage du contenu de la manche si la règle numéro 4 est activé
			if(compteserie<0) {
				System.out.print("Les cartes");
				int taillemanche=0;
				for(int m1=0;m1<manche.size();m1++) {
					taillemanche++;
					if(taillemanche==manche.size()) 
						System.out.println(" et "+manche.get(m1)+" vont être posées.");
					if(taillemanche==manche.size()-1) 
						System.out.print(" "+manche.get(m1));
					if(taillemanche!=manche.size()-1 && taillemanche!=manche.size())
						System.out.print(" "+manche.get(m1)+",");
				}
				//Règle numéro 4 
				System.out.println("Pour poser la carte "+manche.get(m).getNumerodecarte()+", "+manche.get(m).getPseudodujoueur()+" doit choisir la série qu'il va ramasser.");
				for(int j=0; j<nombredeserie;j++) {
					System.out.println(series.get(j));
				}
				System.out.print("Saisissez votre choix : ");
				//Vérifie la saisie de la série pour la règle 4
				do {
		            try {
		            	compteserie = Integer.parseInt(numserie.nextLine());
		                if(compteserie < 0)
		                	compteserie = -1;
		            }
		            catch(NumberFormatException e) {
		                compteserie = -1;
		            }
		            if(compteserie>=1 && compteserie<=4) {
						compteserie-=1;
						manche.get(m).scoredeTetedeBoeuf(series.get(compteserie));
						manche.get(m).getJoueur().getmain().scoredetetedeboeuf(series.get(compteserie));
						manche.get(m).getJoueur().getmain().jouerunecarte(manche.get(m).getNumerodecarte(), series.get(compteserie));
					}
		            else {
		            	compteserie = -1;
		            }
		            if(compteserie==-1) {
		            	System.out.print("Ce n'est pas une série valide, saisissez votre choix : ");
		            }
		        }while(compteserie==-1);
			}
			else {
				//Règle numéro 3
				if(sixiemeposition==true) {
					manche.get(m).scoredeTetedeBoeuf(series.get(compteserie));
					manche.get(m).getJoueur().getmain().scoredetetedeboeuf(series.get(compteserie));
					manche.get(m).getJoueur().getmain().jouerunecarte(manche.get(m).getNumerodecarte(), series.get(compteserie));
				}
				//Règle numéro 1 et 2 si les autres règles ne sont pas activés 
				else{
					manche.get(m).getJoueur().getmain().jouerunecarte(manche.get(m).getNumerodecarte(), series.get(compteserie));
				}
			}
		
			
		}
		//Affichage pour la fin d'une manche
		int taillemanche=0;
		System.out.print("Les cartes");
		for(int m=0;m<manche.size();m++) {
			taillemanche++;
			if(taillemanche==manche.size()) 
				System.out.print(" et "+manche.get(m)+" ont été posées.");
			if(taillemanche==manche.size()-1)
				System.out.print(" "+manche.get(m));
			if(taillemanche!=manche.size()-1 && taillemanche!=manche.size())
				System.out.print(" "+manche.get(m)+",");
		}
		System.out.println();
		for(int j=0; j<nombredeserie;j++) {
			System.out.println(series.get(j));
		}
		//Score des joueurs en fin de manche
		int ceuxquiramasse=0;
		for(int m=0;m<manche.size();m++) {
			if(manche.get(m).getTeteDeBoeuf()>0) {
				ceuxquiramasse+=1;
				System.out.println(manche.get(m).getPseudodujoueur()+" a ramassé "+manche.get(m).getTeteDeBoeuf()+" têtes de boeufs");
			}
		} 
		if(ceuxquiramasse==0) {
			System.out.println("Aucun joueur ne ramasse de tête de boeufs.");
		}
	}
	num.close();
	numserie.close();
	//Afficahge du score final
	System.out.println("** Score final");
	for(int f=0;f<joueurs.size();f++) {
		classementf.add(new CoupledeScorefinal(joueurs.get(f).getmain().getScoretotaldeboeuf(),joueurs.get(f).getPseudo()));
	}
	Collections.sort(classementf,CoupledeScorefinal::compareScore);
	for(int f=0;f<classementf.size();f++) {
		System.out.println(classementf.get(f));
	}
	}
	
}


