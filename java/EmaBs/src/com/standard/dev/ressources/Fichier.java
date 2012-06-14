package com.standard.dev.ressources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Fichier {
	/*
	 * Attributs
	 */
	private String file_name;
	private List<String> texte;
	/*
	 * Constructeur
	 */
	public Fichier(String file_name)
	{
		this.file_name = file_name;
		this.texte = new ArrayList<String>();
	}
	/*
	 * M�thodes
	 */
	private void load()
	{			
		try{
			InputStream ips=new FileInputStream(this.file_name); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);

			String carac;
			while( (carac = br.readLine()) != null){
				this.texte.add( carac);
			}
            br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	public List<String> getTexte() {
		load();
		return this.texte;
	}
	public void newTexte(String diffusion , List<String> newTexte) throws IOException
	{
		if(diffusion == null)
			diffusion = getTexte().get(0);
		FileWriter filewriter = new FileWriter(new File("AddrMac.emabs"), false); 
		
		filewriter.write(diffusion + "\n");
		for(int i = 1 ; i < newTexte.size() ; i++)
			filewriter.write(newTexte.get(i) + "\n");
		filewriter.close();
	}
}