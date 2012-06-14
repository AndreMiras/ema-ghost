package com.standard.architecture.business.util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public abstract class BaseProperties {
	/*
	 * Attributs
	 */
	protected String 			nom_properties;
	protected Properties 		prop;
	protected FileInputStream in;
	/*
	 * Constructeur
	 */
	public BaseProperties(String nom_properties,String comments) 
	{
		this.nom_properties = nom_properties;
	    prop =  new Properties();
	    if(!open())
	    {
	    	create();
	    	saveProperties(prop, this.nom_properties, comments);
	    }	    
	}
	/*
	 * Methodes
	 */
	private boolean open()
	{
		boolean retour = false;
		
		try {
			in = new FileInputStream(this.nom_properties);
			prop.load(in);
			in.close();
			retour = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return retour;
	}
	
	public abstract void create();
	
	public String getProperty(String s)
	{
		String res = null;
		res = prop.getProperty(s);	
		if(res != null)
		{
			if(res.contains("§"))
			{
/*				BaseProperties tmp = new BaseProperties("arg.tmp");
	
				res = res.replaceAll("§0", tmp.getProperty("arg0"));
				res = res.replaceAll("§1", tmp.getProperty("arg1"));
				res = res.replaceAll("§2", tmp.getProperty("arg2"));
				res = res.replaceAll("§3", tmp.getProperty("arg3"));
				res = res.replaceAll("§4", tmp.getProperty("arg4"));
				res = res.replaceAll("§5", tmp.getProperty("arg5"));
				res = res.replaceAll("§6", tmp.getProperty("arg6"));
				res = res.replaceAll("§7", tmp.getProperty("arg7"));
				res = res.replaceAll("§8", tmp.getProperty("arg8"));			
*/			}
		}
		return res;
	}
	public void setProperty(String arg0, String arg1)
	{
		prop.setProperty(arg0, arg1);	
		try {
			FileOutputStream out = new FileOutputStream(this.nom_properties);
		    prop.store(out, null);
		    out.close();
		    in = new FileInputStream(this.nom_properties);
			prop.load(in);
		    in.close();
		} catch (IOException e) {
		}
	}
	/**
	 * Cette méthode stocke le fichier Properties à l'emplacement spécifié
	 * 
	 * @param props Le fichier à stocker
	 * @param fileLocation L'emplacement où le fichier doit être stocké
	 * @param comments Commentaires à insérer en tête du fichier
	 * @throws FileNotFoundException
	 * @throws IOException si une erreur est survenue lors de l'écriture du fichier
	 */
	public void saveProperties(Properties props, String fileLocation, String comments){
		try{
		OutputStream out = new FileOutputStream(fileLocation);
		props.store(out, comments);
		out.flush();
		out.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
