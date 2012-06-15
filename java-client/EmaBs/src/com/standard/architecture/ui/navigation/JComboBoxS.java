package com.standard.architecture.ui.navigation;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.standard.architecture.ui.Controler;

public class JComboBoxS extends JComboBox{
	/*
	 * Attributs
	 */
	private ArrayList<String> list;
	private ActionListener controleur;
	/*
	 * Constructeur
	 */
	public JComboBoxS(String name , Controler controleur)
	{
		super();
		this.controleur = controleur;
		this.setName(name);
		this.setActionCommand(name);
		addActionListener(controleur);
		list = new ArrayList<String>();
	}
	/*
	 * Méthodes
	 */
	/*
	 * vide la combo
	 */
	public void vide()
	{
		//vide la combo	
		if(!this.list.isEmpty())
		{
			this.removeAllItems();
		}
	}
	/*
	 * List vers combo
	 */
	public void listToCombo(ArrayList<String> e)
	{
		this.removeActionListener(controleur);
		this.vide();
		list = e;		
		//ajout de la list a la combo
		for(int i = 0;i <list.size() ;i++)
        {
			this.addItem(list.get(i));
        }
		addActionListener(controleur);
	}
	/*
	 * ajouter element
	 */
	public void addToList(Object e)
	{
		list.add((String)e);
		listToCombo(list);		
	}	
	/*
	 * obtenir l'item selectionné
	 */
	public Object getItemSelected()
	{
		return this.getSelectedItem();
	}
}
