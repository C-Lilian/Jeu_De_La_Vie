/**
 * 
 */
package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Lilian
 *
 */
public class Test{
	private static int taille = 5;
	private static int nbTours = 4;
	private static int[][] tableauVoisins = new int[taille][taille];
	
	/**
	 * @param args Les arguments données en params.
	 */
	public static void main(String[] args) throws IOException{
		/*TODO
		 * Test unit
		 * mettre sur git
		 * faire avec fichier
		 * faire avec la copie (sans reference)
		 */
		// Initialisation de la grille + affichage.
		Grille g = new Grille(taille);
		System.out.println("==========\nGrille d'initialisation :\n");
		g.AfficheGrille();
		System.out.println("");
		
		// On lance une boucle sur la nbr de tours voulu.
		for (int t = 1; t <= nbTours; t++) {
			// On insère dans un tableau le nombre de voisin avant chaque tour.
			for (int i = 0; i < taille; i++) {
				for (int j = 0; j < taille; j++) {
					int nbrVoisins = g.getNbrVoisins(g.getLaGrille()[j][i]);
					tableauVoisins[j][i] = nbrVoisins;
				}
			}
			// On applique les règle du jeu pour le prochain tour.
			for (int i = 0; i < taille; i++) {
				for (int j = 0; j < taille; j++) {
					g.JeuNiveau2(g.getLaGrille()[j][i],tableauVoisins[j][i]);
				}
			}
			// On affiche le tableau après application des règles.
			System.out.println("==========\nTour n°"+t+" :\n");
			g.AfficheGrille();
			System.out.println(" ");
		}
		
		/* REGARDER POUR FAIRE FONCTIONNER LA METHODE AVEC LA COPIE DE LA GRILLE.
		 Grille g = new Grille(taille);
		// Grille gr = new Grille(taille);
		// gr.Clone(g);
		for (int t = 0; t < nbTours; t++) {
			// On insère dans un tableau le nombre de voisin avant chaque tour.
			for (int i = 0; i < taille; i++) {
				for (int j = 0; j < taille; j++) {
					int nbrVoisins = g.getNbrVoisins(g.getLaGrille()[j][i]);
					tableauVoisins[j][i] = nbrVoisins;
				}
			}
			System.out.println("==========\nTour n°"+t+" :\n");
			g.AfficheGrille();
			System.out.println(" ");
			// gr.AfficheGrille();
			// System.out.println(" ");
			for (int i = 0; i < taille; i++) {
				for (int j = 0; j < taille; j++) {
					//int nbrVoisins = gr.getNbrVoisins(gr.getLaGrille()[j][i]);
					// g.JeuNiveau1(g.getLaGrille()[j][i],nbrVoisins);
					//g.JeuNiveau2(g.getLaGrille()[j][i],nbrVoisins);
					g.JeuNiveau2(g.getLaGrille()[j][i],tableauVoisins[j][i]);
				}
			}
		}*/
	}
}
