package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;







public class Client {
	static String port = "5000";
	
	public static void main(String args[]){
		
		new Client().initialize("", Integer.parseInt(port));
		}
	public void initialize(String ip, int port){
		try{
			
			Socket sc = new Socket(ip,port);
			DataInputStream verification = null;
			String width="",height="";
			
			try{
		
			verification= new DataInputStream(sc.getInputStream());
			

			}catch (IOException e){
			e.printStackTrace();
			}

			
			try{
			width = verification.readUTF();
			height = verification.readUTF();
	
			}catch (IOException e){
			e.printStackTrace();		
			}
			CreateFrame abc= new CreateFrame(sc,width,height);
			
			
			System.out.println("Connecting to the Server");
			//Authenticate class is responsible for security purposes
			

			
		} catch (Exception ex){
			ex.printStackTrace();
		}
				           }
	
}
