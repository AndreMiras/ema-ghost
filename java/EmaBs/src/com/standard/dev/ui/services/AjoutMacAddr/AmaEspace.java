package com.standard.dev.ui.services.AjoutMacAddr;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;


public class AmaEspace extends JPanelS implements JInterface_JFrameS_JPanelS, KeyListener {
	/*
	 * Attributs
	 */
	  javax.swing.JTextField jTextField1;
      javax.swing.JTextField jTextField2;
      javax.swing.JTextField jTextField3;
      javax.swing.JTextField jTextField4;
      javax.swing.JTextField jTextField5;
      javax.swing.JTextField jTextField6;
	/*
	 * Constructeur
	 */
	public AmaEspace(Controler controleur)
	{
	super(controleur,"AjoutMacAddr");
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		JButtonS jButton1 = new JButtonS("ama.btn_Apply",getControleur());
        JButtonS jButton2 = new JButtonS("ama.btn_cancel",getControleur());
        
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        
        jTextField1.addKeyListener(this);
        jTextField2.addKeyListener(this);
        jTextField3.addKeyListener(this);
        jTextField4.addKeyListener(this);
        jTextField5.addKeyListener(this);
        jTextField6.addKeyListener(this);

        
        jTextField1.setActionCommand("1");
        jTextField2.setActionCommand("2");
        jTextField3.setActionCommand("3");
        jTextField4.setActionCommand("4");
        jTextField5.setActionCommand("5");
        jTextField6.setActionCommand("6");
        
		jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        JLabelS jLabel2 = new JLabelS("ama.lbl_Ajout",getControleur());
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();

        
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText(":");
        jLabel3.setText(":");
        jLabel4.setText(":");
        jLabel5.setText(":");
        jLabel7.setText(":");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int i = 2;
		System.out.print(((JTextField)arg0.getSource()).getText().length());
		if(arg0.getSource() == jTextField1)
		{
			if(jTextField1.getText().length() == i)
			{
				jTextField2.requestFocus();
			}
		}else if(arg0.getSource() == jTextField2)
		{
			if(jTextField2.getText().length() == i)
			{
				jTextField3.requestFocus();
			}
		}else if(arg0.getSource() == jTextField3)
		{
			if(jTextField3.getText().length() == i)
			{
				jTextField4.requestFocus();
			}
		}else if(arg0.getSource() == jTextField4)
		{
			if(jTextField4.getText().length() == i)
			{
				jTextField5.requestFocus();
			}
		}else if(arg0.getSource() == jTextField5)
		{
			if(jTextField5.getText().length() == i)
			{
				jTextField6.requestFocus();
			}
		}
		if(((JTextField)arg0.getSource()).getText().length() > 1)
		{
			((JTextField)arg0.getSource()).setText(((JTextField)arg0.getSource()).getText().substring(0, 1));
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public String getMacAddress()
	{
		String result = "";
		
		result += jTextField1.getText() + ":";
		result += jTextField2.getText() + ":";
		result += jTextField3.getText() + ":";
		result += jTextField4.getText() + ":";
		result += jTextField5.getText() + ":";
		result += jTextField6.getText();
		
		return result;
	}
}
