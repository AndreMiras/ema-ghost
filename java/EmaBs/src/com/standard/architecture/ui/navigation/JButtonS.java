package com.standard.architecture.ui.navigation;


import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.standard.architecture.business.util.properties.*;
import com.standard.architecture.ui.Controler;


public class JButtonS extends JButton{
	/*
	 * Attributs
	 */
	ActionListener controleur;
    /*
	 * Constructeur
	 */
	public JButtonS(String name , Controler controleur)
	{
		super();
		setOpaque(false);
        
        this.controleur = controleur;
        
        Ressource resL = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"Language"+controleur.getConfiguration().getSeparateur_dossier()+ controleur.getConfiguration().getLang() +".properties");
		Ressource resP = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"button.properties");
		
		this.setName(name);
		this.setActionCommand(name);
		if(name.indexOf(".", 4) !=-1)
		{
			this.setText(resL.getProperty(name.substring(0,name.indexOf(".", 4))));			
		}
		else
		{
			this.setText(resL.getProperty(name));
		}
		

		if(resP.getProperty(name + ".icon") !=null)
		{
			if(!resP.getProperty(name + ".icon").isEmpty())
			{
				if((new File(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty(name + ".icon")).exists()))
				{
					Icon imgicon = new ImageIcon(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty(name + ".icon"));
					this.setIcon(imgicon);
				}
			}
		}
		String visible = "";
		if(resP.getProperty(name + ".visible") !=null)
		{
			if(!resP.getProperty(name + ".visible").isEmpty())
			{
				visible = resP.getProperty(name + ".visible");
			}
		}
		addActionListener(controleur);
	}
	/*
	 * M�thodes
	 */
}
