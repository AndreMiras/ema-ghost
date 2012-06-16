package com.standard.architecture.ui.navigation;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.standard.architecture.business.util.properties.*;
import com.standard.architecture.ui.Controler;
import com.standard.dev.ui.ConfigurationSetting;


public class JLabelErreurS extends JLabel{
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	public JLabelErreurS(String name,Controler controleur)
	{
		super();
		
		if(!name.isEmpty() && !name.equals(""))
		{
			ConfigurationSetting config = new ConfigurationSetting();
			Ressource resL = new Ressource(config.getChemin_dossier_configuration()+"configuration"+config.getSeparateur_dossier()+"Erreur.properties");
			Ressource resP = new Ressource(config.getChemin_dossier_configuration()+"configuration"+config.getSeparateur_dossier()+"button.properties");
			
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
					if((new File(config.getChemin_dossier_configuration()+"configuration"+config.getSeparateur_dossier()+"img"+config.getSeparateur_dossier()+"" +resP.getProperty(name + ".icon")).exists()))
					{
						Icon imgicon = new ImageIcon(config.getChemin_dossier_configuration()+"configuration"+config.getSeparateur_dossier()+"img"+config.getSeparateur_dossier()+"" +resP.getProperty(name + ".icon"));
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
				if(resP.getProperty("err.police") !=null)
				{
					police = resP.getProperty("err.police");
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
				if(resP.getProperty("err.taille") !=null)
				{
					taille = resP.getProperty("err.taille");
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
				if(resP.getProperty("err.gras") !=null)
				{
					gras = resP.getProperty("err.gras");
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
				if(resP.getProperty("err.italique") !=null)
				{
					italique = resP.getProperty("err.italique");
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
				if(resP.getProperty("err.alignement.horizontal") !=null)
				{
					horizontal = resP.getProperty("err.alignement.horizontal");
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
				if(resP.getProperty("err.alignement.vertical") !=null)
				{
					vertical = resP.getProperty("err.alignement.vertical");
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
				if(resP.getProperty("err.Color") !=null)
				{
					color = resP.getProperty("err.Color");
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
	}
	
	/*
	 * M�thodes
	 */
}