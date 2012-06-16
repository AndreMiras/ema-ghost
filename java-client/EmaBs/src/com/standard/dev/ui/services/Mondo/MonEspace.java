package com.standard.dev.ui.services.Mondo;

import javax.swing.JTabbedPane;
import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JInterface_JFrameS_JPanelS;
import com.standard.architecture.ui.navigation.JPanelS;


public class MonEspace extends JPanelS implements JInterface_JFrameS_JPanelS {
	private JTabbedPane tabbedPaneMain;
	
	/*
	 * Constructeur
	 */
	public MonEspace(Controler controleur)
	{
		super(controleur,"Mondo");
	}
	
	@Override
	public void init() {
		tabbedPaneMain = new javax.swing.JTabbedPane();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
	}
	
	@Override
	public void maj() {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Getters
	 */
	public JTabbedPane getTabbedPaneMain() {
		return tabbedPaneMain;
	}
}

