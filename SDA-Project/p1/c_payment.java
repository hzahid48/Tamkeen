package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import service_management.Bank;
import service_management.Paypal;
import user_management.Register;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class c_payment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField a1;
	private JTextField ssn_text;
	private JTextField edate;
	private JTextField amount1;
	private JTextField a2;
	private JPasswordField skey;
	private JTextField amount2;
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					c_payment frame = new c_payment("abc", "abc");
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
	public c_payment(String username, String fusername) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1407, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(53, 44, 68));
		panel.setBounds(0, 0, 1370, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("تمکین");
		lblNewLabel_1.setBounds(1138, 11, 162, 80);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 68));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 24, 66, 67);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\profile.JPG"));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(74, 53, 110, 31);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_2.setBackground(clr);
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_2.setBackground(clr);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome frame3 = new welcome();
                frame3.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(53, 44, 68));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Meiryo", Font.BOLD, 15));
		btnNewButton_2.setBorderPainted(false);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Profile");
		btnNewButton_3.setBounds(235, 41, 95, 28);
		btnNewButton_3.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_3.setBackground(clr);
			}
			
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_3.setBackground(clr);
			}
		});
		btnNewButton_3.setBackground(new Color(53, 44, 68));
		btnNewButton_3.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBorderPainted(false);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Manage Account");
		btnNewButton_4.setBounds(340, 40, 181, 30);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_manage frame3 = new c_manage(username);
                frame3.setVisible(true);
			}
		});
		r = null;
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_4.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_4.setBackground(clr);
			}
		});
		btnNewButton_4.setBackground(new Color(53, 44, 68));
		btnNewButton_4.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBorderPainted(false);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Dashboard\r\n");
		btnNewButton_5.setBounds(515, 41, 137, 28);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_5.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_5.setBackground(clr);
			}
		});
	
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_dashboard frame23 = new c_dashboard(username);
				frame23.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(53, 44, 68));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_5.setBorderPainted(false);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Search Services");
		btnNewButton_6.setBounds(650, 40, 181, 30);
		btnNewButton_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				c_search frame8 = new c_search(username);
				frame8.setVisible(true);
			}
		});
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_6.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_6.setBackground(clr);
			}
		});
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_6.setBackground(new Color(53, 44, 68));
		btnNewButton_6.setBorderPainted(false);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_1_1 = new JButton("Notifications");
		btnNewButton_1_1.setBounds(845, 41, 187, 29);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				C_Notifications frame20 = new C_Notifications(username);
				frame20.setVisible(true);
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_1_1.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_1_1.setBackground(clr);
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\notification.JPG"));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(53, 44, 68));
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(140, 140, 140));
		panel_1.setBounds(0, 112, 1370, 637);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 30, 464, 450);
		panel_2.setBackground(new Color(240, 240, 240));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(38, 110, 381, 280);
		panel_2.add(panel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Account Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(20, 40, 155, 23);
		panel_4.add(lblNewLabel_7);
		
		a1 = new JTextField();
		a1.setColumns(10);
		a1.setBounds(170, 40, 181, 23);
		panel_4.add(a1);
		
		JLabel lblNewLabel_8 = new JLabel("Expiry Date");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(20, 85, 122, 23);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SSN");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(20, 135, 57, 20);
		panel_4.add(lblNewLabel_9);
		
		ssn_text = new JTextField();
		ssn_text.setColumns(10);
		ssn_text.setBounds(170, 135, 180, 23);
		panel_4.add(ssn_text);
		
		JButton btnNewButton_9 = new JButton("Make Payment");
		btnNewButton_9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				double amount = Double.parseDouble(amount1.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date2 = null;
				try 
				{
					System.out.println("Date before :" + date2);
					java.util.Date utilDate = dateFormat.parse(edate.getText());
				    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					System.out.println("Date 2 :" + sqlDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//System.out.println("Date :" + date2);
				int ssn = Integer.parseInt(ssn_text.getText());
				String account_number = a1.getText();
				
			    Bank bank = new Bank( account_number, date2, ssn, amount);
				boolean check = bank.make_payment(username, fusername, amount, account_number, date2, ssn);
				if(check)
				{
					JOptionPane.showInternalMessageDialog(null, "Transaction is successful");
				}
				else
				{
					JOptionPane.showInternalMessageDialog(null, "Error occured");
				}
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			}
		});
		
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_9.setBounds(120, 240, 150, 24);
		panel_4.add(btnNewButton_9);
		
		edate = new JTextField();
		edate.setColumns(10);
		edate.setBounds(170, 88, 181, 23);
		panel_4.add(edate);
		
		JLabel lblNewLabel_9_1 = new JLabel("Amount");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9_1.setBounds(20, 185, 80, 20);
		panel_4.add(lblNewLabel_9_1);
		
		amount1 = new JTextField();
		amount1.setColumns(10);
		amount1.setBounds(170, 187, 180, 23);
		panel_4.add(amount1);
		
		JLabel lblNewLabel_2 = new JLabel("Bank Transfer");
		lblNewLabel_2.setFont(new Font("Meiryo", Font.BOLD, 20));
		lblNewLabel_2.setBounds(160, 39, 190, 20);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(UIManager.getColor("Button.background"));
		panel_2_1.setBounds(700, 30, 464, 450);
		panel_1.add(panel_2_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.LIGHT_GRAY);
		panel_4_1.setBounds(44, 110, 381, 280);
		panel_2_1.add(panel_4_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Account Number");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7_1.setBounds(20, 60, 155, 23);
		panel_4_1.add(lblNewLabel_7_1);
		
		a2 = new JTextField();
		a2.setColumns(10);
		a2.setBounds(170, 60, 181, 23);
		panel_4_1.add(a2);
		
		JLabel lblNewLabel_8_1 = new JLabel("Secret Key");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8_1.setBounds(20, 115, 122, 23);
		panel_4_1.add(lblNewLabel_8_1);
		
		skey = new JPasswordField();
		skey.setBounds(170, 115, 181, 23);
		panel_4_1.add(skey);
		
		JButton btnNewButton_9_1 = new JButton("Make Payment");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				double amount = Double.parseDouble(amount2.getText());
				
				char[] passwordChars = skey.getPassword();
				String secretkey  = new String(passwordChars);
               
				String account_number = a2.getText();
				
			    Paypal paypal = new Paypal( account_number, secretkey, amount);
				boolean check = paypal.make_payment(username, fusername, amount, account_number, secretkey);
				if(check)
				{
					JOptionPane.showInternalMessageDialog(null, "Transaction is successful");
				}
				else
				{
					JOptionPane.showInternalMessageDialog(null, "Error occured");
				}
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			}
		});
		btnNewButton_9_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_9_1.setBounds(115, 245, 150, 24);
		panel_4_1.add(btnNewButton_9_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Amount");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8_1_1.setBounds(20, 175, 122, 23);
		panel_4_1.add(lblNewLabel_8_1_1);
		
		amount2 = new JTextField();
		amount2.setColumns(10);
		amount2.setBounds(170, 175, 181, 23);
		panel_4_1.add(amount2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Paypal");
		lblNewLabel_2_1.setFont(new Font("Meiryo", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(170, 35, 190, 20);
		panel_2_1.add(lblNewLabel_2_1);
	}
}
