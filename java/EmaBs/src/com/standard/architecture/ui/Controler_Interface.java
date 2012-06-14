package com.standard.architecture.ui;

import com.standard.architecture.ui.service.AbstractMessage;
import com.standard.architecture.ui.service.MessageErreur;


public interface Controler_Interface{
	/*
	 * Méthodes
	 */
	boolean decharger();
	boolean charger(AbstractMessage module_name);
	void traitementErreur(MessageErreur module_name);
}
