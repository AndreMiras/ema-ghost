package com.standard.dev.ui.services.ListeRestauration;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;


public class LarEspace extends JPanelS implements JInterface_JFrameS_JPanelS, ActionListener {
	/*
	 * Attributs
	 */
	JCheckBoxS jCheckBox1;
	JPanel jPanel1;
	javax.swing.JScrollPane jScrollPane1;
	JListS jList1;
	/*
	 * Constructeur
	 */
	public LarEspace(Controler controleur)
	{
		super(controleur,"ListeAddresseMac");
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub

		JButtonS jButton1 = new JButtonS("lar.btn_Apply",getControleur());
		JButtonS jButton2 = new JButtonS("lar.btn_cancel",getControleur());
		JButtonS jButton3 = new JButtonS("lar.btn_plus1",getControleur());
		JButtonS jButton4 = new JButtonS("lar.btn_plus2",getControleur());
		
		jList1 = new JListS("lar.listMac", getControleur());
		jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);
		jButton3.setBorderPainted(false);
        jButton3.setBackground(Color.WHITE);
        jButton4.setBorderPainted(false);
        jButton4.setBackground(Color.WHITE);

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jCheckBox1 = new JCheckBoxS("lar.tous",getControleur());
        jCheckBox1.addActionListener(this);
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
	public JListS getList()
	{
		JListS  result = jList1;
		return result;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(jCheckBox1.isSelected())
		{
			getList().selectAll();
		}
		else
		{
			getList().unselectAll();
		}
	}
}
