/**
 * 
 */
package com;

import java.util.Random;

/**
 * @author Lilian
 *
 */
public class Cellule {
	// Variables de la classe.
	private int etat;
	private int posX;
	private int posY;
	private int AGE;
	private int ENERGIE;
	// Variable globale.
	private int ENERGIE_INITIALE = 1;

	/**
	 * Constructeur de la Classe.
	 * Initialise les params suivants :<br>
	 * - position (x,y)<br>
	 * - l'état (aléatoire) de la cellule<br>
	 * - l'age<br>
	 * - l'énergie
	 * 
	 * @param posY	Position de la cellule sur l'axe des ordonnées.
	 * @param posX	Position de la cellule sur l'axe des abscisses.
	 */
	public Cellule(int posY, int posX) {
		Random r = new Random();
		this.posX = posX;
		this.posY = posY;
		this.etat = r.nextInt(2);
		this.AGE = 0;
		this.ENERGIE = this.ENERGIE_INITIALE;
	}
	
	// GETTEUR & SETTEUR
	/**
	 * Permet de retourner l'état de la Cellule.
	 * @return L'état de la cellule
	 */
	public int getEtat() {
		return etat;
	}

	/**
	 * Permet de mettre à jour l'état de la Cellule.
	 * @param etat Le nouvel état de la Cellule.
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

	/**
	 * Permet de retourner la position des abscisses de la Cellule.
	 * @return L'abscisse de la cellule
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Permet de mettre à jour l'abscisse de la Cellule.
	 * @param posX Le nouvel abscisse.
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Permet de retourner la position des ordonnées de la Cellule.
	 * @return L'ordonnée de la cellule
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Permet de mettre à jour l'ordonnée de la Cellule.
	 * @param posY Le nouvel ordonnée.
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Permet de retourner l'âge de la Cellule.
	 * @return L'âge de la Cellule.
	 */
	public int getAGE() {
		return AGE;
	}

	/**
	 * Permet de mettre à jour l'âge de la cellule.
	 * @param aGE	Le nouvel âge de la Cellule.
	 */
	public void setAGE(int aGE) {
		AGE = aGE;
	}

	/**
	 * Permet de retourner l'énergie de la Cellule.
	 * @return	L'énergie de la Cellule.
	 */
	public int getENERGIE() {
		return ENERGIE;
	}

	/**
	 * Permet de mettre à jour l'énergie de la Cellule.
	 * @param eNERGIE	La nouvelle énergie de la Cellule.
	 */
	public void setENERGIE(int eNERGIE) {
		ENERGIE = eNERGIE;
	}

	/**
	 * Permet de retourner l'énergie initiale des cellules à la naissance.
	 * @return L'énergie initiale des cellules à la naissance.
	 */
	public int getENERGIE_INITIALE() {
		return ENERGIE_INITIALE;
	}
	
	@Override
	public String toString() {
		String chaine;
		chaine = "La cellule, se trouve en case : ";
		chaine += "\t- x : "+this.posX;
		chaine += "\t- y : "+this.posY;
		chaine += "\t- etat : "+this.etat;
		return chaine;
	}
	
	/**
	 * Permet de set les différentes valeurs nécessaire à la mort d'une cellule.
	 * Les params setter sont :<br>
	 * - Age => 0<br>
	 * - Etat => 0<br>
	 * - Energie => 0
	 */
	public void celluleMeurt() {
		this.setAGE(0);
		this.setEtat(0);
		this.setENERGIE(0);
	}
	
	/**
	 * Permet de set les différentes valeurs nécessaire à la naissance d'une cellule.
	 * Les params setter sont :<br>
	 * - Age => 0<br>
	 * - Etat => 1<br>
	 * - Energie => ENERGIE INITIALE (variable globale de la fonction)
	 */
	public void celluleNait() {
		this.setAGE(0);
		this.setEtat(1);
		this.setENERGIE(ENERGIE_INITIALE);
	}

}
