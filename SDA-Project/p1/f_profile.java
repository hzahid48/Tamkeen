package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user_management.freelancer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class f_profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean check = false;
	private JTextField textField;
	private JTextField textField_1;	

	
	 private void openNextFrame(String username) 
		{
			f_manage nextFrame = new f_manage(username);
	        nextFrame.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	        home_freelancer nextFrame2 = new home_freelancer(username);
	        nextFrame.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	        
	        f_profile nextFrame3 = new f_profile(username);
	        nextFrame3.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	        notifications nextFrame4 = new notifications(username);
	        nextFrame4.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f_profile frame = new f_profile("abc");
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
	public f_profile(String username) {
		setTitle("Freelancer Profile");
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
		lblNewLabel_1.setBounds(1140, 11, 162, 80);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 68));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				orders frame16 = new orders(username);
				frame16.setVisible(true);
			}
		});
		btnNewButton.setBounds(860, 40, 106, 23);
		btnNewButton.setBackground(new Color(53, 44, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton.setBackground(clr);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton.setBackground(clr);
			}
		});
		btnNewButton.setFont(new Font("Meiryo", Font.BOLD, 18));
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Notifications");
		btnNewButton_1.setBounds(965, 35, 179, 35);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_1.setBackground(clr);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_1.setBackground(clr);
			}
		});
		btnNewButton_1.setFont(new Font("Meiryo", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				notifications frame16 = new notifications(username);
				frame16.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(53, 44, 68));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\notification.JPG"));
		btnNewButton_1.setBorderPainted(false);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(31, 24, 66, 67);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\profile.JPG"));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(95, 53, 115, 31);
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
		btnNewButton_3.setBounds(300, 38, 99, 28);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_profile frame3 = new f_profile(username);
                frame3.setVisible(true);
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
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
		btnNewButton_4.setBounds(409, 37, 183, 30);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_manage frame3 = new f_manage(username);
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
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_dashboard frame29 = new f_dashboard(username);
				frame29.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(592, 38, 137, 28);
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
		btnNewButton_5.setBackground(new Color(53, 44, 68));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_5.setBorderPainted(false);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Services");
		btnNewButton_6.setBounds(739, 37, 115, 30);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_services frame4 = new f_services(username);
                frame4.setVisible(true);
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
		
		JButton btnNewButton_7 = new JButton("Home");
		btnNewButton_7.setBounds(201, 37, 89, 30);
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_freelancer frame4 = new home_freelancer(username);
                frame4.setVisible(true);
			}
		});
		
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_7.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_7.setBackground(clr);
			}
		});
		btnNewButton_7.setBackground(new Color(53, 44, 68));
		btnNewButton_7.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_7.setBorderPainted(false);
		panel.add(btnNewButton_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(140, 140, 140));
		panel_1.setBounds(0, 112, 1370, 637);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBounds(25, 29, 420, 436);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Personal Information");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(20, 32, 189, 40);
		panel_2.add(lblNewLabel_4);
		
		JLabel fname = new JLabel("First Name");
		fname.setFont(new Font("Tahoma", Font.BOLD, 16));
		fname.setBounds(40, 94, 128, 20);
		panel_2.add(fname);
		
		JLabel lname = new JLabel("Last Name");
		lname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lname.setBounds(250, 94, 114, 20);
		panel_2.add(lname);
		
		JLabel usern = new JLabel("User Name");
		usern.setFont(new Font("Tahoma", Font.BOLD, 16));
		usern.setBounds(40, 196, 114, 20);
		panel_2.add(usern);
		
		JLabel number = new JLabel("Phone Number");
		number.setFont(new Font("Tahoma", Font.BOLD, 16));
		number.setBounds(250, 196, 134, 20);
		panel_2.add(number);
		
		JLabel add = new JLabel("Address");
		add.setFont(new Font("Tahoma", Font.BOLD, 16));
		add.setBounds(40, 314, 92, 20);
		panel_2.add(add);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 16));
		email.setBounds(250, 314, 114, 20);
		panel_2.add(email);
		
		JLabel f = new JLabel("");
		f.setFont(new Font("Tahoma", Font.PLAIN, 15));
		f.setBounds(40, 125, 128, 20);
		panel_2.add(f);
		
		JLabel l_n = new JLabel("");
		l_n.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l_n.setBounds(250, 125, 114, 20);
		panel_2.add(l_n);
		
		JLabel un = new JLabel("");
		un.setFont(new Font("Tahoma", Font.PLAIN, 15));
		un.setBounds(40, 227, 114, 20);
		panel_2.add(un);
		
		JLabel num = new JLabel("");
		num.setFont(new Font("Tahoma", Font.PLAIN, 15));
		num.setBounds(250, 227, 134, 20);
		panel_2.add(num);
		
		JLabel address = new JLabel("");
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setBounds(40, 345, 114, 20);
		panel_2.add(address);
		
		JLabel em = new JLabel("");
		em.setFont(new Font("Tahoma", Font.PLAIN, 15));
		em.setBounds(250, 345, 175, 20);
		panel_2.add(em);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(838, 29, 427, 436);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Edit Skills");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(26, 39, 120, 20);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(23, 70, 381, 107);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("Add");
		btnNewButton_8.setBounds(148, 69, 89, 23);
		panel_4.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                freelancer f = new freelancer(username);
				
				try
				{
				    String skill = textField.getText();
					boolean check;
				 
				    check =  f.addSkills(skill, username);
					if(check == false)
					{
						JOptionPane.showInternalMessageDialog(null, "Skill already exists");
					}
					else {
				 JOptionPane.showInternalMessageDialog(null, "New Skill Added");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			
	                
	               
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		textField = new JTextField();
		textField.setBounds(122, 23, 180, 23);
		panel_4.add(textField);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Add Skill");
		lblNewLabel_3.setBounds(20, 22, 71, 24);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBounds(26, 198, 381, 118);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Delete Skill");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(21, 32, 117, 24);
		panel_5.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setBounds(118, 34, 183, 25);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_71 = new JButton("Delete");
		btnNewButton_71.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 freelancer f = new freelancer(username);
					
					try
					{
					    String skill = textField_1.getText();
						boolean check;
					 
					    check =  f.deleteSkills(skill, username);
						if(check == false)
						{
							JOptionPane.showInternalMessageDialog(null, "Skill doesnot exist");
						}
						else {
					 JOptionPane.showInternalMessageDialog(null, "Skill deleted successfully");
						}
					}
					catch(Exception e1)
					{
						JOptionPane.showInternalMessageDialog(null, "Enter correct data");
					}
				
			}
		});
		btnNewButton_71.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_71.setBounds(148, 84, 89, 23);
		panel_5.add(btnNewButton_71);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(450, 29, 380, 436);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Skills");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(20, 39, 71, 21);
		panel_6.add(lblNewLabel_6);
		
		freelancer free = new freelancer(username);
		ArrayList<String> skillsList = free.getSkill(username);

		// Convert ArrayList to an array for JList
		String[] skillsArray = new String[skillsList.size()];
		skillsArray = skillsList.toArray(skillsArray);

		
		JList<String> skillsJList = new JList<>(skillsArray);
		skillsJList.setBackground(new Color(240, 240, 240));
		skillsJList.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		skillsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		skillsJList.setBounds(30, 80, 329, 290);
		
		

		panel_6.add(skillsJList);
		
		 String url = "jdbc:mysql://localhost:3306/project";
         String u_n = "root";
         String p = "210936";
         
	        try(Connection con = DriverManager.getConnection(url, u_n, p)) 
			{
				String selectQuery = "SELECT * FROM user WHERE Username = ? ";
				PreparedStatement selectStatement = con.prepareStatement(selectQuery);
				selectStatement.setString(1, username);
				ResultSet selectResultSet = selectStatement.executeQuery();

				if (selectResultSet.next())
				{
		        
					String f_name = selectResultSet.getString("FirstName");
					String l_name = selectResultSet.getString("LastName");
					String ad = selectResultSet.getString("Address");
					String phone = selectResultSet.getString("PhoneNumber");
					String em_ail = selectResultSet.getString("Email");
					
					f.setText(f_name);
					l_n.setText(l_name);
					address.setText(ad);
					num.setText(phone);
					em.setText(em_ail);
					un.setText(username);
				}
				else {
                    System.out.println("No data found for username: " + username);
                }

				selectStatement.close();
			}
			 catch (SQLException e2)
	         {
	             e2.printStackTrace();
	         }
		
	
	
	
	}
}

