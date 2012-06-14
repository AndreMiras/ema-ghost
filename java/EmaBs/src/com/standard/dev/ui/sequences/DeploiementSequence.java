package com.standard.dev.ui.sequences;

import java.util.ArrayList;
import java.util.List;

import com.standard.dev.business.util.RestaurationJob;
import com.standard.dev.business.util.WOL;

public class DeploiementSequence {
	/*
	 * Attributs
	 */
	List<String> list_addr_mac;
	String promo;
	String cours;
	String distribution;
	String addrDiffusion;	
	String partition;
	List<RestaurationJob> jobList;
	/*
	 * Constructeur
	 */
	public DeploiementSequence()
	{
		list_addr_mac = new ArrayList<String>();
		promo="";
		cours="";
		distribution="";
		partition="";
		jobList = new ArrayList<RestaurationJob>();		
		addrDiffusion="";
	}
	public DeploiementSequence(String mac){
		//CHANGE
		list_addr_mac = new ArrayList<String>();
		list_addr_mac.add(mac);
		partition="";
		jobList = new ArrayList<RestaurationJob>();
		promo="";
		cours="";
		distribution="";
		addrDiffusion="";
	}
	/*
	 * Methodes
	 */
	public List<String> getList_addr_mac() {
		return list_addr_mac;
	}
	public void setList_addr_mac(List<String> list_addr_mac) {
		this.list_addr_mac = list_addr_mac;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public String getCours() {
		return cours;
	}
	public void setCours(String cours) {
		this.cours = cours;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getAddrDiffusion() {
		return addrDiffusion;
	}
	public void setAddrDiffusion(String addrDiffusion) {
		this.addrDiffusion = addrDiffusion;
	}
	/*
	 * Lancement de tous les jobs
	 */
	public void launchJobs(){
		String iso = distribution+".iso";
		for(int i=0; i<list_addr_mac.size(); i++){
			String mac = list_addr_mac.get(i);
			jobList.add(new RestaurationJob(partition, iso, mac));
		}
	}
	
	public void launchJob(){
		RestaurationJob job = new RestaurationJob(list_addr_mac.get(0));
		System.out.println("Lancement du job");
		//job.run();
		WOL wol = new WOL();
		wol.startWol("192.168.6.20", "00:24:21:03:2c:cb");
		System.out.println("Fin du job");
	}

	public void lanceWOL()
	{
		WOL wol = new WOL();
		wol.startWolByList(getAddrDiffusion(), getList_addr_mac());
	}
	public String toString()
	{
		String result ="";
		result = "Lancement du deploiement de la distribution "+ distribution + " sur les machines : \n";
		for(int i = 0 ; i < list_addr_mac.size() ; i++)
		{
			result += "\t" + list_addr_mac.get(i) + "\n";
		}
		result += "\n L'addresse de diffusion est " + addrDiffusion;
		result += "\n  pour le cour " + cours;
		result += "\n  de la promotion :" + promo;
		result += "\n";
		
		return result;
	}
}
