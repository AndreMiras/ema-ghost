package com.standard.dev.ui.services.Restauration;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;
import com.standard.dev.data.Element.Repertoire;

public class RstEspace extends JPanelS implements JInterface_JFrameS_JPanelS {
	/*
	 * Attributs
	 */
	JComboBoxS jComboBox1;
    JComboBoxS jComboBox2;
    JComboBoxS jComboBox3;
    JComboBoxS jComboBox4;
    JComboBoxS jComboBox5;
	/*
	 * Constructeur
	 */
	public RstEspace(Controler controleur)
	{
		super(controleur,"restauration");
		
	}
	@Override
	public void init() {
		JButtonS jButton1 = new JButtonS("rst.btn_Apply",getControleur());
		JButtonS jButton2 = new JButtonS("rst.btn_cancel",getControleur());
/*		jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);
*/        JLabelS jLabel1 = new JLabelS("rst.promo",getControleur());
        JLabelS jLabel4 = new JLabelS("rst.cours",getControleur());
        JLabelS jLabel5 = new JLabelS("rst.iso",getControleur());
		JLabelS jLabel3 = new JLabelS("rst.name",getControleur());
		JLabelS jLabel2 = new JLabelS("rst.backupName",getControleur());
        jComboBox1 = new JComboBoxS("rst.cmb_promotion",getControleur());
        jComboBox2 = new JComboBoxS("rst.cmb_cours",getControleur());
        jComboBox3 = new JComboBoxS("rst.cmb_distribution",getControleur());
        jComboBox4 = new JComboBoxS("rst.cmb_Nom",getControleur());
        jComboBox5 = new JComboBoxS("rst.cmb_sauvegarde",getControleur());

//        setPreferredSize(new java.awt.Dimension(336, 329));


        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//promotion
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//cours
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//distribution
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//nom
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//sauvegarde

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jComboBox1, 0, 306, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox2, 0, 306, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox3, 0, 306, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(70, 70, 70))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jComboBox4, 0, 306, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jComboBox5, 0, 306, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(false);
        jComboBox5.setEnabled(false);
        ArrayList<String> e1 = new ArrayList<String>();
        e1.add("");
        ArrayList<String> e2 = new ArrayList<String>();
        e2.add("");
        ArrayList<String> e3 = new ArrayList<String>();
        e3.add("");
        ArrayList<String> e4 = new ArrayList<String>();
        e4.add("");
        ArrayList<String> e5 = new ArrayList<String>();
        e5.add("");
        jComboBox1.listToCombo(e1);
        jComboBox2.listToCombo(e2);
        jComboBox3.listToCombo(e3);
        jComboBox4.listToCombo(e4);
        jComboBox5.listToCombo(e5);
        remplisCombosPromotion();

	}
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}
	public String getPromotion() {
		// TODO Auto-generated method stub
		return (String) jComboBox1.getSelectedItem();
	}
	public String getCours() {
		// TODO Auto-generated method stub
		return (String) jComboBox2.getSelectedItem();
	}
	public String getDistribution() {
		// TODO Auto-generated method stub
		return (String) jComboBox3.getSelectedItem();
	}
	public String getNom() {
		// TODO Auto-generated method stub
		return (String) jComboBox4.getSelectedItem();
	}
	public String getSauvegarde() {
		// TODO Auto-generated method stub
		return (String) jComboBox5.getSelectedItem();
	}
	public void remplisCombosPromotion()
	{
		String chemin = "";
		if(!getControleur().getConfiguration().getChemin_dossier_partage().equals(""))
		{
			chemin = getControleur().getConfiguration().getChemin_dossier_partage() + getControleur().getConfiguration().getSeparateur_dossier() ;
		}
		chemin += "" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos";
		chemin  = chemin.replaceAll("//", "/");
		
		//remplissage de la combo promotion
		Repertoire repertoire = new Repertoire(chemin,false);
		repertoire.listToList();
		
		for(int i = 0 ; i < repertoire.getListDirectory().size() ; i++)
		{
			String e = ((String)repertoire.getListDirectory().get(i));
			e = (String) e.subSequence(e.lastIndexOf(getControleur().getConfiguration().getSeparateur_dossier().substring(0, 1))+1, e.length());
			jComboBox1.addToList(e);
		}
	}
	public void remplisCombosCours()
	{
		String chemin = "";
		if(!getControleur().getConfiguration().getChemin_dossier_partage().equals(""))
		{
			chemin = getControleur().getConfiguration().getChemin_dossier_partage() + getControleur().getConfiguration().getSeparateur_dossier() ;
		}
		chemin += "" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos" + getControleur().getConfiguration().getSeparateur_dossier() + getPromotion();
		chemin  = chemin.replaceAll("//", "/");
		
		//remplissage de la combo promotion
		Repertoire repertoire = new Repertoire(chemin,false);
		repertoire.listToList();
		
		for(int i = 0 ; i < repertoire.getListDirectory().size() ; i++)
		{
			String e = ((String)repertoire.getListDirectory().get(i));
			e = (String) e.subSequence(e.lastIndexOf(getControleur().getConfiguration().getSeparateur_dossier().substring(0, 1))+1, e.length());
			jComboBox2.addToList(e);
		}
	}
	public void remplisCombosDistribution()
	{
		String chemin = "";
		if(!getControleur().getConfiguration().getChemin_dossier_partage().equals(""))
		{
			chemin = getControleur().getConfiguration().getChemin_dossier_partage() + getControleur().getConfiguration().getSeparateur_dossier() ;
		}
		chemin += "" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos" + getControleur().getConfiguration().getSeparateur_dossier() + getPromotion()  + getControleur().getConfiguration().getSeparateur_dossier() + getCours();
		chemin  = chemin.replaceAll("//", "/");
		
		//remplissage de la combo promotion
		Repertoire repertoire = new Repertoire(chemin,false);
		repertoire.listToList();
		
		for(int i = 0 ; i < repertoire.getListDirectory().size() ; i++)
		{
			String e = ((String)repertoire.getListDirectory().get(i));
			e = (String) e.subSequence(e.lastIndexOf(getControleur().getConfiguration().getSeparateur_dossier().substring(0, 1))+1, e.length());
			jComboBox3.addToList(e);
		}		
	}
	public void remplisCombosNom()
	{
		String chemin = "";
		if(!getControleur().getConfiguration().getChemin_dossier_partage().equals(""))
		{
			chemin = getControleur().getConfiguration().getChemin_dossier_partage() + getControleur().getConfiguration().getSeparateur_dossier() ;
		}
		chemin += "" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos"; 
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getPromotion();
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getCours();
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getDistribution();
		chemin  = chemin.replaceAll("//", "/");
		
		//remplissage de la combo promotion
		Repertoire repertoire = new Repertoire(chemin,false);
		repertoire.listToList();
		
		for(int i = 0 ; i < repertoire.getListDirectory().size() ; i++)
		{
			String e = ((String)repertoire.getListDirectory().get(i));
			e = (String) e.subSequence(e.lastIndexOf(getControleur().getConfiguration().getSeparateur_dossier().substring(0, 1))+1, e.length());
			jComboBox4.addToList(e);
		}		
	}
	public void remplisCombosSauvegarde()
	{
		String chemin = "";
		if(!getControleur().getConfiguration().getChemin_dossier_partage().equals(""))
		{
			chemin = getControleur().getConfiguration().getChemin_dossier_partage() + getControleur().getConfiguration().getSeparateur_dossier() ;
		}
		chemin += "" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos"; 
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getPromotion();
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getCours();
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getDistribution();
		chemin += getControleur().getConfiguration().getSeparateur_dossier() + getNom();
		chemin  = chemin.replaceAll("//", "/");
		
		//remplissage de la combo promotion
		Repertoire repertoire = new Repertoire(chemin,false);
		repertoire.listToList();
		
		for(int i = 0 ; i < repertoire.getListFile().size() ; i++)
		{
			String e = ((String)repertoire.getListFile().get(i));
			e = (String) e.subSequence(e.lastIndexOf(getControleur().getConfiguration().getSeparateur_dossier().substring(0, 1))+1, e.length());
			jComboBox5.addToList(e);
		}		
	}	
}
