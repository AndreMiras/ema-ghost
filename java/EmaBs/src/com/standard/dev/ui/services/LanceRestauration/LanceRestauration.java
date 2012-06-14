package com.standard.dev.ui.services.LanceRestauration;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JButtonS;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.business.util.WOL;
import com.standard.dev.ui.sequences.DeploiementSequence;


public class LanceRestauration extends Service implements ServiceInterface{

	public LanceRestauration(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		JPanel pnl_titre = new JPanel();
		JButtonS jbutton = new JButtonS("lrs.btn_home", getControler());
		jbutton.setBorderPainted(false);
		jbutton.setBackground(Color.WHITE);
		pnl_titre.add(jbutton);
		pnl_titre.add(new JLabelS("lrs.Home",getControler()));
		getJFrameS().setPnl_titre(pnl_titre);
		getJFrameS().setPnl_espace(new LrsEspace(getControler()));
	
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
		
		if(e.equals("btn_home"))
		{
			decharger();
			result = new MessageInterService("prs","lrs",1,null);
		}
		if(e.equals("btn_cancel"))
		{
			decharger();
			result = new MessageInterService("prs","lrs",1,null);
		}
		if(e.equals("cmb1"))
		{
			if(((String)((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox1.getItemSelected()).equals(""))
			{
				((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2.setEnabled(false);
				((LrsEspace)this.getJFrameS().getPnl_espace()).jButton4.setEnabled(false);
				((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2.vide();
				
				ArrayList<String> e2 = new ArrayList<String>();
		        e2.add("");
		        ((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2.listToCombo(e2);
		    }else
			{
				((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2.setEnabled(true);
				((LrsEspace)this.getJFrameS().getPnl_espace()).jButton4.setEnabled(true);
				
				ArrayList<String> e2 = new ArrayList<String>();
		        e2.add("");
		        ((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2.listToCombo(e2);
		        ((LrsEspace)this.getJFrameS().getPnl_espace()).remplisCombosCours();
				
			}
		}
		if(e.equals("cmb2"))
		{

		}
		if(e.equals("btn_plus1"))
		{
			List<Object> message = new ArrayList<Object>();
			message.add(((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox1);
			result = new MessageInterService("acb","lrs",2,message);
		}
		if(e.equals("btn_plus2"))
		{
			List<Object> message = new ArrayList<Object>();
			message.add(((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2);
			result = new MessageInterService("acb","lrs",2,message);
		}
		if(e.equals("btn_plus3"))
		{
			List<Object> message = new ArrayList<Object>();
			message.add(((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox3);
			result = new MessageInterService("acb","lrs",2,message);
		}
		if(e.equals("btn_Apply"))
		{
			if(isvalid())
			{
				List<DeploiementSequence> sequence = new ArrayList<DeploiementSequence>();
				DeploiementSequence unDeploiementSequence = new DeploiementSequence();

				unDeploiementSequence.setCours(((LrsEspace)this.getJFrameS().getPnl_espace()).getCours());
				unDeploiementSequence.setPromo(((LrsEspace)this.getJFrameS().getPnl_espace()).getPromo());
				unDeploiementSequence.setDistribution(((LrsEspace)this.getJFrameS().getPnl_espace()).getIso());
				
				sequence.add(unDeploiementSequence);
				decharger();
				result = new MessageInterService("lar","lrs",1,sequence);
			}
		}
		
		return result;		
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		if(((String)((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox1.getItemSelected()).equals(""))
		{
			this.getJFrameS().setErreur("err.cmbPromoUnselected");
			return false;
		}
		if(((String)((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox2.getItemSelected()).equals(""))
		{
			this.getJFrameS().setErreur("err.cmbCoursUnselected");
			return false;	
		}
		if(((String)((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox3.getItemSelected()).equals(""))
		{
			this.getJFrameS().setErreur("err.cmbIsoUnselected");
			return false;	
		}
		return true;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
		System.err.println("retour lrs");
	}
}