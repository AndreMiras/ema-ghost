package com.standard.architecture.ui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.standard.architecture.business.util.properties.Ressource;
import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JPanelS;

public class JFrameS extends JFrame implements JInterface_JFrameS_JPanelS{
	/*
	 * Attributs
	 */
	private JPanel 			pnl_titre;
	private JPanel 			pnl_menu;
	//private JPanel 			pnl_sous_menu;
	private JPanel 			pnl_espace;
	private JPanel 			pnl_gauche;
	private JPanel 			pnl_bas;
	private JLabel 			lbl_erreur;
	private JScrollPane 	scr;
	private Controler		controleur;
	private JLabelErreurS	mess_err;
    private JMenuBar 		jMenuBar;
    String test;
	GridBagLayout g=new GridBagLayout();
	GridBagConstraints c=new GridBagConstraints();
	
	/*
	 * Constructeur
	 */
	public JFrameS()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}
	public JFrameS(Controler controleur)
	{
		this.controleur = controleur;
		init();
	}
	/*
	 * Methodes
	 */
	public void init()
	{
		pnl_titre 		= new JPanel();
		pnl_menu 		= new JPanel();
//		pnl_sous_menu 	= new JPanel();
		pnl_espace 		= new JPanel();
		pnl_gauche		= new JPanel();		
		pnl_bas			= new JPanel();
	    jMenuBar		= new JMenuBar();
		mess_err		= new JLabelErreurS("",controleur);
		scr = new JScrollPane();
		
		setJMenuBar(jMenuBar); 
		
		this.getContentPane().setLayout(new BorderLayout());
		add(pnl_titre,BorderLayout.NORTH);
		add(pnl_gauche,BorderLayout.WEST);
		//add(pnl_espace,BorderLayout.CENTER);
		add(scr,BorderLayout.CENTER);
		scr.setViewportView(pnl_espace);
		add(pnl_bas,BorderLayout.SOUTH);
		
		pnl_gauche.setLayout(new GridBagLayout());
		pnl_gauche.add(pnl_titre);
		pnl_gauche.add(pnl_menu);
		pnl_gauche.setLayout(g);
		c.gridy=0;
		g.setConstraints(pnl_titre,c);
		c.gridy=1;
		g.setConstraints(pnl_menu,c);
		
		pnl_bas.add(mess_err);
//		this.setPreferredSize(new Dimension(800,800));
		this.pack();
		this.setVisible(true);
		
	}
	/*
	 * Set
	 */
	public void setPnl_titre(JPanel pnl)
	{
		getContentPane().setVisible(false);
		getContentPane().remove(this.pnl_titre);
		setPnl_haut();
		this.pnl_titre = pnl;
		pnl_gauche.add(pnl_titre);
		pnl_gauche.add(pnl_menu);
		pnl_gauche.setLayout(g);
		c.gridy=0;
		g.setConstraints(pnl_titre,c);
		c.gridy=1;
		g.setConstraints(pnl_menu,c);
		getContentPane().add(pnl_gauche,BorderLayout.NORTH);
		getContentPane().setVisible(true);
	}
	public void setPnl_menu(JPanel pnl)
	{
		pnl_gauche.setVisible(false);
		setPnl_haut();
		pnl_gauche.remove(this.pnl_menu);
		this.pnl_menu = pnl;
		pnl_gauche.add(pnl_titre);
		pnl_gauche.add(pnl_menu);
		pnl_gauche.setLayout(g);
		c.gridy=0;
		g.setConstraints(pnl_titre,c);
		c.gridy=1;
		g.setConstraints(pnl_menu,c);
		pnl_gauche.setVisible(true);
	}
	public void setPnl_espace(JPanel pnl)
	{
		getContentPane().setVisible(false);
		getContentPane().remove(this.scr);
		scr = new JScrollPane();
		this.pnl_espace = pnl;
		scr.setViewportView(pnl_espace);
		getContentPane().add(scr,BorderLayout.CENTER);
		getContentPane().setVisible(true);
	}
	private void setPnl_haut()
	{
		getContentPane().setVisible(false);
		getContentPane().remove(this.pnl_gauche);
		this.pnl_gauche = new JPanel();
		this.pnl_gauche.setLayout(new GridBagLayout());
		getContentPane().add(pnl_gauche,BorderLayout.NORTH);
		getContentPane().setVisible(true);
	}
	private void setPnl_bas(String mess)
	{
		getContentPane().setVisible(false);
		getContentPane().remove(this.pnl_bas);
		this.pnl_bas = new JPanel();
		
		mess_err = new JLabelErreurS(mess,controleur);			
		if(mess.equals(""))
		{
			mess_err.setText(" ");
		}
		this.pnl_bas.add(mess_err);
		getContentPane().add(pnl_bas,BorderLayout.SOUTH);
		getContentPane().setVisible(true);
	}
	private void setPnl_bas(JPanel pnl)
	{
		getContentPane().setVisible(false);
		getContentPane().remove(this.pnl_bas);
		this.pnl_bas = pnl;
		getContentPane().add(pnl_bas,BorderLayout.SOUTH);
		getContentPane().setVisible(true);
	}
	public void dechargerPanel()
	{
		getContentPane().setVisible(false);
		getContentPane().remove(this.pnl_titre);
		getContentPane().remove(this.pnl_menu);
//		getContentPane().remove(this.pnl_sous_menu);
		getContentPane().remove(this.pnl_espace);
		getContentPane().remove(this.pnl_gauche);
		this.setPnl_bas("");
		getContentPane().setVisible(true);
	}
	/*
	 * get
	 */
	public JPanel getPnl_espace()
	{
		return this.pnl_espace;
	}
	public JPanel getPnl_titre()
	{
		return this.pnl_titre;
	}
	public void setErreur(String err)
	{
		this.setPnl_bas(err);
	}
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		this.setPnl_titre(this.pnl_titre);
		this.setPnl_menu(this.pnl_menu);
//		this.setPnl_sous_menu(this.pnl_sous_menu);
		this.setPnl_espace(this.pnl_espace);
		this.setPnl_bas(this.pnl_bas);
	}
	public void setControleur(Controler controleur)
	{
		this.controleur = controleur;
		
		Ressource resP = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"button.properties");
		
		if(resP.getProperty("EmaBS.icon") !=null)
		{
			if(!resP.getProperty("EmaBS.icon").isEmpty())
			{
				if((new File(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty("EmaBS.icon")).exists()))
				{
					Image img = new ImageIcon(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"img"+controleur.getConfiguration().getSeparateur_dossier()+"" +resP.getProperty("EmaBS.icon")).getImage();
					setIconImage(img);
				}
			}
		}
		if(resP.getProperty("EmaBS.titre") !=null)
		{
			if(!resP.getProperty("EmaBS.titre").isEmpty())
			{
					String titre = resP.getProperty("EmaBS.titre");
					setTitle(titre);
			}
		}
	}
}

