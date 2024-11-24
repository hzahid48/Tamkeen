package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ContactUs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUs frame = new ContactUs();
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
	public ContactUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 733);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 44, 68));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact Us");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 34));
		lblNewLabel.setBounds(513, 43, 286, 45);
		contentPane.add(lblNewLabel);
		
		JLabel contactUsParagraph = new JLabel("<html>We'd love to hear from you! Whether you have questions about our platform, need assistance, or just want\r\n "
				+ "to say hello, feel free to reach out using any of the contact methods below. <br><br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_tamkeen_ <br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://www.facebook.com/tamkeen/ <br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tamkeen@gmail.com <br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;051 1272977</html>");
		
		
		contactUsParagraph.setVerticalAlignment(SwingConstants.TOP);
		contactUsParagraph.setHorizontalAlignment(SwingConstants.CENTER);
		contactUsParagraph.setForeground(new Color(255, 255, 255));
		contactUsParagraph.setFont(new Font("Cambria", Font.PLAIN, 24));
		contactUsParagraph.setBounds(169, 119, 1006, 455);
		contentPane.add(contactUsParagraph);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\insta.JPG"));
		lblNewLabel_1.setBounds(165, 230, 50, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\facebook.JPG"));
		lblNewLabel_2.setBounds(165, 289, 50, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\gmail.JPG"));
		lblNewLabel_3.setBounds(166, 345, 49, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\phone.JPG"));
		lblNewLabel_4.setBounds(169, 407, 25, 35);
		contentPane.add(lblNewLabel_4);
		
		  JButton btnNewButton_1 = new JButton("");
		     btnNewButton_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) 
		     	{
		     		welcome frame29 = new welcome();
		     		frame29.setVisible(true);
		     	}
		     });
		     btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Color clr = new Color(192,192,192);
						btnNewButton_1.setBackground(clr);
					}
					public void mouseExited(MouseEvent e) {
						Color clr = new Color(53,44,68);
						btnNewButton_1.setBackground(clr);
					}
				});
		     btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\back.png"));
		     btnNewButton_1.setBackground(new Color(53, 44, 68));
		     btnNewButton_1.setBounds(10, 11, 89, 23);
		     btnNewButton_1.setBorderPainted(false);
		     contentPane.add(btnNewButton_1);
	}
}
