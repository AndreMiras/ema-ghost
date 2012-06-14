package com.standard.architecture.ui.navigation.tableau;

import java.io.File;
import javax.swing.*;

import com.standard.architecture.business.util.properties.Ressource;
import com.standard.architecture.ui.Controler;

import java.awt.*;


public class Tab_Case extends JLabel{
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	public Tab_Case(String name, Controler controleur)
	{
		super();
		Ressource resL = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"Language"+controleur.getConfiguration().getSeparateur_dossier()+ controleur.getConfiguration().getLang() +".properties");
		Ressource resP = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"button.properties");
		
		this.setName(name);
		
		if(resL.getProperty(name) !=null)
		{			
			this.setText(resL.getProperty(name));
		}
		else
		{
			this.setText(name);
		}
//image		
		boolean image = true;
		if(resP.getProperty(name + ".icon") !=null)
		{
			if(!resP.getProperty(name + ".icon").isEmpty())
			{
				if((new File(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier() +resP.getProperty(name + ".icon")).exists()))
				{
					Icon imgicon = new ImageIcon(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty(name + ".icon"));
					this.setIcon(imgicon);
					image = false;
				}
			}
		}
		if(image)
		{
			if(resP.getProperty("case.icon") !=null)//image
			{
				if(!resP.getProperty("case.icon").isEmpty())
				{
					if((new File(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty("case.icon")).exists()))
					{
						Icon imgicon = new ImageIcon(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty("case.icon"));
						this.setIcon(imgicon);
					}
				}
			}
		}
//bordure
		String bordure="";
		if(resP.getProperty("case.couleur.bordure") !=null)
		{
			bordure = resP.getProperty("case.couleur.bordure");
		}
		if(bordure.equals(""))//si pas de style specifique // si standard
		{
			this.setBorder(BorderFactory.createTitledBorder(""));
		}
		else
		{
			Integer b = Integer.parseInt(bordure);
			this.setBorder(BorderFactory.createLineBorder(new Color(b.intValue())));			
		}
		
//style
		String police = "";
		if(resP.getProperty(name + ".text.police") !=null)//style specifique
		{
			police = resP.getProperty(name + ".text.police");
		}
		if(police.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.police") !=null)
			{
				police = resP.getProperty("case.police");
			}
		}
		if(police.equals(""))//sinon style par default
		{
			
		}
		//taille
		String taille = "";
		if(resP.getProperty(name + ".text.taille") !=null)//style specifique
		{
			taille = resP.getProperty(name + ".text.taille");
		}
		if(taille.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.taille") !=null)
			{
				taille = resP.getProperty("case.taille");
			}
		}
		if(taille.equals(""))//sinon style par default
		{
			taille = "15";
		}
		Integer i = Integer.parseInt(taille);
		
//gras
		String gras = "";
		int g = 0;
		if(resP.getProperty(name + ".text.gras") !=null)//style specifique
		{
			gras = resP.getProperty(name + ".text.gras");
		}
		if(gras.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.gras") !=null)
			{
				gras = resP.getProperty("case.gras");
			}
		}
		if(gras.equals("y") ||gras.equals("O")||gras.equals("Y") || gras.equals("o"))
		{
			g = Font.BOLD;
		}
		
//italique
		String italique = "";
		int j=0;
		if(resP.getProperty(name + ".text.italique") !=null)//style specifique
		{
			italique = resP.getProperty(name + ".text.italique");
		}
		if(italique.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.italique") !=null)
			{
				italique = resP.getProperty("case.italique");
			}
		}
		if(italique.equals("y") ||gras.equals("O")||gras.equals("Y") || gras.equals("o"))
		{
			j = Font.ITALIC;
		}
				
		this.setFont(new Font(police, g | j, i.intValue()));
		
//Alignement Horizontal
		String horizontal = "";
		if(resP.getProperty(name + ".text.alignement.horizontal") !=null)//style specifique
		{
			horizontal = resP.getProperty(name + ".text.alignement.horizontal");
		}
		if(horizontal.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.alignement.horizontal") !=null)
			{
				horizontal = resP.getProperty("case.alignement.horizontal");
			}
		}
		if(horizontal.equals("y") ||horizontal.equals("O")||horizontal.equals("Y") || horizontal.equals("o"))
		{
			this.setHorizontalAlignment(CENTER);
		}
		
//alignement vertical
		String vertical = "";
		if(resP.getProperty(name + ".text.alignement.vertical") !=null)//style specifique
		{
			vertical = resP.getProperty(name + ".text.alignement.vertical");
		}
		if(vertical.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.alignement.vertical") !=null)
			{
				vertical = resP.getProperty("case.alignement.vertical");
			}
		}
		if(vertical.equals("y") ||vertical.equals("O")||vertical.equals("Y") || vertical.equals("o"))
		{
			this.setVerticalAlignment(CENTER);
		}	
//Color
		String color="";
		if(resP.getProperty(name + ".text.Color") !=null)//style specifique
		{
			color = resP.getProperty(name + ".text.Color");
		}
		if(color.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("case.text.Color") !=null)
			{
				color = resP.getProperty("case.text.Color");
			}
		}
		if(!color.equals(""))//sinon style par default
		{
			Integer b = Integer.parseInt(color);
			this.setForeground(new Color(b.intValue()));
		}	
		else
		{
			this.setForeground(Color.BLACK);
		}
	}
	/*
	 * Méthodes
	 */
}