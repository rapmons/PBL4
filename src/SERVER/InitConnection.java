package Server;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public class InitConnection{
		
	ServerSocket socket = null;
	DataOutputStream verify = null;
	String width="";
	String height="";
			
	InitConnection(int port){
		Robot robot = null;
		Rectangle rectangle = null;
		try{
			System.out.println("Awaiting Connection from Client");
			socket=new ServerSocket(port);
			
			GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
	
			Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
			String width=""+dim.getWidth();
			String height=""+dim.getHeight();
			rectangle=new Rectangle(dim);
			robot=new Robot(gDev);

			

			while(true){
				
				Socket sc=socket.accept();	
				verify=new DataOutputStream(sc.getOutputStream());
					verify.writeUTF(width);
					verify.writeUTF(height);
					new SendSreen(sc,robot,rectangle);
					
					}
				
			
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
			
	

}

