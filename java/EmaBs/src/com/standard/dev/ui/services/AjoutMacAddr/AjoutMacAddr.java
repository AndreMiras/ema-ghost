package com.standard.dev.ui.services.AjoutMacAddr;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.business.util.WOL;
import com.standard.dev.ressources.Fichier;
import com.standard.dev.ui.services.AjoutCombo.AcbEspace;
import com.standard.dev.ui.services.Chargement.ChrEspace;


public class  AjoutMacAddr extends Service implements ServiceInterface{
	/*
	 * Attributs
	 */
	private JFrameS frameSPere;
	private Service pere;
	/*
	 * Constructeur
	 */
	public AjoutMacAddr(Service pere, JFrameS frame) {
		super(null, frame);
		// TODO Auto-generated constructor stub
		init();
		this.pere = pere;
		this.pere.setJFrameSVisible(false);
		
		this.getJFrameS().setAlwaysOnTop(true);
		this.getJFrameS().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public AjoutMacAddr(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
		frameSPere = frame;		
		//this.setJFrameS(new JFrameS());
		//this.getJFrameS().setVisible(false);
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;
		this.setJFrameS(new JFrameS());
		this.getJFrameS().setControleur(this.getControler());
		this.getJFrameS().setVisible(true);
		this.getJFrameS().setErreur("");
		getJFrameS().setPnl_espace(new AmaEspace(getControler()));
		
		frameSPere.setEnabled(false);
		this.getJFrameS().setAlwaysOnTop(true);
		this.getJFrameS().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getJFrameS().pack();
		
		return result;
	}

	@Override
	public boolean decharger() {
		// TODO Auto-generated method stub
		boolean result = true;
		getJFrameS().dechargerPanel();
		return result;
	}

	@Override
	public AbstractMessage action(String e) {
		// TODO Auto-generated method stub
		AbstractMessage result = null;
		System.out.println(e);
		this.getJFrameS().setErreur("");		
		
		if(e.equals("btn_Apply"))
		{
			if(isvalid())
			{
				decharger();
				String addrMac = ((AmaEspace)this.getJFrameS().getPnl_espace()).getMacAddress();
				Fichier file = new Fichier("AddrMac.emabs");
				List<String> addr = file.getTexte();
				
				addr.add(addrMac);
				
				try {
					file.newTexte(addr);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				result = new MessageInterService(((MessageInterService)getAbstractMessage()).getnameSource(),"ama",3,null);
				this.frameSPere.setEnabled(true);
				this.getJFrameS().setVisible(false);
			}
		}	
		if(e.equals("btn_cancel"))
		{
			decharger();
			result = new MessageInterService(((MessageInterService)getAbstractMessage()).getnameSource(),"ama",3,null);
			this.frameSPere.setEnabled(true);
			this.getJFrameS().setVisible(false);
		}	
		return result;		
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		if(((AmaEspace)this.getJFrameS().getPnl_espace()).getMacAddress().length() != (17))
		{
			this.getJFrameS().setErreur("err.AddressMac");
			return false;
		}		
		this.getJFrameS().setErreur("");
		return true;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
		System.err.println("retour ama");
	}
}