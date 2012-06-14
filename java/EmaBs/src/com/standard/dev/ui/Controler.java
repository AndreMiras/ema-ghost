package com.standard.dev.ui;

import java.util.Hashtable;

import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.dev.ui.services.AjoutCombo.AjoutCombo;
import com.standard.dev.ui.services.AjoutMacAddr.AjoutMacAddr;
import com.standard.dev.ui.services.Chargement.Chargement;
import com.standard.dev.ui.services.CreateSauvegarde.CreateSauvegarde;
import com.standard.dev.ui.services.LanceRestauration.LanceRestauration;
import com.standard.dev.ui.services.ListeRestauration.ListeRestauration;
import com.standard.dev.ui.services.PrincipalCLient.PrincipalClient;
import com.standard.dev.ui.services.PrincipalServeur.PrincipalServeur;
import com.standard.dev.ui.services.Restauration.Restauration;
import com.standard.dev.ui.services.Sauvegarde.Sauvegarde;

public class Controler extends com.standard.architecture.ui.Controler{

	public Controler(String Service_principale) {
		super(new JFrameS(), Service_principale);
		// TODO Auto-generated constructor stub
	}
	public void chargerService() {
		// TODO Auto-generated method stub
		getHtable().put("prc", new PrincipalClient(this,this.frame));
		getHtable().put("prs", new PrincipalServeur(this,this.frame));
		getHtable().put("svg", new Sauvegarde(this,this.frame));
		getHtable().put("rst", new Restauration(this,this.frame));
		getHtable().put("chr", new Chargement(this,this.frame));
		getHtable().put("acb", new AjoutCombo(this,this.frame));
		getHtable().put("ama", new AjoutMacAddr(this,this.frame));
		getHtable().put("lrs", new LanceRestauration(this,this.frame));
		getHtable().put("lar", new ListeRestauration(this,this.frame));	
		getHtable().put("csv", new CreateSauvegarde(this,this.frame));		
	}
}
