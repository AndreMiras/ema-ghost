package com.standard.dev.ui.services.Chargement;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JButtonS;
import com.standard.architecture.ui.navigation.JInterface_JFrameS_JPanelS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.navigation.JPanelS;

public class ChrEspace extends JPanelS implements JInterface_JFrameS_JPanelS , ActionListener{
	/*
	 * Attributs
	 */
	public javax.swing.JProgressBar jProgressBar1;
	boolean sens = true;
	public Timer timer;                        // for later start/stop actions
	public JTextArea infochargement;
	boolean prm = true;
	public JScrollPane scr;
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
/*		jProgressBar1 = new javax.swing.JProgressBar();
		timer = new Timer(30, this);
        jProgressBar1.setValue(0);
        this.setLayout(new GridLayout(3, 1));
        JLabelS text = new JLabelS("chr.chargement",getControleur());
        infochargement = new JLabel();
        infochargement.setText("Debut du traitement");
        add(text);
        add(jProgressBar1);
        add(infochargement);
  */      
		GridBagLayout g=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
        JPanel pnl_0 = new JPanel();
		JPanel pnl_1 = new JPanel();
		JPanel pnl_2 = new JPanel();
		scr = new JScrollPane();
		/****************************/
		this.setLayout(g);
		c.gridy=0;
		g.setConstraints(pnl_0,c);
		c.gridy=1;
		g.setConstraints(pnl_1,c);
		c.gridy=2;
//		g.setConstraints(pnl_2,c);
		g.setConstraints(scr,c);

		pnl_0.setOpaque(false);
		pnl_1.setOpaque(false);		
		pnl_2.setOpaque(false);

		add(pnl_0);
        add(pnl_1);
        add(scr);
		scr.setViewportView(pnl_2);
		
        JLabelS text = new JLabelS("chr.chargement",getControleur());
		jProgressBar1 = new javax.swing.JProgressBar();
		timer = new Timer(30, this);
        jProgressBar1.setValue(0);
        infochargement = new JTextArea();
        infochargement.setText("Debut du traitement");
        
        pnl_0.add(text);
        pnl_1.add(jProgressBar1);
        pnl_2.add(infochargement);

    	this.setPreferredSize(new Dimension(550,550));
		scr.setPreferredSize(new Dimension(400,400));
	}
	public void startAnimation(){
		timer.start();		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(prm)
		{
			ActionEvent e = new ActionEvent(this, 1, "chr.lance");
			prm = false;
			this.getControleur().actionPerformed(e);
		}
		if(sens)
	    {
			if(jProgressBar1.getValue() == 100)
			{
				jProgressBar1.setValue(0);
				//sens = false;
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
