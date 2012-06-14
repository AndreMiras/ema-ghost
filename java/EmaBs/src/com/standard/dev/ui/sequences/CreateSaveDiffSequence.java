package com.standard.dev.ui.sequences;

public class CreateSaveDiffSequence {
	/*
	 * Attributs
	 */
	String cours; 
	String promotion;
	String distribution;
	String nom;
	String sauvegarde;
	/*
	 * Constructeur 
	 */
	public CreateSaveDiffSequence()
	{
		cours =""; 
		promotion ="";
		distribution ="";
		nom="";
		sauvegarde="";
	}
	/*
	 * Getter Setter
	 */
	public String getCours() {
		return cours;
	}
	public void setCours(String cours) {
		this.cours = cours;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSauvegarde() {
		return sauvegarde;
	}
	public void setSauvegarde(String sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
	/*
	 * Méthodes
	 */
}
