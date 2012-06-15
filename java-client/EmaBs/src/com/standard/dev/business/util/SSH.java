package com.standard.dev.business.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.standard.dev.ui.sequences.DeploiementSequence;
import javax.swing.JTextField;

public class SSH {
	/** Var util SSH **/
	private static final String user = "emabs";
	private static final String pwd = "emabs";
	/** Var util mondo **/
	private static final String srv = "192.168.6.1";
	private String cmd = "/usr/local/bin/sc_restore";
	/** Informations deploiement **/
	private DeploiementSequence sequence;
	private String ip;
	/** Graphics elements **/
	private JTextField fieldConsole;
	
	public SSH(DeploiementSequence seq, String ip, JTextField field){
		this.sequence = seq;
		this.ip=ip;
		this.fieldConsole = field;
	}
	
	public void launchViaSSH(){
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
			
			String text = "";
			String line = "";
			while ((line=br.readLine()) != null){
				text += line;
				fieldConsole.setText(text);
			}
			
			/* Close this session */
			sess.close();
			/* Close the connection */
			conn.close();
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
		}
	}
}
