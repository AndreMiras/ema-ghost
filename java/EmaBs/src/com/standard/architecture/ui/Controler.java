package com.standard.architecture.ui;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.standard.architecture.ui.navigation.JFrameS;
import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageErreur;
import com.standard.architecture.ui.service.MessageInterService;
import com.standard.architecture.ui.service.ServiceInterface;
import com.standard.architecture.ui.service.Service;
import com.standard.dev.ui.ConfigurationSetting;

public abstract class Controler implements ActionListener, Controler_Interface{
	/*
	 * Attributs
	 */
	private String 		current_Service_name;
	private String		pere_Service_name; 
	private Hashtable  	htable;
	protected JFrameS	frame;
	private ConfigurationSetting config;
	/*
	 * Constructeur
	 */
	public Controler(JFrameS frame,String Service_principale)
	{
		this.frame = frame;
		config = new ConfigurationSetting();
		frame.setControleur(this);
		this.current_Service_name = Service_principale;
		this.pere_Service_name = "";
		setHtable(new Hashtable());
		chargerService();
		charger( new  MessageInterService(this.current_Service_name));
	}
	/*
	 * Méthodes
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean sortie = false;
		AbstractMessage result;
		/*si l'évenement n'est pas du Service courrant*/
		if(!current_Service_name.equals(e.getActionCommand().substring(0,3)))
		{	
			if(decharger())
			{
				result = new  MessageInterService(e.getActionCommand().substring(0,3));
				if(charger(result))
				{
					pere_Service_name	= current_Service_name;
					current_Service_name = e.getActionCommand().substring(0,3);			
				}
				else
				{
					traitementErreur((MessageErreur) ((Service) this.htable.get(e.getActionCommand().substring(0,3))).getAbstractMessage());
					sortie = true;
				}
			}
			else
			{
				traitementErreur((MessageErreur) ((Service) this.htable.get(e.getActionCommand().substring(0,3))).getAbstractMessage());
				sortie = true;
			}
		}		
		/* Si l'évenement est du Service courant ou si on a changer de modul*/
		if(!sortie)
		{
			/* on redirige le message vers le Service concerné et on récupere l'abstracMessage de l'action*/
			result = ((ServiceInterface) this.htable.get(current_Service_name)).action(e.getActionCommand().substring(4));
			/*
			 * result va permettre de savoir si l'action neccessite un changement de page
			 */
			if(result != null)
			{
				if(result instanceof MessageErreur)
				{
					//traitement de l'erreur
					traitementErreur((MessageErreur) result);
				}
				if(result instanceof MessageInterService) 
				{
					switch(((MessageInterService)result).gettype())
					{
						case 1://changement de Service
						{
							if(charger(result))
							{
								this.pere_Service_name = current_Service_name;
								current_Service_name = ((MessageInterService)result).getnameCible();
							}
							else
							{
								//traitement de l'erreur de chargement			
								traitementErreur((MessageErreur) ((Service) this.htable.get(((MessageInterService) result).getnameCible())).getAbstractMessage());
								sortie = true;
							}
							break;
						}
						case 2://ouverture d'auxiliaire
						{
//!!!!!							((MessageInterModul)result).setnameSource(current_Service_name);
							if(charger(result))
							{
								this.pere_Service_name = current_Service_name;
								current_Service_name = ((MessageInterService)result).getnameCible();
							}
							else
							{
								//traitement de l'erreur de chargement			
								traitementErreur((MessageErreur) ((Service) this.htable.get(((MessageInterService) result).getnameCible())).getAbstractMessage());
								sortie = true;
							}
							break;
						}
						case 3://fermeture auxiliaire
						{
							//si l'on retourne vers le pere
							if(((MessageInterService) result).getnameCible().equals(pere_Service_name))
							{
								this.current_Service_name = pere_Service_name;
								
								pere_Service_name = ((MessageInterService)((Service) this.htable.get(current_Service_name)).getAbstractMessage()).getnameSource();

								((MessageInterService)result).nameCible(current_Service_name);
								((MessageInterService)result).setnameSource(pere_Service_name);
							}
							else///sinon
							{
								if(charger(result))
								{
									this.pere_Service_name = current_Service_name;
									this.current_Service_name = ((MessageInterService) result).getnameCible();
								}
								else
								{
									//traitement de l'erreur de chargement			
									traitementErreur((MessageErreur) ((Service) this.htable.get(((MessageInterService) result).getnameCible())).getAbstractMessage());
									sortie = true;
								}
							}
							if(!sortie)
							{
								((Service) this.htable.get(current_Service_name)).setAbstractMessage(result);
								((ServiceInterface) this.htable.get(current_Service_name)).mise_a_jour_fils();
							}
							break;
						}
					}
				}
			}
		}
		else
		{
			//ecran principal probleme de chargement
		}
	}
	@Override
	public boolean decharger() {
		// TODO Auto-generated method stub
		return ((ServiceInterface) this.htable.get(current_Service_name)).decharger();
	}
	@Override
	public boolean charger(AbstractMessage abstractMessage) {
		// TODO Auto-generated method stub
		String service_name = ((MessageInterService)abstractMessage).getnameCible();
		((Service) this.htable.get(service_name)).setAbstractMessage(abstractMessage);
		this.frame.setErreur("");
		return ((ServiceInterface) this.htable.get(service_name)).init();
	}
	public abstract void chargerService() ;
	@Override
	public void traitementErreur(MessageErreur messageErreur) {
		// TODO Auto-generated method stub
		System.err.println("Erreur : " + messageErreur.gettype());		
	}
	public Hashtable getHtable() {
		return htable;
	}
	public void setHtable(Hashtable htable) {
		this.htable = htable;
	}
	public ConfigurationSetting getConfiguration()
	{
		return this.config;
	}
}
