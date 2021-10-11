package CLIENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class clientfirstpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientfirstpage frame = new clientfirstpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public clientfirstpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textInactiveText);
		panel.setBounds(0, 0, 434, 33);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Wellcome ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(SystemColor.window);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(247, 35, 187, 226);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Control remote computer");
		lblNewLabel_1_1.setBackground(Color.GRAY);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 11, 167, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Partner ID");
		lblNewLabel_2_2.setForeground(Color.GRAY);
		lblNewLabel_2_2.setBounds(10, 47, 60, 14);
		panel_1.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBounds(10, 64, 144, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("PassWord");
		lblNewLabel_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_2_1_1.setBounds(10, 101, 60, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 127, 144, 26);
		panel_1.add(textField_1);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.setBounds(47, 173, 89, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_1.setBounds(0, 35, 246, 226);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("  Allow remote control");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(38, 11, 149, 14);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your ID");
		lblNewLabel_2.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2.setBounds(10, 46, 46, 14);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 58, 161, 24);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("PassWord");
		lblNewLabel_2_1.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2_1.setBounds(10, 104, 60, 14);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(20, 118, 161, 24);
		panel_1_1.add(lblNewLabel_3_1);
	}
}
