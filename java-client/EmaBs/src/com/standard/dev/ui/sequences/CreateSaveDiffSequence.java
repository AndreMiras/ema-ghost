package com.standard.dev.ui.sequences;

import java.util.Date;

import sun.org.mozilla.javascript.tools.shell.ShellLine;

import com.standard.architecture.ui.service.Service;
import com.standard.dev.business.util.LanceCmdShell;
import com.standard.dev.business.util.WOL;
import com.standard.dev.ui.services.Chargement.Chargement;
import com.standard.dev.ui.services.Chargement.ChrEspace;

public class CreateSaveDiffSequence extends Thread implements Sequence {
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
	public CreateSaveDiffSequence()
	{
		cours =""; 
		promotion ="";
		distribution ="";
		nom="";
		sauvegarde="";
		Partage="";
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
	 * M�thodes
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
		((Chargement) service).setTexte("mkdir "+getPartage() + "/Promos/" + getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom());
		System.out.println(LanceCmdShell.lancecmd("mkdir "+getPartage() + "/Promos/" + getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom()));
		
		//chemin complet de la sauvegarde diff
		String Chemin_sauvaugarde_diff = getPartage() + "/Promos/" + getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom();
				
/*		Date date_jour = new Date();
		./sc_save_diff -f /mnt/backups/testpart-1.iso -d /mnt/backups -n testpartdiff -v		
		String cmdMondo = "mondoarchive -O -i -I '/etc' -d '"+ Chemin_sauvaugarde_diff +"' -s 4g -W";
		cmdMondo = "/usr/local/bin/sc_save_diff ";
		cmdMondo +="-f " + getPartage() +"/isos/" + getDistribution() + " ";
		cmdMondo +="-d " + Chemin_sauvaugarde_diff + " ";
		cmdMondo +="-n " + getDistribution() + "_"+ getNom()  + "_"+ date_jour.getMinutes() +date_jour.getHours() + date_jour.getDay()+ date_jour.getMonth()+ date_jour.getYear() ;
*/		
		Date date_jour = new Date();
		//sudo sc_save_diff -f /mnt/share/isos/testpart-1.iso -d /mnt/share/Promos/Promotion1/COURS/testpart-1.iso/Guillaume_TEST1/  -n testpart-1.iso_Guillaume_TEST1_292055333 -v

		String cmdMondo ="sudo sc_save_diff ";
		//chemin image de base + nom
		cmdMondo += "-f /mnt/share/isos/" + getDistribution() +" ";
		//destination de la diff sans nom
		cmdMondo += "-d /mnt/share"+"/Promos/" + getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom() +" ";
		//nom de la diff que le nom
		cmdMondo += "-n "+ getDistribution() + "_"+ getNom()  + "_"+ date_jour.getMinutes() +date_jour.getHours() + date_jour.getDay()+ date_jour.getMonth()+ date_jour.getYear()  + " -v";
		cmdMondo += "";
		
		System.out.println(cmdMondo);
		((Chargement) service).setTexte(cmdMondo);
		((Chargement) service).setTexte(LanceCmdShell.lancecmd(cmdMondo));
		
/*		String[] cmdMondo2 = {"echo emabs |sudo -S sc_save_diff",
				"-f /mnt/share/isos/" + getDistribution(),
				"-d /mnt/share"+"/Promos/" + getPromotion() + "/" + getCours() + "/" +getDistribution() + "/" +getNom(),
				"-n "+ getDistribution() + "_"+ getNom()  + "_"+ date_jour.getMinutes() +date_jour.getHours() + date_jour.getDay()+ date_jour.getMonth()+ date_jour.getYear(),
				"-v"} ;
		((Chargement) service).setTexte(LanceCmdShell.lancecmd(cmdMondo2));
		
		((Chargement) service).setTexte(LanceCmdShell.lancecmd("sc_save_diff"));
	*/	
		((Chargement) service).setTexte("Fin traitement");
		((Chargement) service).afficheBoutonFermer();		
		espace.timer.stop();
		espace.jProgressBar1.setValue(100);
	}
}
