package com.standard.dev.ui.services.Mondo;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JButtonS;
import com.standard.architecture.ui.navigation.JInterface_JFrameS_JPanelS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.navigation.JPanelS;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;


public class MonEspace extends JPanelS implements JInterface_JFrameS_JPanelS, KeyListener {
	private JTextField tfieldMontfieldconsole;
	/*
	 * Constructeur
	 */
	public MonEspace(Controler controleur)
	{
		super(controleur,"Mondo");
	}
	@Override
	public void init() {
        JLabelS lblsMonlbmaintitle = new JLabelS("mon.lbl_MainTitle",getControleur());        
        JLabelS lblsMonlbliptitle = new JLabelS("mon.lbl_IpTitle",getControleur());        
        JLabelS lblsMonlblmactitle = new JLabelS("mon.lbl_MacTitle",getControleur());
        JLabelS lblsMonlbldistribtitle = new JLabelS("mon.lbl_DistribTitle",getControleur());
        
        JLabel lblsMonlblmacvalue = new JLabel("");
        lblsMonlblmacvalue.setFont(new Font("Dialog", Font.PLAIN, 12));
        JLabel lblsMonlblipvalue = new JLabel("");
        lblsMonlblipvalue.setFont(new Font("Dialog", Font.PLAIN, 12));
        JLabel lblsMonlbldistribvalue = new JLabel("");
        lblsMonlbldistribvalue.setFont(new Font("Dialog", Font.PLAIN, 12));
        
        tfieldMontfieldconsole = new JTextField();
        tfieldMontfieldconsole.setForeground(Color.GREEN);
        tfieldMontfieldconsole.setFont(new Font("Dialog", Font.PLAIN, 12));
        tfieldMontfieldconsole.setEditable(false);
        tfieldMontfieldconsole.setBackground(Color.BLACK);
        tfieldMontfieldconsole.setColumns(10);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(tfieldMontfieldconsole, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblsMonlbmaintitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(16)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblsMonlblmactitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lblsMonlblmacvalue, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        									.addGap(1))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblsMonlbliptitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(lblsMonlblipvalue, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        									.addGap(2)))))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblsMonlbldistribtitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        					.addGap(6)
        					.addComponent(lblsMonlbldistribvalue, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblsMonlbmaintitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblsMonlbldistribtitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblsMonlbldistribvalue, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblsMonlblipvalue, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblsMonlbliptitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblsMonlblmactitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblsMonlblmacvalue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tfieldMontfieldconsole, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        			.addContainerGap())
        );
        this.setLayout(layout);
	}
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int i = 1;
		System.out.print(((JTextField)arg0.getSource()).getText().length());
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
}

