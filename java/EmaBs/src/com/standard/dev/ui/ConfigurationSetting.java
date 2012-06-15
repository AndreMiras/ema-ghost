package com.standard.dev.ui;

import com.standard.architecture.business.util.properties.Ressource;

public class ConfigurationSetting {
	/*
	 * Attributs
	 */
	String lang;
	String dossierConf;
	String separateur;
	String chemin_dossier_partage;
	/*
	 * Constructeur
	 */
	public ConfigurationSetting() {
		// TODO Auto-generated constructor stub
		lang = null;
		dossierConf = null;
		separateur = null;
		chemin_dossier_partage = null;
	}
	/*
	 * Getter Setter
	 */
	/*
	 * Methodes
	 */
	public String getSeparateur_dossier()
	{
		String result="";
		if(separateur == null)
		{
			Ressource resP = new Ressource("configuration.properties");
	
			if(resP.getProperty("separateur_dossier") !=null)
			{			
				separateur = resP.getProperty("separateur_dossier");
			}
			else
			{
				separateur = "//";
			}
		}
		return separateur;
	}
	public String getChemin_dossier_partage()
	{
		if(chemin_dossier_partage == null)
		{
			chemin_dossier_partage="";
			Ressource resP = new Ressource("configuration.properties");
	
			if(resP.getProperty("chemin_dossier_partage") !=null)
			{			
				chemin_dossier_partage = resP.getProperty("chemin_dossier_partage");
			}
		}
		return chemin_dossier_partage;
	}
	public String getChemin_dossier_configuration()
	{
		if(dossierConf == null)
		{
			dossierConf="";
			Ressource resP = new Ressource("configuration.properties");
	
			if(resP.getProperty("chemin_dossier_configuration") !=null)
			{			
				dossierConf = resP.getProperty("chemin_dossier_configuration");
			}
		}
		return dossierConf;
	}
	public String getLang()
	{
		if(lang == null)
		{
			Ressource resP = new Ressource("configuration.properties");
	
			if(resP.getProperty("lang_default") !=null)
			{			
				lang = resP.getProperty("lang_default");
			}
			else
			{
				lang = "FR";
			}
		}
		return lang;
	}
	public void setLang(String lang)
	{
		this.lang = lang;
	}
}
