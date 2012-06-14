package com.standard.dev.ui.services.Mondo;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.standard.dev.business.util.RestaurationJob;
import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.Service;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.dev.ui.sequences.DeploiementSequence;
import com.standard.dev.ui.Controler;
import com.standard.dev.business.util.WOL;


public class MondoOutput extends Service implements ServiceInterface{
	/** Attributs guillaume **/
	private JFrameS frameSPere;
	private Service pere;
	/** Graphic elements **/
	private MonEspace espaceMain;
	private JTabbedPane tabbedPaneMain;
	/** Sequence de deploiement **/
	private DeploiementSequence sequence;
	
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
		boolean result = true;
		JFrameS jFrameS = getJFrameS();
		jFrameS.setVisible(true);
		jFrameS.setErreur("");
		
		//Recuperation de la sequence
		List<DeploiementSequence> seq = ((MessageInterService)this.getAbstractMessage()).getlistData();
		sequence = seq.get(0);
		//Initialisation de l'espace principal
		espaceMain = new MonEspace(getControler());
		jFrameS.setPnl_espace(espaceMain);
		//Recuperation du tabbedpane
		tabbedPaneMain = espaceMain.getTabbedPaneMain();
		//Lancement de la creation des differents onglets
		createJobs();
		
		//Parametres de la fenetre
		frameSPere.setEnabled(false);
		jFrameS.setAlwaysOnTop(true);
		jFrameS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jFrameS.pack();
		
		return result;
	}
	
	public void createJobs(){
		List<String> macs = sequence.getList_addr_mac();
		WOL wol = new WOL();
		for(int i=0; i<macs.size(); i++){
			//Recup @mac et reveil de la machine
			String mac = macs.get(i);
			//wol.startWol("", mac);
			//Creation d'un panel pour le job, et ajout aux onglets
			MondoPanel panel = new MondoPanel(getControler());
			tabbedPaneMain.add(mac,panel);
			//Creation d'un job
			RestaurationJob job = new RestaurationJob(sequence,panel,mac);
		}
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
		System.err.println("retour mon");
	}
}
