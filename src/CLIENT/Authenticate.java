package Client;




import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

class Authenticate {
		static 	private Socket cSocket = null;
			
		static 	DataInputStream verification = null;
		static 	String width="",height="";

Authenticate(Socket cSocket){
				
				this.cSocket = cSocket;
		
				
				}


public static  void main(String[] args) {


				
				
				try{
			
				verification= new DataInputStream(cSocket.getInputStream());
				
	
				}catch (IOException e){
				e.printStackTrace();
				}

				
				try{
				width = verification.readUTF();
				height = verification.readUTF();
		
				}catch (IOException e){
				e.printStackTrace();		
				}
				CreateFrame abc= new CreateFrame(cSocket,width,height);
				
				}
				

				
			
	}

