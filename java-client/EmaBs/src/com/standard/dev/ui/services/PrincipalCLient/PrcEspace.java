package com.standard.dev.ui.services.PrincipalCLient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;


public class PrcEspace extends JPanelS implements JInterface_JFrameS_JPanelS {
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	public PrcEspace(Controler controleur)
	{
		super(controleur,"PrincipalClient");
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
//		GridBagLayout g=new GridBagLayout();
//		GridBagConstraints c=new GridBagConstraints();
//		JPanel pnl_0 = new JPanel();
//		JPanel pnl_1 = new JPanel();
		/****************************/
//		this.setLayout(g);
//		c.gridy=0;
//		g.setConstraints(pnl_0,c);
//		c.gridy=1;
//		g.setConstraints(pnl_1,c);
		/****************************/
		//this.setBackground(Color.WHITE);
		//pnl_1.setBackground(Color.WHITE);
		//pnl_2.setBackground(Color.WHITE);
		/****************************/
//		pnl_0.add(new JButtonS("prc.btn_sauvegarde", getControleur()));
//		pnl_0.add(new JLabelS("prc.sauvegarde"));
		/****************************/
//		pnl_1.add(new JButtonS("prc.btn_restauration", getControleur()));
//		pnl_1.add(new JLabelS("prc.restauration"));
		/****************************/		
//		add(pnl_0);
//		add(pnl_1);
		/****************************/
		JButtonS jButton1 = new JButtonS("prc.btn_sauvegarde", getControleur());
		JButtonS jButton2 = new JButtonS("prc.btn_restauration", getControleur());
		/****************************/
		/****************************/
		/****************************/
		/****************************/
		/****************************/
		JPanel jPanel1 = new javax.swing.JPanel();
		JPanel jPanel2 = new javax.swing.JPanel();
		JPanel jPanel3 = new javax.swing.JPanel();
		JPanel jPanel4 = new javax.swing.JPanel();
		JPanel jPanel5 = new javax.swing.JPanel();

	     jPanel1.setLayout(new java.awt.GridLayout(4, 1));

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 316, Short.MAX_VALUE)
	            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jPanel2Layout.createSequentialGroup()
	                    .addGap(0, 121, Short.MAX_VALUE)
	                    .addComponent(jButton1)
	                    .addGap(0, 122, Short.MAX_VALUE)))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 76, Short.MAX_VALUE)
	            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jPanel2Layout.createSequentialGroup()
	                    .addGap(0, 26, Short.MAX_VALUE)
	                    .addComponent(jButton1)
	                    .addGap(0, 27, Short.MAX_VALUE)))
	        );

	        jPanel1.add(jPanel2);

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 316, Short.MAX_VALUE)
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 76, Short.MAX_VALUE)
	        );

	        jPanel1.add(jPanel3);

	        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
	        jPanel4.setLayout(jPanel4Layout);
	        jPanel4Layout.setHorizontalGroup(
	            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 316, Short.MAX_VALUE)
	            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jPanel4Layout.createSequentialGroup()
	                    .addGap(0, 121, Short.MAX_VALUE)
	                    .addComponent(jButton2)
	                    .addGap(0, 122, Short.MAX_VALUE)))
	        );
	        jPanel4Layout.setVerticalGroup(
	            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 76, Short.MAX_VALUE)
	            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jPanel4Layout.createSequentialGroup()
	                    .addGap(0, 26, Short.MAX_VALUE)
	                    .addComponent(jButton2)
	                    .addGap(0, 27, Short.MAX_VALUE)))
	        );

	        jPanel1.add(jPanel4);

	        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
	        jPanel5.setLayout(jPanel5Layout);
	        jPanel5Layout.setHorizontalGroup(
	            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 316, Short.MAX_VALUE)
	        );
	        jPanel5Layout.setVerticalGroup(
	            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 76, Short.MAX_VALUE)
	        );

	        jPanel1.add(jPanel5);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, Short.MAX_VALUE)
	                .addContainerGap())
	        );	        
	        jPanel1.setOpaque(false);
	        jPanel2.setOpaque(false);
	        jPanel3.setOpaque(false);
	        jPanel4.setOpaque(false);
	        jPanel5.setOpaque(false);
	    }
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}
}
