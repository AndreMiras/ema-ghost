package com.standard.architecture.ui.navigation.tableau;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.standard.architecture.business.util.properties.*;
import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JButtonS;
import com.standard.architecture.ui.navigation.JLabelS;


public class Tableau extends JPanel implements ActionListener{
	/*
	 * Attributs
	 */
	private List<Object> 	colonne;
	private List<Object> 	ligne		= new ArrayList<Object>();
	private String			titre; 
	private boolean 		checkable;
	private boolean			one_checkable;
	private List<JCheckBox> listCheck;
	private Controler controleur;
	private GridBagLayout 	g;
	private GridBagConstraints c;
	/*
	 * Contructeur
	 */
	public Tableau(String titre,List<Object> colonne, List<Object> ligne , JButtonS btn_1, JButtonS btn_2,boolean one_checkable,JButtonS btn_plus,Controler controleur)
	{
		this.colonne 	= colonne;
		this.ligne		= ligne;
		this.titre		= titre;
		this.controleur = controleur;
		if(btn_1 != null || btn_2 != null || btn_plus != null)
		{
			this.checkable 	= true;
			this.one_checkable = one_checkable;
		}
		else
		{
			this.checkable = false;
			this.one_checkable = false;
		}
		genereTableau(ligne,btn_1,btn_2,btn_plus);
	}
	public void genereTableau(List<Object> ligne , JButtonS btn_1, JButtonS btn_2,JButtonS btn_plus)
	{
		JPanel pnl_tab 	= new JPanel();	
		JPanel pnl_btn  = new JPanel();		
		this.listCheck	= new ArrayList<JCheckBox>();
		this.ligne 		= ligne;
		

		g=new GridBagLayout();
		c = new GridBagConstraints();		
		c.fill=GridBagConstraints.BOTH;
		this.setLayout(g);

		this.setBorder(BorderFactory.createTitledBorder(new JLabelS(titre,controleur).getText()));
		this.add(pnl_tab);
		this.add(pnl_btn);

		c.gridy=0;
		g.setConstraints(pnl_tab,c);
		c.gridy=1;
		g.setConstraints(pnl_btn,c);	
		if(this.checkable)
		{
			if(btn_1 != null)
			{
				pnl_btn.add(btn_1);
			}
			if(btn_2 != null)
			{
				if(ligne != null)
				{
					if(ligne.size() != 0)
					{
						if(((ArrayList)ligne.get(0)).size() != 0)
						{
							pnl_btn.add(btn_2);
						}
					}
				}
			}
			if(btn_plus != null)
			{
				if(ligne != null)
				{
					if(ligne.size() != 0)
					{
						if(((ArrayList)ligne.get(0)).size() != 0)
						{
							pnl_btn.add(btn_plus);
						}
					}
				}
			}
			pnl_tab.setLayout((new GridLayout(ligne.size()+1, colonne.size()+1 )));
		}
		else
		{
			pnl_tab.setLayout(new GridLayout(ligne.size()+1, colonne.size() ));
		}
		for(int i = 0 ; i < colonne.size() ; i++)
		{
			pnl_tab.add(new Tab_Titre(((String)colonne.get(i)),controleur),controleur);
		}
		if(this.checkable)
			pnl_tab.add(new JLabelS(" ",controleur));	

		for(int i = 0 ; i < ligne.size() ; i++)
		{
			for(int j = 0 ; j < ((ArrayList)ligne.get(i)).size() - 1; j++)
			{
				pnl_tab.add(new Tab_Case(((String)((ArrayList)ligne.get(i)).get(j)),controleur));
			}
			if(this.checkable)
			{
				JCheckBox jcheckbox = new JCheckBox();
				if(this.one_checkable)
				{
					jcheckbox.setActionCommand(Integer.toString(i));
					jcheckbox.addActionListener(this);
				}
				listCheck.add(jcheckbox);
				pnl_tab.add(listCheck.get(i));
				c.gridx = 1;
				g.setConstraints(jcheckbox,c);
				jcheckbox.setSelected(i == 0);
			}
		}
		Ressource resP = new Ressource(controleur.getConfiguration().getChemin_dossier_configuration()+"configuration"+controleur.getConfiguration().getSeparateur_dossier()+"button.properties");
				//visible
				String visible = "";
				if(resP.getProperty(titre + ".visible") !=null)
				{
					if(!resP.getProperty(titre + ".visible").isEmpty())
					{
						visible = resP.getProperty(titre + ".visible");
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
	public List<Object> delete_line_checked()
	{
		List<Object> newLigne = new ArrayList<Object>();
		if(this.checkable)
		{
			List<Object> listLigne = getcheckedLine();
			if(listLigne.size() != 0 )
			{
				for(int i = listLigne.size() ; i > 0 ; i--)
				{
					int index = (Integer) listLigne.get(i-1);
					ligne.remove(index);
				}
			}
		}		
		return ligne;
	}
	public List<Object> getcheckedLine()
	{
		List<Object> res = new ArrayList<Object>();
		if(this.checkable)
		{
			for(int i = 0 ; i < this.ligne.size() ; i++)
			{
				if(((JCheckBox)listCheck.get(i)).isSelected())
				{
					res.add(i);
				}
			}
		}		
		return res;
	}
	public List<Object> getLigne()
	{
		return this.ligne;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//un seul selectionné
		for(int i = 0 ; i < this.listCheck.size() ; i++)
		{
			if(((JCheckBox)listCheck.get(i)).isSelected() && i != Integer.parseInt((e.getActionCommand())))
			{
				((JCheckBox)listCheck.get(i)).setSelected(false);
			}
		}
	}
}
