package com.standard.dev.ui.services.Sauvegarde;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;
import com.standard.dev.data.Element.Repertoire;

public class SvgEspace extends JPanelS implements JInterface_JFrameS_JPanelS, ActionListener {
	/*
	 * Attributs
	 */
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    JComboBoxS jComboBox1;
    JComboBoxS jComboBox2;
    JComboBoxS jComboBox3;

    public JButtonS jButton6;
    public JComboBoxS jComboBox4;
	/*
	 * Constructeur
	 */
	public SvgEspace(Controler controleur)
	{
		super(controleur,"SauvegardeDiff");
	}
	@Override
	public void init() {

		JButtonS jButton1 = new JButtonS("svg.btn_Apply", getControleur());
		JButtonS jButton2 = new JButtonS("svg.btn_cancel", getControleur());
		JButtonS jButton3 = new JButtonS("svg.btn_plus1", getControleur());
		JButtonS jButton4 = new JButtonS("svg.btn_plus2", getControleur());
		JButtonS jButton5 = new JButtonS("svg.btn_plus3", getControleur());
		jButton6 = new JButtonS("svg.btn_plus", getControleur());
		JLabelS jLabel1 = new JLabelS("svg.promo",getControleur());
		JLabelS jLabel2 = new JLabelS("svg.backupDestination",getControleur());
        JLabelS jLabel6 = new JLabelS("svg.backupName",getControleur());
        JLabelS jLabel4 = new JLabelS("svg.cours",getControleur());
        JLabelS jLabel5 = new JLabelS("svg.iso",getControleur());
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
/*
        jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);
*/        jButton3.setBorderPainted(false);
        jButton3.setBackground(Color.WHITE);
        jButton4.setBorderPainted(false);
        jButton4.setBackground(Color.WHITE);
        jButton5.setBorderPainted(false);
        jButton5.setBackground(Color.WHITE);
        jButton6.setBorderPainted(false);
        jButton6.setBackground(Color.WHITE);
        
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        jRadioButton1.addActionListener(this);
        jRadioButton2.addActionListener(this);
        jRadioButton1.setActionCommand("rad1");
        jRadioButton2.setActionCommand("rad2");
        jRadioButton1.setSelected(true);
		jRadioButton2.setSelected(false);
		jRadioButton1.setText("Local");
        jRadioButton2.setText("Server");

		jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new JComboBoxS("svg.cmb_promo",getControleur());
        jComboBox2 = new JComboBoxS("svg.cmb_cours",getControleur());
        jComboBox3 = new JComboBoxS("svg.cmb_iso",getControleur());
        jComboBox4 = new JComboBoxS("svg.cmb_Nom",getControleur());
//        setPreferredSize(new java.awt.Dimension(336, 329));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//promotion
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//cours
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//distribution
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jComboBox3, 0, 289, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox4, 0, 289, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(60, 60, 60))
        );
  
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(false);
        jButton6.setEnabled(false);
        
        ArrayList<String> e1 = new ArrayList<String>();
        e1.add("");
        ArrayList<String> e2 = new ArrayList<String>();
        e2.add("");
        ArrayList<String> e3 = new ArrayList<String>();
        e3.add("");
        ArrayList<String> e4 = new ArrayList<String>();
        e4.add("");
        jComboBox1.listToCombo(e1);
        jComboBox2.listToCombo(e2);
        jComboBox3.listToCombo(e3);
        jComboBox3.listToCombo(e4);
        remplisCombosPromotion();
	}
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("rad1"))
		{
			jRadioButton2.setSelected(false);
			jRadioButton1.setSelected(true);
			
		}else if(e.getActionCommand().equals("rad2"))
		{
			jRadioButton1.setSelected(false);
			jRadioButton2.setSelected(true);
		}
	}
	public String getPromotion() {
		// TODO Auto-generated method stub
		return (String) jComboBox1.getSelectedItem();
	}
	public String getCours() {
		// TODO Auto-generated method stub
		String result = "";
		if((String) jComboBox2.getSelectedItem() != null)
		{
			result = (String) jComboBox2.getSelectedItem();
		}
		return result;
	}
	public String getDistribution() {
		// TODO Auto-generated method stub
		return (String) jComboBox3.getSelectedItem();
	}
	public String getNom() {
		// TODO Auto-generated method stub
		return (String) jComboBox4.getSelectedItem();
	}
	public void remplisCombosPromotion()
	{
		String chemin = "";
		if(!getControleur().getConfiguration().getChemin_dossier_partage().equals(""))
		{
			chemin = getControleur().getConfiguration().getChemin_dossier_partage() + getControleur().getConfiguration().getSeparateur_dossier() ;
		}
		chemin += "partage" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos";
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
		chemin += "partage" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos" + getControleur().getConfiguration().getSeparateur_dossier() + getPromotion();
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
		chemin += "partage" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos" + getControleur().getConfiguration().getSeparateur_dossier() + getPromotion()  + getControleur().getConfiguration().getSeparateur_dossier() + getCours();
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
		chemin += "partage" +getControleur().getConfiguration().getSeparateur_dossier() + "Promos"; 
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
}
