package com.standard.dev.data.Element;

import java.util.List;
import java.util.ArrayList;

import java.io.File;

public class Repertoire {
	/*
	 * Attributs
	 */
	List<String> listDirectory = new ArrayList<String>(); 
	List<String> listFile = new ArrayList<String>(); 
	/*
	 * Constructeur
	 */
	public Repertoire()
	{
		listDirectory = new ArrayList<String>(); 
		listFile = new ArrayList<String>(); 
	}
	/*
	 * M�thodes
	 */

/**
 * Lister le contenu d'un r�pertoire
 * @author fobec 2010
 */

    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;

/**
 * Constructeur
 * @param path chemin du r�pertoire
 * @param subFolder analyse des sous dossiers
 */
    public Repertoire(String path, Boolean subFolder) {
        super();
		listDirectory = new ArrayList<String>(); 
		listFile = new ArrayList<String>(); 
        this.initialpath = path;
        this.recursivePath = subFolder;
    }

    public void list() {
        this.listDirectory(this.initialpath);
    }

    private void listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier " + files[i].getAbsolutePath());
                    this.dircount++;
                } else {
                    System.out.println("Fichier " + files[i].getName());
                    this.filecount++;
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
    }

    /**
     * Exemple : lister les fichiers dans tous les sous-dossiers
     * @param args
     */
    public static void main(String[] args) {
        String pathToExplore = "/home/emabs/workspace/EmaBS";
        Repertoire diskFileExplorer = new Repertoire(pathToExplore, false);
        Long start = System.currentTimeMillis();
        diskFileExplorer.list();
        System.out.println("----------");
        System.out.println("Analyse de " + pathToExplore + " en " + (System.currentTimeMillis() - start) + " mses");
        System.out.println(diskFileExplorer.dircount + " dossiers");
        System.out.println(diskFileExplorer.filecount + " fichiers");
    }
    public void listToList() {
        this.listDirectoryAndFile(this.initialpath);
    }
    private void listDirectoryAndFile(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier " + files[i].getAbsolutePath());
                    listDirectory.add(files[i].getAbsolutePath());
                    this.dircount++;
                } else {
                    System.out.println("Fichier " + files[i].getName());
                    listFile.add(files[i].getName());
                    this.filecount++;
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }        
    }
	public List<String> getListDirectory() {
		return listDirectory;
	}

	public List<String> getListFile() {
		return listFile;
	}    
}