package com.standard.dev.ui.services.Sauvegarde;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;

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
    JComboBoxS jComboBox4;
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
		JLabelS jLabel1 = new JLabelS("svg.promo",getControleur());
		JLabelS jLabel2 = new JLabelS("svg.backupDestination",getControleur());
        JLabelS jLabel3 = new JLabelS("svg.backupName",getControleur());
        JLabelS jLabel4 = new JLabelS("svg.cours",getControleur());
        JLabelS jLabel5 = new JLabelS("svg.iso",getControleur());
        jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);
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

//        setPreferredSize(new java.awt.Dimension(336, 329));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//promotion
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//cours
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));//distribution

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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
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
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))))))
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
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );    
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
}
