package com.standard.dev.ui.services.Sauvegarde;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.*;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.ui.sequences.CreateSaveCompletSequence;
import com.standard.dev.ui.sequences.CreateSaveDiffSequence;
import com.standard.dev.ui.services.LanceRestauration.LrsEspace;
import com.standard.dev.ui.services.Restauration.RstEspace;

public class Sauvegarde  extends Service implements ServiceInterface{
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	public Sauvegarde(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		JPanel pnl_titre = new JPanel();
		JButtonS jbutton = new JButtonS("svg.btn_home", getControler());
		jbutton.setBorderPainted(false);
		jbutton.setBackground(Color.WHITE);
		
		pnl_titre.add(jbutton);
		pnl_titre.add(new JLabelS("svg.titre",getControler()));		
		getJFrameS().setPnl_titre(pnl_titre);
		getJFrameS().setPnl_espace(new SvgEspace(getControler()));
	
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
					List<CreateSaveDiffSequence> sequence = new ArrayList<CreateSaveDiffSequence>();
					CreateSaveDiffSequence uneCreateSaveDiffSequence = new CreateSaveDiffSequence();

					uneCreateSaveDiffSequence.setCours(((SvgEspace)this.getJFrameS().getPnl_espace()).getCours());
					uneCreateSaveDiffSequence.setDistribution(((SvgEspace)this.getJFrameS().getPnl_espace()).getDistribution());
					uneCreateSaveDiffSequence.setNom(((SvgEspace)this.getJFrameS().getPnl_espace()).getNom());
					uneCreateSaveDiffSequence.setPromotion(((SvgEspace)this.getJFrameS().getPnl_espace()).getPromotion());
					uneCreateSaveDiffSequence.setPartage(this.getControler().getConfiguration().getChemin_dossier_partage());
					
					//uneCreateSaveDiffSequence.lanceDeploiement();
					sequence.add(uneCreateSaveDiffSequence);
					decharger();
					result = new MessageInterService("chr","svg",1,sequence);
				}
			}
		}
		if(e.equals("btn_cancel"))
		{
			decharger();
			result = new MessageInterService("prc","svg",1,null);
		}
		if(e.equals("cmb_promo"))
		{
			if(((SvgEspace)this.getJFrameS().getPnl_espace()).getPromotion().equals(""))
			{
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.vide();		
				ArrayList<String> e2 = new ArrayList<String>();
		        e2.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox2.listToCombo(e2);
		        
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.vide();		
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.listToCombo(e3);

		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(false);
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.vide();
				((SvgEspace)this.getJFrameS().getPnl_espace()).jButton6.setEnabled(false);				
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		    }else
			{
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox2.setEnabled(true);
				
				ArrayList<String> e2 = new ArrayList<String>();
		        e2.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.listToCombo(e3);
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).remplisCombosCours();
				
			}
		}
		if(e.equals("cmb_cours"))
		{
			if(((SvgEspace)this.getJFrameS().getPnl_espace()).getCours().equals(""))
			{
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(false);
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.vide();		
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e3);

		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(false);
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.vide();
				((SvgEspace)this.getJFrameS().getPnl_espace()).jButton6.setEnabled(false);				
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		    }else
			{
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.setEnabled(true);
				
				ArrayList<String> e3 = new ArrayList<String>();
		        e3.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox3.listToCombo(e3);
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).remplisCombosDistribution();				
			}
		}
		if(e.equals("cmb_iso"))
		{
			if(((SvgEspace)this.getJFrameS().getPnl_espace()).getDistribution().equals(""))
			{		    
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(false);
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.vide();
				((SvgEspace)this.getJFrameS().getPnl_espace()).jButton6.setEnabled(false);				
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		    }else
			{
				((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.setEnabled(true);	
				((SvgEspace)this.getJFrameS().getPnl_espace()).jButton6.setEnabled(true);	
				ArrayList<String> e4 = new ArrayList<String>();
		        e4.add("");
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4.listToCombo(e4);
		        ((SvgEspace)this.getJFrameS().getPnl_espace()).remplisCombosNom();				
			}
		}
		if(e.equals("btn_plus"))
		{
			List<Object> message = new ArrayList<Object>();
			message.add(((SvgEspace)this.getJFrameS().getPnl_espace()).jComboBox4);
			result = new MessageInterService("acb","svg",2,message);
		}
		return result;					
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
		if(((SvgEspace)this.getJFrameS().getPnl_espace()).getPromotion().equals(""))
		{
			this.getJFrameS().setErreur("err.promotionUnselected");
			return false;
		}
		if(((SvgEspace)this.getJFrameS().getPnl_espace()).getCours().equals(""))
		{
			this.getJFrameS().setErreur("err.CoursUnselected");
			return false;
		}
		if(((SvgEspace)this.getJFrameS().getPnl_espace()).getDistribution().equals(""))
		{
			this.getJFrameS().setErreur("err.DistributionUnselected");
			return false;
		}
		if(((SvgEspace)this.getJFrameS().getPnl_espace()).getNom().equals(""))
		{
			this.getJFrameS().setErreur("err.NomUnselected");
			return false;
		}
		return true;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
	}
}
