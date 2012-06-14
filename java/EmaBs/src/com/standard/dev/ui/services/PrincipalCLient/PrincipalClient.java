package com.standard.dev.ui.services.PrincipalCLient;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.business.util.WOL;


public class PrincipalClient extends Service implements ServiceInterface{

	public PrincipalClient(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		JPanel pnl_titre = new JPanel();
		pnl_titre.add(new JLabelS("prc.Home",getControler()));
		getJFrameS().setPnl_titre(pnl_titre);
		getJFrameS().setPnl_espace(new PrcEspace(getControler()));
	
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
		
		if(e.equals("btn_sauvegarde"))
		{
			decharger();
			result = new MessageInterService("svg","prc",1,null);
		}			
		if(e.equals("btn_restauration"))
		{
//			WOL ooo = new WOL();
//			ooo.starWolByFile();
			decharger();
			result = new MessageInterService("rst","prc",1,null);
		}
		return result;		
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
		System.err.println("retour prc");
	}
}