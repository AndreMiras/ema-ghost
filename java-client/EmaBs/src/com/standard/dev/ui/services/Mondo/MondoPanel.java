package com.standard.dev.ui.services.Mondo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

import com.standard.dev.business.util.RestaurationJob;
import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JLabelS;

public class MondoPanel extends JPanel {
	/** Dynamic graphic element **/
	private JTextField fieldConsole;
	private JLabel labelIp;
	private JLabel labelMac;
	private JLabel labelDistro;
	/** Controler for jlabels **/
	Controler controler;
	
	/*
	 * Constructeur
	 */
	public MondoPanel(Controler controler)
	{
		super();
		this.controler = controler;
		init();
	}

	public void init() {
        JLabelS lblsMonlbmaintitle = new JLabelS("mon.lbl_MainTitle",controler);        
        JLabelS lblsMonlbliptitle = new JLabelS("mon.lbl_IpTitle",controler);        
        JLabelS lblsMonlblmactitle = new JLabelS("mon.lbl_MacTitle",controler);
        JLabelS lblsMonlbldistribtitle = new JLabelS("mon.lbl_DistribTitle",controler);
        
        labelMac = new JLabel("");
        labelMac.setFont(new Font("Dialog", Font.PLAIN, 12));
        labelIp = new JLabel("");
        labelIp.setFont(new Font("Dialog", Font.PLAIN, 12));
        labelDistro = new JLabel("");
        labelDistro.setFont(new Font("Dialog", Font.PLAIN, 12));
        
        fieldConsole = new JTextField();
        fieldConsole.setForeground(Color.GREEN);
        fieldConsole.setFont(new Font("Dialog", Font.PLAIN, 12));
        fieldConsole.setEditable(false);
        fieldConsole.setBackground(Color.BLACK);
        fieldConsole.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(fieldConsole, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblsMonlbmaintitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(16)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblsMonlblmactitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(labelMac, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        									.addGap(1))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblsMonlbliptitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(labelIp, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        									.addGap(2)))))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblsMonlbldistribtitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        					.addGap(6)
        					.addComponent(labelDistro, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblsMonlbmaintitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblsMonlbldistribtitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelDistro, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelIp, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblsMonlbliptitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblsMonlblmactitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelMac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(fieldConsole, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        			.addContainerGap())
        );
        this.setLayout(layout);
	}

	public JTextField getFieldConsole() {
		return fieldConsole;
	}

	public JLabel getLabelIp() {
		return labelIp;
	}

	public JLabel getLabelMac() {
		return labelMac;
	}

	public JLabel getLabelDistro() {
		return labelDistro;
	}

}
