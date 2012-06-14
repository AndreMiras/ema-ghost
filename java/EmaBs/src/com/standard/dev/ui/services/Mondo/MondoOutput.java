package com.standard.dev.ui.services.Mondo;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.ui.sequences.DeploiementSequence;
import com.standard.dev.ui.sequences.RestaurationSequence;
import com.standard.dev.ui.services.AjoutMacAddr.AmaEspace;

public class MondoOutput extends Service implements ServiceInterface{
	/*
	 * Attributs
	 */
	private JFrameS frameSPere;
	private Service pere;
	/*
	 * Constructeur
	 */
	public MondoOutput(Service pere, JFrameS frame) {
		super(null, frame);
		// TODO Auto-generated constructor stub
		init();
		this.pere = pere;
		this.pere.setJFrameSVisible(false);
		
		this.getJFrameS().setAlwaysOnTop(true);
		this.getJFrameS().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public MondoOutput(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
		frameSPere = frame;		
		this.setJFrameS(new JFrameS());
		this.getJFrameS().setVisible(false);
	}


	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		this.getJFrameS().setVisible(true);
		this.getJFrameS().setErreur("");
		getJFrameS().setPnl_espace(new MonEspace(getControler()));
		
		frameSPere.setEnabled(false);
		this.getJFrameS().setAlwaysOnTop(true);
//		this.getJFrameS().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
				//Recup @mac
				//String addrMAC = ((AmaEspace)this.getJFrameS().getPnl_espace()).getMacAddress();
				//Creer une sequence de restauration
			DeploiementSequence seq = new DeploiementSequence("00:24:21:03:28:cb");
				//Lance le job
				seq.launchJob();
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
		System.err.println("retour mon");
	}
}
