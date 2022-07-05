/**
 * 
 */
package com;

/**
 * @author Lilian
 *
 */
public class Grille implements Cloneable{

	private Cellule[][] laGrille;
	private int taille;
	// Variables globales
	private int AGE_MORT = 5;
	private int ENERGIE_REPRODUCTION = 10;
	
	
	// Constructeurs
	
	/**
	 * Constructeur de la classe. Initialise une grille de Cellule grâce à une double boucle.
	 * 
	 * @param taille	La taille de la grille.
	 */
	public Grille(int taille) {
		this.taille = taille;
		this.setLaGrille(new Cellule[taille][taille]);
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				Cellule c = new Cellule(i,j);
				getLaGrille()[i][j] = c;
			}
		}
	}

	
	// Grilles
	
	/**
	 * Permet d'afficher la grille en récupérant l'état de la cellule.
	 * Parcours de la grille à l'aide d'une double boucle.
	 */
	public void AfficheGrille() {
		// Double boucle avec un print de l'état sur chaque cellule.
		for (int i = 0; i < this.taille; i++) {
			String ligne = "";
			for (int j = 0; j < this.taille; j++) {
				ligne += this.getLaGrille()[i][j].getEtat();
			}
			System.out.println(ligne);
		}
	}

	
	// Voisins
	
	/**
	 * Permet de trouver la voisin de nord de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinNord(Cellule maCase) {
		int posX,posY;
		posX = maCase.getPosX();
		if(maCase.getPosY() == 0) {
			posY = 4;
		}
		else {
			posY = maCase.getPosY()-1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de nord-est de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinNordEst(Cellule maCase) {
		int posX, posY;
		posY = maCase.getPosY();
		if(maCase.getPosY() == 0) {
			posX = 4;
		}
		else {
			posX = maCase.getPosY()-1;
		}
		if(maCase.getPosX() == this.taille-1) {
			posY = 0;
		}
		else {
			posX = maCase.getPosX()+1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de nord-ouest de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinNordOuest(Cellule maCase) {
		int posX, posY;
		if(maCase.getPosY() == 0) {
			posY = 4;
		}
		else {
			posY = maCase.getPosY()-1;
		}
		if(maCase.getPosX() == 0) {
			posX = 4;
		}
		else {
			posX = maCase.getPosX()-1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de sud de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinSud(Cellule maCase) {
		int posX, posY;
		posX = maCase.getPosX();
		if(maCase.getPosY() == this.taille-1) {
			posY = 0;
		}
		else {
			posY = maCase.getPosY()+1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de sud-est de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinSudEst(Cellule maCase) {
		int posX, posY;
		if(maCase.getPosY() == this.taille-1) {
			posY = 0;
		}
		else {
			posY = maCase.getPosY()+1;
		}
		if(maCase.getPosX() == this.taille-1) {
			posX = 0;
		}
		else {
			posX = maCase.getPosX()+1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de sud-ouest de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinSudOuest(Cellule maCase) {
		int posX, posY;
		if(maCase.getPosY() == this.taille-1) {
			posY = 0;
		}
		else {
			posY = maCase.getPosY()+1;
		}
		if(maCase.getPosX() == 0) {
			posX = 4;
		}
		else {
			posX = maCase.getPosX()-1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de l'ouest de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinOuest(Cellule maCase) {
		int posX, posY;
		posY = maCase.getPosY();
		if(maCase.getPosX() == 0) {
			posX = 4;
		}
		else {
			posX = maCase.getPosX()-1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet de trouver la voisin de l'est de la cellule.
	 * 
	 * @param maCase	La cellule pour qui l'on doit vérifier le voisin.
	 * @return La cellule trouver.
	 */
	public Cellule VoisinEst(Cellule maCase) {
		int posX, posY;
		posY = maCase.getPosY();
		if(maCase.getPosX() == this.taille-1) {
			posX = 0;
		}
		else {
			posX = maCase.getPosX()+1;
		}
		return getLaGrille()[posY][posX];
	}
	
	/**
	 * Permet d'avoir le nombre de voisins d'un Celulle. (utile pour jeu niv 1 et 2).
	 * 
	 * @param maCase	La case pour laquelle on doit trouver le nbr de voisins.
	 * @return Le nbr de voisins retourné.
	 */
	public int getNbrVoisins(Cellule maCase) {
		int nbrVoisins = 0;
		if (this.VoisinNord(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinNord : ["+this.VoisinNord(maCase).getPosY()+"]["+this.VoisinNord(maCase).getPosX()+"] "+this.VoisinNord(maCase).getEtat());
		if (this.VoisinSud(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinSud : ["+this.VoisinSud(maCase).getPosX()+"]["+this.VoisinSud(maCase).getPosY()+"] "+this.VoisinSud(maCase).getEtat());
		if (this.VoisinEst(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinEst : ["+this.VoisinEst(maCase).getPosX()+"]["+this.VoisinEst(maCase).getPosY()+"] "+this.VoisinEst(maCase).getEtat());
		if (this.VoisinOuest(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinOuest : ["+this.VoisinOuest(maCase).getPosX()+"]["+this.VoisinOuest(maCase).getPosY()+"] "+this.VoisinOuest(maCase).getEtat());
		if (this.VoisinNordEst(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinNordEst : ["+this.VoisinNordEst(maCase).getPosX()+"]["+this.VoisinNordEst(maCase).getPosY()+"] "+this.VoisinNordEst(maCase).getEtat());
		if (this.VoisinNordOuest(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinNordOuest : ["+this.VoisinNordOuest(maCase).getPosX()+"]["+this.VoisinNordOuest(maCase).getPosY()+"] "+this.VoisinNordOuest(maCase).getEtat());
		if (this.VoisinSudEst(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		// System.out.println("VoisinSudEst : ["+this.VoisinSudEst(maCase).getPosX()+"]["+this.VoisinSudEst(maCase).getPosY()+"] "+this.VoisinSudEst(maCase).getEtat());
		if (this.VoisinSudOuest(maCase).getEtat() != 0) {
			nbrVoisins += 1;
		}
		return nbrVoisins;
	}
	
	
	// Jeux
	
	/**
	 * Applique les règles du jeu (niv 1).
	 * 
	 * @param maCase		La Cellule pour laquelle on applique les règles
	 * @param nbrVoisins	Le nombre de voisins que possède cette cellule (voisin => etat = 1);
	 * @return La nouvelle cellule.
	 */
	public Cellule JeuNiveau1(Cellule maCase, int nbrVoisins) {
		
		if (nbrVoisins >= 4 || nbrVoisins == 1) // Mort
			maCase.celluleMeurt();
		if (nbrVoisins == 3 || nbrVoisins == 2) // Survie/Naissance
			maCase.celluleNait();
		
		return maCase;
	}
	
	/**
	 * Applique les règles du jeu (niv 2).
	 * 
	 * @param maCase		La Cellule pour laquelle on applique les règles
	 * @param nbrVoisins	Le nombre de voisins que possède cette cellule (voisin => etat = 1);
	 * @return La nouvelle cellule.
	 */
	public Cellule JeuNiveau2(Cellule maCase, int nbrVoisins) {
		// On commence par appliquer les mêmes règles que pour le niv 1.
		JeuNiveau1(maCase, nbrVoisins);
		
		// Puis on applique les règles pour le niv 2.
		int ageCase = maCase.getAGE();
		int nrjCase = maCase.getENERGIE();
		
		// VIEILLISSEMENT
		if (ageCase < AGE_MORT) { 
			maCase.setAGE(ageCase+1);			
		} else {
			maCase.celluleMeurt();
		}
		
		// REPRODUCTION
		if (ageCase < AGE_MORT && nrjCase >= ENERGIE_REPRODUCTION && nbrVoisins != 8) {
			if (reproduction(maCase))
				maCase.setENERGIE(nrjCase - ENERGIE_REPRODUCTION);
		}
			
		return maCase;
	}
	
	
	// Fonctions utiles
	
	/**
	 * Permet de reproduire ou non une Cellule en fonction d'une Cellule donnée.
	 * 
	 * @param maCase	La Cellule qui permet la reproduction.
	 * @return	Un boolean qui permet de savoir si dans les 8 voisins une reproduction s'est faite.
	 */
	public boolean reproduction(Cellule maCase) {
		boolean cReproduit = false; // On initialise une variable qui sera celle renvoyée par la fonction.
		
		// On initialise un tableau de Cellule qui sont les voisins de la cellule envoyée en param.
		Cellule[] voisins = {VoisinEst(maCase), VoisinOuest(maCase), VoisinSud(maCase), VoisinNord(maCase),
		                     VoisinNordEst(maCase), VoisinNordOuest(maCase), VoisinSudEst(maCase), VoisinSudOuest(maCase)};
		
		// On créé une boucle qui va venir regarder l'état du voisin.
		for (int i = 0; i < voisins.length; i++) {
			if (voisins[i].getEtat() == 1) { // Si celui-ci est à 1 (= cellule vivante).
				cReproduit = true; // on change la variable de retour de la fonction a true.
				voisins[i].celluleNait(); // on fait naitre une cellule sur la cellule voisine concernée.
			}
		}
		
		return cReproduit;
	}
	
	
	// GETTEUR & SETTEUR
	
	/**
	 * Permet de retourner la Grille.
	 * @return	Retourne la Grille.
	 */
	public Cellule[][] getLaGrille() {
		return laGrille;
	}

	/**
	 * Permet de mettre à jour la grille.
	 * @param laGrille La grille que l'on copie.
	 */
	public void setLaGrille(Cellule[][] laGrille) {
		this.laGrille = laGrille;
	}

	/**
	 * Permet de setter l'âge maximal qu'une Cellule peut avoir avant de mourir.
	 * @param aGE_MORT	L'âge maximal.
	 */
	public void setAGE_MORT(int aGE_MORT) {
		AGE_MORT = aGE_MORT;
	}

	/**
	 * Permet de setter l'énergie de reproduction minimal pour autoriser une Cellule à se reproduire.
	 * @param eNERGIE_REPRODUCTION	L'énergie minimale nécessaire.
	 */
	public void setENERGIE_REPRODUCTION(int eNERGIE_REPRODUCTION) {
		ENERGIE_REPRODUCTION = eNERGIE_REPRODUCTION;
	}
}
