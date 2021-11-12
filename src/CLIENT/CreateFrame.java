package Client;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.util.zip.*;

import java.io.IOException;

public class CreateFrame extends Thread {
	String width="", height="";
	private JFrame frame = new JFrame();

	//JDesktopPane represents the main container that will contain all connected clients' screens


	private Socket cSocket = null;
	
	private JPanel cPanel = new JPanel();

	public CreateFrame(Socket cSocket, String width, String height) {

		this.width = width;
		this.height = height;
		this.cSocket = cSocket;
		start();
	}
	
	//Draw GUI per each connected client

	public void drawGUI() {
		
		//This allows to handle KeyListener events
		cPanel.setFocusable(true);
		frame.setSize(1930, 1050);

        cPanel.setSize(1930, 1050);

       frame.setExtendedState(Frame.MAXIMIZED_BOTH);

      

       frame.add(cPanel);

       frame.pack();

       frame.setVisible(true);
		
	}

	public void run() { 
		//Used to read screenshots
		InputStream in = null;
		//start drawing GUI
		drawGUI();

		try{
			in = cSocket.getInputStream();
			}catch (IOException ex){
			ex.printStackTrace();
		}

		//Start receiving screenshots
		new ReceiveScreen(in,cPanel);
		//Start sending events to the client
		new SendEvents(cSocket,cPanel,width,height);
	}
}
