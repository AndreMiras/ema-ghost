package com.standard.architecture.business.util.properties;


public class Configuration extends BaseProperties {

	public Configuration(String nom_properties) {
		super(nom_properties,"Fichier Configuration");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

		prop.setProperty("configuration.ressource","");
		prop.setProperty("configuration.style","");
		prop.setProperty("configuration.imgRep","");
		prop.setProperty("configuration.lang","");
		prop.setProperty("configuation.Erreur","");
	}
}
