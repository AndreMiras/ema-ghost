package com.standard.dev.business.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.standard.dev.ui.services.Mondo.MondoPanel;
import com.standard.dev.ui.sequences.DeploiementSequence;

public class RestaurationJob extends Thread{
	private static final String path = "/partage/isos/";
	/** Informations de deploiement **/
	private DeploiementSequence sequence;
	private String mac;
	private String ip;
	/** MondoPanel associé **/
	private MondoPanel myPanel;
	
	public RestaurationJob(DeploiementSequence seq, MondoPanel panel, String mac){
		//Init variables
		this.sequence = seq;
		this.myPanel = panel;
		this.mac = mac;
		//MAJ UI
		majUI();
		//Found ip address
		findIp();
		//Launch job
		//start();
	}
	
	public void majUI(){
		myPanel.getLabelDistro().setText(sequence.getDistribution());
		myPanel.getLabelMac().setText(mac);
	}
	
	public void findIp(){
		//String cmd = "grep -i "+mac+" /var/lib/dhcp/dhcpd.leases -B 10 | tail -n 7 | grep lease | cut -d' ' -f2";
		String cmd = "/emabs/getIp "+mac;
		//TODO condition boucle => regex ip
		while(!ip.matches("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")){
			System.out.println("REGEX UNVALID");
			try{
				//Launch & get output
				final Process proc = Runtime.getRuntime().exec(cmd);
				BufferedReader buf = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				ip = buf.readLine();
				buf.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//MAJ ui
		myPanel.getLabelIp().setText(ip);
		
		System.out.println("REGEX VALID");
	}

	public void run(){
		SSH sessionJob = new SSH(sequence,ip,myPanel.getFieldConsole());
		sessionJob.launchViaSSH();
	}
	
}
