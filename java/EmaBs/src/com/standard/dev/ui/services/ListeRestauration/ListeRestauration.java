package com.standard.dev.ui.services.ListeRestauration;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
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
import com.standard.dev.ressources.Fichier;
import com.standard.dev.ui.sequences.DeploiementSequence;


public class ListeRestauration extends Service implements ServiceInterface{
	DeploiementSequence unDeploiementSequence;
	public ListeRestauration(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;
		
		List<DeploiementSequence> sequence = ((MessageInterService)this.getAbstractMessage()).getlistData();
		unDeploiementSequence = sequence.get(0);

		JPanel pnl_titre = new JPanel();
		JButtonS jbutton = new JButtonS("lar.btn_home", getControler());
		jbutton.setBorderPainted(false);
		jbutton.setBackground(Color.WHITE);
		pnl_titre.add(jbutton);
		pnl_titre.add(new JLabelS("lar.Home",getControler()));
		getJFrameS().setPnl_titre(pnl_titre);
		getJFrameS().setPnl_espace(new LarEspace(getControler()));
	
		getJFrameS().pack();
		chargeList();
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
			result = new MessageInterService("prs","lar",1,null);
		}
		if(e.equals("btn_cancel"))
		{
			decharger();
			result = new MessageInterService("prs","lar",1,null);
		}
		if(e.equals("btn_Apply"))
		{
			if(isvalid())
			{
				if(JOptionPane.showConfirmDialog(getJFrameS(), "Voulez-vous le deploiement ?", "Apply",JOptionPane.YES_NO_OPTION) == 0 )
				{
					
					Fichier file = new Fichier("AddrMac.emabs");
					List addr = ((LarEspace)this.getJFrameS().getPnl_espace()).getList().getSelectedList();
	
					unDeploiementSequence.setList_addr_mac(addr);
					unDeploiementSequence.setAddrDiffusion(file.getTexte().get(0));
	
					System.out.println(unDeploiementSequence);
//					sequence.add(unDeploiementSequence);
					decharger();
					List<DeploiementSequence> sequence = new ArrayList<DeploiementSequence>();
					sequence.add(unDeploiementSequence);
					result = new MessageInterService("mon","lar",1,sequence);
				}
			}
		}
		if(e.equals("btn_plus1"))//add
		{
			result = new MessageInterService("ama","lar",1,null);
		}
		if(e.equals("btn_plus2"))//supp
		{
			if(((LarEspace)this.getJFrameS().getPnl_espace()).getList().getList().size() != 0)
			{
				if(((LarEspace)this.getJFrameS().getPnl_espace()).getList().getSelectedIndex() != -1)
				{
					if(JOptionPane.showConfirmDialog(getJFrameS(), "Voulez-vous supprimer les elements selectionnes ?", "Apply",JOptionPane.YES_NO_OPTION) == 0 )
					{
						((LarEspace)this.getJFrameS().getPnl_espace()).getList().removeALLSelected();
						
						Fichier file = new Fichier("AddrMac.emabs");
						List addr = ((LarEspace)this.getJFrameS().getPnl_espace()).getList().getList();
						
						try {
							file.newTexte(file.getTexte().get(0), addr);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else
				{
					this.getJFrameS().setErreur("err.ListunSelect");					
				}
			}else
			{
				this.getJFrameS().setErreur("err.ListNone");
			}
		}
		return result;		
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		int[] test = ((LarEspace)this.getJFrameS().getPnl_espace()).getList().getSelectedIndices();
		if(((LarEspace)this.getJFrameS().getPnl_espace()).getList().getSelectedIndices().length == 0)
		{
			this.getJFrameS().setErreur("err.listAddrMacunSelected");
			return false;
		}
		return true;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
		System.err.println("retour lar");
		chargeList();
		
	}
	public void chargeList()
	{
		((LarEspace)this.getJFrameS().getPnl_espace()).getList().vide();
		List<String> listMac = new Fichier("AddrMac.emabs").getTexte();
		for(int i = 1 ; i < listMac.size() ; i++)
		{
			((LarEspace)this.getJFrameS().getPnl_espace()).getList().addToList((listMac.get(i)));
		}
		
	}
}