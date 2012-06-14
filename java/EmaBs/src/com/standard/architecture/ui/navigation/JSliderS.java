package com.standard.architecture.ui.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.standard.architecture.business.util.properties.Ressource;
import com.standard.architecture.ui.Controler;

public class JSliderS extends JSlider implements ChangeListener{
	
	private Controler controleur;
	
	public JSliderS(String name , Controler controleur)
	{
		super();
		this.controleur = controleur;
		this.setName(name);
		this.setMinimum(0);
		this.setMaximum(100);
		this.addChangeListener(this);
	}
	public void stateChanged(ChangeEvent e) {
	    ActionEvent action = new ActionEvent(this, -1, this.getName());
	    controleur.actionPerformed(action);
	}
}
