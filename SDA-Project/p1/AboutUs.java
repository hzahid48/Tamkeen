package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class AboutUs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AboutUs()
	{        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 45, 68));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setVerticalAlignment(SwingConstants.TOP);
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setForeground(new Color(255, 255, 255));
		lblAboutUs.setFont(new Font("Snap ITC", Font.BOLD, 34));
		lblAboutUs.setBounds(541, 24, 232, 62);
		contentPane.add(lblAboutUs);
		
		JLabel aboutUsParagraph = new JLabel("<html>Welcome to Tamkeen – Where Talent Meets Opportunities! Our platform is dedicated to connecting businesses with skilled freelancers, empowering projects to thrive. Whether you're looking for top talent to elevate your projects or you're a freelancer seeking exciting opportunities, you're in the right place.<br><br>"
				+ "Explore our website to discover a seamless way to bring your projects to life. Connect with talented freelancers or find rewarding opportunities that match your skills. Feel free to reach out to us through the 'Contact Us' button if you have any questions or need assistance.<br><br>"
				+ "Join us in building a community where talent flourishes and opportunities abound. We're thrilled to have you on board!</html>");
		aboutUsParagraph.setVerticalAlignment(SwingConstants.TOP);
		aboutUsParagraph.setHorizontalAlignment(SwingConstants.CENTER);
		aboutUsParagraph.setForeground(new Color(255, 255, 255));
		aboutUsParagraph.setFont(new Font("Cambria", Font.PLAIN, 24));
		aboutUsParagraph.setBounds(156, 130, 1006, 455);
		contentPane.add(aboutUsParagraph);
		
		JButton btnNewButton_1 = new JButton("Contact Us");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ContactUs frame6 = new ContactUs();
				frame6.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(157, 550, 120, 30);
		contentPane.add(btnNewButton_1);
		
		  JButton btnNewButton_11 = new JButton("");
		     btnNewButton_11.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) 
		     	{
		     		welcome frame29 = new welcome();
		     		frame29.setVisible(true);
		     	}
		     });
		     btnNewButton_11.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Color clr = new Color(192,192,192);
						btnNewButton_11.setBackground(clr);
					}
					public void mouseExited(MouseEvent e) {
						Color clr = new Color(53,44,68);
						btnNewButton_11.setBackground(clr);
					}
				});
		     btnNewButton_11.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\back.png"));
		     btnNewButton_11.setBackground(new Color(53, 44, 68));
		     btnNewButton_11.setBounds(10, 11, 89, 23);
		     btnNewButton_11.setBorderPainted(false);
		     contentPane.add(btnNewButton_11);
		
	}
}
