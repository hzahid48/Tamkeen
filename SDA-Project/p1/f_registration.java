package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user_management.Register;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class f_registration extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField em;
	private JPasswordField pass;
	private JPasswordField c_pass;
	private JTextField usern;
	private JTextField num;
	private JTextField add;

	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
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
	public f_registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 45, 68));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Join as a Freelancer ");
		lblNewLabel.setBounds(491, 103, 438, 27);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 34));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(525, 198, 113, 20);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		fname = new JTextField();
		fname.setBounds(683, 196, 168, 27);
		fname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fname.setForeground(Color.WHITE);
		fname.setBackground(new Color(53, 45, 68));
		contentPane.add(fname);
		fname.setColumns(10);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setBounds(525, 236, 142, 20);
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		l2.setForeground(new Color(255, 255, 255));
		contentPane.add(l2);
		
		lname = new JTextField();
		lname.setBounds(683, 234, 168, 27);
		lname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lname.setForeground(Color.WHITE);
		lname.setBackground(new Color(53, 45, 68));
		contentPane.add(lname);
		lname.setColumns(10);
		
		JLabel l3 = new JLabel("Email");
		l3.setBounds(525, 432, 76, 20);
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		l3.setForeground(new Color(255, 255, 255));
		contentPane.add(l3);
		
		em = new JTextField();
		em.setBounds(683, 430, 168, 27);
		em.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		em.setForeground(Color.WHITE);
		em.setBackground(new Color(53, 45, 68));
		contentPane.add(em);
		em.setColumns(10);
		
		JLabel l4 = new JLabel("Password");
		l4.setBounds(525, 474, 97, 27);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l4.setForeground(new Color(255, 255, 255));
		contentPane.add(l4);
		
		pass = new JPasswordField();
		pass.setBounds(683, 475, 168, 25);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pass.setBackground(new Color(53, 45, 68));
		contentPane.add(pass);
		
		JLabel l5 = new JLabel("Confirm Password");
		l5.setBounds(525, 512, 163, 24);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l5.setForeground(new Color(255, 255, 255));
		contentPane.add(l5);
		
		c_pass = new JPasswordField();
		c_pass.setBounds(683, 512, 168, 27);
		c_pass.setForeground(Color.WHITE);
		c_pass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		c_pass.setBackground(new Color(53, 45, 68));
		contentPane.add(c_pass);
		
		JButton btnNewButton = new JButton("Already have an account? Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				login frame12 = new login();
				frame12.setVisible(true);
			}
		});
		btnNewButton.setBounds(525, 577, 316, 23);
		btnNewButton.setBackground(new Color(53, 45, 68));
		btnNewButton.setForeground(new Color(63, 164, 207));
		btnNewButton.setBorderPainted(false); // Remove button border
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("تمکین");
		lblNewLabel_8.setBounds(1150, 11, 231, 114);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel_8.setForeground(new Color(240, 240, 0));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 185, 400, 332);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\reg.JPG"));
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(680, 611, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Register r = new Register();
				
				try
				{
					String Fname = fname.getText();
					String Lname = lname.getText();
					String address = add.getText();
					int phoneNumber = Integer.parseInt(num.getText());
					String name = usern.getText();
					String username = "F" + name ;
					String email = em.getText();
					boolean check;
				
				
					char[] passwordChars = pass.getPassword();
					String password = new String(passwordChars);
                
					char[] c_passwordChars = c_pass.getPassword();
					String confirm_pass = new String(c_passwordChars);
				
					if (!confirm_pass.equals(password))
					{
						JOptionPane.showInternalMessageDialog(null, "Passwords do not match");
					}
					else
					{
						check = r.signup_Customer(Fname,  Lname, address,phoneNumber,username, email,  password);
						if(check == false)
						{
							JOptionPane.showInternalMessageDialog(null, "Freelancer with the same username already exists");
						}
						else
						{
							JOptionPane.showInternalMessageDialog(null, "Registration Successful");
							login frame22 = new login();
							frame22.setVisible(true);
						}
					}
					
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblAddress = new JLabel("Username");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(525, 287, 142, 20);
		contentPane.add(lblAddress);
		
		usern = new JTextField();
		usern.setForeground(Color.WHITE);
		usern.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		usern.setColumns(10);
		usern.setBackground(new Color(53, 45, 68));
		usern.setBounds(683, 285, 168, 27);
		contentPane.add(usern);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(525, 332, 142, 20);
		contentPane.add(lblPhoneNumber);
		
		num = new JTextField();
		num.setForeground(Color.WHITE);
		num.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		num.setColumns(10);
		num.setBackground(new Color(53, 45, 68));
		num.setBounds(683, 330, 168, 27);
		contentPane.add(num);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setForeground(Color.WHITE);
		lblAddress_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress_1.setBounds(525, 379, 142, 20);
		contentPane.add(lblAddress_1);
		
		add = new JTextField();
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add.setColumns(10);
		add.setBackground(new Color(53, 45, 68));
		add.setBounds(683, 377, 168, 27);
		contentPane.add(add);
		
		JButton btnNewButton_2 = new JButton("Save in file");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Register r = new Register();
				
				try
				{
					String Fname = fname.getText();
					String Lname = lname.getText();
					String address = add.getText();
					int phoneNumber = Integer.parseInt(num.getText());
					String name = usern.getText();
					String username = "C" + name ;
					String email = em.getText();
					boolean check;
				
				
					char[] passwordChars = pass.getPassword();
					String password = new String(passwordChars);
                
					char[] c_passwordChars = c_pass.getPassword();
					String confirm_pass = new String(c_passwordChars);
				
					if (!confirm_pass.equals(password))
					{
						JOptionPane.showInternalMessageDialog(null, "Passwords do not match");
					}
					else
					{
						check = r.signup_Customer(Fname,  Lname, address,phoneNumber,username, email,  password);
						if(check == false)
						{
							JOptionPane.showInternalMessageDialog(null, "Freelancer with the same username already exists");
						}
						if(check == true)
						{
							r.storeInFile(Fname, Lname, address, username, email, phoneNumber, password);
						}
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			}
		});
		btnNewButton_2.setBounds(570, 611, 95, 23);
		contentPane.add(btnNewButton_2);
	}
}
