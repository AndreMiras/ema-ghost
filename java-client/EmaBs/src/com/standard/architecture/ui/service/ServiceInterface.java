package com.standard.architecture.ui.service;

public interface ServiceInterface {
	/*
	 * Methodes
	 */
	public boolean init();
	public boolean decharger();
	public AbstractMessage action(String e);
	public boolean isvalid();
	public void mise_a_jour_fils();

}
