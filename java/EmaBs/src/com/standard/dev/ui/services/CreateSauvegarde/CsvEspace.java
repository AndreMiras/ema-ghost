package com.standard.dev.ui.services.CreateSauvegarde;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;


public class CsvEspace extends JPanelS implements JInterface_JFrameS_JPanelS {
	/*
	 * Attributs
	 */
	JComboBoxS jComboBox1;
	JComboBoxS jComboBox2; 
	JComboBoxS jComboBox3; 
	/*
	 * Constructeur
	 */
	public CsvEspace(Controler controleur)
	{
		super(controleur,"CreationSauvegardeComplete");
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub

		JButtonS jButton1 = new JButtonS("csv.btn_Apply",getControleur());
		JButtonS jButton2 = new JButtonS("csv.btn_cancel",getControleur());
		JButtonS jButton3 = new JButtonS("csv.btn_plus1",getControleur());
		JButtonS jButton4 = new JButtonS("csv.btn_plus2",getControleur());
		JButtonS jButton5 = new JButtonS("csv.btn_plus3",getControleur());
		
		jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);
        jButton3.setBorderPainted(false);
        jButton3.setBackground(Color.WHITE);
        jButton4.setBorderPainted(false);
        jButton4.setBackground(Color.WHITE);
        
        jButton5.setVisible(false);


		JLabelS jLabel1 = new JLabelS("csv.promo",getControleur());
        JLabelS jLabel4 = new JLabelS("csv.cours",getControleur());
        JLabelS jLabel5 = new JLabelS("csv.iso",getControleur());
        jComboBox1 = new JComboBoxS("csv.cmb1",getControleur());
        jComboBox2 = new JComboBoxS("csv.cmb2",getControleur());
        jComboBox3 = new JComboBoxS("csv.cmb3",getControleur());
        
        setPreferredSize(new java.awt.Dimension(336, 329));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ""}));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ""}));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ""}));



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jComboBox3, 0, 277, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(107, Short.MAX_VALUE))
        );
	}
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}
	public String getPromo()
	{
		String result = (String) jComboBox1.getItemSelected();
		return result;
	}
	public String getCours()
	{
		String result = (String) jComboBox2.getItemSelected();
		return result;
	}
	public String getIso()
	{
		String result = (String) jComboBox3.getItemSelected();
		return result;
	}
}
