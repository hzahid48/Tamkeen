package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user_management.Register;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login extends JFrame {
	/*public login() 
	{
		getContentPane().setLayout(null);
	}*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField passwordField;
	private JPasswordField pass;
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();

	
	private void openNextFrame(String username) 
	{
		c_profile nextFrame = new c_profile(username);
        nextFrame.setVisible(true);
        this.dispose(); // Close the current frame if needed        
    }
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					login frame = new login();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() 
	{
		setTitle("SIGN IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1433, 788);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 45, 68));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TAMKEEN");
		lblNewLabel.setBounds(872, 211, 334, 74);
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(872, 306, 115, 48);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBackground(new Color(53, 45, 68));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(872, 409, 115, 32);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBackground(new Color(53, 45, 68));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_3);
		
		uname = new JTextField();
		uname.setBounds(872, 346, 252, 32);
		uname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		uname.setForeground(new Color(255, 255, 255));
		uname.setBackground(new Color(53, 45, 68));
		contentPane.add(uname);
		uname.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
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
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//Register r = new Register();
				String url = "jdbc:mysql://localhost:3306/project";
		        String un = "root";
		        String p = "210936";
				
		        try
				{
					String username = uname.getText();
					char[] passwordChars = pass.getPassword();
					String password = new String(passwordChars);
					boolean check;
					
					check = r.login(username, password);
					
					if(check == true)
					{
						try(Connection con = DriverManager.getConnection(url, un, p)) 
						{
							String selectQuery = "SELECT * FROM user WHERE Username = ? and Password = ?";
							PreparedStatement selectStatement = con.prepareStatement(selectQuery);
							selectStatement.setString(1, username);
							selectStatement.setString(2, password);
							ResultSet selectResultSet = selectStatement.executeQuery();

							if (selectResultSet.next())
							{
					        
								String fname = selectResultSet.getString("FirstName");
								String lname = selectResultSet.getString("LastName");
								String address = selectResultSet.getString("Address");
								String phone = selectResultSet.getString("PhoneNumber");
								String email = selectResultSet.getString("Email");
								
								System.out.println("Fetched FirstName: " + fname);
								System.out.println("Fetched LastName: " + lname);
								System.out.println("Fetched Address: " + address);
								System.out.println("Fetched Phone Number: " + phone);
								System.out.println("Fetched Email: " + email);        			       
							}

							selectStatement.close();
						}
						 catch (SQLException e2)
			             {
			                 e2.printStackTrace();
			             }
						if(username.charAt(0) == 'C')
						{	
							c_profile frame2 = new c_profile(username);
							frame2.setVisible(true);
						}
						else
						{
							home_freelancer frame15 = new home_freelancer(username);
							frame15.setVisible(true);
						}
					}
					else
					{
						JOptionPane.showInternalMessageDialog(null, "Incorrect username or password");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showInternalMessageDialog(null, "Enter correct data");
				}
			}
		});
		btnNewButton.setBounds(872, 543, 252, 32);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(53, 45, 68));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(633, 380, 21, -2);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("تمکین");
		lblNewLabel_4.setBackground(new Color(53, 44, 68));
		lblNewLabel_4.setBounds(881, 133, 325, 89);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 99));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_4);
		
		JLabel label = new JLabel("");
		label.setBounds(153, 95, 486, 531);
		label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\c.JPG"));
		contentPane.add(label);
		
		JLabel lblNewLabel_6 = new JLabel("New to Tamkeen? ");
		lblNewLabel_6.setBounds(871, 616, 127, 23);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(new Color(63, 164, 207));
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Forgot Password?");
		btnNewButton_1.setBounds(854, 485, 144, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactUs frame3 = new ContactUs();
                frame3.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(53, 44, 68));
		btnNewButton_1.setForeground(new Color(63, 164, 207));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create an Account");
		btnNewButton_2.setBounds(976, 617, 156, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome frame3 = new welcome();
                frame3.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(53, 44, 68));
		btnNewButton_2.setForeground(new Color(63, 164, 207));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_2.setBorderPainted(false);
		contentPane.add(btnNewButton_2);
		
		pass = new JPasswordField();
		pass.setBackground(new Color(53, 44, 68));
		pass.setForeground(new Color(255, 255, 255));
		pass.setBounds(872, 450,252, 32);
		
		contentPane.add(pass);
	}
}
