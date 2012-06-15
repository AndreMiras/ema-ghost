package com.standard.architecture.ui.navigation;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import com.standard.architecture.ui.Controler;

public class JListS extends JList{
	/*
	 * Attributs
	 */
	private List<Object> list = new ArrayList<Object>();
	/*
	 * Constructeur
	 */
	public JListS(String name , Controler controleur)
	{
		super();
		this.setName(name);
		this.setSelectedIndex(0);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//SINGLE_INTERVAL_SELECTION//SINGLE_SELECTION
		this.setLayoutOrientation(JList.VERTICAL);
		this.list = new ArrayList<Object>();
		this.list.add(new ArrayList<Object>());
		this.list.add(new ArrayList<Object>());
	}
	/*
	 * M�thodes
	 */
	/*
	 * vide la jlist
	 */
	public void vide()
	{
		//vide la jlist	
		if(!this.list.isEmpty())
		{
			this.list = new ArrayList<Object>();
        	this.setListData(list.toArray());
		}
	}
	/*
	 * List vers jlist
	 */
	public void listTojList(List<Object> e)
	{
		this.vide();
		list = e;		
		//this.setListData(list.toArray());      
		this.setListData(((ArrayList)list).toArray());      
	}
	/*
	 * ajouter element
	 */
	public void addToList(Object e)
	{
		if(e != null)
		{
			((ArrayList)list).add(e);
					
			int index = this.getLastVisibleIndex(); //get last index
	        if (index == -1) { //no selection, so insert at beginning
	            index = 0;
	        } else {           //add after the selected item
	            index++;
	        }
	        this.setListData(((ArrayList)list).toArray());
	        this.ensureIndexIsVisible(index);
		}
	}	
	public Object removeSelected()
	{
		Object obj = null;
			
		int index = this.getSelectedIndex(); //get last index
        if (index == -1) { //no selection, so insert at beginning
        	obj = null;
        } else {           //add after the selected item
        	
    		obj = (((ArrayList)list).get(index));
    		
    		((ArrayList)list).remove(index);
    		
        	this.setListData(((ArrayList)list).toArray());
        }		
		return obj;		
	}
	public void removeALLSelected()
	{
		int[] indices = this.getSelectedIndices();
		for(int i = indices.length - 1 ;  i !=-1 ; i--)
		{
			list.remove(indices[i]);
		}

    	this.setListData(((ArrayList)list).toArray());
	}
	public List<Object> getList()
	{
		return this.list;
	}
	public List<Object> getSelectedList()
	{
		List<Object> objs = new ArrayList<Object>();
		int[] indices  = this.getSelectedIndices();
		for(int i = 0 ; i < indices.length ; i++)
		{
			objs.add(list.get(indices[i]));
		}		
		return objs;
	}
	public void selectAll()
	{
		int[] indices = new int[list.size()];
		for(int i = 0 ; i < list.size() ; i++)
		{
			indices[i]=i;
		}
		setSelectedIndices(indices);
	}
	public void unselectAll()
	{
		setSelectedIndex(0);
	}
}
