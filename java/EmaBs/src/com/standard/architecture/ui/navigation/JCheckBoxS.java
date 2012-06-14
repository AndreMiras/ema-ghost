package com.standard.architecture.ui.navigation;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import com.standard.architecture.business.util.properties.Ressource;
import com.standard.architecture.ui.Controler;

public class JCheckBoxS extends JCheckBox{
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	public JCheckBoxS(String name, Controler controleur)
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
		if(resP.getProperty(name + ".icon") !=null)//image
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
		//style
		String police = "";
		if(resP.getProperty(name + ".text.police") !=null)//style specifique
		{
			police = resP.getProperty(name + ".text.police");
		}
		if(police.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("text.police") !=null)
			{
				police = resP.getProperty("text.police");
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
			if(resP.getProperty("text.taille") !=null)
			{
				taille = resP.getProperty("text.taille");
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
			if(resP.getProperty("text.gras") !=null)
			{
				gras = resP.getProperty("text.gras");
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
			if(resP.getProperty("text.italique") !=null)
			{
				italique = resP.getProperty("text.italique");
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
			if(resP.getProperty("text.alignement.horizontal") !=null)
			{
				horizontal = resP.getProperty("text.alignement.horizontal");
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
			if(resP.getProperty("text.alignement.vertical") !=null)
			{
				vertical = resP.getProperty("text.alignement.vertical");
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
			if(resP.getProperty("text.Color") !=null)
			{
				color = resP.getProperty("text.Color");
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
//visible
		String visible = "";
		if(resP.getProperty(name + ".visible") !=null)
		{
			if(!resP.getProperty(name + ".visible").isEmpty())
			{
				visible = resP.getProperty(name + ".visible");
			}
		}
		if(!visible.equals("n") && !visible.equals("N"))
		{
			this.setVisible(true);
		}
		else
		{
			this.setVisible(false);
		}
	}
	/*
	 * M�thodes
	 */	
	public String toString()
	{
		return this.getText();
	}
}
