package com.standard.dev.business.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RestaurationJob extends Thread{
	private static final String path = "/partage/isos/";
	private String partition;
	private String iso;
	private String mac;
	private String ip;
	
	public RestaurationJob(String part, String iso, String mac){
		//Init variables
		this.partition = part;
		this.iso = iso;
		this.mac = mac;
		//Found ip address
		findIp();
		//Launch job
		start();
	}
	
	public void findIp(){
		//String getIp = "no IP";
		//String cmd = "grep -i "+mac+" /var/lib/dhcp/dhcpd.leases -B 10 | tail -n 7 | grep lease | cut -d' ' -f2";
		String cmd = "/emabs/getIp "+mac;
		
		try{
			//Launch & get output
			final Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader buf = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			ip = buf.readLine();
			buf.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//return getIp;
	}
	
	public void run(){
		findIp();
		SSH sessionJob = new SSH(ip);
		String result = sessionJob.launchViaSSH();
		System.out.println(result);
	}
	
	public RestaurationJob(String mac){
		this.mac=mac;
	}
	
}
