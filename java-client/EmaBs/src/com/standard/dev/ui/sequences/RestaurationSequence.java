package com.standard.dev.ui.sequences;

import com.standard.architecture.ui.service.Service;
import com.standard.dev.business.util.LanceCmdShell;
import com.standard.dev.ui.services.Chargement.Chargement;
import com.standard.dev.ui.services.Chargement.ChrEspace;
import com.standard.dev.ui.services.Restauration.RstEspace;

public class RestaurationSequence extends Thread implements Sequence {
	/*
	 * Attributs
	 */
	String cours; 
	String promotion;
	String distribution;
	String nom;
	String sauvegarde;
	String Partage;
	Service service;
	ChrEspace espace;
	/*
	 * Constructeur 
	 */
	public RestaurationSequence()
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
	public String getPartage() {
		return Partage;
	}
	public void setPartage(String Partage) {
		this.Partage = Partage;
	}
	/*
	 * Methodes
	 */
	@Override
	public void lanceSequence(Service service,ChrEspace espace) 
	{
		this.service = service;
		this.espace = espace;
		this.start();
	}
		
	public void run()
	{
		String res ="";
		// TODO Auto-generated method stub
		//chemin complet de la sauvegarde diff
		String Chemin_sauvaugarde_diff = "192.168.1.1:/share/Promos/" + getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom();
		
		String cmdMondo ="";
		
		cmdMondo += "sudo sc_diff_restore -v -s 192.168.6.1:/partage/ ";
//		cmdMondo += "-f /mnt/share/isos/testpart-1.iso ";//
		cmdMondo += "-f /mnt/share/isos/" + getDistribution() + " ";
//		cmdMondo += "-d /mnt/share/Promos/Promotion1/COURS/testpart-1.iso/guillaume/testpart-1.iso_guillaume_382255112-1.iso"; 
		cmdMondo += "-d /mnt/share/Promos/";
		cmdMondo += getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom() + "/";
		cmdMondo += getSauvegarde();
		
		System.out.println(cmdMondo);
		res = LanceCmdShell.lancecmd(cmdMondo);
		System.out.println(res);		//afficahe console
		((Chargement) service).setTexte(res); //affichage fenetre
		
		
		((Chargement) service).setTexte("Fin traitement");
		((Chargement) service).afficheBoutonFermer();		
		espace.timer.stop();
		espace.jProgressBar1.setValue(100);
	}
}
