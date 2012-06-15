package com.standard.architecture.ui.service;

import com.standard.architecture.ui.service.AbstractMessage;

public class MessageErreur extends AbstractMessage{
	/*
	 * Attributs
	 */
	private int			type;
	/*
	 * Constructeur
	 */
	public MessageErreur()
	{
		
	}
	/*
	 * Méthodes
	 */
	@Override
	public void settype(int type) {
		// TODO Auto-generated method stub
		this.type = type;
	}
	@Override
	public int gettype() {
		// TODO Auto-generated method stub
		return this.type;
	}
}
