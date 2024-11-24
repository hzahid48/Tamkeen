package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user_management.Register;
import user_management.freelancer;
import user_management.services;

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


public class f_services extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean check = false;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();
	
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
	        
	        f_services nextFrame4 = new f_services(username);
	        nextFrame3.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f_services frame = new f_services("abc");
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
	public f_services(String username) {
		setTitle("Freelancer Services");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 878);
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
		btnNewButton.setBounds(855, 40, 106, 23);
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
		btnNewButton_1.setBounds(940, 35, 180, 35);
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
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_dashboard frame29 = new f_dashboard(username);
				frame29.setVisible(true);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(840, 11, 428, 486);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Edit Services");
		lblNewLabel_2.setBounds(26, 28, 120, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(23, 57, 381, 280);
		panel_4.setBackground(new Color(192, 192, 192));
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Title");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(20, 40, 89, 23);
		panel_4.add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 40, 181, 23);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Description");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(20, 85, 122, 23);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Price");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(20, 200, 57, 20);
		panel_4.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(152, 200, 180, 23);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 109, 312, 80);
		panel_4.add(textArea);
		
		JButton btnNewButton_9 = new JButton("Add");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 freelancer free = new freelancer(username);
				
				try
				{
					//String idString = textField.getText();
				    //int id = Integer.parseInt(idString);
				    String title = textField_2.getText();
				    String description = textArea.getText();
				    String price = textField_4.getText();
				    int p = Integer.parseInt(price);
				    
					boolean check;
				    System.out.println("*********************888");
				    check =  free.addServiceToDatabase(title, description, username, p);
				    System.out.println("check" + check);
					if(check == false)
					{
						JOptionPane.showInternalMessageDialog(null, "Service already exists");
					}
					else
					{
						JOptionPane.showInternalMessageDialog(null, "New Service Added");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_9.setBounds(141, 240, 89, 24);
		panel_4.add(btnNewButton_9);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(26, 348, 381, 110);
		panel_5.setBackground(new Color(192, 192, 192));
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Delete Service");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(21, 19, 117, 24);
		panel_5.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setBounds(148, 19, 183, 25);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_71 = new JButton("Delete");
		btnNewButton_71.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 freelancer f = new freelancer(username);
					
					try
					{
					    String service = textField_1.getText();
						boolean check;
					 
					    check =  f.deleteServices(service, username);
						if(check == false)
						{
							JOptionPane.showInternalMessageDialog(null, "Service doesnot exist");
						}
						else {
					 JOptionPane.showInternalMessageDialog(null, "Service deleted successfully");
						}
					}
					catch(Exception e2)
					{
						JOptionPane.showInternalMessageDialog(null, "Enter correct data");
					}
				
			}
		});
		btnNewButton_71.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_71.setBounds(135, 60, 89, 23);
		panel_5.add(btnNewButton_71);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(23, 11, 788, 486);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		//freelancer free = new freelancer(username);
		//ArrayList<services> servicesList = free.getServices(username);
		ArrayList<services> servicesList = r.getServicess(username);

		// Convert ArrayList to an array for JList
		String[] servicesArray = new String[servicesList.size()];
		for (int i = 0; i < servicesList.size(); i++) {
			
		    servicesArray[i] = servicesList.get(i).toString(); // Adjust this based on your services class
		    System.out.println(servicesArray[i]);
		}
		//skillsArray = skillsList.toArray(skillsArray);

		JList<String> servicesJList = new JList<>(servicesArray);
		servicesJList.setBounds(43, 142, 695, 305);
		servicesJList.setBackground(new Color(240, 240, 240));
		servicesJList.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		servicesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel_6.add(servicesJList);

		
		JLabel lblNewLabel_10 = new JLabel("Preview Services");
		lblNewLabel_10.setBounds(25, 44, 218, 38);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel_6.add(lblNewLabel_10);
		
	
	}
}


