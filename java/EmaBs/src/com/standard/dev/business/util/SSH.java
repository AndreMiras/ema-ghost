package com.standard.dev.business.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSH {
	/** Var util SSH **/
	private static final String user = "emabs";
	private static final String pwd = "emabs";
	private String ip;
	/** Var info **/
	private static final String srv = "192.168.6.1";
	private String cmd = "/emabs/the_script";
	
	public SSH(String ip){
		this.ip=ip;
	}
	
	public String launchViaSSH(){
		String result = "";
		try
		{
			/* Create a connection instance */
			Connection conn = new Connection(ip);
			/* Now connect */
			conn.connect();
			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */	
			boolean isAuthenticated = conn.authenticateWithPassword(user,pwd);
			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			/* Create a session */
			Session sess = conn.openSession();
			sess.execCommand(cmd);
			/* Get output */
			InputStream stdout = new StreamGobbler(sess.getStdout());
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
			
			String line;
			while ((line=br.readLine()) != null)
				result += line;

			/* Show exit status, if available (otherwise "null") */
			//System.out.println("ExitCode: " + sess.getExitStatus());
			
			/* Close this session */
			sess.close();
			/* Close the connection */
			conn.close();
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
		}
		
		return result;
	}
}
