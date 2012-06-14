package com.standard.dev.business.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.standard.dev.ressources.Fichier;

public class WOL {
	/*
	 * Attributs
	 */
	/*
	 * Constructeur
	 */
	public WOL()
	{
		
	}
	/*
	 * Methodes
	 */
	public void startWol(String ipStr, String macStr)
	{           
        try {
            byte[] macBytes = getMacBytes(macStr);
            byte[] bytes = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
            }
            
            InetAddress address = InetAddress.getByName(ipStr);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 9);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
            
            System.out.println("Wake-on-LAN packet sent. " + ipStr + " " + macStr);
        }
        catch (Exception e) {
            System.out.println("Failed to send Wake-on-LAN packet: + e");
            System.exit(1);
        }
        
    }
    
    private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = macStr.split("(\\:|\\-)");
        if (hex.length != 6) {
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }
	public void startWolByFile()
	{
		List<String> listMac = new Fichier("AddrMac").getTexte();
		for(int i = 1 ; i < listMac.size() ; i++)
		{
			startWol(listMac.get(0),listMac.get(i));
		}		
	}
	public void startWolByList(String addrDiff ,List<String> listMac)
	{
		for(int i = 0 ; i < listMac.size() ; i++)
		{
			startWol(addrDiff,listMac.get(i));
		}		
	}
}
