package Server;
import java.awt.EventQueue;
import Client.CreateFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.TextField;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

import javax.swing.UIManager;


import Server.server;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class giaodien {
	String verify ="";
	private Socket cSocket = null;
	String width="",height="";
	DataOutputStream psswrchk = null;
	DataInputStream verification = null;
	String value1;
	static int port=7749;
	private JFrame frame;
	  static private JTextField textField;
	 static private JTextField textField_1;
	static private JTextField textField_2;
	static private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	 private static char[] generatePassword(int length) {
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters  + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      
	   
	      for(int i = 0; i< length ; i++) {
	         password[i]=  combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;
	   }
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodien window = new giaodien();
					window.frame.setVisible(true);
					InetAddress IP = InetAddress.getLocalHost();
                    String pString=  String.copyValueOf(generatePassword(6));
                    String x = IP.getHostAddress();
                    textField.setText(x);
                    textField_1.setText(pString);
                   
                   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public giaodien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 216, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label = new Label("Allow Remote Control");
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setForeground(SystemColor.desktop);
		label.setBounds(40, 10, 140, 22);
		panel.add(label);
		
		Label label_2 = new Label("Your ID");
		label_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		label_2.setBounds(10, 49, 62, 22);
		panel.add(label_2);
		
		Label label_4 = new Label("PassWord");
		label_4.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		label_4.setBounds(10, 123, 62, 22);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(20, 77, 153, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 159, 153, 29);
		panel.add(textField_1);
		
		JButton btnNewButton_1_1 = new JButton("Accept");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value1=textField_1.getText();
				
				 new InitConnection(port,value1);
			}
		});
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1_1.setBounds(59, 210, 86, 23);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(218, 0, 216, 261);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Label label_1 = new Label("Control Remote Computer");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(35, 10, 153, 22);
		panel_1.add(label_1);
		
		Label label_3 = new Label("Partner ID");
		label_3.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		label_3.setBounds(10, 47, 62, 22);
		panel_1.add(label_3);
		
		Label label_5 = new Label("PassWord");
		label_5.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		label_5.setBounds(10, 126, 62, 22);
		panel_1.add(label_5);
		
		JButton btnNewButton_1 = new JButton("Connect");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				 cSocket = new Socket("",port);
				
             String value2=textField_3.getText();
				
				
				psswrchk= new DataOutputStream(cSocket.getOutputStream());
				verification= new DataInputStream(cSocket.getInputStream());
				psswrchk.writeUTF(value2);
				verify=verification.readUTF();
	
				}catch (IOException ee){
				ee.printStackTrace();
				}

				if(verify.equals("valid")){
				try{
				width = verification.readUTF();
				height = verification.readUTF();
		
				}catch (IOException ee){
				ee.printStackTrace();		
				}
				CreateFrame abc= new CreateFrame(cSocket,width,height);
				
				}
				else {
				System.out.println("enter the valid password");
				
				}

				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBounds(65, 210, 86, 23);
		panel_1.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(35, 75, 153, 29);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(35, 159, 153, 29);
		panel_1.add(textField_3);
	}
	
}
