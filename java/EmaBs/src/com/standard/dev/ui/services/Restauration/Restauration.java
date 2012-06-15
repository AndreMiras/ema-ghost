package com.standard.dev.ui.services.Restauration;

import java.awt.Color;
import java.awt.event.ActionListener;
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
import com.standard.dev.ui.sequences.RestaurationSequence;


public class Restauration extends Service implements ServiceInterface{

	public Restauration(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		JPanel pnl_titre = new JPanel();
		JButtonS jbutton = new JButtonS("rst.btn_home", getControler());
		jbutton.setBorderPainted(false);
		jbutton.setBackground(Color.WHITE);
		pnl_titre.add(jbutton);
		pnl_titre.add(new JLabelS("rst.titre",getControler()));
		getJFrameS().setPnl_titre(pnl_titre);
		getJFrameS().setPnl_espace(new RstEspace(getControler()));
	
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
			result = new MessageInterService("prc","svg",1,null);
		}
		if(e.equals("btn_Apply"))
		{
			if(isvalid())
			{
				if(JOptionPane.showConfirmDialog(getJFrameS(), "Voulez-vous continuer ?", "Apply",JOptionPane.YES_NO_OPTION) == 0 )
				{
					List<RestaurationSequence> sequence = new ArrayList<RestaurationSequence>();
					RestaurationSequence uneRestaurationSequence  = new RestaurationSequence();
	
					uneRestaurationSequence.setCours(((RstEspace)this.getJFrameS().getPnl_espace()).getCours());
					uneRestaurationSequence.setDistribution(((RstEspace)this.getJFrameS().getPnl_espace()).getDistribution());
					uneRestaurationSequence.setNom(((RstEspace)this.getJFrameS().getPnl_espace()).getNom());
					uneRestaurationSequence.setPromotion(((RstEspace)this.getJFrameS().getPnl_espace()).getPromotion());
					uneRestaurationSequence.setSauvegarde(((RstEspace)this.getJFrameS().getPnl_espace()).getSauvegarde());
					uneRestaurationSequence.setPartage(this.getControler().getConfiguration().getChemin_dossier_partage());
					
					sequence.add(uneRestaurationSequence);
					decharger();
					result = new MessageInterService("chr","prc",1,sequence);
				}
			}
		}
		if(e.equals("cmb_promotion"))
		{
			if(((RstEspace)this.getJFrameS().getPnl_espace()).getPromotion().equals(""))
			{
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.vide();		
				ArrayList<String> e2 = new ArrayList<String>();
		        e2.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox2.listToCombo(e2);
		        
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.vide();		
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.listToCombo(e3);

		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.vide();			
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		    }else
			{
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox2.setEnabled(true);
				
				ArrayList<String> e2 = new ArrayList<String>();
		        e2.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.listToCombo(e3);
		        ((RstEspace)this.getJFrameS().getPnl_espace()).remplisCombosCours();
				
			}
		}
		if(e.equals("cmb_cours"))
		{
			if(((RstEspace)this.getJFrameS().getPnl_espace()).getCours().equals(""))
			{
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.vide();		
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e3);

		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.vide();			
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		    }else
			{
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(true);
				
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox3.listToCombo(e3);
		        ((RstEspace)this.getJFrameS().getPnl_espace()).remplisCombosDistribution();				
			}
		}
		if(e.equals("cmb_distribution"))
		{
			if(((RstEspace)this.getJFrameS().getPnl_espace()).getDistribution().equals(""))
			{		    
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.vide();		
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		    }else
			{
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(true);
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		        ((RstEspace)this.getJFrameS().getPnl_espace()).remplisCombosNom();				
			}
		}
		if(e.equals("cmb_Nom"))
		{
			if(((RstEspace)this.getJFrameS().getPnl_espace()).getDistribution().equals(""))
			{		    
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox5.setEnabled(false);
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox5.vide();		
				ArrayList<String> e5 = new ArrayList<String>();
		        e5.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox5.listToCombo(e5);
		    }else
			{
				((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox5.setEnabled(true);
				ArrayList<String> e5 = new ArrayList<String>();
		        e5.add("");
		        ((RstEspace)this.getJFrameS().getPnl_espace()).jComboBox5.listToCombo(e5);
		        ((RstEspace)this.getJFrameS().getPnl_espace()).remplisCombosSauvegarde();				
			}
		}		
		if(e.equals("btn_cancel"))
		{
			decharger();
			result = new MessageInterService("prc","svg",1,null);
		}
		return result;					
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		if(((RstEspace)this.getJFrameS().getPnl_espace()).getPromotion().equals(""))
		{
			this.getJFrameS().setErreur("err.promotionUnselected");
			return false;
		}
		if(((RstEspace)this.getJFrameS().getPnl_espace()).getCours().equals(""))
		{
			this.getJFrameS().setErreur("err.CoursUnselected");
			return false;
		}
		if(((RstEspace)this.getJFrameS().getPnl_espace()).getDistribution().equals(""))
		{
			this.getJFrameS().setErreur("err.DistributionUnselected");
			return false;
		}
		if(((RstEspace)this.getJFrameS().getPnl_espace()).getNom().equals(""))
		{
			this.getJFrameS().setErreur("err.NomUnselected");
			return false;
		}
		if(((RstEspace)this.getJFrameS().getPnl_espace()).getSauvegarde().equals(""))
		{
			this.getJFrameS().setErreur("err.SaveUnselected");
			return false;
		}
		return true;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
	}
}