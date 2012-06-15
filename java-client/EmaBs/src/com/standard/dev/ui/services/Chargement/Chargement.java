package com.standard.dev.ui.services.Chargement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.standard.architecture.ui.Controler;
import com.standard.architecture.ui.navigation.JButtonS;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.navigation.JLabelS;
import com.standard.architecture.ui.navigation.JPanelS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.ui.sequences.DeploiementSequence;
import com.standard.dev.ui.sequences.Sequence;

public class Chargement extends Service implements ServiceInterface {
	/*
	 * Attributs
	 */
	private JFrameS frameSPere;
	private Service pere;
	private Sequence uneSequence;
	private ChrEspace espaceChargement;
	/*
	 * Constructeur
	 */
	public Chargement(Service pere, JFrameS frame) {
		super(null, frame);
		// TODO Auto-generated constructor stub
		
		init();
		this.pere = pere;
		this.pere.setJFrameSVisible(false);
		
		this.getJFrameS().setMaximumSize(new Dimension(400,400));
		this.getJFrameS().setAlwaysOnTop(true);
		this.getJFrameS().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public Chargement(Controler controleur, JFrameS frame) {
		super(controleur, frame);
		// TODO Auto-generated constructor stub
		frameSPere = frame;		
		//this.setJFrameS(new JFrameS());
		this.setJFrameS(frame);
		//this.getJFrameS().setVisible(false);
	}
	/*
	 * Methodes
	 */

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		boolean result = true;

		this.setJFrameS(new JFrameS());
		this.getJFrameS().setControleur(this.getControler());
		this.getJFrameS().setVisible(true);
		
		espaceChargement = new ChrEspace(getControler());
			
		getJFrameS().setPnl_espace(espaceChargement);
		
		frameSPere.setEnabled(false);
		this.getJFrameS().setAlwaysOnTop(true);
//		this.getJFrameS().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getJFrameS().pack();
		((ChrEspace)getJFrameS().getPnl_espace()).startAnimation();
		List<Sequence> sequence = ((MessageInterService)this.getAbstractMessage()).getlistData();
		uneSequence = sequence.get(0);
//		uneSequence.lanceSequence(this,espaceChargement );
		return result;
	}

	@Override
	public boolean decharger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AbstractMessage action(String e) {
		// TODO Auto-generated method stub
		AbstractMessage result = null;
		System.out.println(e);
		this.getJFrameS().setErreur("");		
		
		if(e.equals("btn_Fermer"))
		{
			decharger();
			result = new MessageInterService("prc","chr",3,null);
			this.frameSPere.setEnabled(true);
			this.getJFrameS().setVisible(false);
		}
		if(e.equals("lance"))
		{
			uneSequence.lanceSequence(this,espaceChargement);
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
		uneSequence.lanceSequence(this,espaceChargement );
	}
	public void setTexte(String texteinfo)
	{
		espaceChargement.infochargement.setText(espaceChargement.infochargement.getText()+ "\n" + texteinfo) ;
		espaceChargement.scr.getVerticalScrollBar().setValue(espaceChargement.scr.getVerticalScrollBar().getMaximum());
	}
	public void afficheBoutonFermer()
	{
		JPanel pnl_titre = new JPanel();		
		JButtonS jButton1 = new JButtonS("chr.btn_Fermer",getControler());
		
		pnl_titre.add(jButton1);
		pnl_titre.setOpaque(false);
//        jButton1.setBorderPainted(false);
 //       jButton1.setBackground(Color.WHITE);
		this.getJFrameS().setPnl_titre(pnl_titre);
	}
}
