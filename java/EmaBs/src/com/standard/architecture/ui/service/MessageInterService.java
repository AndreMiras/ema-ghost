package com.standard.architecture.ui.service;

import java.util.Collection;
import java.util.List;

public class MessageInterService extends AbstractMessage{
	/*
	 * Attributs
	 */
	private String			nameCible 	= new String();
	private String			nameSource	= new String();
	private int				type		= 1;
	private List 			listData	= null;
	/*
	 * Controleurs
	 */
	public MessageInterService()
	{
		super();
	}
	public MessageInterService(String nameCible)
	{
		super();
		this.nameCible = nameCible;
	}
	public MessageInterService(String nameCible,List listData)
	{
		super();
		this.nameCible = nameCible;
		this.listData  = listData;
	}
	public MessageInterService(String nameCible,String nameSource,int type,List	listData)
	{
		super();
		this.nameCible = nameCible;
		this.nameSource = nameSource;
		this.type = type;
		this.listData  = listData;
	}
	/*
	 * Méthodes
	 */
	/*
	 * Set
	 */
	public void nameCible(String nameCible)
	{
		this.nameCible = nameCible;
	}
	public void	setnameSource(String nameSource)
	{
		this.nameSource = nameSource;
	}
	public void	settype(int type)
	{
		this.type = type;
	}
	public void setlistData(List<Object> listData)
	{
		this.listData = listData;
	}
	/*
	 * Get
	 */
	public String getnameCible()
	{
		return this.nameCible;
	}
	public String	getnameSource()
	{
		return this.nameSource;
	}
	public int gettype()
	{
		return this.type;
	}
	public List getlistData()
	{
		return this.listData;
	}
}
