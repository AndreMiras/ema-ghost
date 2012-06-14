package com.standard.dev.ui.services.Chargement;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JInterface_JFrameS_JPanelS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.navigation.JPanelS;

public class ChrEspace extends JPanelS implements JInterface_JFrameS_JPanelS , ActionListener{
	/*
	 * Attributs
	 */
	javax.swing.JProgressBar jProgressBar1;
	boolean sens = true;
	public Timer timer;                        // for later start/stop actions
	/*
	 * Constructeur
	 */
	public ChrEspace(Controler controleur) {
		super(controleur,"chargement");
		// TODO Auto-generated constructor stub
	}
	/*
	 * Methodes
	 */
	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		jProgressBar1 = new javax.swing.JProgressBar();
		timer = new Timer(30, this);
        jProgressBar1.setValue(0);
        this.setLayout(new GridLayout(2, 1));
        JLabelS text = new JLabelS("chr.chargement",getControleur());
        add(text);
        add(jProgressBar1);
	}
	public void startAnimation(){
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(sens)
	    {
			if(jProgressBar1.getValue() == 100)
			{
				sens = false;
			}
			jProgressBar1.setValue(jProgressBar1.getValue()+1);
//			jProgressBar1.setForeground(jProgressBar1.getForeground().darker());
	    }
	    else
	    {
	    	if(jProgressBar1.getValue() == 0)
			{
				sens = true;
			}
			jProgressBar1.setValue(jProgressBar1.getValue()-1);
//			jProgressBar1.setBackground(jProgressBar1.getBackground().brighter());
	    }
	    repaint();
	}
}
