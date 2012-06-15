package com.standard.dev.business.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LanceCmdShell {
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	/*
	 * Methode
	 */
	final static public String lancecmd(String cmd){
		String result = "" ;
		String tampon;
		try{
			//Launch & get output
			final Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader buf = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			while( (tampon =  buf.readLine() ) != null){			
				result += tampon + "\n";
			}

			buf.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
