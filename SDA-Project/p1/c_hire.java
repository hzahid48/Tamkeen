package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import user_management.Register;

public class c_hire extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String s; //searched service
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();
	private static int id = 1;

	private void openNextFrame(String username) 
	{
		c_manage nextFrame = new c_manage(username);
        nextFrame.setVisible(true);
        this.dispose(); // Close the current frame if needed
        
        c_hire nextFrame1 = new c_hire(username, "", "",0);
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
					c_hire frame = new c_hire("abc", "abc", "", 0);
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
	public c_hire(String username, String fusername, String searched, int pr) 
	{
		s = searched;
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(343, 11, 580, 520);
		panel_2.setBackground(new Color(240, 240, 240));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Hiring Application");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(24, 32, 189, 40);
		panel_2.add(lblNewLabel_4);
		
		JLabel fname = new JLabel("First Name");
		fname.setFont(new Font("Tahoma", Font.BOLD, 16));
		fname.setBounds(40, 94, 128, 20);
		panel_2.add(fname);
		
		JLabel lname = new JLabel("Last Name");
		lname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lname.setBounds(357, 96, 114, 20);
		panel_2.add(lname);
		
		JLabel usern = new JLabel("User Name");
		usern.setFont(new Font("Tahoma", Font.BOLD, 16));
		usern.setBounds(40, 196, 114, 20);
		panel_2.add(usern);
		
		JLabel number = new JLabel("Phone Number");
		number.setFont(new Font("Tahoma", Font.BOLD, 16));
		number.setBounds(357, 196, 134, 20);
		panel_2.add(number);
		
		JLabel add = new JLabel("Address");
		add.setFont(new Font("Tahoma", Font.BOLD, 16));
		add.setBounds(40, 314, 92, 20);
		panel_2.add(add);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 16));
		email.setBounds(357, 314, 114, 20);
		panel_2.add(email);
		
		JLabel f = new JLabel("");
		f.setFont(new Font("Tahoma", Font.PLAIN, 15));
		f.setBounds(40, 125, 128, 20);
		panel_2.add(f);
		
		JLabel l_n = new JLabel("");
		l_n.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l_n.setBounds(357, 125, 114, 20);
		panel_2.add(l_n);
		
		JLabel un = new JLabel("");
		un.setFont(new Font("Tahoma", Font.PLAIN, 15));
		un.setBounds(40, 227, 114, 20);
		panel_2.add(un);
		
		JLabel num = new JLabel("");
		num.setFont(new Font("Tahoma", Font.PLAIN, 15));
		num.setBounds(357, 229, 134, 20);
		panel_2.add(num);
		
		JLabel address = new JLabel("");
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setBounds(40, 345, 114, 20);
		panel_2.add(address);
		
		JLabel em = new JLabel("");
		em.setFont(new Font("Tahoma", Font.PLAIN, 15));
		em.setBounds(357, 347, 145, 20);
		panel_2.add(em);
		
		JLabel lblService = new JLabel("Service");
		lblService.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblService.setBounds(40, 414, 92, 20);
		panel_2.add(lblService);
		
		JLabel service = new JLabel("");
		service.setFont(new Font("Tahoma", Font.PLAIN, 15));
		service.setBounds(40, 440, 145, 20);
		panel_2.add(service);
		
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(357, 414, 114, 20);
		panel_2.add(lblPrice);
		
		JLabel price = new JLabel("");
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		price.setBounds(357, 440, 114, 20);
		panel_2.add(price);		
		
		String url = "jdbc:mysql://localhost:3306/project";
        String u_n = "root";
        String p = "210936";
			
	        try(Connection con = DriverManager.getConnection(url, u_n, p)) 
			{
				String selectQuery = "SELECT * FROM user WHERE Username = ? ";
				PreparedStatement selectStatement = con.prepareStatement(selectQuery);
				selectStatement.setString(1, fusername.trim());
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
					un.setText(fusername);
					service.setText(searched);
					price.setText(String.valueOf(pr));
				}
				else {
                    System.out.println("No data found for username: " + fusername);
                }

				selectStatement.close();
			}
			 catch (SQLException e2)
	         {
	             e2.printStackTrace();
	         }
		
		
		JButton btnNewButton_7 = new JButton("Send Application");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Register r = new Register();
				boolean check;
				check = r.send_app(username, fusername,s,pr,LocalDate.now(),false);
				if(check)
				{
					System.out.println("Send Application to" + fusername);
					JOptionPane.showInternalMessageDialog(null, "Application sent to " + fusername);
					//id++;
				}
				else
				{
					JOptionPane.showInternalMessageDialog(null, "Error while sending application");
				}
			}
		});
		btnNewButton_7.setBounds(235, 480, 150, 23);
		panel_2.add(btnNewButton_7);
		
		
		
		
		
	}

}
