package com.standard.architecture.ui.navigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.standard.architecture.business.util.properties.Ressource;
import com.standard.architecture.ui.Controler;

public abstract class JPanelS extends JPanel {
	/*
	 * Attributs
	 */
	private Controler		controleur;
	private int				esp_num;
	private Image 			img;

	/*
	 * Constructeur
	 */
	public JPanelS(Controler controleur,String pnl_name)
	{
		super();
		this.controleur = controleur;
		esp_num = -1;
		
		Ressource resP = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"button.properties");
		
		if(resP.getProperty(pnl_name + ".icon") !=null)
		{
			if(!resP.getProperty(pnl_name + ".icon").isEmpty())
			{
				if((new File(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty(pnl_name + ".icon")).exists()))
				{
					img = new ImageIcon(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty(pnl_name + ".icon")).getImage();
				//	Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
				//    setPreferredSize(size);
				//    setMinimumSize(size);
				//    setMaximumSize(size);
				//    setSize(size);
				    setLayout(null);			
				}
			}
		}
		if(img==null)
		{
			if(!resP.getProperty("font.icon").isEmpty())
			{
				if((new File(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty("font.icon")).exists()))
				{
					img = new ImageIcon(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty("font.icon")).getImage();
				    setLayout(null);			
				}
			}
		}
		String color="";
		if(resP.getProperty(pnl_name + ".Color") !=null)//style specifique
		{
			color = resP.getProperty(pnl_name + ".Color");
		}
		if(color.equals(""))//si pas de style specifique // si standard
		{
			if(resP.getProperty("font.Color") !=null)
			{
				color = resP.getProperty("font.Color");
			}
		}
		if(!color.equals(""))//sinon style par default
		{
			Integer b = Integer.parseInt(color);
			this.setBackground(new Color(b.intValue()));
		}	
		
		
		init();
	}
	/*
	 * Méthodes
	 */
	/*
	 * get
	 */
	public Controler getControleur()
	{
		return this.controleur;
	}
	public int getEspace_num()
	{
		return this.esp_num;
	}
	/*
	 * set
	 */
	public void setControleur(Controler controleur)
	{
		this.controleur = controleur;
	}
	public void setEspace_num(int esp_num)
	{
		this.esp_num = esp_num;
	}	
	public abstract void init();
	
	public void paintComponent(Graphics g) {
		if(img != null)
			g.drawImage(img, 0, 0, null);
		else
			super.paintComponent(g);
	}
}
