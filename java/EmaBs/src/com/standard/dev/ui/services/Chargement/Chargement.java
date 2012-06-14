package com.standard.dev.ui.services.Chargement;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;

public class Chargement extends Service implements ServiceInterface {
	/*
	 * Attributs
	 */
	private JFrameS frameSPere;
	private Service pere;
	/*
	 * Constructeur
	 */
	public Chargement(Service pere, JFrameS frame) {
		super(null, frame);
		// TODO Auto-generated constructor stub
		init();
		this.pere = pere;
		this.pere.setJFrameSVisible(false);
		
		this.getJFrameS().setAlwaysOnTop(true);
		this.getJFrameS().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public Chargement(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
		frameSPere = frame;		
		this.setJFrameS(new JFrameS());
		this.getJFrameS().setVisible(false);
	}
	/*
	 * Methodes
	 */

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
boolean result = true;
		
		this.getJFrameS().setVisible(true);
	
		getJFrameS().setPnl_espace(new ChrEspace(getControler()));
		
		frameSPere.setEnabled(false);
		this.getJFrameS().setAlwaysOnTop(true);
//		this.getJFrameS().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getJFrameS().pack();
		((ChrEspace)getJFrameS().getPnl_espace()).startAnimation();
		return result;
	}

	@Override
	public boolean decharger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AbstractMessage action(String e) {
		// TODO Auto-generated method stub
		AbstractMessage result = null;
		System.out.println(e);
		this.getJFrameS().setErreur("");		
		
/*		if(e.equals("btn_annuler"))
		{
			decharger();
			result = new MessageInterService(((MessageInterService)getAbstractMessage()).getnameSource(),"sle",3,null);
			this.frameSPere.setEnabled(true);
			this.getJFrameS().setVisible(false);
		}
*/		return result;
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
		
	}
}
