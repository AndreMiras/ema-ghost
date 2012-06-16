package com.standard.architecture.ui.service;

import java.awt.event.ActionListener;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JFrameS;


public abstract class Service{
	/*
	 * Attributs
	 */
	private Controler 	controleur;
	private JFrameS			frame;
	private AbstractMessage abstractMessage;
	/*
	 * Controleur
	 */
	public Service(Controler controleur, JFrameS frame)
	{
		this.controleur = controleur;
		this.frame		= frame;
		this.abstractMessage = null;
	}
	/*
	 * Methodes
	 */
	public Controler getControler()
	{
		return this.controleur;
	}
	public void setControler(Controler controleur)
	{
		this.controleur = controleur;
	}
	public JFrameS getJFrameS()
	{
		return this.frame;
	}
	public void setJFrameS(JFrameS frame)
	{
		this.frame = frame;
	}
	public void setJFrameSVisible(boolean b)
	{
		this.frame.setEnabled(b);
	}
	public void setAbstractMessage(AbstractMessage abstractMessage)
	{
		this.abstractMessage = abstractMessage;
		System.out.println("Source : "+ ((MessageInterService)this.abstractMessage).getnameSource());
		System.out.println("Cible  : "+ ((MessageInterService)this.abstractMessage).getnameCible());
	}
	public AbstractMessage getAbstractMessage()
	{
		return this.abstractMessage;
	}
}
