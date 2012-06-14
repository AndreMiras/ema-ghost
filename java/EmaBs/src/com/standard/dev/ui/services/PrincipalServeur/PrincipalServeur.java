package com.standard.dev.ui.services.PrincipalServeur;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JButtonS;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.navigation.JListS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.business.util.WOL;


public class PrincipalServeur extends Service implements ServiceInterface{

	public PrincipalServeur(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		JPanel pnl_titre = new JPanel();
		
		JButtonS jButton1 = new JButtonS("prs.btn_FR",getControler());
		JButtonS jButton2 = new JButtonS("prs.btn_EN",getControler());

		jButton1.setBorderPainted(false);
        jButton1.setBackground(Color.WHITE);
		jButton2.setBorderPainted(false);
        jButton2.setBackground(Color.WHITE);
        
        pnl_titre.add(new JLabelS("prs.Home",getControler()));
        pnl_titre.add(jButton1);
        pnl_titre.add(jButton2);
		
		getJFrameS().setPnl_titre(pnl_titre);		
		getJFrameS().setPnl_espace(new PrsEspace(getControler()));
	
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
			result = new MessageInterService("csv","prs",1,null);
		}			
		if(e.equals("btn_restauration"))
		{
			decharger();
			result = new MessageInterService("lrs","prs",1,null);
		}
		if(e.equals("btn_FR"))
		{
			this.getControler().getConfiguration().setLang("FR");
			result = new MessageInterService("prs","prs",1,null);
		}
		if(e.equals("btn_EN"))
		{
			this.getControler().getConfiguration().setLang("EN");
			result = new MessageInterService("prs","prs",1,null);
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
		System.err.println("retour prs");
	}
}