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

					uneCreateSaveDiffSequence.setCours(((RstEspace)this.getJFrameS().getPnl_espace()).getCours());
					uneCreateSaveDiffSequence.setDistribution(((RstEspace)this.getJFrameS().getPnl_espace()).getDistribution());
					uneCreateSaveDiffSequence.setNom(((RstEspace)this.getJFrameS().getPnl_espace()).getNom());
					uneCreateSaveDiffSequence.setPromotion(((RstEspace)this.getJFrameS().getPnl_espace()).getPromotion());
					
					sequence.add(uneCreateSaveDiffSequence);
					decharger();
					result = new MessageInterService("chr","prc",1,sequence);
				}
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
