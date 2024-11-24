package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user_management.Register;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class c_manage extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean check = false;
	private JPasswordField confirm;
	private JPasswordField newp;
	private JPasswordField old;
	private JTextField textField;
	private JTextField textField_1;
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();

	private void openNextFrame(String username) 
	{
		c_manage nextFrame = new c_manage(username);
        nextFrame.setVisible(true);
        this.dispose(); // Close the current frame if needed
        
        c_hire nextFrame1 = new c_hire(username, "abc", "", 0);
        nextFrame1.setVisible(true);
        this.dispose(); // Close the current frame if needed
        
        c_profile nextFrame2 = new c_profile(username);
        nextFrame2.setVisible(true);
        this.dispose(); // Close the current frame if needed
        
        c_search nextFrame3 = new c_search(username);
        nextFrame3.setVisible(true);
        this.dispose();
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					c_manage frame = new c_manage("abc");
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
	public c_manage(String username) 
	{
		setTitle("Customer Manage Account");
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
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(435, 29, 580, 500);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Change Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(36, 42, 183, 21);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Old Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(69, 93, 119, 21);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("New Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(69, 146, 129, 21);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(69, 199, 160, 21);
		panel_3.add(lblNewLabel_6);
		
		confirm = new JPasswordField();
		confirm.setBounds(233, 199, 175, 22);
		panel_3.add(confirm);
		
		newp = new JPasswordField();
		newp.setBounds(233, 145, 175, 22);
		panel_3.add(newp);
		
		old = new JPasswordField();
		old.setBounds(232, 93, 176, 21);
		panel_3.add(old);
		
		JLabel lblNewLabel_7 = new JLabel("Change Personal Information");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(36, 302, 288, 21);
		panel_3.add(lblNewLabel_7);
		
		JButton btnNewButton_7 = new JButton("Change Password");
		btnNewButton_7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{     	
				//Register r = new Register();
				char[] passwordChars = old.getPassword();
         		String password = new String(passwordChars);
         		
         		char[] passwordChars2 = newp.getPassword();
         		String newpassword = new String(passwordChars2);
         		
         		char[] passwordChars3 = confirm.getPassword();
         		String cpassword = new String(passwordChars3);
         		
         		boolean check = false;
         		if (newpassword.equals(cpassword))
         		{
         			check = true;
         		}
         		
         		if(check)
         		{
         			r.manage_account(1,username,password ,newpassword,"",0);
         			JOptionPane.showInternalMessageDialog(null, "Password has been changed");
         		}
         		else
         		{
         			JOptionPane.showInternalMessageDialog(null, "Passwords do not match");
         		}
			}	
		});
		btnNewButton_7.setBounds(196, 256, 149, 23);
		panel_3.add(btnNewButton_7);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(69, 349, 90, 21);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Phone Number");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(69, 399, 150, 21);
		panel_3.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(212, 401, 196, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 351, 196, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Update Information");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Register r = new Register();
				String address = textField_1.getText();
         		int number = Integer.parseInt(textField.getText());
         		
         		String url = "jdbc:mysql://localhost:3306/project";
                String un = "root";
                String p = "210936";
        		
        		 try (Connection con = DriverManager.getConnection(url, un, p)) 
        			 {
        				 String checkIfExistsQuery = "SELECT COUNT(*) FROM user WHERE Username = ?";
        				 PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
        				 checkIfExistsStatement.setString(1, username);
        				 
        				 ResultSet resultSet = checkIfExistsStatement.executeQuery();
        				 resultSet.next();
        				 int rowCount = resultSet.getInt(1);

        				 if (rowCount > 0) 
        				 {
        					 r.manage_account(2,username,"","", address,number);
        				     JOptionPane.showInternalMessageDialog(null, "Information has been updated"); 
        				 }
        				 
        		      }
        			 catch (SQLException e2)
                     {
                         e2.printStackTrace();
                     }
			}
		});
		btnNewButton_8.setBounds(196, 455, 149, 23);
		panel_3.add(btnNewButton_8);
		
	
	
	}
}


