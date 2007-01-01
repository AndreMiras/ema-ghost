package main;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;

import com.standard.dev.business.util.LanceCmdShell;
import com.standard.dev.business.util.WOL;
import com.standard.dev.data.Element.Repertoire;
import com.standard.dev.ui.Controler;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws IOException, NamingException {
		// TODO Auto-generated method stub
/*		System.out.println(LanceCmdShell.lancecmd(" find . -maxdepth 1 -type d -print"));
		System.out.println(LanceCmdShell.lancecmd("mkdir /home/emabs/workspace/EmaBS/toto"));
				
				
				
				
		String pathToExplore = "/home/emabs/workspace/EmaBS";
		Repertoire diskFileExplorer = new Repertoire(pathToExplore, true);
		diskFileExplorer.listToList();
		List<String> listDirectory = diskFileExplorer.getListDirectory();
		List<String> listFile = diskFileExplorer.getListFile();
*/
//		System.out.println(LanceCmdShell.lancecmd("mkdir /home/emabs/workspace/EmaBS/partage/isos"));
//		System.out.println(LanceCmdShell.lancecmd("mkdir /home/emabs/workspace/EmaBS/partage/Promos"));
		Controler ctrl = new Controler("prc");
		Controler ctrl2 = new Controler("prs");
	}
}
/*
mkdir -p /media/backups/`date +%F`

mondoarchive -Oi -E "/dev /proc /media /tmp" -d /media/backups/`date +%F` -s 4g

Arguments:

    -O Backup the system
    -i Make an ISO
    -g GUI (non-cron-friendly)
    -E Exclude path(s) from backup
    -d Backup device|dir 

Differential backup

mkdir -p /media/backups/`date +%F`

mondoarchive -Oi -E "/dev /proc /media /tmp" -d /media/backups/`date +%F` -s 4g -D -W

Arguments:

    -D Make a differential backup
    -W Don't make your backup self-booting 

---------------Functionnal scenario-------------

    mondoarchive -O -i -I "/etc" -d "/var/cache/mondo/mondouser" -s 4g -W
    touch /etc/test.txt
    mondoarchive -O -i -I "/etc" -d "/var/cache/mondo/mondouser" -p "differentialbackup" -s 4g -W -D
    mondorestore //let the gui work for you 
*/