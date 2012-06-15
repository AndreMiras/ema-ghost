package com.standard.dev.ui.services.CreateSauvegarde;

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
import com.standard.dev.ui.sequences.CreateSaveCompletSequence;


public class CreateSauvegarde extends Service implements ServiceInterface{

	public CreateSauvegarde(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		JPanel pnl_titre = new JPanel();
		JButtonS jbutton = new JButtonS("csv.btn_home", getControler());
		jbutton.setBorderPainted(false);
		jbutton.setBackground(Color.WHITE);
		pnl_titre.add(jbutton);
		pnl_titre.add(new JLabelS("csv.Home",getControler()));
		getJFrameS().setPnl_titre(pnl_titre);
		getJFrameS().setPnl_espace(new CsvEspace(getControler()));
	
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
			result = new MessageInterService("prs","csv",1,null);
		}
		if(e.equals("btn_cancel"))
		{
			decharger();
			result = new MessageInterService("prs","csv",1,null);
		}
		if(e.equals("btn_Apply"))
		{
			if(isvalid())
			{
				List<CreateSaveCompletSequence> sequence = new ArrayList<CreateSaveCompletSequence>();
				CreateSaveCompletSequence uneCreateSaveCompletSequence = new CreateSaveCompletSequence();

				sequence.add(uneCreateSaveCompletSequence);
				decharger();
				result = new MessageInterService("","csv",1,sequence);
			}
		}
		
		return result;		
	}

	@Override
	public boolean isvalid() {
		// TODO Auto-generated method stub
/*		if(((String)((LrsEspace)this.getJFrameS().getPnl_espace()).jComboBox1.getItemSelected()).equals(""))
		{
			this.getJFrameS().setErreur("err.cmbPromoUnselected");
			return false;
		}
*/		return true;
	}

	@Override
	public void mise_a_jour_fils() {
		// TODO Auto-generated method stub
		System.err.println("retour csv");
	}
}